import java.io.*;
import javax.swing.*;
public class DeleteNote{
    public void deleteNote(String id) {
        try {
            File file = new File("Notes Managements.txt");
            File tempFile = new File("temp.txt");

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream(tempFile, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Note ID No.: " + id)) {
                    // Skip the note details
                    for (int i = 0; i < 5; i++) {
                        line = br.readLine();
                        if (line == null) break;
                    }
                } else {
                    bw.write(line);
                    bw.newLine();
                }
            }

            br.close();
            bw.close();

            // Delete the original file
            if (!file.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file))
                System.out.println("Could not rename file");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}