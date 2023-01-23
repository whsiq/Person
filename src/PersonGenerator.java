import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {

    public static void main(String[] args) {

        // Initializations

        Scanner in = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        String id;
        String firstName;
        String lastName;
        String title;
        int YOB;
        boolean ynConfirm = false;

        // Create data for each person

        do {

            id = SafeInput.getRegExString(in, "Enter your 6 digit ID", "\\d{6}");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            title = SafeInput.getRegExString(in, "Enter your title", "^(Dr|Mr|Mrs|Ms|Esq)\\b\\.");
            YOB = SafeInput.getInt(in, "Enter your age");
            ynConfirm = SafeInput.getYNConfirm(in, "Do you have more entries to make?");
            people.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB);

        } while(ynConfirm);

        // File Input for each person in the ArrayList

        File workingDirectory = new File(System.getProperty("user.dir")); // Project Directory
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt"); // Select input file

        try {

            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : people) {

                writer.write(rec, 0, rec.length()); // 0 represents the starting character on the write
                writer.newLine();

            }
            writer.close(); // closes the file and flushes buffer
            System.out.println("Data written to file");
        }
        catch (IOException e) {

            e.printStackTrace();

        }



    }
}