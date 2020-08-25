//This class creates a table for the schedule of a specific day.

//The necessary import are made.
import java.awt.*;
import javax.swing.*;
import java.awt.Color;

//Creates a schedule class which implements the JFrame abstract class.
public class schedule extends JFrame{
    //The scheduleTable variable is declared.
    JTable scheduleTable;
    //The columns variable will hold the columns of the JTable.
    String columns[] = {"Time", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    //The object multi-dimensional array is created with 24 rows and 8 columns.
    Object[][] data = new Object[24][8];

    //Constructor.
    public schedule() {

        //This will keep track of the hour.
        int currentHour = 24;
        
        //The left-most column of the schedule table is filled with hours values for 24 hours. It starts from 1am, and ends at 12am.
        for(int i = 23; i >= 0; i--){
            data[i][0] = currentHour + ": 00";
            //Due to the fact that, we initally start at the end, the currentHour is decreased by one, to add all the hours of the day in the table.
            currentHour -= 1; 
        }

        //The dimensions and values of schedule table are initalized.
        scheduleTable = new JTable(data, columns);
        //Sets the background colour of a row to green, when selected.
        scheduleTable.setSelectionBackground(new java.awt.Color(0, 255, 0));
        //Sets the grid colour of the table to red.
        scheduleTable.setGridColor(new java.awt.Color(255, 0, 0));
        scheduleTable.setPreferredScrollableViewportSize(new Dimension(50, 50));
        scheduleTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        add(scrollPane);
    }

    //This method adds an event to the JTable.
    void addEvent(int row, int column, String event){
        //If the user enters something that isn't valid then they will be prompted with the Invalid operation output.
        if(column > 8 || column <= 0 || row > 24 || row <= 0){
            System.out.println("Invalid operation, please enter something valid!");
        }
        //The else-statement is run if the user enters some value, and this value is added to the schedule table.
        else{
            data[row - 1][column] = event;
        }
    }

    //This function will close the schedule table, if the user exits.
    void closeOnExit(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}