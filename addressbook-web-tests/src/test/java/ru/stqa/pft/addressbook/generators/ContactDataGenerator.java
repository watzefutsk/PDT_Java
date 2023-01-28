package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }

        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContactData(count);
        if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }

    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private List<ContactData> generateContactData(int count) {

        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                            .withFirstName(String.format("TestFN%s", i))
                            .withLastName(String.format("TestLN%s", i))
                            .withAddress("Saint_Petersburg")
                            .withFirstEmail(String.format("test%s@test.com", i))
                            .withSecondEmail(String.format("test@test%s.com", i))
                            .withThirdEmail("test@test.com")
                            .withHomeNumber(String.format("44-04-0%s", i))
                            .withMobileNumber(String.format("8-900-655-12-2%s", i))
                            .withWorkNumber(String.format("%s-900-655-12-2", i)));
        }
        return contacts;
    }
}
