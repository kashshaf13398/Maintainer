package maintainer;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class testtext {
    JDateChooser d;
    //Font font = new Font(Th, style, size);
    JTextField f;
    JCalendar c;
    JLabel label;
    JButton button1, button2;
    JPanel panel, p,p2;
    JFrame ob;
    JSpinner j;
    SpinnerDateModel sp;
    Date date;
    JCheckBox ch;
    public testtext() {
        ch=new JCheckBox("Sakif", true);
        date=new Date();
        label = new JLabel("Maintainer");
        label.setForeground(Color.white);
        f = new JTextField(20);
        button1 = new JButton("Submit");
        button1.addActionListener(new ButtonListener());
        //c=new JCalendar();
        //d=new JDateChooser();
        sp=new SpinnerDateModel(date,null,null,Calendar.HOUR);
        j=new JSpinner(sp);
        JSpinner.DateEditor de= new JSpinner.DateEditor(j,"hh:mm a");
        j.setEditor(de);
        panel = new JPanel();
        p2=new JPanel();
        //panel.setBackground();
        //panel.add(label);
        panel.add(f);
        
        panel.add(button1);
       // p2.add(c);
        //p2.add(d);
        p2.add(j);
        p2.add(ch);
        p = new JPanel();
        p.add(label);
        p.setBackground(Color.DARK_GRAY);
        p.setBounds(0, 0, 1200, 350);
        ob = new JFrame("Title");
        p.setSize((int)ob.getHeight(), ob.getHeight());
        ob.add(p, BorderLayout.NORTH);
        ob.add(p2,BorderLayout.WEST);
        ob.add(panel);
        ob.setSize(700, 500);
        ob.setLocation(200, 200);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static ArrayList<String> list = new ArrayList<String>();

    public static void add(File f,String s) throws FileNotFoundException, IOException {

        int i;
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        PrintWriter pw = new PrintWriter(f);
        for (i = 0; i < list.size(); i++) {
            pw.println(list.get(i));
        }
        pw.println(s);
        pw.close();
        list.clear();
    }
    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s;
            s = f.getText();
            System.out.println(s);
            File file = new File("Sakif.txt");
            SimpleDateFormat sdf = new SimpleDateFormat(" hh:mm a");
            
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(testtext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                add(file,s);
            } catch (IOException ex) {
                Logger.getLogger(testtext.class.getName()).log(Level.SEVERE, null, ex);
            }
           Date date = ((SpinnerDateModel)sp).getDate();
           SimpleDateFormat sdf2 = new SimpleDateFormat("E MM/dd/YYYY hh:mm a");
            System.out.println(""+sdf.format(date)); 
           

        }
    }
    public static void main(String args[]) {
        testtext t = new testtext();
    }
}
