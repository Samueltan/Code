package com.sample.interview.mimecast;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class FileSearcher {
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

            System.out.println(folderPath);
            System.out.println(searchTerm);
            System.out.println(outputPath);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("search string patterns in a given folder", options);

            System.exit(1);
        }

    }
}
