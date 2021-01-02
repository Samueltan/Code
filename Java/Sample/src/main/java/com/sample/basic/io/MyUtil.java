package com.sample.basic.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class MyUtil {

    private MyUtil() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    public static int countWordInFile(String filename, String word) {
        int counter = 0;

        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null) {
                int index = -1;
                while ((index = line.indexOf(word)) >= 0) {
                    counter++;
                    line = line.substring(index + word.length());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (FileReader fr = new FileReader(filename)) {
//            try (BufferedReader br = new BufferedReader(fr)) {
//                String line = null;
//                while ((line = br.readLine()) != null) {
//                    int index = -1;
//                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
//                        counter++;
//                        line = line.substring(index + word.length());
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        return counter;
    }

    public static void main(String[] args) {
        //            MyUtil.fileCopy("/Users/samueltan/Downloads/download/pic/2.jpg", "/Users/samueltan/Downloads/her.jpg");
//            MyUtil.fileCopyNIO("/Users/samueltan/Downloads/download/pic/2.jpg", "/Users/samueltan/Downloads/hers.jpg");
        int count = countWordInFile("/Users/samueltan/Downloads/collection.txt", "com");
        System.out.println(count);
    }
}