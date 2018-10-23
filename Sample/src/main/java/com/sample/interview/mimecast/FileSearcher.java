package com.sample.interview.mimecast;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSearcher {
    private final static int THREADPOOL_SIZE = 20;
    private final static int QUEUE_LIMIT = 1024;
    private final static int BUFFER_SIZE = 65536;

    public static void main(String[] args) throws Exception {

        Options options = new Options();

        Option folder = new Option("p", "path", true, "the path of the folder to scan");
        folder.setRequired(true);
        options.addOption(folder);

        Option search = new Option("s", "search", true, "the search term to match");
        search.setRequired(true);
        options.addOption(search);

        Option output = new Option("o", "output", true, "the path of the output file");
        output.setRequired(true);
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            String folderPath = cmd.getOptionValue("path");
            String searchTerm = cmd.getOptionValue("search");
            String outputPath = cmd.getOptionValue("output");

            searchPatternInFolder(folderPath, searchTerm, outputPath);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("search string patterns in a given folder", options);

            System.exit(1);
        }
    }

    private static void searchPatternInFolder(
        final String folderPath,
        final String searchTerm,
        final String outputPath
    )
    {
        final ExecutorService es = Executors.newFixedThreadPool(THREADPOOL_SIZE);
        ConcurrentLinkedQueue<String> queue =  new ConcurrentLinkedQueue<>();

        try {
            Files.walkFileTree(
                Paths.get(folderPath),
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println("\tAccessing file: " + file);
                        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(
                            () -> {
                                return searchInFile(file, searchTerm, queue);
                            },
                            es
                        );

                        completableFuture.whenComplete(
                                (result, e) -> {
                                    System.out.println(file + ": " + result);
                                }
                        );

                        return FileVisitResult.CONTINUE;
                    }
                }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }

    private static int searchInFile(
        final Path file,
        final String searchTerm,
        final ConcurrentLinkedQueue<String> queue
    )
    {
        int count = 0;

        try {
            FileInputStream fis = new FileInputStream(file.toString());
            FileChannel channel = fis.getChannel();
            int fileSize = (int)channel.size();
            MappedByteBuffer mappedBuf = channel.map(
                FileChannel.MapMode.READ_ONLY,
                0,
                fileSize
            );

            for (int offset = 0; offset < fileSize; offset += BUFFER_SIZE) {
                int size = (fileSize - offset > BUFFER_SIZE) ? BUFFER_SIZE : fileSize - offset;
                byte[] b = new byte[size];
                mappedBuf.get(b);

                Pattern pattern = Pattern.compile(searchTerm);
                Matcher m = pattern.matcher(new String(b));
                while(m.find()) {
                    count++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

}
