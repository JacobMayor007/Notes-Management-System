import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class NotesManagementSystem {
    private static JFrame f;
    private static JPanel p, pAdd;
    private static JTextArea txtnText;
    private static JTextField txtnID, txtnName, txtnSubject, txtnTitle, deleteTF;
    private static JButton addNote, updateNote, deleteNote, searchNote, displayNote, Exit, Submit, Cancel;
    static String ID , name, subject, title, text, deleteID;
    public static void main(String[] args){
        f = new JFrame("Notes Management System");
        p = new JPanel();
        Color cp = new Color(204,204,204);
        p.setBackground(cp);
        p.setLayout(null);
        f.setSize(610,700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        f.add(p);

        JLabel Title = new JLabel("Notes Management System");
        Title.setFont(new Font("Arial",Font.BOLD,24));
        Title.setBounds(150,15,500,30);
        p.add(Title);

        addNote = new JButton("Add Note");
        addNote.setFont(new Font("Arial",Font.BOLD,24));
        addNote.setBounds(150,100,300,30);
        Color c = new Color(255,255,204);
        addNote.setBackground(c);
        addNote.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pAdd = new JPanel();
                    pAdd.setBackground(c);
                    pAdd.setLayout(null);
                    f.add(pAdd);
                    JLabel title = new JLabel("Add Note");
                    title.setFont(new Font("Arial",Font.BOLD,24));
                    title.setBounds(250,15,500,30);
                    pAdd.add(title);

                    JLabel nID = new JLabel("Note ID no. :");
                    nID.setFont(new Font("Arial", Font.BOLD,18));
                    nID.setBounds(30,92,300,30);
                    pAdd.add(nID);

                    txtnID = new JTextField();
                    txtnID.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnID.setBounds(150,94,150,30);
                    pAdd.add(txtnID);

                    JLabel Name = new JLabel("Name: ");
                    Name.setFont(new Font("Arial", Font.BOLD,18));
                    Name.setBounds(30,152,300,30);
                    pAdd.add(Name);

                    txtnName = new JTextField();
                    txtnName.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnName.setBounds(150,152,150,30);
                    pAdd.add(txtnName);

                    JLabel Subject = new JLabel("Subject: ");
                    Subject.setFont(new Font("Arial", Font.BOLD,18));
                    Subject.setBounds(30,210,300,30);
                    pAdd.add(Subject);

                    txtnSubject = new JTextField();
                    txtnSubject.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnSubject.setBounds(150,210,150,30);
                    pAdd.add(txtnSubject);

                    JLabel Title = new JLabel("Title: ");
                    Title.setFont(new Font("Arial", Font.BOLD,18));
                    Title.setBounds(30,268,300,30);
                    pAdd.add(Title);

                    txtnTitle = new JTextField();
                    txtnTitle.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnTitle.setBounds(150,268,150,30);
                    pAdd.add(txtnTitle);

                    JLabel Text = new JLabel("Enter Text:");
                    Text.setFont(new Font("Arial", Font.BOLD,18));
                    Text.setBounds(30,326,300,30);
                    pAdd.add(Text);

                    txtnText = new JTextArea();
                    txtnText.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnText.setBounds(28,358,500,250);
                    txtnText.setLineWrap(true);
                    txtnText.setWrapStyleWord(true);
                    JScrollPane scrollPane = new JScrollPane(txtnText);
                    scrollPane.setBounds(28,358,530,250);
                    scrollPane.setBackground(c);
                    pAdd.add(scrollPane);

                    Submit = new JButton("Submit");
                    Submit.setFont(new Font("Arial", Font.BOLD,20));
                    Submit.setBounds(120,628,150,25);
                    pAdd.add(Submit);
                    Submit.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if(txtnName.getText().equals("") || txtnText.getText().equals("") || txtnID.getText().equals("") || txtnSubject.getText().equals("") || txtnTitle.getText().equals("")){
                                    JOptionPane.showMessageDialog(null, "Enter Data","Error",JOptionPane.WARNING_MESSAGE);
                                    txtnName.requestFocus();
                                } else {
                                    String ID = txtnID.getText();
                                    String name = txtnName.getText();
                                    String subject = txtnSubject.getText();
                                    String title = txtnTitle.getText();
                                    String text = txtnText.getText();
                                    txtnID.setText("");
                                    txtnName.setText("");
                                    txtnSubject.setText("");
                                    txtnTitle.setText("");
                                    txtnText.setText("");
                                    AddNote n = new AddNote(ID,name,subject,title,text);
                                    n.addNotes();
                                    JOptionPane.showMessageDialog(null, "Successfully Entered Data","Notes Added",JOptionPane.INFORMATION_MESSAGE);
                                }

                                p.setVisible(false);
                                pAdd.setVisible(true);
                            }
                        });

                    Cancel = new JButton("Cancel");
                    Cancel.setFont(new Font("Arial", Font.BOLD,20));
                    Cancel.setBounds(330,628,150,25);
                    Cancel.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                p.setVisible(true);
                                pAdd.setVisible(false);
                            }
                        });
                    pAdd.add(Cancel);

                    p.setVisible(false);
                    pAdd.setVisible(true);
                }
            });
        p.add(addNote);
        updateNote = new JButton("Update Note");
        updateNote.setFont(new Font("Arial",Font.BOLD,20));
        updateNote.setBounds(150,185,300,30);
        updateNote.setBackground(c);
        updateNote.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    pAdd = new JPanel();
                    pAdd.setBackground(c);
                    pAdd.setLayout(null);
                    f.add(pAdd);

                    JOptionPane.showMessageDialog(null,"Enter existing ID number", "Update Notes", JOptionPane.INFORMATION_MESSAGE);

                    JLabel Title1 = new JLabel("Update Note");
                    Title1.setFont(new Font("Arial",Font.BOLD,24));
                    Title1.setBounds(230,15,300,30);
                    pAdd.add(Title1);

                    JLabel nID = new JLabel("Note ID no. :");
                    nID.setFont(new Font("Arial", Font.BOLD,18));
                    nID.setBounds(30,92,300,30);
                    pAdd.add(nID);

                    txtnID = new JTextField();
                    txtnID.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnID.setBounds(230,94,150,30);
                    pAdd.add(txtnID);
                    txtnID.addFocusListener(new FocusListener(){
                            @Override
                            public void focusGained(FocusEvent e){
                                if(txtnID.getText().equals("000")){
                                    txtnID.setText("");
                                    txtnID.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e){
                                if(txtnID.getText().isEmpty()){
                                    txtnID.setText("");
                                    txtnID.setForeground(Color.BLACK);
                                }
                            }
                        });
                    
                        
                    JLabel Name = new JLabel("Name: ");
                    Name.setFont(new Font("Arial", Font.BOLD,18));
                    Name.setBounds(30,152,300,30);
                    pAdd.add(Name);

                    txtnName = new JTextField();
                    txtnName.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnName.setEditable(false);
                    txtnName.setText("Update Name");
                    txtnName.setBounds(230,152,150,30);
                    pAdd.add(txtnName);
                    txtnName.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnName.getText().equals("Update Name")) {
                                    txtnName.setText("LOCKED");
                                    txtnName.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnName.getText().isEmpty()) {
                                    txtnName.setText("Update Name");
                                    txtnName.setForeground(Color.GRAY);
                                }
                            }
                        });

                    JLabel Subject = new JLabel("Subject: ");
                    Subject.setFont(new Font("Arial", Font.BOLD,18));
                    Subject.setBounds(30,210,300,30);
                    pAdd.add(Subject);

                    txtnSubject = new JTextField();
                    txtnSubject.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnSubject.setEditable(false);
                    txtnSubject.setText("Update Subject");
                    txtnSubject.setBounds(230,210,150,30);
                    pAdd.add(txtnSubject);
                    txtnSubject.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnSubject.getText().equals("Update Subject")) {
                                    txtnSubject.setText("LOCKED");
                                    txtnSubject.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnSubject.getText().isEmpty()) {
                                    txtnSubject.setText("Update Subject");
                                    txtnSubject.setForeground(Color.GRAY);
                                }
                            }
                        });
                    
                    JLabel Title = new JLabel("Title: ");
                    Title.setFont(new Font("Arial", Font.BOLD,18));
                    Title.setBounds(30,268,300,30);
                    pAdd.add(Title);

                    txtnTitle = new JTextField();
                    txtnTitle.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnTitle.setEditable(false);
                    txtnTitle.setText("Update Title");
                    txtnTitle.setBounds(230,268,150,30);
                    pAdd.add(txtnTitle);
                    txtnTitle.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnTitle.getText().equals("Update Subject")) {
                                    txtnTitle.setText("LOCKED");
                                    txtnTitle.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnTitle.getText().isEmpty()) {
                                    txtnTitle.setText("Update Subject");
                                    txtnTitle.setForeground(Color.GRAY);
                                }
                            }
                        });
                    
                    JLabel Text = new JLabel("Text:");
                    Text.setFont(new Font("Arial", Font.BOLD,18));
                    Text.setBounds(30,326,300,30);
                    pAdd.add(Text);

                    txtnText = new JTextArea();
                    txtnText.setText("Update Text");
                    txtnText.setForeground(Color.GRAY);
                    txtnText.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnText.setBounds(28,358,530,250);
                    txtnText.setEditable(false);
                    txtnText.setLineWrap(true);
                    txtnText.setWrapStyleWord(true);
                    JScrollPane scrollPane = new JScrollPane(txtnText);
                    scrollPane.setBounds(28,358,530,250);
                    scrollPane.setBackground(c);
                    pAdd.add(scrollPane);
                    txtnText.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnText.getText().equals("Update Text")) {
                                    txtnText.setText("LOCKED");
                                    txtnText.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnText.getText().isEmpty()) {
                                    txtnText.setText("Update Text   ");
                                    txtnText.setForeground(Color.GRAY);
                                }
                            }
                        });
                    
                    Submit = new JButton("Search");
                    Submit.setFont(new Font("Arial", Font.BOLD,20));
                    Submit.setBounds(420,94,150,30);
                    pAdd.add(Submit);
                    Submit.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(txtnID.getText().equals("")){
                                    JOptionPane.showMessageDialog(null,"Enter Data", "Error", JOptionPane.WARNING_MESSAGE);
                                    txtnID.requestFocus();
                                }
                                else{
                                    String idUpdate = txtnID.getText();
                                    UpdateNoteGUI unGUI = new UpdateNoteGUI();
                                    unGUI.updateNoteGUI(idUpdate,f);
                                    f.setVisible(false);
                                }
                            }
                        });

                    Cancel = new JButton("Cancel");
                    Cancel.setFont(new Font("Arial", Font.BOLD,20));
                    Cancel.setBounds(220,628,150,25);
                    Cancel.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                p.setVisible(true);
                                pAdd.setVisible(false);
                            }
                        });
                    pAdd.add(Cancel);
                    p.setVisible(false);
                    pAdd.setVisible(true);
                }
            });
        p.add(updateNote);

        deleteNote = new JButton("Delete Note");
        deleteNote.setFont(new Font("Arial", Font.BOLD, 20));
        deleteNote.setBounds(150, 275, 300, 30);
        deleteNote.setBackground(c);
        deleteNote.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pAdd = new JPanel();
                    pAdd.setBackground(c);
                    pAdd.setLayout(null);
                    f.add(pAdd);
                    
                    JOptionPane.showMessageDialog(null,"Enter existing ID to delete", "Delete Notes", JOptionPane.INFORMATION_MESSAGE);
                    
                    JLabel Title1 = new JLabel("Delete Note");
                    Title1.setFont(new Font("Arial",Font.BOLD,24));
                    Title1.setBounds(230,15,300,30);
                    pAdd.add(Title1);

                    JLabel nID = new JLabel("Note ID no. :");
                    nID.setFont(new Font("Arial", Font.BOLD,18));
                    nID.setBounds(30,92,300,30);
                    pAdd.add(nID);

                    txtnID = new JTextField();
                    txtnID.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnID.setBounds(230,94,150,30);
                    pAdd.add(txtnID);
                    txtnID.addFocusListener(new FocusListener(){
                            @Override
                            public void focusGained(FocusEvent e){
                                if(txtnID.getText().equals("000")){
                                    txtnID.setText("");
                                    txtnID.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e){
                                if(txtnID.getText().isEmpty()){
                                    txtnID.setText("");
                                    txtnID.setForeground(Color.BLACK);
                                }
                            }
                        });
                    
                        
                    JLabel Name = new JLabel("Name: ");
                    Name.setFont(new Font("Arial", Font.BOLD,18));
                    Name.setBounds(30,152,300,30);
                    pAdd.add(Name);

                    txtnName = new JTextField();
                    txtnName.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnName.setEditable(false);
                    txtnName.setText("Name");
                    txtnName.setBounds(230,152,150,30);
                    pAdd.add(txtnName);
                    txtnName.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnName.getText().equals("Name")) {
                                    txtnName.setText("LOCKED");
                                    txtnName.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnName.getText().isEmpty()) {
                                    txtnName.setText("Name");
                                    txtnName.setForeground(Color.GRAY);
                                }
                            }
                        });

                    JLabel Subject = new JLabel("Subject: ");
                    Subject.setFont(new Font("Arial", Font.BOLD,18));
                    Subject.setBounds(30,210,300,30);
                    pAdd.add(Subject);

                    txtnSubject = new JTextField();
                    txtnSubject.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnSubject.setEditable(false);
                    txtnSubject.setText("Subject");
                    txtnSubject.setBounds(230,210,150,30);
                    pAdd.add(txtnSubject);
                    txtnSubject.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnSubject.getText().equals("Subject")) {
                                    txtnSubject.setText("LOCKED");
                                    txtnSubject.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnSubject.getText().isEmpty()) {
                                    txtnSubject.setText("Subject");
                                    txtnSubject.setForeground(Color.GRAY);
                                }
                            }
                        });
                    
                    JLabel Title = new JLabel("Title: ");
                    Title.setFont(new Font("Arial", Font.BOLD,18));
                    Title.setBounds(30,268,300,30);
                    pAdd.add(Title);

                    txtnTitle = new JTextField();
                    txtnTitle.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnTitle.setEditable(false);
                    txtnTitle.setText("Title");
                    txtnTitle.setBounds(230,268,150,30);
                    pAdd.add(txtnTitle);
                    txtnTitle.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnTitle.getText().equals("Title")) {
                                    txtnTitle.setText("LOCKED");
                                    txtnTitle.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnTitle.getText().isEmpty()) {
                                    txtnTitle.setText("Title");
                                    txtnTitle.setForeground(Color.GRAY);
                                }
                            }
                        });
                    
                    JLabel Text = new JLabel("Text:");
                    Text.setFont(new Font("Arial", Font.BOLD,18));
                    Text.setBounds(30,326,300,30);
                    pAdd.add(Text);

                    txtnText = new JTextArea();
                    txtnText.setText("Text");
                    txtnText.setForeground(Color.GRAY);
                    txtnText.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnText.setBounds(28,358,530,250);
                    txtnText.setEditable(false);
                    txtnText.setLineWrap(true);
                    txtnText.setWrapStyleWord(true);
                    JScrollPane scrollPane = new JScrollPane(txtnText);
                    scrollPane.setBounds(28,358,530,250);
                    scrollPane.setBackground(c);
                    pAdd.add(scrollPane);
                    txtnText.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnText.getText().equals("Text")) {
                                    txtnText.setText("LOCKED");
                                    txtnText.setForeground(Color.BLACK);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnText.getText().isEmpty()) {
                                    txtnText.setText("Text");
                                    txtnText.setForeground(Color.GRAY);
                                }
                            }
                        });
                    
                    Submit = new JButton("Search");
                    Submit.setFont(new Font("Arial", Font.BOLD,20));
                    Submit.setBounds(420,94,150,30);
                    pAdd.add(Submit);
                    Submit.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(txtnID.getText().equals("")){
                                    JOptionPane.showMessageDialog(null,"Enter Data", "Error", JOptionPane.WARNING_MESSAGE);
                                    txtnID.requestFocus();
                                }
                                else{
                                    String idUpdate = txtnID.getText();
                                    DeleteNoteGUI dnGUI = new DeleteNoteGUI();
                                    dnGUI.deleteNoteGUI(idUpdate,f);
                                    f.setVisible(false);
                                }
                            }
                        });

                    Cancel = new JButton("Cancel");
                    Cancel.setFont(new Font("Arial", Font.BOLD,20));
                    Cancel.setBounds(220,628,150,25);
                    Cancel.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                p.setVisible(true);
                                pAdd.setVisible(false);
                            }
                        });
                    pAdd.add(Cancel);
                    p.setVisible(false);
                    pAdd.setVisible(true);
                }
            });

        p.add(deleteNote);

        searchNote = new JButton("Search Note");
        searchNote.setFont(new 
        Font("Arial",Font.BOLD,20));
        searchNote.setBounds(150,360,300,30);
        searchNote.setBackground(c);
        searchNote.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    pAdd = new JPanel();
                    pAdd.setBackground(c);
                    pAdd.setLayout(null);
                    f.add(pAdd);
                    JOptionPane.showMessageDialog(null,"Search existing ID number", "Search Notes", JOptionPane.INFORMATION_MESSAGE);
                    JLabel Title1 = new JLabel("Search Note");
                    Title1.setFont(new Font("Arial",Font.BOLD,24));
                    Title1.setBounds(230,15,300,30);
                    pAdd.add(Title1);

                    JLabel nID = new JLabel("Note ID no. :");
                    nID.setFont(new Font("Arial", Font.BOLD,18));
                    nID.setBounds(30,92,300,30);
                    pAdd.add(nID);

                    txtnID = new JTextField();
                    txtnID.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnID.setBounds(230,94,150,30);
                    txtnID.setText("000");
                    pAdd.add(txtnID);
                    txtnID.addFocusListener(new FocusListener(){
                            @Override
                            public void focusGained(FocusEvent e){
                                if(txtnID.getText().equals("000")){
                                    txtnID.setText("");
                                    txtnID.setForeground(Color.GRAY);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e){
                                if(txtnID.getText().isEmpty()){
                                    txtnID.setText("");
                                    txtnID.setForeground(Color.GRAY);
                                }
                            }
                        });

                    JLabel Name = new JLabel("Name: ");
                    Name.setFont(new Font("Arial", Font.BOLD,18));
                    Name.setBounds(30,152,300,30);
                    pAdd.add(Name);

                    txtnName = new JTextField();
                    txtnName.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnName.setText("Name");
                    txtnName.setEditable(false);
                    txtnName.setBounds(230,152,150,30);
                    pAdd.add(txtnName);
                    txtnName.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnName.getText().equals("Name")) {
                                    txtnName.setText("LOCKED");
                                    txtnName.setForeground(Color.GRAY);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnName.getText().isEmpty()) {
                                    txtnName.setText("Name");
                                    txtnName.setForeground(Color.GRAY);
                                }
                            }
                        });

                    JLabel Subject = new JLabel("Subject: ");
                    Subject.setFont(new Font("Arial", Font.BOLD,18));
                    Subject.setBounds(30,210,300,30);
                    pAdd.add(Subject);

                    txtnSubject = new JTextField();
                    txtnSubject.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnSubject.setText("Subject");
                    txtnSubject.setEditable(false);
                    txtnSubject.setBounds(230,210,150,30);
                    pAdd.add(txtnSubject);
                    txtnSubject.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnSubject.getText().equals("Subject")) {
                                    txtnSubject.setText("LOCKED");
                                    txtnSubject.setForeground(Color.GRAY);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnSubject.getText().isEmpty()) {
                                    txtnSubject.setText("Subject");
                                    txtnSubject.setForeground(Color.GRAY);
                                }
                            }
                        });

                    JLabel Title = new JLabel("Title: ");
                    Title.setFont(new Font("Arial", Font.BOLD,18));
                    Title.setBounds(30,268,300,30);
                    pAdd.add(Title);

                    txtnTitle = new JTextField();
                    txtnTitle.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnTitle.setText("Title");
                    txtnTitle.setEditable(false);
                    txtnTitle.setBounds(230,268,150,30);
                    pAdd.add(txtnTitle);
                    txtnTitle.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnTitle.getText().equals("Title")) {
                                    txtnTitle.setText("LOCKED");
                                    txtnTitle.setForeground(Color.GRAY);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnTitle.getText().isEmpty()) {
                                    txtnTitle.setText("Title");
                                    txtnTitle.setForeground(Color.GRAY);
                                }
                            }
                        });

                    JLabel Text = new JLabel("Text:");
                    Text.setFont(new Font("Arial", Font.BOLD,18));
                    Text.setBounds(30,326,300,30);
                    pAdd.add(Text);

                    txtnText = new JTextArea();
                    txtnText.setText("Text");
                    txtnText.setForeground(Color.GRAY);
                    txtnText.setFont(new Font("Arial",Font.PLAIN,14));
                    txtnText.setEditable(false);
                    txtnText.setBounds(28,358,530,250);
                    txtnText.setLineWrap(true);
                    txtnText.setWrapStyleWord(true);
                    JScrollPane scrollPane = new JScrollPane(txtnText);
                    scrollPane.setBounds(28,358,530,250);
                    scrollPane.setBackground(c);
                    pAdd.add(scrollPane);

                    txtnText.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                if (txtnText.getText().equals("Text")) {
                                    txtnText.setText("LOCKED");
                                    txtnText.setForeground(Color.GRAY);
                                }
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                if (txtnText.getText().isEmpty()) {
                                    txtnText.setText("Text");
                                    txtnText.setForeground(Color.GRAY);
                                }
                            }
                        });
                    Submit = new JButton("Submit");
                    Submit.setFont(new Font("Arial", Font.BOLD,20));
                    Submit.setBounds(120,628,150,25);
                    Color jb = new Color(204,204,204);
                    pAdd.add(Submit);
                    Submit.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if(txtnID.getText().equals("")){
                                    JOptionPane.showMessageDialog(null,"Enter Data", "Error", JOptionPane.WARNING_MESSAGE);
                                    txtnID.requestFocus();
                                }
                                else{
                                    String idUpdate = txtnID.getText();
                                    SearchNote sn = new SearchNote();
                                    sn.searchNoteGUI(idUpdate,f);
                                    f.setVisible(false);
                                }
                            }
                        });
                    Cancel = new JButton("Cancel");
                    Cancel.setFont(new Font("Arial", Font.BOLD,20));
                    Cancel.setBounds(330,628,150,25);
                    Cancel.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                p.setVisible(true);
                                pAdd.setVisible(false);
                            }
                        });
                    pAdd.add(Cancel);
                    p.setVisible(false);
                    pAdd.setVisible(true);
                }
            });
        p.add(searchNote);

        displayNote = new JButton("Display All Note");
        displayNote.setFont(new Font("Arial",Font.BOLD,20));
        displayNote.setBounds(150,445,300,30);
        displayNote.setBackground(c);
        displayNote.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    DisplayAllNote dal = new DisplayAllNote();
                    pAdd = new JPanel();
                    pAdd.setBackground(c);
                    pAdd.setLayout(null);
                    f.add(pAdd);
                    JLabel title = new JLabel("Display All");
                    title.setFont(new Font("Arial",Font.BOLD,24));
                    title.setBounds(230,15,520,30);
                    pAdd.add(title);
                    dal.displayNotes();
                    pAdd.add(dal.getSP());
                    p.setVisible(false);
                    pAdd.setVisible(true);
                    JButton back = new JButton("Back");
                    back.setFont(new Font("Arial", Font.BOLD, 20));
                    back.setBounds(240, 570, 120, 25);
                    back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                p.setVisible(true);
                                pAdd.setVisible(false);
                            }
                        });
                    pAdd.add(back);
                }
            });
        p.add(displayNote);

        Exit = new JButton("Exit");

        Exit.setFont(new Font("Arial",Font.BOLD,20));
        Exit.setBounds(150,530,300,30);
        Exit.setBackground(c);
        Exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        p.add(Exit);

        f.setVisible(true);

    }
}