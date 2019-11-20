import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ParkingTicket extends JFrame 
{
   private JPanel panel;
   private JLabel makeLabel,modelLabel,licNumberLabel,numMinutesLabel,purchasedMinutesLabel,officerNameLabel,badgeNumberLabel,baseFineLabel;
   private JTextField make;
   private JTextField model;
   private JTextField licNumber;
   public JTextField numMinutes;
   public JTextField purchasedMinutes;
   private JTextField officerName;
   private JTextField badgeNumber;
   public JTextField baseFine;
   private JButton calButton;
   private double totalFine;
   private final int WINDOW_WIDTH = 400;
   private final int WINDOW_HEIGHT = 100;
   
   public ParkingTicket()
   {
      // set title
      setTitle("Parking Ticket Fine Information");
      // set the size of the window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      // specify an action for the close button
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // build the panel and add it to the frame
      buildPanel();
      // add the panel to the frame's contant pane
      add(panel);
      // Display the window
      setVisible(true);
   }
   
   private void buildPanel()
   {
      // create the label
      makeLabel = new JLabel("Enter the make of the car");
      // create the text field
      make = new JTextField(10);
      
      modelLabel = new JLabel("Enter model of the car");
      model = new JTextField(10);
      
      licNumberLabel = new JLabel("Enter the licnumber of the car");
      licNumber= new JTextField(10);
      
      numMinutesLabel = new JLabel("Enter the number of the minutes car has been parked");
      numMinutes = new JTextField(10);
       
      //mLabel = new JLabel("Enter the make of the car");
      //numMinutes = new JTextField(10);
      
      purchasedMinutesLabel = new JLabel("Enter the purchased  minutes of the car");
      purchasedMinutes = new JTextField(10);
      
      officerNameLabel = new JLabel("Enter the officer name");
      officerName = new JTextField(10);
      
      badgeNumberLabel = new JLabel("Enter the badge number of the officer");
      badgeNumber = new JTextField(10);
      
      baseFineLabel = new JLabel("Enter the base fine of the car");
      baseFine = new JTextField(10);
      
     // mLabel = new JLabel("Enter the make of the car");
     // create a button with caption "TotalFine"
     calButton = new JButton("Total Fine ");
     // add an action listener for this button
     calButton.addActionListener(new CalButtonListener());

      
      // create a panel and add the components to it
      panel = new JPanel();
      panel.add(makeLabel);
      panel.add(make);
      panel.add(modelLabel);
      panel.add(model);
      panel.add(licNumberLabel);
      panel.add(licNumber);
      panel.add(numMinutesLabel);
      panel.add(numMinutes);
      panel.add(purchasedMinutesLabel);
      panel.add(purchasedMinutes);
      panel.add(officerNameLabel);
      panel.add(officerName);
      panel.add(badgeNumberLabel);
      panel.add(badgeNumber);
      panel.add(baseFineLabel);
      panel.add(baseFine);
      panel.add(calButton);
      
      }
      // create an action listener class
      private class CalButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            int min=0;
            int fine;
            int hour = min/60;
            //double fine = 25;
            int adFine = 10;
            double illegalMinutes;
            int extraFine = 0;
            //totalFine = (Double.parseDouble(baseFine.getText())+ adFine);
            
          illegalMinutes = (Double.parseDouble(numMinutes.getText())) - (Double.parseDouble(purchasedMinutes.getText()));                   
            //illegalMinutes = (numMinutes - purchasedMinutes);
           JOptionPane.showMessageDialog(null,"Illegal minutes is " + illegalMinutes); 
            //fine = baseFine.getText();
            if(illegalMinutes<= 60)
            {
               totalFine = (Double.parseDouble(baseFine.getText()));
               JOptionPane.showMessageDialog(null,"Fine is " + totalFine);
                               
            }
            
            else if(illegalMinutes>60) {
               
               double extra = illegalMinutes/60;
               
               for(int i = 1; i <= extra; i++){
                  extraFine = extraFine + 10; 
               }
               totalFine = (Double.parseDouble(baseFine.getText())+ extraFine);
               JOptionPane.showMessageDialog(null,"Fine is " + totalFine);
            } 
            
            
         }
      }





      
   
   public static void main(String[]args)
   {
      new ParkingTicket();
   }
}