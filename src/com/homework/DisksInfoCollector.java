package com.homework;

import com.homework.handlers.ConsoleHandler;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class DisksInfoCollector {
    public static void displayDisksInfo() {
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        Arrays.stream(File.listRoots()).forEach(file -> {
            ConsoleHandler.writeLine("Название: " + file);
            ConsoleHandler.writeLine("Тип: " + fileSystemView.getSystemTypeDescription(file));
            ConsoleHandler.writeLine("Объём диска: " + file.getTotalSpace());
            ConsoleHandler.writeLine("Свободное пространство: " + file.getFreeSpace());
            ConsoleHandler.writeLine("Метка: " + fileSystemView.getSystemDisplayName(file) + '\n');
        });
    }

    public static void displayFilesAndSubDirs() {
        String dirName = "C:\\";
        File dir = new File(dirName);

        if (dir.exists()){
            ConsoleHandler.writeLine("Подкаталоги:");
            Stream.of(Objects.requireNonNull(dir.listFiles())).forEach(file -> {
                if (file.isDirectory()){
                    ConsoleHandler.writeLine(file.getName());
                }
            });
            ConsoleHandler.writeLine("Файлы:");
            Stream.of(Objects.requireNonNull(dir.listFiles())).forEach(file -> {
                if (file.isFile()){
                    ConsoleHandler.writeLine(file.getName());
                }
            });
        }
    }
}
