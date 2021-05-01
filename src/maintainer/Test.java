/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintainer;

/**
 *
 * @author hp
 */
import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class Test {
    public static void main(String[] args) {
        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null,
                                                      Calendar.DAY_OF_MONTH);
        JSpinner spinner = new JSpinner(model);
        String format = "dd MMM yyyy";
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, format);
        spinner.setEditor(editor);
        model.addChangeListener(new ChangeListener() {
            DateFormat intFormat = new SimpleDateFormat("M");
            DateFormat strFormat = new SimpleDateFormat("MMM");
 
            public void stateChanged(ChangeEvent e) {
                Date date = ((SpinnerDateModel)e.getSource()).getDate();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int monthIndex = calendar.get(Calendar.MONTH);
                System.out.printf("monthIndex: %d  month: %s  %s%n",
                                   monthIndex, 
                                   intFormat.format(date),
                                   strFormat.format(date));
            }
        });
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(spinner, new GridBagConstraints());
     
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        f.setSize(200,100);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
