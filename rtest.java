import java.io.*;
public class rtest
{
    public static void deleteLine(int dN) throws IOException {
        try {
            FileInputStream fis = new FileInputStream("Notes Managements.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String delete;
            String task = "";

            while ((delete = br.readLine()) != null) {
                if (delete.startsWith("Note ID: " + dN)) {
                    break;
                }
                task += delete + "\n";
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("me.txt"));
            writer.write(task);
            br.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
