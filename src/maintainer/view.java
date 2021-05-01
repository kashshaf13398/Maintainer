/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintainer;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static maintainer.Maintainer.music;

/**
 *
 * @author hp
 */
public class view {
    JLabel label,label2,label3,label4,label5,label6,label7,label8;
    JTextField f;
    JButton button3,button4,button5;
    JPanel panel,pView,p2;
    JCheckBox a,b,c,d;
    JFrame ob;
    String Day_Of_Week;
    Calendar cal= new GregorianCalendar();
    int dow=cal.get(Calendar.DAY_OF_WEEK);
    {
        
        if(dow==1){
            Day_Of_Week="Sunday";
        }
        else if(dow==2){
            Day_Of_Week="Monday";
        }
        else if(dow==3){
            Day_Of_Week="Tuesday";
        }
        else if(dow==4){
            Day_Of_Week="Wednesday";
        }
        else if(dow==5){
            Day_Of_Week="Thursday";
        }
        else if(dow==6){
            Day_Of_Week="Friday";
        }
        else if(dow==7){
            Day_Of_Week="Saturday";
        }
    }
    ArrayList <JLabel> listd=new ArrayList<JLabel>();
    ArrayList <JCheckBox> listch=new ArrayList<JCheckBox>();
    String t;
    GridBagConstraints gbc=new GridBagConstraints();
    GridBagConstraints gbc2=new GridBagConstraints();
    public view(){
//        label=new JLabel("Maintainer");
//        label.setSize(20, 40);
//        label.setForeground(Color.white);
        JButton button0= new JButton("Maintainer");
        button0.setBackground(Color.DARK_GRAY);
        button0.setForeground(Color.WHITE);
        button0.setBorderPainted(false);
        button0.addActionListener(new buttonlistener0());
        button5=new JButton("←");
       
        panel=new JPanel();
        //panel.add(button5);
        panel.add(button0);
        
        
        panel.setBackground(Color.DARK_GRAY);
        Date date=new Date();
        //hh:mm a
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/YYYY ");
        SimpleDateFormat sdf2 = new SimpleDateFormat("a ");
        label2=new JLabel(sdf.format(date));
        pView=new JPanel();
        pView.add(label2);
        p2=new JPanel(new GridBagLayout());
        JLabel lk=new JLabel(Day_Of_Week);
        gbc.gridx=0;
        gbc.gridy=0;
                
        p2.add(lk,gbc);
        gbc.gridy++;
        Thread t1=new Thread(){
            public void run(){
             Date date=new Date();
        
                
                int w=0;
                while(w==0){
                    Calendar c= new GregorianCalendar();
                    int hour=c.get(Calendar.HOUR);
                    int mins=c.get(Calendar.MINUTE);
                    int s=c.get(Calendar.AM_PM);
                    label2.setText(sdf.format(date)+" "+Integer.toString(hour)+":"+Integer.toString(mins)+" "+sdf2.format(date));
                    pView.validate();
                    pView.repaint();
                    
                    
                    
                
                    try {
                            sleep(5000);
                        } catch (InterruptedException ex) {
                            
                        }
                    
                    
                        
                }
            }
        };
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        
        
            try {
                BufferedReader brd=new BufferedReader(new FileReader("Currentday.txt"));
                try {
                    while((t=brd.readLine())!=null){
                        String q,qq[]=t.split("#");
                        JCheckBox ch;
                        if(qq[1].equals("0")){
                             ch=new JCheckBox(qq[0],false);
                        }
                        else
                        {
                            ch=new JCheckBox(qq[0],true);
                        }
                        ch.addItemListener(new CheckboxListener(ch));
                        listch.add(ch);
                        
                    }
                    brd.close();
                } catch (IOException ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
        for(int i=0;i<listch.size();i++){
            p2.add(listch.get(i),gbc);
            gbc.gridy++;
        }
        listch.clear();
        JButton button6=new JButton("View Rating");
        button6.addActionListener(new ButtonListener());
        p2.add(button6,gbc);
        gbc.gridy++;
        p2.validate();
        p2.repaint();
        JScrollPane scrollPane = new JScrollPane(p2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setBounds(50, 30, 400, 400);
        scrollPane.setSize(400,400);
        JPanel contentPane = new JPanel(new GridBagLayout());
        //contentPane.setPreferredSize(new Dimension(400, 400));
        contentPane.setSize(400,400);
        contentPane.setBackground(Color.red);
        contentPane.setVisible(true);
        contentPane.add(scrollPane);
        ob=new JFrame("View");
        ob.add(panel,BorderLayout.NORTH);
        ob.add(pView,BorderLayout.WEST);
        ob.add(scrollPane,BorderLayout.CENTER);
        ob.setSize(550,500);
        ob.setLocation(200,200);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class buttonlistener0 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new Maintainer();
            ob.setVisible(false);
        }
        
    }
    class CheckboxListener implements ItemListener{
        JCheckBox bx;
        public CheckboxListener(JCheckBox ch){
            bx=ch;
            
        }
        
        //String n= bx.getText();
        ArrayList<String>list=new ArrayList<String>();
        ArrayList<String>list2=new ArrayList<String>();
        @Override
        public void itemStateChanged(ItemEvent e) {
            String n=bx.getText();
            try {
                
                BufferedReader br= new BufferedReader(new FileReader("Currentday.txt"));
                String s;
                try {
                    while((s=br.readLine())!=null){
                        list.add(s);
                    }
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
            }
            File file=new File("Currentday.txt");
            String cor;
            
            try {
                PrintWriter pw= new PrintWriter(file);
                for(int i=0;i<list.size();i++){
                    String vu,dt[]=list.get(i).split("#");
                    //System.out.println(list.get(i));
                    if(dt[0].equals(n)){
                        if(dt[1].equals("0")){
                            cor=dt[0]+"#1";
                            //System.out.println(""+cor);
                        }
                        else{
                            cor=dt[0]+"#0";
                           // System.out.println(""+cor);
                        }
                        list2.add(cor);
                    }
                    else{
                        list2.add(list.get(i));
                    }
                        
                }
                for(int i=0;i<list2.size();i++){
                    //System.out.println(""+list2.get(i));
                    pw.println(list2.get(i));
                }
                pw.close();
                list.clear();
                list2.clear();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
        }
        
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                new rating();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
            }
            ob.setVisible(false);
        }
    }
    public static void main(String[] args) {
        view v= new view();
    }
    
}
