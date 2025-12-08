import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryContents {
    public static List<String> getFirstFiveFiles(String directoryPath) {
        List<String> fileList = new ArrayList<>();
        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return fileList;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            int count = 0;
            for (File file : files) {
                if (count >= 5) break;
                fileList.add(file.getName());
                count++;
            }
        }
        return fileList;
    }

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        List<String> firstFiveFiles = getFirstFiveFiles(currentDirectory);
        
        for (String fileName : firstFiveFiles) {
            System.out.println(fileName);
        }
    }
}