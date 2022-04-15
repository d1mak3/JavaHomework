package com.homework.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.homework.models.Person;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonHandler {
    public static void writeJsonInFile(String path, Person person) {
        Gson jsonConverter = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(path + "person.json", false)) {
            writer.write(jsonConverter.toJson(person));
            System.out.println("json строка успешно записана в файл");
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static String readPersonFromJsonFile(String path) {
        Gson jsonConverter = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder jsonFromFile = new StringBuilder();

        try (FileReader reader = new FileReader(path + "person.json")) {
            int byteFromFileStream;

            while ((byteFromFileStream = reader.read()) != -1) {
                jsonFromFile.append((char) byteFromFileStream);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        Person personFromJson = jsonConverter.fromJson(jsonFromFile.toString(), Person.class);
        System.out.println("Конвертированные данные класса:\n" + personFromJson);
        return jsonFromFile.toString();
    }
}
