/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintainer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class rating {
    JLabel label,label2,label3,label4,label5,label6,label7,label8;
    JTextField f;
    JButton button3,button4;
    JPanel panel,p,p2;
    JCheckBox a,b,c,d;
    JFrame ob;
    public rating() throws FileNotFoundException{
//        label=new JLabel("Maintainer");
//        label.setForeground(Color.white);
        JButton button0=new JButton("Maintainer");
        button0.setBackground(Color.DARK_GRAY);
        button0.setForeground(Color.WHITE);
        button0.setBorderPainted(false);
        button0.addActionListener(new buttonlistener0());
        Date date=new Date();
        //hh:mm a
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/YYYY ");
        SimpleDateFormat sdf2 = new SimpleDateFormat("a ");
        label2=new JLabel(sdf.format(date));
        //panel=new JPanel();
        p=new JPanel();
        p.add(button0);
        p2=new JPanel();
        p2.add(label2);
        p.setBackground(Color.DARK_GRAY);
       
        ob = new JFrame("Title");
        ob.add(p,BorderLayout.NORTH);
        ob.add(p2,BorderLayout.WEST);
        
        ob.setSize(500,500);
        ob.setLocation(200,200);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);Thread t1=new Thread(){
            public void run(){
             Date date=new Date();
        
                
                int w=0;
                while(w==0){
                    Calendar c= new GregorianCalendar();
                    int hour=c.get(Calendar.HOUR);
                    int mins=c.get(Calendar.MINUTE);
                    int s=c.get(Calendar.AM_PM);
                    label2.setText(sdf.format(date)+" "+Integer.toString(hour)+":"+Integer.toString(mins)+" "+sdf2.format(date));
                    p2.validate();
                    p2.repaint();
                    
                    
                    
                
                    try {
                            sleep(5000);
                        } catch (InterruptedException ex) {
                            
                        }
                    
                    
                        
                }
            }
        };
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        int c=0;
        int k=0;
        BufferedReader br= new BufferedReader(new FileReader("Currentday.txt"));
        String s;
        try {
            while((s=br.readLine())!=null){
                k++;
                String uv[]=s.split("#");
                //System.out.println(""+uv[0]+" "+uv[1]);
                if(uv[1].equals("1")){
                    c++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(rating.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(""+c+" "+k);
        double l=(c*100)/k;
        //System.out.println(""+l);
        String h=Double.toString(l);
        JLabel lk=new JLabel("Routine Maintained today: "+h+"%");
        panel=new JPanel(new GridBagLayout());
        panel.add(lk);
        ob.add(panel,BorderLayout.CENTER);
    }
    class buttonlistener0 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new Maintainer();
            ob.setVisible(false);
        }
        
    }
    
    public static void main(String[] args) {
        try {
            rating r=new rating();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(rating.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
