package pl.sda;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LanguageDetector {

    public static void main(String[] args) throws APIError, IOException {
        detectLanguagesInFolder("C:\\artykuly");
    }

    private static void detectLanguagesInFolder(String folderPath) throws IOException, APIError {
        List<String> filePaths = readAllFilePaths(folderPath);
        for (String filePath : filePaths) {
            String lines = readLinesFromFile(filePath);
            System.out.println(filePath + " " + detect(lines));
        }
    }

    private static List<String> readAllFilePaths(String path) {
        List<String> filePaths = new ArrayList<>();
        File folder = new File(path);

        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                filePaths.add(file.getAbsolutePath());
            }
        }

        return filePaths;
    }

    private static String readLinesFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    private static String detect(String words) throws APIError {
        DetectLanguage.apiKey = "3937959c7e0878cc47b14f0e92644548";
        List<Result> results = DetectLanguage.detect(words);
        Result result = results.get(0);
        return result.language;
    }


}
