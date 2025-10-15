import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class AddNote extends Note{
    private String id;
    private String name;
    private String subject;
    private String title;
    private String text;
    public AddNote(String ID, String name, String subject, String title, String text){
        super(ID,name,subject,title,text);
    }

    public void addNotes(){
        try{
            File file = new File("Notes Managements.txt");
            FileOutputStream fos = new FileOutputStream(file,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            text = String.format("Note ID No.: %s\nName: %s\nSubject: %s\nTitle: %s\nText: %s\n",super.getID(),super.getName(),super.getSubject(),super.getTitle(),super.getText());
            bw.write(text);
            bw.newLine();
            bw.newLine();
            bw.close();
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }

    public void displayNotes(){
        StringBuilder notes = new StringBuilder();
        try{
            FileInputStream fis = new FileInputStream("Notes Managements.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String text;
            text = br.readLine();
            while(text!=null){
                notes.append(text).append("\n");
            }
            br.close();
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}