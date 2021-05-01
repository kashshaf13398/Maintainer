

package maintainer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Maintainer{
    JLabel label;
    JTextField f;
    JButton button1,button2;
    JPanel panel,p;
    JFrame ob;
    String Day_Of_Week;
    ArrayList<Integer> a=new ArrayList<Integer>();
    ArrayList<Integer> b=new ArrayList<Integer>();
    ArrayList<String> cd=new ArrayList<String>();
    ArrayList<String> cr=new ArrayList<String>();
    public static void music() throws IOException{
        try{
            Clip clip=  AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("1.wav")));
            clip.start();
        }catch(Exception e){
            
        }
    }
    public Maintainer(){
    
    Calendar cal= new GregorianCalendar();
    int dow=cal.get(Calendar.DAY_OF_WEEK);
    
        
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
    
        label=new JLabel("Maintainer");
        label.setForeground(Color.white);
        button1=new JButton("Build new routine");
        button2=new JButton("View current");
//        button1.setBorderPainted(false);
//        button1.setBackground(Color.white);
        
        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener2());
        panel=new JPanel();
        //panel.setBackground();
        //panel.add(label);
        panel.add(button1);
        panel.add(button2);
        p=new JPanel();
        p.add(label);
        p.setBackground(Color.DARK_GRAY);
        p.setBounds(0, 0, 1200, 350);
        ob = new JFrame("Title");
        ob.add(p,BorderLayout.NORTH);
        ob.add(panel);
        ob.setSize(700,500);
        ob.setLocation(200,200);
        ob.setVisible(true);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread t=new Thread(){
            public void run(){
             Date date=new Date();
        //hh:mm a
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/YYYY ");
        JLabel k=new JLabel();
        
                
                int w=0;
                while(w==0){
                    try {
                            sleep(20000);
                        } catch (InterruptedException ex) {
                            
                        }
                    Calendar c= new GregorianCalendar();
                    int hour=c.get(Calendar.HOUR);
                    int mins=c.get(Calendar.MINUTE);
                    int s=c.get(Calendar.PM);
                    System.out.println(hour);
                    k.setText(sdf.format(date)+" ");
                    try{
                    File file1=new File(Day_Of_Week+".txt");
                    BufferedReader br=new BufferedReader(new FileReader(Day_Of_Week+".txt"));
                    a.clear();
                    b.clear();
                    cd.clear();
                    cr.clear();
                    String se,sr,sy,su,sq;
                    try {
                        while((sq=br.readLine())!=null){
                            se=sq.substring(0, 2);
                            sr=sq.substring(3, 5);
                            sy=sq.substring(6, 8);
                            if(Integer.parseInt(se)==12){
                                a.add(0);
                            }
                            else{
                                a.add(Integer.parseInt(se));
                            }
              
                            b.add(Integer.parseInt(sr));
                            cr.add(sy);
                            cd.add(sq);
                            //System.out.println(se+" "+sr);
                        }
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Maintainer.class.getName()).log(Level.SEVERE, null, ex);
                    }}catch(FileNotFoundException e){
                        
                    }
                    System.out.println(""+c.get(Calendar.AM_PM)+Calendar.PM);
                    for(int i=0;i<a.size();i++){
                        if(a.get(i)==hour &&b.get(i)== mins ){
                            if((c.get(Calendar.AM_PM)==Calendar.AM && (cr.get(i).equals("AM")) || (cr.get(i).equals("PM") && c.get(Calendar.AM_PM)==Calendar.PM))){
                                try {
                                music();
                            } catch (IOException ex) {
                                Logger.getLogger(Maintainer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        JOptionPane.showMessageDialog(null, cd.get(i));
                            }
                                
                            
                        
                    }
//                        a.clear();
//                        b.clear();
//                        cd.clear();
                    }
                    
                
                    try {
                            sleep(20000);
                        } catch (InterruptedException ex) {
                            
                        }
                    
                    
                        
                }
            }
        };
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                new add();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Maintainer.class.getName()).log(Level.SEVERE, null, ex);
            }
            ob.setVisible(false);
            
        }
    } 
    class ButtonListener2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        Calendar cal= new GregorianCalendar();
        int dow=cal.get(Calendar.DAY_OF_WEEK);
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
        ArrayList<String> listk=new ArrayList<String>();
            File filek=new File(Day_Of_Week+".txt");
            try {
                BufferedReader brd5=new BufferedReader(new FileReader(filek));
                //System.out.println(""+Day_Of_Week);
                String uv;
                try {
                    while((uv=brd5.readLine())!=null){
                        
                        listk.add(uv);
                    }
                    brd5.close();
                } catch (Exception ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> listl=new ArrayList<String>();
            File filel=new File("Currentday"+".txt");
            try {
                BufferedReader brd5=new BufferedReader(new FileReader(filel));
                
                String uv;
                try {
                    while((uv=brd5.readLine())!=null){
                        
                        listl.add(uv);
                    }
                    brd5.close();
                } catch (Exception ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> listkl=new ArrayList<String>();
            File f=new File("Currentday.txt");
            PrintWriter pw= null;
            try{
            pw=new PrintWriter(f);
            if(listl.isEmpty()){
                for(int i=0;i<listk.size();i++){
                    pw.println(listk.get(i)+"#0");
                }
            }
            
            else /*if(!listl.isEmpty() && listk.size()!=listl.size())*/{
                int c=0;
                for(int i=0;i<listl.size();i++){
                    c=0;
                    String fi,uc[]=listl.get(i).split("#");
                    fi=uc[0];
                    for(int j=0;j<listk.size();j++){
                        if(fi.equals(listk.get(j))){
                            c=1;
                            break;
                        }
                    }
                    if(c==1){
                        listkl.add(listl.get(i));
                        
                    }
                }
                for(int i=0;i<listk.size();i++){
                    c=0;
                    for(int j=0;j<listl.size();j++){
                        String fj,st[]=listl.get(j).split("#");
                        fj=st[0];
                        if(listk.get(i).equals(fj)){
                            
                            c=1;
                            break;
                        }
                    }

                    if(c==0){
                        listkl.add(listk.get(i)+"#0");
                    }
                }
                for(int i=0;i<listkl.size();i++){
                    pw.println(listkl.get(i));
                }
            }
            pw.close();
            listk.clear();
            listl.clear();
            listkl.clear();
            }catch(FileNotFoundException g){
                
            }
            new view();
            ob.setVisible(false);
           
        
        }
        
    }
    public static void main(String args[]){
        Maintainer m= new Maintainer();
    }
}