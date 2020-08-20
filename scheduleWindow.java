import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.*;
import javax.swing.JLabel;
import java.lang.*;

public class scheduleWindow extends JFrame{

    private String windowName;
    private int xValue, yValue, width = 0, height = 0;
    private double totalSum;
    JPanel panel = new JPanel(new GridBagLayout());
    JFrame defaultFrame;
    GridBagConstraints constraints = new GridBagConstraints();

    void addWindow(int widthOfTemplate, int heightOfTemplate){
        this.width = widthOfTemplate;
        this.height = heightOfTemplate;

        JFrame  frame = new JFrame("Invoice System");
        frame.getContentPane();

        JLabel title = new JLabel("Click on one of the buttons to view your schedule: ");
        Dimension size = title.getPreferredSize();
        title.setBounds(this.width / 3, 100, size.width, size.height);
        panel.setLayout(null);
        panel.add(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        defaultFrame = frame;
    }

    void setWindowName(String windowName){
        this.windowName = windowName;
        JLabel windowNameLabel = new JLabel(this.windowName);
        windowNameLabel.setHorizontalAlignment(JLabel.CENTER);
        windowNameLabel.setVerticalAlignment(JLabel.TOP);
        windowNameLabel.setSize(250, 250);
        windowNameLabel.setVisible(true);
        defaultFrame.add(windowNameLabel);
    }
    final String []days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    void addDay(){
        JButton dayButton[] = new JButton[7];
        int current_x_position = 0;
        final int current_y_position = 350;

        for(int current_index = 0; current_index < days.length; current_index++){
            dayButton[current_index] = new JButton(days[current_index]);
            dayButton[current_index].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JFrame  new_frame = new JFrame("Schedule");
                    new_frame.setPreferredSize(new Dimension(width, height));
                    new_frame.setResizable(false);
                    new_frame.setVisible(true);
                    new_frame.pack();
                    new_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                }
            });
            Dimension buttonSize = dayButton[current_index].getPreferredSize();
            dayButton[current_index].setBounds(current_x_position, current_y_position, 120, buttonSize.height);
            panel.add(dayButton[current_index]);
            current_x_position += 125;
        }


    }

    void setTotalSum(double price){ this.totalSum += price; }
    double getTotalSum(){ return(this.totalSum);}
}