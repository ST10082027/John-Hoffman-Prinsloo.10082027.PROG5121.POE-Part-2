/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_tasklogger;

import javax.swing.JOptionPane;
/**
 *
 * @author johnhoffmanprinsloo
 */

/*=====================================================================================================================
*   POE_TaskLogger Class
*=====================================================================================================================
    * The main class that serves as the entry point to the Task Logger application.
    * It displays a welcome message and initializes the RunApplication class to start the application.
    * The user is then prompted to either login, create an account, or quit the application.
 */
public class POE_TaskLogger {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        RunApplication execute = new RunApplication();
        execute.registerAndLogin();
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
}
//=====================================================================================================================
