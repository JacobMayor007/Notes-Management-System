import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import javax.swing.JTable;
public class DisplayAllNote extends Note {
    private JScrollPane sp;

    public DisplayAllNote() {
        super();
        JTable table = new JTable();
        table.setFont(new Font("Arial", Font.PLAIN,14));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        sp = new JScrollPane(table);
        sp.setBounds(28,50,530,500);
    }

    public JScrollPane getSP() {
        return sp;
    }

    public void displayNotes() {
        String[] columnNames = {"Note"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        try {
            FileInputStream fis = new FileInputStream("Notes Managements.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String text;
            while((text = br.readLine()) != null) {
                model.addRow(new Object[]{text});
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        JTable table = (JTable) sp.getViewport().getView();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(sp.getWidth());
    }
}