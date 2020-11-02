import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * This program finds the factorial of a given number
 * @author Thomas Quigley
*/

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JButton calcButton;

  JTextField inputField;
  JTextField outputField;

  JLabel factorialLabel;
  JLabel nLabel;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 400 pixels by 100 pixels, and closes when you click on the X
    JFrame frame = new JFrame("AWT Factorial");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 100);
    frame.setVisible(true);

    // create the main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    // make the button and add it to the main panel
    calcButton = new JButton("CALC");
    calcButton.setBounds(310, 20, 80, 25);
    calcButton.addActionListener(this);
    calcButton.setActionCommand("calc");
    mainPanel.add(calcButton);
    

    // make the two text fields, add them to the main panel and make it so the output field isn't interactable
    inputField = new JTextField();
    outputField = new JTextField();

    inputField.setBounds(55, 20, 80, 25);
    outputField.setBounds(225, 20, 80, 25);

    mainPanel.add(inputField);
    mainPanel.add(outputField);

    outputField.setEnabled(false);

    // make the two labels and add them to the main panel
    factorialLabel = new JLabel("factorial(n)");
    nLabel = new JLabel("n");

    factorialLabel.setBounds(140, 20, 80, 25);
    nLabel.setBounds(25, 20, 40, 25);
    
    mainPanel.add(factorialLabel);
    mainPanel.add(nLabel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // if the calc button is pressed
    if (command.equals("calc")) {
      // get the users input
      String userInput = inputField.getText();
      int n = Integer.parseInt(userInput);
     
      // get the output
      int factorialOutput = factorial(n);

      // tell the user their output
      outputField.setText("" + factorialOutput);
    }

  }

  // method to get the factorial number
  public int factorial(int n) {
    // create the product variable
    int product = 1;

    // multiplies every number including n together
    for (int i = 1; i <= n; i++) {
      product = product * i;
    }
    // outputs the product
    return product;
  }


  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
