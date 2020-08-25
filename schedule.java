//This class creates a table for the schedule of a specific day.

import java.awt.*;
import javax.swing.*;

public class schedule extends JFrame{
    JTable scheduleTable;
    String columns[] = {"Time", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    Object[][] data = new Object[24][8];

    public schedule() {

        int currentHour = 24;

        for(int i = 23; i >= 0; i--){
            data[i][0] = currentHour + ": 00";
            currentHour -= 1;
        }


        scheduleTable = new JTable(data, columns);
        scheduleTable.setPreferredScrollableViewportSize(new Dimension(50, 50));
        scheduleTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        add(scrollPane);
    }

    void addEvent(int row, int column, String event){
        boolean isValid = false;
        while(!isValid){
            if(column > 8 || column <= 0 || row > 24 || row <= 0){
                System.out.println("Invalid operation, please enter something valid!");
            }
            else{
                isValid = true;
                data[row][column] = event;
            }
        }
    }

    void closeOnExit(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
    public static void main(String[] args){
        schedule gui = new schedule();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000, 1000);
        gui.setVisible(true);
    }*/
}