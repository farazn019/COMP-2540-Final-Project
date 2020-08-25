# COMP-2540-Final-Project
This is our final project for the Data Structures and Algorithms course.
The group members in this project were: <i>Satya Bhandari</i>, <i>Hasan Faisal</i>,
<i>Marko Milovic</i> and <i>Faraz Naseem</i>. 




<h2>Design Of The Project</h2>
When we initally designed to create a scheduler, there were many designs factors
that we had to consider. Due to the nature of this project, there were a variety
of Data Structures we had decided to use such as: Linked Lists, Priority Queues,
Matrices, and arrays.

The inital design plan was to implement all those data structures simultaneously
and then have a visual representation of the weekly schedule as a GUI
using the Java Swing library. For the GUI we were thinking of implementing the 
days by using Buttons, and then the user would click on one of the buttons to
display the schedule for the day.



<h2>Problems Encountered</h2>
Although we were successful in implementing the Data Structures, and integrating
them together. As we got to the GUI, the complexity of the project increased 
drastically, due to the inital way the project was designed. 
By having a window that displays the days of the week as a button, and then 
clicking those buttons, we had increased the dependency of all the clases, and
this resulted in us using many static classes and static variables.



<h2>Solution To The Problems</h2>
The problem that we witnessed in the previous step was resolved by restructuring 
our GUI. So, instead of having clickable regions filled with buttons to represent
each day of the week, we ended up having one screen for the GUI with the first
column being the 24 hours of the day, and each column heading being the days of
the week. This reduced our need to use buttons to represent each of the seven 
days of the week, and our classes/class variables did not have to be static.



<h2>Final Product</h2>

This is an image of the code for the project:
https://github.com/farazn019/COMP-2540-Final-Project/blob/master/code.png

This is an image of the GUI after doing some operations:
https://github.com/farazn019/COMP-2540-Final-Project/blob/master/GUI-Image.png


