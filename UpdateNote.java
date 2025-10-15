import java.io.*;
import javax.swing.*;
public class UpdateNote {
    public void updateInterface(String updateID,String updatedID, String updatedName, String updatedSubject, String updatedTitle, String updatedText){
        boolean update = false;
        StringBuilder updateData = new StringBuilder();

        try{
            FileInputStream fis = new FileInputStream("Notes Managements.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                if(line.contains("Note ID No.:")) {
                    String fileID = line.substring(line.indexOf(":") + 1).trim();
                    if(fileID.equals(updateID)){
                        updateData.append(String.format("Note ID No.: %s\nName: %s\nSubject: %s\nTitle: %s\nText:\n%s\n\n",updatedID, updatedName , updatedSubject , updatedTitle, updatedText ));
                        update = true;
                        // Skip the next lines until the next note or end of file
                        while((line = br.readLine()) != null && !line.equals("") && !line.startsWith("Note ID No.:")) {}
                    }
                }
                if(line != null) {
                    updateData.append(line).append("\n");
                }
            }
            br.close();

            if(!update){
                JOptionPane.showMessageDialog(null, "ID No. not found", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else {
                File store = new File("Notes Managements.txt");
                FileOutputStream fos = new FileOutputStream(store,false); // Changed 'true' to 'false' to overwrite the file
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(updateData.toString());
                bw.close();
                JOptionPane.showMessageDialog(null,"Updated Data", "Note Management System",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}     