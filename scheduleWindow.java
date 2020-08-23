import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.*;
import javax.swing.JLabel;
import java.lang.*;

public class scheduleWindow extends JFrame{
    static int width = 0, height = 0;
    static schedule gui;
    static JPanel panel = new JPanel(new GridBagLayout());
    static JFrame defaultFrame;
    static GridBagConstraints constraints = new GridBagConstraints();

    static void addWindow(int widthOfTemplate, int heightOfTemplate){
        width = widthOfTemplate;
        height = heightOfTemplate;

        JFrame  frame = new JFrame("Invoice System");
        frame.getContentPane();

        JLabel title = new JLabel("Click on one of the buttons to view your schedule: ");
        Dimension size = title.getPreferredSize();
        title.setBounds(width / 3, 100, size.width, size.height);
        panel.setLayout(null);
        panel.add(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        defaultFrame = frame;
    }

    static void setWindowName(String windowName){
        JLabel windowNameLabel = new JLabel(windowName);
        windowNameLabel.setHorizontalAlignment(JLabel.CENTER);
        windowNameLabel.setVerticalAlignment(JLabel.TOP);
        windowNameLabel.setSize(250, 250);
        windowNameLabel.setVisible(true);
        defaultFrame.add(windowNameLabel);
    }
    final static String []days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static void addDay(){
        JButton dayButton[] = new JButton[7];
        int current_x_position = 0;
        final int current_y_position = 350;

        for(int current_index = 0; current_index < days.length; current_index++){
            dayButton[current_index] = new JButton(days[current_index]);
            dayButton[current_index].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    gui = new schedule();
                    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gui.setSize(1000, 1000);
                    gui.setVisible(true);

                } 
            });
            Dimension buttonSize = dayButton[current_index].getPreferredSize();
            dayButton[current_index].setBounds(current_x_position, current_y_position, 120, buttonSize.height);
            panel.add(dayButton[current_index]);
            current_x_position += 125;
        }


    }
}