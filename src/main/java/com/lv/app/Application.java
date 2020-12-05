package com.lv.app;

import com.lv.app.company.impl.EmploymentDepartment;

import java.io.*;

public class Application {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final EmploymentDepartment department = new EmploymentDepartment();
        department.joinData("file-1.csv", "file-2.csv");
        department.writeData("result.csv");
    }
}
