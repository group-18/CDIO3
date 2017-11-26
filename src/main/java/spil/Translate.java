package spil;


import java.io.*;
import java.util.HashMap;

public class Translate {
    private static Translate instance;

    private static String fileLocation = "/languages/";
    private static String lang = "da_DK";

    private HashMap<String, String> translations;


    private Translate()
    {
        this.translations = new HashMap<>();
        this.parseFile(Translate.fileLocation + Translate.lang + ".txt");
    }


    public static void setFileLocation(String location)
    {
        Translate.fileLocation = location;
    }


    public static Translate getInstance()
    {
        if (Translate.instance == null) {
            Translate.instance = new Translate();
        }

        return Translate.instance;
    }


    public static Translate setLang(String lang)
    {
        if (! lang.equals(Translate.lang)) {
            Translate.lang = lang;
            Translate.instance = new Translate();
        }

        return Translate.instance;
    }


    public static String getLang()
    {
        return Translate.lang;
    }


    public static String t(String key)
    {
        return Translate.getInstance().get(key);
    }


    public static String t(String key, String[] variables)
    {
        return Translate.getInstance().get(key, variables);
    }


    private String get(String key)
    {
        if (! this.translations.containsKey(key)) {
            return key;
        }

        String translation = this.translations.get(key);

        if (translation.equals("")) {
            return key;
        }

        return translation;
    }


    private String get(String key, String[] variables)
    {
        String translation = this.t(key);

        if (! translation.equals(key)) {
            for (int i = 0; i < variables.length; i++) {
                translation = translation.replaceAll("\\{\\{ ?#" + i + " ?\\}\\}", variables[i]);
            }
        }

        return translation;
    }


    private void parseFile(String filePath)
    {
        try {
            InputStream in = this.getClass().getResourceAsStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.equals("")) {
                    continue;
                }

                String[] keyValue = currentLine.split(":", 2);

                String key = keyValue[0];
                String val = keyValue.length == 1 ? "" : this.parseValue(keyValue[1]);

                if (! this.translations.containsKey(key)) {
                    this.translations.put(key, val);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseValue(String val)
    {
        return val
                .replace(" \\n ", "\n")
                .replace("\\n", "\n");
    }
}
