import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class DeleteNoteGUI {
    private static JFrame fAdd;
    private static JPanel p, updatePanelAdd, updatePanel;
    private static JTextArea txtnText;
    private static JTextField txtnID, txtnName, txtnSubject, txtnTitle;
    private static JButton addNote, updateNote, deleteNote, searchNote, displayNote, Exit, Submit, Cancel; 
    static String ID , name, subject, title, text;

    public void deleteNoteGUI(String idUpdate, JFrame f) {
        fAdd = new JFrame("Notes Delete Management System");
        Color c = new Color(255,255,204);
        updatePanel = new JPanel();
        updatePanel.setBackground(c);
        updatePanel.setLayout(null);
        fAdd.setSize(600,730);
        fAdd.setLocationRelativeTo(null);
        fAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fAdd.setResizable(false);
        fAdd.add(updatePanel);

        String upName = "" , upSubject = "", upTitle = "", upText="";
        try {
            FileInputStream fis = new FileInputStream("Notes Managements.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("Note ID No.:")){
                    String id = line.split(": ")[1];
                    if (id.equals(idUpdate)) {
                        String name = br.readLine().split(": ")[1];
                        String subject = br.readLine().split(": ")[1];
                        String title = br.readLine().split(": ")[1];
                        StringBuilder textBuilder = new StringBuilder();
                        String textLine;
                        br.readLine(); // Skip the "Text:" line
                        while ((textLine = br.readLine()) != null && !textLine.startsWith("Note ID No.:")) {
                            textBuilder.append(textLine).append("\n");
                        }
                        String text = textBuilder.toString();

                        upName = name;
                        upSubject = subject;
                        upTitle = title;
                        upText = text;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel Title1 = new JLabel("Delete Note");
        Title1.setFont(new Font("Arial",Font.BOLD,24));
        Title1.setBounds(230,15,300,30);
        updatePanel.add(Title1);

        JLabel nID = new JLabel("Note ID no. :");
        nID.setFont(new Font("Arial", Font.BOLD,18));
        nID.setBounds(30,92,300,30);
        updatePanel.add(nID);

        txtnID = new JTextField(idUpdate);
        txtnID.setFont(new Font("Arial",Font.PLAIN,14));
        txtnID.setEditable(false);
        txtnID.setBounds(230,94,150,30);
        updatePanel.add(txtnID);

        JLabel Name = new JLabel("Name: ");
        Name.setFont(new Font("Arial", Font.BOLD,18));
        Name.setBounds(30,152,300,30);
        updatePanel.add(Name);

        txtnName = new JTextField(upName);
        txtnName.setFont(new Font("Arial",Font.PLAIN,14));
        txtnName.setEditable(false);
        txtnName.setBounds(230,152,150,30);
        updatePanel.add(txtnName);

        JLabel Subject = new JLabel("Subject: ");
        Subject.setFont(new Font("Arial", Font.BOLD,18));
        Subject.setBounds(30,210,300,30);
        updatePanel.add(Subject);

        txtnSubject = new JTextField(upSubject);
        txtnSubject.setFont(new Font("Arial",Font.PLAIN,14));
        txtnSubject.setEditable(false);
        txtnSubject.setBounds(230,210,150,30);
        updatePanel.add(txtnSubject);

        JLabel Title = new JLabel("Title: ");
        Title.setFont(new Font("Arial", Font.BOLD,18));
        Title.setBounds(30,268,300,30);
        updatePanel.add(Title);

        txtnTitle = new JTextField(upTitle);
        txtnTitle.setFont(new Font("Arial",Font.PLAIN,14));
        txtnTitle.setEditable(false);
        txtnTitle.setBounds(230,268,150,30);
        updatePanel.add(txtnTitle);

        JLabel Text = new JLabel("Text:");
        Text.setFont(new Font("Arial", Font.BOLD,18));
        Text.setBounds(30,326,300,30);
        updatePanel.add(Text);

        txtnText = new JTextArea(upText);
        txtnText.setFont(new Font("Arial",Font.PLAIN,14));
        txtnText.setEditable(false);
        txtnText.setBounds(28,358,530,250);
        txtnText.setLineWrap(true);
        txtnText.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtnText);
        scrollPane.setBounds(28,358,530,250);
        scrollPane.setBackground(c);
        updatePanel.add(scrollPane);

        Submit = new JButton("Confirm");
        Submit.setFont(new Font("Arial", Font.BOLD,20));
        Submit.setBounds(120,628,150,25);
        updatePanel.add(Submit);

        Submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = txtnID.getText();
                    DeleteNote dn = new DeleteNote();
                    dn.deleteNote(id);
                    txtnID.setText("");
                    txtnName.setText("");
                    txtnSubject.setText("");
                    txtnTitle.setText("");
                    txtnText.setText("");
                }
            });
        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Arial", Font.BOLD,20));
        Cancel.setBounds(330,628,150,25);
        Cancel.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    fAdd.setVisible(false);
                    f.setVisible(true);
                }
            });
        updatePanel.add(Cancel);

        updatePanel.setVisible(true);
        fAdd.setVisible(true);
    }

}
