import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class scheduleWindow extends JFrame{

    private String windowName;
    private int xValue, yValue, width = 0, height = 0;
    private double totalSum;

    JFrame defaultFrame;
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    void addWindow(int widthOfTemplate, int heightOfTemplate){
        width = widthOfTemplate;
        height = heightOfTemplate;
        JFrame  frame = new JFrame("Invoice System");
        frame.setPreferredSize(new Dimension(widthOfTemplate, heightOfTemplate));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        defaultFrame = frame;
        defaultFrame.getContentPane().add(panel);

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
        int current_y_position = 0;
        panel.setLayout(new GridBagLayout());
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
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weighty = 1;
            constraints.gridx = current_x_position;
            constraints.gridy = current_y_position;
            constraints.gridheight = 1;
            current_y_position += 1;
            panel.add(dayButton[current_index]);
        }


    }

    void setTotalSum(double price){ this.totalSum += price; }
    double getTotalSum(){ return(this.totalSum);}
}