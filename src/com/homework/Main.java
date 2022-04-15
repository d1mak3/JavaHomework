package com.homework;

import com.homework.handlers.*;
import com.homework.models.Person;

import java.io.*;

public class Main {
    public static String readLine() {
        StringBuilder finalString = new StringBuilder();
        int byteFromInputStream;

        try {
            while ((byteFromInputStream = System.in.read()) != 10) {
                finalString.append((char) byteFromInputStream);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        return finalString.toString();
    }

    public static void main(String[] args) {
        final String path = "C:\\SomeDir\\";

        // First task
        System.out.println("Задание №1:");
        DisksInfoCollector.displayDisksInfo();
        DisksInfoCollector.displayFilesAndSubDirs();

        // Second task
        System.out.println("\nЗадание №2:");
        FileHandler.createDir(path); // Create directory to save files in
        FileHandler.writeInFileStream(path);
        try {
            System.out.println(FileHandler.readFromFileStream(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        FileHandler.writeInFile(path);
        System.out.println(FileHandler.readFromFile(path + "hta.txt"));

        // Third task
        System.out.println("\nЗадание №3:");
        Person newPerson = new Person("Dima", 2002);
        JsonHandler.writeJsonInFile(path, newPerson);
        System.out.println(JsonHandler.readPersonFromJsonFile(path));

        // Fourth task
        System.out.println("\nЗадание №4:");
        XMLHandler.addNewXMLElementInFile();
        System.out.println(XMLHandler.getXMLFromFile());

        // Fifth task
        System.out.println("\nЗадание №5:");
        ZipHandler.zipFile(new File(path + "hta.txt"));
        File unzippedFile = ZipHandler.unzipFile("hta.txt");
        System.out.println("Данные из разархивированного файла:");
        System.out.println(FileHandler.readFromFile(path + "newhta.txt"));

        readLine();
        FileHandler.deleteFiles(path);
        FileHandler.deleteDir(path);
    }
}
