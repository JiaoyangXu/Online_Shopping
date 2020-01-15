/*
 * Name: Jiaoyang Xu
 * Purpose: Create a online shopping program to enable the customer to buy items online
 */
// import dimension to set dimensions
import java.awt.Dimension;
// import javax.swing to set JFrames
import javax.swing.*;
// import io.* to create Files
import java.io.*;
// import DecimalFormat to formatting numbers
import java.text.DecimalFormat;
// create the oop class
public class functions_online {
 // create DecimalFormat, call it mf
 DecimalFormat mf;
     
 // calculating tax for the main class
 // return double 
 public double taxCaculate (double originalPrice)
 {
  // tax is 0.13 * the parameter
  double tax = originalPrice*0.13;
  // return tax
  return tax;
 }
 // calculating grandtotal for the main class
 // return double
 public double grandTotal (double originalPrice)
 {
  // create delivery fee 3 dollar
  double ship = 3 ;
  // the grandtotal is paramter * 1.13 plus delivery fee
  originalPrice = originalPrice*1.13+ship;
    
  // return the grandtotal
  return originalPrice;
  
 }
 // Creating a 2D array for recording the transactions 
 // we need to know the payment of the order, the number of column it is, the recharing amount, and the remaining balance in credit card
 // return a String
 public String twoDarray (double payment, int column, double recharge, double start)
 {
  // set decimalFormat to 2 places
  mf = new DecimalFormat(".00");
  // Initailize and set the String to nothing
  String answer = "";
  
  // the remaining $ in debit card
  if(column == 0 )
  {
   // return the staring amount
       answer = mf.format(start);
       return answer;
  }
  
  // the $ of this cosumption 
  if(column ==1 )
  {
   // return the amount of payment
   return "-" + mf.format(payment);
  }
  
  // recharge 
  if(column == 2)
  {
   // return the amount of recharging
   return "+" + mf.format(recharge);
  }
  // closing amount 
  else
  {
   // return the difference between all parameters
   start = start - payment + recharge;
   return  mf.format(start);
  }

 }
 
 // create 2D array method for the main class
 // creating 4 labels that show the information of 4 columns
 public JLabel label (int row)
 {
  // when it is the first column 
  if(row ==0)
  {
   // set JLabel to amount
  JLabel one = new JLabel("Amount");
  //return it 
  return one;
  }
  
  // when it is the 2nd column 
  if(row ==1)
  {
   // set JLabel to consumption amount
      JLabel two = new JLabel("Consumption Amount");
   //return it 
      return two;

  }
  // when it is the 3rd column 
  if(row ==2 )
  {
   // set JLabel to recharges amount
      JLabel three = new JLabel("Recharge Amount");
   //return it 
      return three;
  }
  // when it is the 4th column 
  else
  {
   // set JLabel to new balance
      JLabel four = new JLabel("New Balance");
   //return it 
      return four;

  }

 }
 
 // Create error catching method for the main panel 
 public void numberError(String item)
 {
  // set the dimension of the JOptionPane to (200,200)
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   // tell the user that it is invalid for the parameter item
  JOptionPane.showMessageDialog(null, "Invalid input for" + item, "Error", JOptionPane.ERROR_MESSAGE);
 }
 // create JOptionPane method for the main panel
 public void shopping()
 {
  // set the dimension of the JOptionPane to (200,200)
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   // tell the user to engjoy shopping
  JOptionPane.showMessageDialog(null, "enjoy your shopping!", "Hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
 }
 // To store the order to files 
 public void write (String customer, String address, int counter , File dataFile,String c1,String c2, String p1, String p2, String s1, String s2, String b1, String b2)
 {
  // use try-catch to avoid error 
  try {
   // initialize String repeat to nothing, it will contain one more index each time increasing 
   String repeat = "";
   // check if the file name is already exist
   // we cannot write on an exsit file, this will cover the originial one   
   while(new File("H:Jason Order"+counter+repeat+".txt").isFile())
   {
    // add one more index to repeat
    repeat = repeat + "a";
   }
   // create a new file with an non-repeated name
   dataFile = new File("H:Jason Order"+counter+repeat+".txt");
   // create bufferedWrite to write all necessary information on this file
   BufferedWriter out = new BufferedWriter(new FileWriter(dataFile));
   // use array to add each component to the file
   String name[] = {c1, c2,p1,p2,s1,s2,b1,b2};
   // there are total of 8 component, so using loop to save time
   for(int a = 0 ; a < 7 ; a ++)
   {
    // when the String is not empty, add it on
    // when it is empty, we do not need to add it to the file
    if(name[a].isEmpty() == false)
    {
     // skip a line
     out.newLine();
     // write a line on the file
    out.write(name[a]);
    }
    
   }
   // adding shipping information
   // skip a line
   out.newLine();
   // adding address 
   out.write("Address: " + address);
   // skip a line
   out.newLine();
   // adding the name of customer
   out.write("Customer Name: " + customer);
   // close the bufferedWriter
   out.close();
   

  }
  catch(IOException e)
  {
   JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
  }

 }
 
 // To store the created account in files 
 public void Account (int counter , File accountFile,String name,String pw)
 {
  // initialize String repeat to nothing, it will contain one more index each time increasing 
  String repeat = "";
  // use try-catch to avoid error
  try {
   // check if the file name is already exist
   // we cannot write on an exsit file, this will cover the originial one
   while(new File("Account"+"1"+repeat+".txt").isFile())
   {
    // add one more index to repeat
    repeat = repeat + "1";
   }
   // create a new file with an non-repeated name
   accountFile = new File("Account"+"1"+repeat+".txt");
   // set bufferedWriter to write info
   BufferedWriter out = new BufferedWriter(new FileWriter(accountFile));
   // write the name to the first line
   out.write(name);
   // skip a line to write password
   out.newLine();
   // write the password to the second line
   out.write(pw);
      // close the buffered write -- done writing 
   out.close();
   

  }
  catch(IOException e)
  {
   JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
  }
}
 
 // To match the entered account name/password with the stored information in Files
 public boolean read (String name, String pw)
 {
  
            // Initialize String check to go through every files, since the files have silimar name
   String check = "1";
   // Initialize boolean checkName to check if the entered account name matches the stored one 
   boolean checkName = false;
   // Initialize boolean checkPW to check if the entered password matches the stored one
   boolean checkPW = false;
   // Initialize boolean correct to see whether it is correct
   // if both account Name and Password is correct, it will be correct
   boolean correct = false ;
   // use While loop to check all existing files that stores account info
   while(new File("Account" +check + ".txt" ).isFile())
   {
    // use try-catch to avoid numberFormatException error
    try
    {
     // Initialize boolean checkName to check if the entered account name matches the stored one 
     checkName = false;
     // Initialize boolean checkPW to check if the entered password matches the stored one
     checkPW = false;
     // Initialize String line1 to store the first line in file
     String line1 = "";
     // Initialize String line2 to store the first line in file
     String line2 = "";
     // Initialize FileReader and BufferedReader objects
     BufferedReader in = new BufferedReader(new FileReader("Account"+check+".txt"));
     // Read the first line from the text file
     line1 = in.readLine();
     // when name matches the stored one
     if(line1.equals(name))
     {
      // checkName changes to true --- the name is correct
      checkName = true;
     }
     // read the second line from the text file
     line2 = in.readLine();
     // when password matches the stored one
     if(line2.equals(pw))
     {
      // checkPW changes to true -- the password is correct
      checkPW = true;
     }
     // if both are true, the account is exsiting!
     if(checkName == true && checkPW == true)
     {
      // the entered accout is correct
      correct = true;
     }
     // Close BufferedReader stream
     in.close();
     check = check + "1";
    }
     
     // Output error message if exception is thrown
     catch (IOException e)
     {
      System.err.println("IOException:" + e.getMessage());
     }
    
   }
   // if the entered name and password is correct, return true
   if(correct == true)
   {
        return true ;
   }
   // if the entered name and password is correct, return false
   else
   {
     return false;

   }
   
  
 }
}
