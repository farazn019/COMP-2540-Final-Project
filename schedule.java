//This class creates a table for the schedule of a specific day.

import java.awt.*;
import javax.swing.*;

public class schedule extends JFrame{
    JTable scheduleTable;

    public schedule() {
        String columns[] = {"Time", "Event"};
        //For the time being I just started off filling the table schedule up with some values.
        Object[][] data = {{"1:00", "Stuff"}, {"2:00", "Stuff2"}};

        scheduleTable = new JTable(data, columns);
        scheduleTable.setPreferredScrollableViewportSize(new Dimension(50, 50));
        scheduleTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        add(scrollPane);
    }

    public static void main(String[] args){
        schedule gui = new schedule();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600, 600);
        gui.setVisible(true);
    }
}