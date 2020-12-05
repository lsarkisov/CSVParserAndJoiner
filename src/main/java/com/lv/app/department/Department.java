package com.lv.app.department;

import java.io.IOException;
import java.io.Serializable;

public interface Department extends Serializable {
    void joinData(String file1, String file2) throws IOException;
    void writeData(String outputFileName) throws IOException;
}
