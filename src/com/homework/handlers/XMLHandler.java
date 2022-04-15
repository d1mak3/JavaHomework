package com.homework.handlers;

import com.homework.Main;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Objects;

public class XMLHandler {
    private static String convertDocumentToString(Document document) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans;
        StringWriter sw = null;
        try {
            trans = tf.newTransformer();
            sw = new StringWriter();
            trans.transform(new DOMSource(document), new StreamResult(sw));
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }

        return Objects.requireNonNull(sw).toString();
    }

    public static void addNewXMLElementInFile() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;

        try {
            document = Objects.requireNonNull(documentBuilder).parse(new File("d4t4.xml"));
        }
        catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("Введите название элемента:");
        String tagName = Main.readLine();

        System.out.println("Введите строку для записи в элемент:");
        String stringToSave = Main.readLine();

        Element root = (Element) Objects.requireNonNull(document).getElementsByTagName("data").item(0);
        Element newElement = Objects.requireNonNull(document).createElement(tagName);
        newElement.setTextContent(stringToSave);

        root.appendChild(newElement);

        FileOutputStream fstream = null;
        try {
            fstream = new FileOutputStream("d4t4.xml");
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        try {
            byte[] buffer = convertDocumentToString(document).getBytes();
            Objects.requireNonNull(fstream).write(buffer, 0, buffer.length);
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static String getXMLFromFile() {
        StringBuilder XMLFromFile = new StringBuilder();

        try (FileReader reader = new FileReader("d4t4.xml")) {
            int byteFromFileStream;

            while ((byteFromFileStream = reader.read()) != -1) {
                XMLFromFile.append((char) byteFromFileStream);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        return XMLFromFile.toString();
    }
}
