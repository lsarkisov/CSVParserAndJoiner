package com.lv.app.decoders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DataParser {
    List<Map<String , String >> getParsedData(String fileName) throws IOException;
}
