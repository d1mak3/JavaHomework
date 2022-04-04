package com.homework;

import com.homework.handlers.*;
import com.homework.models.Person;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        final String path = "C:\\SomeDir\\";

        // First task
        ConsoleHandler.writeLine("Задание №1:");
        DisksInfoCollector.displayDisksInfo();
        DisksInfoCollector.displayFilesAndSubDirs();

        // Second task
        ConsoleHandler.writeLine("\nЗадание №2:");
        FileHandler.createDir(path); // Create directory to save files in
        FileHandler.writeInFileStream(path);
        try {
            ConsoleHandler.writeLine(FileHandler.readFromFileStream(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        FileHandler.writeInFile(path);
        ConsoleHandler.writeLine(FileHandler.readFromFile(path + "hta.txt"));

        // Third task
        ConsoleHandler.writeLine("\nЗадание №3:");
        Person newPerson = new Person("Dima", 2002);
        JsonHandler.writeJsonInFile(path, newPerson);
        ConsoleHandler.writeLine(JsonHandler.readPersonFromJsonFile(path));

        // Fourth task
        ConsoleHandler.writeLine("\nЗадание №4:");
        XMLHandler.addNewXMLElementInFile();
        ConsoleHandler.writeLine(XMLHandler.getXMLFromFile());

        // Fifth task
        ConsoleHandler.writeLine("\nЗадание №5:");
        ZipHandler.zipFile(new File(path + "hta.txt"));
        File unzippedFile = ZipHandler.unzipFile("hta.txt");
        ConsoleHandler.writeLine("Данные из разархивированного файла:");
        ConsoleHandler.writeLine(FileHandler.readFromFile(path + "newhta.txt"));

        ConsoleHandler.readLine();
        FileHandler.deleteFiles(path);
        FileHandler.deleteDir(path);
    }
}
