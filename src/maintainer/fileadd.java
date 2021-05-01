/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintainer;

import com.toedter.calendar.JCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class fileadd {
    JFrame ob;
    JLabel label1;
    JTextField textField1;
    JButton button1;
    JPanel panel1;
    public fileadd(){
        label1 =new JLabel("Add task:");
        textField1 = new JTextField(40);
        button1= new JButton("Submit");
        button1.addActionListener(new ButtonListener());
        panel1=new JPanel();
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(button1);
        
        ob=new JFrame("Add");
        ob.setSize(200,100);
        ob.setVisible(true);
        ob.add(panel1);
        
    }
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            PrintWriter pw = null;
            try {
                ArrayList<String >list2=new ArrayList<String>();
                File file = new File("Sakif.txt");
                pw = new PrintWriter(file);
                BufferedReader br =new BufferedReader(new FileReader(file));
                String s;
                try {
                    while((s=br.readLine())!=null){
                        pw.println(s);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(fileadd.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(fileadd.class.getName()).log(Level.SEVERE, null, ex);
                }
                s=textField1.getText();
                pw.println(s);
                pw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(fileadd.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                pw.close();
            }
            ob.setVisible(false);
        }

        
            
    }
                  
    
}
