package com.lv.app.decoders.impl;

import org.junit.jupiter.api.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CSVParserTest {
    String fileName = "test.csv";
    String CSVMOck = "id;name;surname;department_id\n" +
            "1;John;Smith;2\n" +
            "2;Pete;Hallock;1";

    @BeforeAll
    void init() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.append(CSVMOck);

        try (BufferedWriter wr = new BufferedWriter(fileWriter)) {
        }
    }

    @AfterAll
    void destruct() throws IOException {
        Files.deleteIfExists(Paths.get(fileName));
    }

    @Test
    void getParsedDataTest() throws IOException {
        final CSVParser parser = new CSVParser();
        Assertions.assertEquals(parser.getParsedData(fileName).toString(),
                "[{department_id=2, surname=Smith, name=John, id=1}, {department_id=1, surname=Hallock, name=Pete, id=2}]");

    }
}