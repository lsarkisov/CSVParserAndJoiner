package com.lv.app.decoders.impl;

import com.lv.app.decoders.DataParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVParser implements DataParser {
    List<Map<String , String >> result;

    public CSVParser() {
        result = new ArrayList<>();
    }

    @Override
    public List<Map<String , String >> getParsedData(String fileName) throws IOException {
        try (final BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int i = -1;
            String[] title = new String[0];

            while ((line = br.readLine()) != null) {
                if (i == -1) {
                    title = line.split(";");
                    i = 0;
                } else {
                    Map<String, String> map = new HashMap<>();
                    for (int j = line.length(); j > 0; j--) {
                        for (int k = 0; k < title.length; k++) {
                            map.put(title[k], line.split(";")[k]);
                        }
                    }
                    result.add(map);
                }
            }
        }

        return result;
    }
}
