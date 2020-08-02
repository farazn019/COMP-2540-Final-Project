import java.awt.*;
import javax.swing.*;

public class scheduleWindow{

    private String windowName;
    private int xValue;
    private int yValue;
    private double totalSum;

    JFrame defaultFrame;
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    void addWindow(int widthOfTemplate, int heightOfTemplate){
        JFrame  frame = new JFrame("Invoice System");
        frame.setPreferredSize(new Dimension(widthOfTemplate, heightOfTemplate));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        defaultFrame = frame;
        defaultFrame.getContentPane().add(panel);
        /*
        panel = new JPanel(new GridBagLayout());
        panel.setConstraints(new GridBagLayout());
        constraints = new GridBagConstraints();*/

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

    void addDay(){
        String []days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JButton day;
        int current_x_position = 0;
        int current_y_position = 0;
        panel.setLayout(new GridBagLayout());
        for(int current_index = 0; current_index < days.length; current_index++){
            day = new JButton(days[current_index]);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weighty = 1;
            constraints.gridx = current_x_position;
            constraints.gridy = current_y_position;
            constraints.gridheight = 1;
            current_y_position += 1;
            panel.add(day);
        }
    }

    void setTotalSum(double price){ this.totalSum += price; }
    double getTotalSum(){ return(this.totalSum);}
}