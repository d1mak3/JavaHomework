package com.homework.handlers;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipHandler {
    public static void zipFile(File file) {
        try (ZipOutputStream zipStream = new ZipOutputStream(new FileOutputStream("C:\\SomeDir\\output.zip"));
                FileInputStream fileDataStream = new FileInputStream(file)) {
            ZipEntry newEntry = new ZipEntry(file.getName());
            zipStream.putNextEntry(newEntry);
            byte[] buffer = new byte[fileDataStream.available()];
            fileDataStream.read(buffer);
            zipStream.write(buffer);
            zipStream.closeEntry();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File unzipFile(String fileName) {
        try (ZipInputStream zipStream = new ZipInputStream(new FileInputStream("C:\\SomeDir\\output.zip"))) {
            ZipEntry newEntry = new ZipEntry(fileName);

            while ((newEntry = zipStream.getNextEntry()) != null) {
                if (newEntry.getName().equals(fileName)) {
                    FileOutputStream unzipper = new FileOutputStream("C:\\SomeDir\\new" + fileName);

                    int byteFromZipStream;
                    while ((byteFromZipStream = zipStream.read()) != -1){
                        unzipper.write(byteFromZipStream);
                    }

                    unzipper.flush();
                    unzipper.close();
                }

                zipStream.closeEntry();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return new File("C:\\SomeDir\\new" + fileName);
    }
}
