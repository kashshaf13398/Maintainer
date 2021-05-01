/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintainer;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class check {

    JLabel label, label2;
    JTextField f;
    JButton button1, button2;
    JPanel panel, p;
    JFrame ob;
    static ArrayList<JLabel> l = new ArrayList<JLabel>();

    public check() throws FileNotFoundException, IOException {
        File file = new File("Sakif.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(testtext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            
            if(!line.equals("mim")){
                label = new JLabel(line);
                l.add(label);
            }
            
        }
        br.close();

        label = new JLabel("Maintainer");
        label.setForeground(Color.white);

        panel = new JPanel();
        //panel.setBackground();
        //panel.add(label);
        //panel.add(f);
        //panel.add(button1);
        for(int i=0;i<l.size();i++){
            panel.add(l.get(i));
        }
        l.clear();
        p = new JPanel();
        p.add(label);
        p.setBackground(Color.DARK_GRAY);
        p.setBounds(0, 0, 1200, 350);
        ob = new JFrame("Title");
        ob.add(p, BorderLayout.NORTH);
        ob.add(panel);
        ob.setSize(700, 500);
        ob.setLocation(200, 200);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        try {
            check t = new check();
        } catch (IOException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
