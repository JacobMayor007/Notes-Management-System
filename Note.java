import java.io.*;
import javax.swing.*;
public class Note{
    private String id;
    private String name;
    private String subject;
    private String title;
    private String text;
    public Note(){
        this.id = "";
        this.name = "";
        this.subject = "";
        this.title = "";
        this.text = "";
    }
    
    public Note(String ID, String name, String subject, String title, String text){
        this.id = ID;
        this.name = name;
        this.subject = subject;
        this.title = title;
        this.text = text;
    }

    public void setID(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

    public String getTitle(){
        return title;
    }

    public String getText(){
        return text;
    }
    public void addNotes(){
        try{
            File file = new File("Notes Managements.txt");
            FileOutputStream fos = new FileOutputStream(file,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            text = String.format("Note ID No.: %s\nName: %s\nSubject: %s\nTitle: %s\nText:\n%s",getID(),getName(),getSubject(),getTitle(),getText());
            bw.write(text);
            bw.newLine();
            bw.close();
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }

    public void displayNotes() {
        StringBuilder notes = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream("Notes Managements.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String text;
            while((text = br.readLine()) != null) {
                if(text.startsWith("Note ID No.:")) {
                    notes.append("\n");
                }
                notes.append(text).append("\n");
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
