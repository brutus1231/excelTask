package pl.sda;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LanguageDetector {

    public static void main(String[] args) throws APIError, IOException {
        String language = detect("das auto fährt schnell");
        System.out.println("Język to " + language);

        String lines = readLinesFromFile("C:\\artykuly\\chunichi.txt");
        System.out.println(detect(lines));

        List<String> filePaths = readAllFilePaths("C:\\artykuly");
    }

    private static List<String> readAllFilePaths(String path) {
        List<String> filePaths = new ArrayList<>();

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
