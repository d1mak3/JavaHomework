package com.homework.handlers;

import java.io.*;
import java.util.Objects;
import java.util.stream.Stream;

public class FileHandler {
    public static void createDir(String path) {
        File dirToCreate = new File(path);

        try {
            if (!dirToCreate.exists()) {
                boolean checkCreation = dirToCreate.mkdir();
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void deleteDir(String path) {
        File file = new File(path);
        boolean checkDelete = file.delete();
    }

    public static void deleteFiles(String path) {
        File someDir = new File(path);
        Stream.of(Objects.requireNonNull(someDir.listFiles())).forEach(file -> {
            boolean checkFileDelete = file.delete();
        });
    }

    public static void writeInFileStream(String path) {
        File dirToCreateFileIn = new File(path);
        FileOutputStream fstream = null;

        if (!dirToCreateFileIn.exists()) {
            boolean checkCreation = dirToCreateFileIn.mkdir();
        }

        try {
            fstream = new FileOutputStream(path + "note.txt");
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        ConsoleHandler.writeLine("Введите строку для записи в файл:");
        String text = ConsoleHandler.readLine();

        try {
            byte[] buffer = text.getBytes();
            Objects.requireNonNull(fstream).write(buffer, 0, buffer.length);
            ConsoleHandler.writeLine("Текст записан в файл");
        }
        catch (Exception e) {
            e.getStackTrace();
        }

        try {
            Objects.requireNonNull(fstream).close();
        }
        catch (IOException e) {
            e.getStackTrace();
        }

    }

    public static String readFromFileStream(String path) throws IOException {
        File dirToFindFileIn = new File(path);
        FileInputStream fstream = null;

        if (!dirToFindFileIn.exists()) {
            throw new IOException();
        }

        try {
            fstream = new FileInputStream(path + "note.txt");
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        int byteFromFile;
        StringBuilder fileData = new StringBuilder();
        try {
            while((byteFromFile = Objects.requireNonNull(fstream).read()) != -1) {
                fileData.append((char) byteFromFile);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        try {
            Objects.requireNonNull(fstream).close();
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        return fileData.toString();
    }

    public static void writeInFile(String path) {
        ConsoleHandler.writeLine("Введите строку для записи в файл:");
        String text = ConsoleHandler.readLine();

        try (FileWriter writer = new FileWriter(path + "hta.txt", false)) {
            writer.write(text + '\n');
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        try (FileWriter writer = new FileWriter(path + "hta.txt", true)) {
            writer.write("Дозапись:\n");
            writer.write("4.5");
            ConsoleHandler.writeLine("Запись выполнена");
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static String readFromFile(String path) {
        StringBuilder fileData = new StringBuilder();
        try (FileReader reader = new FileReader(path)) {
            int byteFromFileStream;

            while ((byteFromFileStream = reader.read()) != -1) {
                fileData.append((char) byteFromFileStream);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        return fileData.toString();
    }
}
