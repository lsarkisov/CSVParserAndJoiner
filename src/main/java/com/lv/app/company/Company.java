package com.lv.app.company;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Company extends Serializable {
    void joinData(String file1, String file2) throws IOException;
    void writeData(String outputFileName) throws IOException;
}
