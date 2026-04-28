package utils;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Env {

    public static Map<String, String> values = new HashMap<>();
    public static final String PATH = ".env";


    public static void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String linea;
            while((linea = br.readLine()) != null) {
                
                String[] parts = linea.split("=");

                if (parts.length != 2) {
                    throw new IOException("No puedes poner = en una clave o valor");
                }

                values.put(parts[0], parts[1]);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String get(String key) {
        return values.get(key);
    }
   
}
