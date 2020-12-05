package com.lv.app.company.impl;

import com.lv.app.company.Company;
import com.lv.app.decoders.impl.CSVParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class EmploymentDepartment implements Company {


    List<Map<String, String>> employmentDepartment;

    public EmploymentDepartment() {
        employmentDepartment = new ArrayList<>();
    }

    public void setEmploymentDepartment(List<Map<String, String>> employmentDepartment) {
        this.employmentDepartment = employmentDepartment;
    }

    public List<Map<String, String>> getEmploymentDepartment() {
        return employmentDepartment;
    }

    @Override
    public void joinData(String departmentFileName, String employeeFileName) throws IOException {
        final CSVParser departmentParser = new CSVParser();
        final List<Map<String, String>> departmentRowData = departmentParser.getParsedData(departmentFileName);
        final CSVParser employeeParser = new CSVParser();
        final List<Map<String, String>> employeeRowData = employeeParser.getParsedData(employeeFileName);


        employmentDepartment = employeeRowData.stream().filter(e ->
                departmentRowData.stream().anyMatch(f -> f.get("id").equals(e.get("id"))))
                .map(e -> {
                    final HashMap<String, String> result = departmentRowData.stream()
                            .filter(f -> f.get("id").equals(e.get("id")))
                            .collect(HashMap::new, HashMap::putAll, HashMap::putAll);

                    result.put("department", e.get("name"));
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void writeData(String outputFileName) throws IOException {

        final FileWriter fileWriter = new FileWriter(outputFileName);

        fileWriter.append(
                String.format("%s,%s,%s,%s,%s%c",
                        "id",
                        "name",
                        "surname",
                        "department",
                        "department_id", '\n'));

        employmentDepartment.forEach(e -> {
            try {
                fileWriter.append(
                        String.format("%s,%s,%s,%s,%s%c",
                                e.get("id"),
                                e.get("name"),
                                e.get("surname"),
                                e.get("department"),
                                e.get("department_id"), '\n'));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        try (final BufferedWriter wr = new BufferedWriter(fileWriter)) {
        }
    }
}
