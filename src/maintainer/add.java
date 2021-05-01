/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintainer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author hp
 */
public class add {
    
    JLabel label,label2,label3,label4,label5,label6,label7,label8;
    JTextField f;
    JButton button3,button4,button5,button6,sun,mon,wed,tue,thurs,fri,sat;
    JScrollPane j;
    JPanel panel,p,p2,p4;
    GridBagConstraints gbc=new GridBagConstraints();
    GridBagConstraints gbc2=new GridBagConstraints();
    
    int k=0;
    JCheckBox a,b,c,d;
    JFrame ob;
    ArrayList <JLabel>list=new ArrayList<JLabel>();
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
    
    public add() throws FileNotFoundException{
        sun=new JButton("Sunday");
        sun.addActionListener(new ButtonDayListener());
        mon=new JButton("Monday");
        mon.addActionListener(new ButtonDayListener());
        tue=new JButton("Tuesday");
        tue.addActionListener(new ButtonDayListener());
        wed=new JButton("Wednesday");
        wed.addActionListener(new ButtonDayListener());
        thurs=new JButton("Thursday");
        thurs.addActionListener(new ButtonDayListener());
        fri=new JButton("Friday");
        fri.addActionListener(new ButtonDayListener());
        sat=new JButton("Saturday");
        fri.addActionListener(new ButtonDayListener());
        p4= new JPanel();
        p4.add(sun);
        p4.add(mon);
        p4.add(wed);
        p4.add(tue);
        p4.add(thurs);
        p4.add(fri);
        p4.add(sat);
        Date date=new Date();
        //hh:mm a
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/YYYY ");
        SimpleDateFormat sdf2 = new SimpleDateFormat("a");
//        label=new JLabel("Maintainer");
//        label.setForeground(Color.white);
        JButton button0=new JButton("Maintainer");
        button0.setBackground(Color.DARK_GRAY);
        button0.setForeground(Color.WHITE);
        button0.setBorderPainted(false);
        button0.addActionListener(new buttonlistener0());
        label2=new JLabel(""+sdf.format(date));
        //label7=new JLabel(" 20/05/28 ");
        //label8=new JLabel("11.05 pm     ");
        button3= new JButton("Add more task +");
        button3.addActionListener(new ButtonListener());
        button4=new JButton("Delete");
        button4.addActionListener(new DeleteListener());
        a=new JCheckBox();
        b=new JCheckBox();
        c=new JCheckBox();
        d=new JCheckBox();
        panel=new JPanel(new GridBagLayout());
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx=0;
        gbc.gridy=0;
        p=new JPanel();
        p2=new JPanel();
        p2.add(label2);
        //p2.add(label7);
       // p2.add(label8);
        p.add(button0);
        p.setBackground(Color.DARK_GRAY);
        File f=new File(Day_Of_Week+".txt");
        BufferedReader br1=new BufferedReader(new FileReader(f));
        String sn;
        list.clear();
        try {
            while((sn=br1.readLine())!=null){
                JLabel ly=new JLabel(sn);
                list.add(ly);
            }
            br1.close();
        } catch (IOException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
        JLabel lop=new JLabel(Day_Of_Week);
        panel.add(lop,gbc);
        gbc.gridy++;
        for(int i=0;i<list.size();i++){
            panel.add(list.get(i),gbc);
            gbc.gridy++;
        }
        
        panel .add(button3,gbc);
        gbc.gridy++;
        panel.add(button4,gbc);
        gbc.gridy++;
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 400, 400);
        JPanel contentPane = new JPanel(null);
        contentPane.setBackground(Color.red);
        contentPane.setPreferredSize(new Dimension(800, 800));
        contentPane.add(scrollPane,gbc2);
        JPanel panel3 =new JPanel(new GridBagLayout());
        //panel3.add(contentPane,gbc2);
        ob = new JFrame("Title");
        //ob.add(panel3);
        
        
        //ob.setContentPane(contentPane);
        ob.add(p,BorderLayout.NORTH);
        ob.add(p2,BorderLayout.WEST);
        ob.add(scrollPane,BorderLayout.CENTER);
        //ob.add(panel3,BorderLayout.CENTER);
        ob.add(p4,BorderLayout.SOUTH);
        ob.setSize(550,500);
        ob.setLocation(200,200);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }
    class buttonlistener0 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new Maintainer();
            ob.setVisible(false);
        }
        
    }
    

    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
            
            panel.remove(button3);
            panel.remove(button4);
            panel.validate();
            panel.repaint();
            new fileadd();
           
            
        }
    }
    class ButtonDayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            
            Day_Of_Week=null;
            if(e.getSource()==sun){
                Day_Of_Week="Sunday";
            }
            else if(e.getSource()==mon){
                Day_Of_Week="Monday";
            }
            else if(e.getSource()==tue){
                Day_Of_Week="Tuesday";
            }
            else if(e.getSource()==wed){
                Day_Of_Week="Wednesday";
            }
            else if(e.getSource()==thurs){
                Day_Of_Week="Thursday";
            }
            else if(e.getSource()==fri){
                Day_Of_Week="Friday";
            }
            else if(e.getSource()==sat){
                Day_Of_Week="Saturday";
            }
            //System.out.println(""+Day_Of_Week);
            panel.removeAll();
            panel.validate();
            panel.repaint();
            JLabel lo=new JLabel(Day_Of_Week);
            gbc.gridx=0;
            gbc.gridy=0;
            panel.add(lo,gbc);
            
            gbc.gridy++;
            ArrayList<JLabel> listk=new ArrayList<JLabel>();
            File filek=new File(Day_Of_Week+".txt");
            try {
                BufferedReader brd5=new BufferedReader(new FileReader(filek));
                //System.out.println(""+Day_Of_Week);
                String uv;
                try {
                    while((uv=brd5.readLine())!=null){
                        JLabel lp=new JLabel(uv);
                        listk.add(lp);
                    }
                    brd5.close();
                } catch (Exception ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<listk.size();i++){
                panel.add(listk.get(i),gbc);
                gbc.gridy++;
            }
            listk.clear();
            panel.add(button3,gbc);
            gbc.gridy++;
            panel.add(button4,gbc);
            gbc.gridy++;
            panel.validate();
            panel.repaint();
            
        }
        
    }
    ArrayList <String> sch=new ArrayList<String>();
    ArrayList <JLabel> listd=new ArrayList<JLabel>();
    ArrayList <JCheckBox> listch=new ArrayList<JCheckBox>();
    class DeleteListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String t;
           
            sch.clear();
            listch.clear();
            
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
            
            try {
                BufferedReader brd=new BufferedReader(new FileReader(Day_Of_Week+".txt"));
                try {
                    while((t=brd.readLine())!=null){
                        JLabel ld=new JLabel(t);
                        JCheckBox ch=new JCheckBox(t);
                        listd.add(ld);
                        listch.add(ch);
                        
                    }
                    brd.close();
                } catch (IOException ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
//            for(int i=0;i<listd.size();i++){
//                panel.remove(listd.get(i));
//                //gbc.gridy--;
//            }
            
            panel.validate();
            panel.repaint();
            gbc.gridy=0;
            JLabel lop=new JLabel(Day_Of_Week);
            panel.add(lop,gbc);
            gbc.gridy++;
            for(int i=0;i<listch.size();i++){
                listch.get(i).addItemListener(new ChListener(listch.get(i)));
                panel.add(listch.get(i),gbc);
                gbc.gridy++;
            }
            button5= new JButton("Done");
            button5.addActionListener(new button5Listener());
            panel.add(button5,gbc);
            gbc.gridy++;
            panel.validate();
            panel.repaint();
        }
        
    }
    
    class ChListener implements ItemListener{
        JCheckBox c1;
        
        ChListener(JCheckBox c){
            c1=c;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(c1.isSelected()){
                sch.add(c1.getText());
                
            }
        }
        
    }
    ArrayList<String>selected=new ArrayList<String>();
    ArrayList<JLabel>lab=new ArrayList<>();
    class button5Listener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.removeAll();
            panel.validate();
            panel.repaint();
            try {
                BufferedReader brd2=new BufferedReader(new FileReader(Day_Of_Week+".txt"));
                String g;
                selected.clear();
                try {
                    while((g=brd2.readLine())!=null){
                        selected.add(g);
                    }
                    brd2.close();
                } catch (IOException ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
            File f2= new File(Day_Of_Week+".txt");
            try {
                PrintWriter pw= new PrintWriter(f2);
                for(int i=0;i<selected.size();i++){
                    int l3=0;
                    for(int j=0;j<sch.size();j++){
                        if(selected.get(i).equals(sch.get(j))){
                            l3=1;
                        }
                    }
                    if(l3==0){
                        pw.println(selected.get(i));
                    }
                   
                        
                }
                 pw.close();
                
                selected.clear();
                sch.clear();
                panel.validate();
                panel.repaint();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                BufferedReader brd3= new BufferedReader(new FileReader(Day_Of_Week+".txt"));
                String h;
                lab.clear();
                try {
                    while((h=brd3.readLine())!=null){
                        JLabel p=new JLabel(h);
                        lab.add(p);
                    }
                    brd3.close();
                } catch (IOException ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
            panel.remove(button5);
            panel.validate();
            panel.repaint();
            gbc.gridy=0;
            JLabel lop=new JLabel(Day_Of_Week);
            panel.add(lop,gbc);
            gbc.gridy++;
            for(int i=0;i<lab.size();i++){
                panel.add(lab.get(i),gbc);
                gbc.gridy++;
            }
            panel.add(button3,gbc);
            gbc.gridy++;
            panel.add(button4,gbc);
            gbc.gridy++;
            panel.validate();
            panel.repaint();
            
                
        }
        
    }
    public static void main (String args[]){
        try {
            new add();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public class fileadd {
    JFrame ob1;
    JLabel label1,l1,l2,l3;
    JTextField textField1;
    JButton button1;
    JPanel panel1;
    JSpinner j1,j2;
    SpinnerDateModel sp1,sp2;
    public fileadd(){
        
        Date date=new Date();
        sp1= new SpinnerDateModel(date, null, null, Calendar.HOUR);
        sp2= new SpinnerDateModel(date, null, null, Calendar.HOUR);
        j1=new JSpinner(sp1);
        j2=new JSpinner(sp2);
        JSpinner.DateEditor de1=new JSpinner.DateEditor(j1,"hh:mm a");
        JSpinner.DateEditor de2=new JSpinner.DateEditor(j2,"hh:mm a");
        j1.setEditor(de1);
        j2.setEditor(de2);
        l1=new JLabel("-");
        l2=new JLabel("-");
        l3= new JLabel("-");
        label1 =new JLabel("Add task:");
        textField1 = new JTextField(10);
        button1= new JButton("Done");
        button1.addActionListener(new ButtonListener());
        panel1=new JPanel();
        panel1.add(label1);
        panel1.add(j1);
        panel1.add(l1);
        panel1.add(j2);
        panel1.add(l2);
        panel1.add(textField1);
        panel1.add(button1);
        
        ob1=new JFrame("Add");
        ob1.setSize(400,150);
        ob1.setLocation(400, 400);
        ob1.setVisible(true);
        ob1.add(panel1);
    }
    
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            panel.removeAll();
            
            panel.revalidate();
            panel.repaint();
            ArrayList<String> list3=new ArrayList<String>();
            try {
                File file = new File(Day_Of_Week+".txt");
                
                BufferedReader br =new BufferedReader(new FileReader(file));
                String s;
                list3.clear();
                list.clear();
                try {
                    while((s=br.readLine())!=null){
                        list3.add(s);
                        JLabel o= new JLabel(s);
                        list.add(o);
                    }
                     br.close();
                } catch (IOException ex) {
                    Logger.getLogger(fileadd.class.getName()).log(Level.SEVERE, null, ex);
                }
                PrintWriter pw = null;
                pw = new PrintWriter(file);
                for(int i=0;i<list3.size();i++){
                    pw.println(list3.get(i));
                    
                }
                list3.clear();
                Date date2= sp1.getDate();
                Date date3= sp2.getDate();
                SimpleDateFormat sdf1= new SimpleDateFormat("hh:mm a");
                s=textField1.getText();
                if(!s.isEmpty()){
                    pw.println(sdf1.format(date2)+" - "+sdf1.format(date3)+" - "+s);
                }
                pw.close();
                list.clear();
                BufferedReader br1= new BufferedReader(new FileReader(Day_Of_Week+".txt"));
                String s1;
                try {
                    while((s1=br1.readLine())!=null){
                        JLabel lx=new JLabel(s1);
                        list.add(lx);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
                JLabel lop= new JLabel(Day_Of_Week);
                 panel.add(lop,gbc);
                 gbc.gridy++;
                for(int i=0;i<list.size();i++){
                    panel.add(list.get(i),gbc);
                    gbc.gridy++;
                }
                
                
//                System.out.println(""+list.size());
//                System.out.println(""+list3.size());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(fileadd.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
               // pw.close();
            }
            ob1.setVisible(false);
            panel.add(button3,gbc);
            gbc.gridy++;
            panel.add(button4,gbc);
            gbc.gridy++;
            panel.validate();
            panel.repaint();
            
        }

        
            
    }
                  
    
}
    

 }
