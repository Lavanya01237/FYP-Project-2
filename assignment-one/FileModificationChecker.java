import java.io.File;

public class FileModificationChecker {
    public static void main(String[] args) {
        String filePath = "part1_value_iteration_utility_estimates.csv";
        File file = new File(filePath);

        // Get last modified time before function execution
        long beforeModTime = file.lastModified();

        // Run the function that modifies the CSV
        modifyCSVFile();

        // Get last modified time after function execution
        long afterModTime = file.lastModified();

        // Compare timestamps
        if (afterModTime > beforeModTime) {
            System.out.println("The file has been modified.");
        } else {
            System.out.println("The file has NOT been modified.");
        }
    }

    private static void modifyCSVFile() {
        // Your function that modifies the CSV
    }
}
