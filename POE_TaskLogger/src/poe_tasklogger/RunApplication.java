/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_tasklogger;

import java.util.Scanner;

/**
 *
 * @author johnhoffmanprinsloo
 */
/*=====================================================================================================================
    *RunApplication Class
*=====================================================================================================================
     * The RunApplication class handles the main functionality of the Task Logger application.
     * It allows users to register, login, and perform tasks related to task management.
     * The class provides methods for registering a user, logging in, handling the task menu,
     * and adding tasks.
 */
class RunApplication {

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    Variables
    registeredUser is an object that is accessible by the whole class.
    totalDuration is used to store the total duration of all the tasks combined*/
    private Login registeredUser;
    private int totalDuration = 0;
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method handles the registration and login process. It prompts the user to choose between login, create an account, 
    or quit. Depending on the user's choice, it calls the login(), register(), or terminates the program.
    */
    public void registerAndLogin() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("|  1  |  Login");
        System.out.println("|  2  |  Create an account");
        System.out.println("|  3  |  Quit");

        int chooseLoginOrRegister = userInput.nextInt();
        switch (chooseLoginOrRegister) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid input. Goodbye!");
                break;
        }
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method collects user input for registration (username, password, first name, last name) and creates an instance of
    the Login class with the provided information. It calls the registerUser() method of the Login class to register the
    user and displays the registration message. If the registration is successful, it calls the login() method to prompt the
    user to log in.
    */
    public void register() {
        Scanner registerInput = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("CREATE AN ACCOUNT");
        System.out.println("==============================");

        System.out.println("Enter a username:");
        String username = registerInput.nextLine();

        System.out.println("Enter a password:");
        String password = registerInput.nextLine();

        System.out.println("Enter your first name:");
        String firstName = registerInput.nextLine();

        System.out.println("Enter your last name:");
        String lastName = registerInput.nextLine();

        registeredUser = new Login(username, password, firstName, lastName);

        String registrationMessage = registeredUser.registerUser();
        System.out.println(registrationMessage);

        if (registrationMessage.equals("Registration successful.")) {
            // If registration was successful, prompt the user to login
            login();
        }
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method handles the login process. It prompts the user to enter their username and password, validates the input 
    by calling the loginUser() method of the Login class, and displays the login status message returned by the 
    returnLoginStatus() method of the Login class. If the login is successful, it calls the handleTaskMenu() method to start
    the task management menu.
    */
    public void login() {
        if (registeredUser == null) {
            System.out.println("No registered user found. Please register first.");
            return;
        }
        Scanner loginInput = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("LOGIN TO ACCOUNT");
        System.out.println("==============================");

        System.out.println("Enter your username:");
        String inputUsername = loginInput.nextLine();

        System.out.println("Enter your password:");
        String inputPassword = loginInput.nextLine();

        boolean isLoggedIn = registeredUser.loginUser(inputUsername, inputPassword);

        String loginStatusMessage = registeredUser.returnLoginStatus(isLoggedIn);
        System.out.println(loginStatusMessage);

        if (isLoggedIn) {
            handleTaskMenu();
        }
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method displays a menu for task management. It allows the user to add tasks, show a report (placeholder message),
    or quit the application. It uses a loop to continuously display the menu until the user chooses to quit. It calls the 
    addTask() method to add tasks and keeps track of the total task count and duration.
    */
    public void handleTaskMenu() {
        Scanner menuInput = new Scanner(System.in);
        boolean quit = false;
        int taskCount = 0;

        while (!quit) {
            System.out.println("\nSelect an option:");
            System.out.println("1) Add tasks");
            System.out.println("2) Show report (Coming Soon)");
            System.out.println("3) Quit");

            int menuChoice = menuInput.nextInt();
            menuInput.nextLine();

            switch (menuChoice) {
                case 1:
                    System.out.println("\nEnter the number of tasks to enter:");
                    int numTasks = menuInput.nextInt();
                    menuInput.nextLine();

                    for (int i = 0; i < numTasks; i++) {
                        System.out.println("\nTask " + (i + 1) + ":");
                        addTask();
                        taskCount++;
                    }
                    break;
                case 2:
                    System.out.println("\nComing Soon");
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }

        System.out.println("\nTotal task count: " + taskCount);
        System.out.println("Total duration: " + totalDuration);
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    * Method
    This method collects user input for creating a new task. It prompts the user to enter the task status, developer's first
    and last name, task name, task description, and duration. It creates an instance of the Task class with the provided 
    information and calls the printTaskDetails() method of the Task class to display the task details. It also updates the 
    total task duration.
    */
    public void addTask() {
        Scanner taskInput = new Scanner(System.in);
        String taskStatus;

        System.out.println("Enter task status:");
        System.out.println("|  1  |  ToDo");
        System.out.println("|  2  |  Done");
        System.out.println("|  3  |  Doing");

        int status = taskInput.nextInt();
        taskInput.nextLine();

        switch (status) {
            case 1:
                taskStatus = "ToDo";
                break;
            case 2:
                taskStatus = "Done";
                break;
            case 3:
                taskStatus = "Doing";
                break;
            default:
                System.out.println("Invalid status. Defaulting to ToDo.");
                taskStatus = "ToDo";
                break;
        }

        System.out.println("Enter developer's first name:");
        String devFirstName = taskInput.nextLine();
        System.out.println("Enter developer's last name:");
        String devLastName = taskInput.nextLine();
        System.out.println("Enter task name:");
        String taskName = taskInput.nextLine();
        System.out.println("Enter task description (up to 50 characters):");
        String description = taskInput.nextLine();

        if (description.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters");
            return;
        }

        System.out.println("Enter task duration (in hours):");
        int duration = taskInput.nextInt();
        taskInput.nextLine();

        Task newTask = new Task(taskStatus, devFirstName, devLastName, taskName, description, duration);
        newTask.printTaskDetails();

        totalDuration += duration;
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
}
//=====================================================================================================================
