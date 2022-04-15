package com.homework;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class DisksInfoCollector {
    public static void displayDisksInfo() {
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        Arrays.stream(File.listRoots()).forEach(file -> {
            System.out.println("Тип: " + fileSystemView.getSystemTypeDescription(file));
            System.out.println("Название: " + file);
            System.out.println("Объём диска: " + file.getTotalSpace());
            System.out.println("Свободное пространство: " + file.getFreeSpace());
            System.out.println("Метка: " + fileSystemView.getSystemDisplayName(file) + '\n');
        });
    }

    public static void displayFilesAndSubDirs() {
        String dirName = "C:\\";
        File dir = new File(dirName);

        if (dir.exists()){
            System.out.println("Подкаталоги:");
            Stream.of(Objects.requireNonNull(dir.listFiles())).forEach(file -> {
                if (file.isDirectory()){
                    System.out.println(file.getName());
                }
            });
            System.out.println("Файлы:");
            Stream.of(Objects.requireNonNull(dir.listFiles())).forEach(file -> {
                if (file.isFile()){
                    System.out.println(file.getName());
                }
            });
        }
    }
}
