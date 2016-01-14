package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    private static FileManager instance;
    private FileManager(){};
    public static String LINE_SEPARATOR = System.getProperty("line.separator");
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public String readFile (String path) {
        BufferedReader br = null;
        String result = "";
        try {
            File file = new File(path);
            if (file.exists()) {
                String sCurrentLine;

                br = new BufferedReader(new FileReader(file));

                while((sCurrentLine = br.readLine()) != null) {
                    result += sCurrentLine + LINE_SEPARATOR;
                }

                if (br != null)br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }
}
