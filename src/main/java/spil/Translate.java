package spil;


import java.io.*;
import java.util.HashMap;

public class Translate {
    private String lang;

    private HashMap<String, String> translations;


    public Translate(String lang)
    {
        this.lang = lang;
        this.translations = new HashMap<>();

        this.parseFile("/languages/" + this.lang + ".txt");
    }


    public String getLang()
    {
        return this.lang;
    }


    public Translate changeLang(String lang)
    {
        return new Translate(lang);
    }


    public String t(String key)
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


    public String t(String key, String[] variables)
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
