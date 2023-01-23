import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {

        // Initializations

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;
        ArrayList<String> records = new ArrayList<>();

        int length = 5;
        String id;
        String firstName;
        String lastName;
        String title;
        int birthYear;

        // Processing

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;

                while (reader.ready()) {
                    rec = reader.readLine();
                    records.add(rec);
                    line++;
                }

                reader.close();
                System.out.println("\nFile read successfully");

                String[] fields;

                System.out.print("ID#   | First Name | Last Name | Title | YOB");
                System.out.print("\n============================================");
                for (String l : records) {

                    fields = l.split(",");

                    if (fields.length == length) {
                        id = fields[0].trim();
                        firstName = fields[1].trim();
                        lastName = fields[2].trim();
                        title = fields[3].trim();
                        birthYear = Integer.parseInt(fields[4].trim());
                        System.out.printf("\n%-8s%-12s%-12s%-6s%6d", id, firstName, lastName, title, birthYear);
                    }
                    else {
                        System.out.println("File may be corrupt: ");
                        System.out.println(l);
                    }
                }

            }

            else {

                System.out.println("No file chosen");
                System.out.println("Please run the program again.");
                System.exit(0);

            }
        }

        catch(FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        catch(IOException e) {
            e.printStackTrace();
        }

    }
}
