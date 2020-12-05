package com.lv.app.company.impl;

import org.junit.jupiter.api.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmploymentDepartmentTest {
    String fileName1 = "test-1.csv";
    String fileName2 = "test-2.csv";
    String fileName3 = "test-output.csv";
    String CSVMock1 = "id;name;surname;department_id\n" +
            "1;John;Smith;2\n" +
            "2;Pete;Hallock;1";
    String CSVMock2 = "id;name\n" +
            "1;Marketing\n" +
            "2;Management";

    @BeforeAll
    void init() throws IOException {
        createFile(fileName1, CSVMock1);
        createFile(fileName2, CSVMock2);
    }

    @AfterAll
    void destruct() throws IOException {
        Files.deleteIfExists(Paths.get(fileName1));
        Files.deleteIfExists(Paths.get(fileName2));
        Files.deleteIfExists(Paths.get(fileName3));
    }


    @Test
    void joinDataTest() throws IOException {
        final EmploymentDepartment em = new EmploymentDepartment();

        em.joinData(fileName1, fileName2);
        Assertions.assertEquals(em.getEmploymentDepartment().toString(),
                "[{name=John, id=1, department=Marketing, department_id=2, surname=Smith}, {name=Pete, id=2, department=Management, department_id=1, surname=Hallock}]");
    }

    @Test
    void writeDataTest() throws IOException {
        final EmploymentDepartment em = new EmploymentDepartment();

        List<Map<String, String>> data = new ArrayList<>();
        Map<String , String > map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "John");
        map.put("surname", "Smith");
        map.put("department", "Marketing");
        map.put("department_id", "2");
        data.add(map);

        em.setEmploymentDepartment(data);

        em.writeData(fileName3);
        Assertions.assertEquals(Files.readString(Path.of(fileName3)),
                "id,name,surname,department,department_id\n" +
                        "1,John,Smith,Marketing,2\n");
    }

    private void createFile(String fileName, String  CSVMock) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.append(CSVMock);

        try (BufferedWriter wr = new BufferedWriter(fileWriter)) {
        }
    }
}