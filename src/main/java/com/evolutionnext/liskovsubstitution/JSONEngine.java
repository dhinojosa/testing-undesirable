package com.evolutionnext.liskovsubstitution;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class JSONEngine {
    private OutputStream outputStream;

    public void outputAll(List<JSONOutputable>
                                  jsonOutputables)
            throws IOException {
         for (JSONOutputable jsonOutputable : jsonOutputables) {
             byte[] bytes = jsonOutputable
                     .outputJSON().getBytes();
             for (int i = 0; i < bytes.length; i++) {
                 outputStream.write(i);
             }
         }
    }

    public static void main(String[] args) {
        JSONEngine jsonEngine = new JSONEngine();
    }
}
