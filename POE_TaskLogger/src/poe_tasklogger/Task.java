/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_tasklogger;

import javax.swing.JOptionPane;

/**
 *
 * @author johnhoffmanprinsloo
 */
/*=====================================================================================================================
*     Task Class
*=====================================================================================================================
     * The Task class represents a task in the Task Logger application.
     * It stores the task's status, developer details, task name, description, duration, and task ID.
     * The task ID is generated based on the task count and developer's last name.
     * The class provides methods for checking the task description, creating a task ID, and printing task details.
 */
class Task {

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    Variables
    These are used to store information regarding the tasks of the user.*/
    private static int taskCount = 0;
    private String status;
    private String devFirstName;
    private String devLastName;
    private String taskName;
    private String description;
    private int duration;
    private String taskID;
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Constructor
    This is the constructor of the Task class. It takes task-related information as parameters and initializes the 
    corresponding instance variables. It also calls the createTaskID() method to generate a unique task ID for each task.
    */
    public Task(String status, String devFirstName, String devLastName, String taskName, String description, int duration) {
        this.status = status;
        this.devFirstName = devFirstName;
        this.devLastName = devLastName;
        this.taskName = taskName;
        this.description = description;
        this.duration = duration;
        this.taskID = createTaskID();
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method checks if the task description length is less than or equal to 50 characters. It returns true if the 
    description length is valid, otherwise it returns false.
    */
    public boolean checkTaskDescription() {
        return description.length() <= 50;
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method generates a unique task ID based on the task name, a task count (incremented for each task), and the last 
    three characters of the developer's last name. It returns the generated task ID.
    */
    public String createTaskID() {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" + devLastName.substring(devLastName.length() - 3).toUpperCase();
        taskCount++;
        return taskID;
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method generates a strings containing the task details (status, developer details, task number, task name, task 
    description, task ID, and duration) and displays it. It returns the generated task details string.
    */
    public String printTaskDetails() {
        String taskDetails = "Task Status: " + status + "\n"
                + "Developer Details: " + devFirstName + " " + devLastName + "\n"
                + "Task Number: " + taskCount + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + description + "\n"
                + "Task ID: " + taskID + "\n"
                + "Duration: " + duration + " hours";

        System.out.println(taskDetails);
        JOptionPane.showMessageDialog(null, taskDetails);
        return taskDetails;
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method returns the total number of tasks created so far.
    */
    public static int returnTotalHours() {
        return taskCount;
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
}
//=====================================================================================================================
