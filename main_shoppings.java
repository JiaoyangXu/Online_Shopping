/*
 * Name: Jason Xu 
 * Started Date: Jan 8
 * Completion Date: Jan 17
 * Purpose: Create a online shopping program to enable the customer to buy items online
 */

//Imports all java awt, awt.Dimension, swing and event.
//import color class that can  get color
import java.awt.Color;
//import color class for the dimension
import java.awt.Dimension;
//import classes from awt 
import java.awt.Font;
//import it to GridLayout 
import java.awt.GridLayout;
//import it to add image
import java.awt.Image;
//import window to make a window
import java.awt.Window;
//import swing class that can use swing component architecture
import javax.swing.*;
//import it to make ItemListener/ buttonListener work 
import java.awt.event.*;
// import io.file to enable creating files
import java.io.File;
//import DecimalFormat to make the program looks neat
import java.text.DecimalFormat;
import java.util.*;
//create my class 
public class main_shoppings extends JFrame {
 public static void main(String [] args)
 {
  new main_shoppings();
 }

 private File[] data,account;
//initialize txtname,txtpw to represents the JTextField
 private JTextField txtname,txtpw,txtCreateName,txtCreatePW;
//initialize  btnCloth,btnPant,btnShoe,btnBag represents the JButton
 private JButton btnCloth,btnPant,btnShoe,btnBag;
//initialize confirmc1,confirmc2,confirmp1,confirmp2,confirms1,confirms2,confirmb1,confirmb2 represents the JButten
 private JButton confirmc1,confirmc2,confirmp1,confirmp2,confirms1,confirms2,confirmb1,confirmb2;
//initialize JButton cart,btnlog,btnSign,btnCheckou
 private JButton cart,btnlog,btnSign,btnCheckout,btnCreateOK;
//initialize labels to show information about the order
 private JLabel lbCloth1,lbCloth2,lbPant2,lbPant1,lbShoe1,lbShoe2,lbBag1,lbBag2;
//count the number of toppings that is ordered
 private JLabel lbCP1,lbCP2,lbPP1,lbPP2,lbSP1,lbSP2,lbBP1,lbBP2;
//initialize lbname lbpw lbLog
 private JLabel lbname,lbpw,lbLog,lbCreateName,lbCreatePW;
//initialize panel to show panelCloth,panelPant,panelShoe,panelBag,panelCart,panelLog,panelHistory,panelDetail
 private JPanel panelCloth,panelPant,panelShoe,panelBag,panelCart,panelLog,panelHistory,panelDetail,panelCreate;
//initialize 20 radio button 
 private JRadioButton sizeSmallC1,sizeMediumC1,sizeLargeC1,sizeSmallC2,sizeMediumC2,sizeLargeC2,sizeSmallP1,sizeMediumP1,sizeLargeP1,sizeSmallP2,sizeMediumP2,sizeLargeP2,sizeSmallS1,sizeMediumS1,sizeLargeS1,sizeSmallS2,sizeMediumS2,sizeLargeS2;
//initialize six radio button to represents the radioButtons 
 private JRadioButton sizeSmallB1,sizeMediumB1,sizeLargeB1,sizeSmallB2,sizeMediumB2,sizeLargeB2;
//doubles to store the prices 
 private double clothPrice1,clothPrice2,pantPrice1,pantPrice2,shoePrice1,shoePrice2,bagPrice1,bagPrice2;
//initialize ButtonGroup size to connect 3 buttons to a group
 private ButtonGroup sizeC1,sizeC2,sizeP1,sizeP2,sizeS1,sizeS2,sizeB1,sizeB2;
//initialize JcomboBox to let the user select the number of items
 private JComboBox<String> cboC1, cboC2, cboP1, cboP2,cboS1, cboS2, cboB1, cboB2 ;
 // initialize labels to show information about the order
 private JLabel cartC1,cartC2,cartP1,cartP2,cartS1,cartS2,cartB1,cartB2,lbcartPrice,lbcartTax,lbcartShip,lbcartGrand,lbcartPrice1,lbcartTax1,lbcartShip1,lbcartGrand1;
 // doubles to store the prices 
 private double cartPrice;
 //initialize mf of decimalformat
 private DecimalFormat mf;
 // use methods from CPT class
 private functions_online cpt = new functions_online();
//initialize three JButton
private JButton btnHistory, btnRecharge, btnDetail;
//initialize labels to show information about the array
private JLabel try1[][];
//doubles to store the prices 
private double recharge ;
//store make by the user
 private String hello;
//initialize use double of array
private Double payment[],recharge2[],start[];
//initialize counter by int 
private int counter;
//initialize labels to show information about the order
private JLabel lbAmount,lbRecharge,lbConsuption,lbBalance;
//initialize imageIcon to store image
private ImageIcon imgJacket, imgHoodie, imgIcon,imgJean,imgPant,imgOxford,imgCasuel,imgMess,imgTravel;
//initialize labels to show information about the order
 private JLabel lbJacket,lbHoodie,lbJean,lbPant,lbOxford,lbCasuel,lbMess,lbTravel,lbPoster;
//initialize imageIcon to store image
 private ImageIcon imgCloth,imgPant2,imgShoe,imgBag,imgCart,imgCard,imgPoster;
 //address, phone number
 private JLabel lbAddress,lbPhone;
//initialize JTextField to txtAddress,txtPhone
 private JTextField txtAddress,txtPhone;
 // new panel to store goods
 private JPanel panelCloth1,panelCloth2,panelPant1,panelPant2,panelShoe1,panelShoe2,panelBag1,panelBag2;
 //new panel to store goods
 private int checkoutCounter,accountCounter;
 //initialize JButtons to allow the user to clear all info, and create new accounts
 private JButton btnClear,btnCreate;
 // initialize boolean to check whether the entered Username matches the stored one
 private boolean accountsuccess;
    public main_shoppings()
 {
    	// Initialize Checkout Counter to recored the number of times the customer click checkout
    	// It is used for File Writing
    	// As the checkoutCounter increases by 1, I create a new File to record the order
    	// Therefore, each order is stored in a separate file
    	// It is good for delivery and accounting purpose, because the employees knows each order
    	checkoutCounter = 0;
    	
    	//Initialize accountCounter to record the number of account that is created
    	// Use its value to create Files that store the account information
    	accountCounter = 0; 
    	
    	   // variable counter to counter the number of indexes in the payment array
    	   // counter represents the number of rows in the 2D array 
    	   // counter is counting the number of purchases 
    	   counter = 1;

    	
    	// Initialize btnCreate to allow user create new account
    	btnCreate = new JButton("New here? Create an account");
    	// add actionListener to it
    	btnCreate.addActionListener(new CreateListener());
    	
    	// Initialize btnCreateOK to done creating the account
    	btnCreateOK = new JButton("Create Account");
    	// add Actionlistener to it
    	btnCreateOK.addActionListener(new createOKListener());
    	
    	// initialize boolean accountsuccess to determine whether the account exits
    	accountsuccess = true;
    	
    	// Initialize JLabels to show user the needed information to create a new account
    	lbCreateName = new JLabel("Create Username:");
    	// initialize JLabel to prompt the user to enter password
    	lbCreatePW = new JLabel("Create Password:");
     // initialize File data to store the order for delivery
    	data = new File[100];
    	// initialize account files to store the created accounts
        account = new File[100];
    	
    	
   	 // Initialize and create a JLabel to store the lbAddress to Your Adress
    	lbAddress = new JLabel("Your Adress");
   	 // Initialize and create a JLabel to store the lbAPhone toYour Phone number
    	lbPhone = new JLabel("Your Phone number");
    	// initialize and set position of txtAddress
    	txtAddress = new JTextField(20);
    	// initialize and set position of txtPhone
    	txtPhone = new JTextField(20);
    	
    	// initialize imgIcons for JButtons
    	//initialize and set image tatal is jacket and set adress of imgCloth 
    	  imgCloth = new ImageIcon(new ImageIcon("jacket.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	//initialize and set image tatal is pant2 of imgpant2 and set adress
    	  imgPant2 = new ImageIcon(new ImageIcon("pant2.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	//initialize and set image tatal is shoe of imgshoe and set adress
    	  imgShoe = new ImageIcon(new ImageIcon("shoe.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	//initialize and set image tatal is bag of imgshoe and set adress
    	  imgBag = new ImageIcon(new ImageIcon("bag.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	//initialize and set image tatal is cart of imgshoe and set adress
    	  imgCart = new ImageIcon(new ImageIcon("cart.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    	//initialize and set image tatal is card of imgshoe and set adress
    	  imgCard = new ImageIcon(new ImageIcon("card.jpg").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));

          // create image for the front page of the program
          imgPoster = new ImageIcon(new ImageIcon("spring1.jpg").getImage().getScaledInstance(640, 300, Image.SCALE_DEFAULT));
             lbPoster  = new JLabel();
             lbPoster.setIcon(imgPoster);
        // Initialize picture for cloths
     
     // Initialize lbJacket and imgJacket to show the custmer the image of the jacket
     // Initialize and create a JLabel to store the payment icon later 
     lbJacket = new JLabel();
     // create a imageIcon to store the picture
     imgJacket = new ImageIcon(new ImageIcon("jacket.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
     // store the icon in the label
     lbJacket.setIcon(imgJacket);
     
     
   // Initialize picture for hoodie 
   // Initialize and create a JLabel to store the payment icon later 
   lbHoodie = new JLabel();
   // create a imageIcon to store the picture
   imgHoodie = new ImageIcon(new ImageIcon("hoodie.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
   // store the icon in the label
   lbHoodie.setIcon(imgHoodie);
     
   
    // Initialize picture for jean 
    // Initialize and create a JLabel to store the jean icon later 
    lbJean = new JLabel();
    // create a imageIcon to store the picture
    imgJean = new ImageIcon(new ImageIcon("jean.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
    // store the icon in the label
    lbJean.setIcon(imgJean);
    
     // Initialize picture for pant 
     // Initialize and create a JLabel to store the pant icon later 
     lbPant = new JLabel();
     // create a imageIcon to store the picture
     imgPant = new ImageIcon(new ImageIcon("pant.jpeg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
     // store the icon in the label
     lbPant.setIcon(imgPant);
     
      // Initialize picture for hoodie 
      // Initialize and create a JLabel to store the payment icon later 
      lbOxford = new JLabel();
      // create a imageIcon to store the picture
      imgOxford = new ImageIcon(new ImageIcon("oxford.jpeg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      // store the icon in the label
      lbOxford.setIcon(imgOxford);
      
       // Initialize picture for hoodie 
      // Initialize and create a JLabel to store the payment icon later 
      lbCasuel = new JLabel();
      // create a imageIcon to store the picture
      imgCasuel = new ImageIcon(new ImageIcon("casuel.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      // store the icon in the label
      lbCasuel.setIcon(imgCasuel);
      
       // Initialize picture for hoodie 
      // Initialize and create a JLabel to store the payment icon later 
      lbMess = new JLabel();
      // create a imageIcon to store the picture
      imgMess = new ImageIcon(new ImageIcon("Messenger.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      // store the icon in the label
      lbMess.setIcon(imgMess);
       // Initialize picture for hoodie 
      // Initialize and create a JLabel to store the payment icon later 
      lbMess = new JLabel();
      // create a imageIcon to store the picture
      imgMess = new ImageIcon(new ImageIcon("Messenger.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      // store the icon in the label
      lbMess.setIcon(imgMess);
      
       // Initialize picture for hoodie 
      // Initialize and create a JLabel to store the payment icon later 
      lbTravel = new JLabel();
      // create a imageIcon to store the picture
      imgTravel = new ImageIcon(new ImageIcon("travel.jpeg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      // store the icon in the label
      lbTravel.setIcon(imgTravel);
      
      
      

      
      // set JLabels for the 2-D Array
      
      // Initialize Jlabel to show the amount of prices
     lbAmount = new JLabel("Amount");
     // Initialize JLabel to show the recahrging acmount
     lbRecharge = new JLabel("Recharge amount");
     // intialize Jlabels to show the consuming price
     lbConsuption = new JLabel("Consuption amount");
     // intialize Jlabels to show the new Balance
     lbBalance = new JLabel("New balance");
     
     
     // double start for 2-D Array
     // the initialize amount in credit card
   start = new Double[100];
   // the initialize amount is 1000.00
   start[1] = 1000.00;
   
   

   
   // array payment to store each amount of payment the customer neeeds to pay 
   // it is a component of my 2D array
   payment = new Double[100];
   
   recharge2 = new Double[100];
   
     //add component to the history detail panel -- to show the detail of purchase history
     panelDetail = new JPanel();


       

        // let the user to put money in their credit card
        recharge = 0; 
        btnRecharge = new JButton("Recharge");
        btnRecharge.addActionListener(new rechargeListener());
        
        btnDetail = new JButton("Purchase History");
        btnDetail.addActionListener(new detailListener());



     
        //mf retain two decimals  	
        mf = new DecimalFormat(".00");
        //initialize a JButton - sign in
        btnlog = new JButton("sign in");
        // add ActionListener 
        btnlog.addActionListener(new logListener());
        //initialize a JButton - sign in
        btnSign = new JButton("sign in");
        //add ActionListener
        btnSign.addActionListener(new signListener());
        //initialize a JButton - Shopping cart 
        cart = new JButton("Shopping cart");
        //add ActionListener
        cart.addActionListener(new cartListener());
        //initialize a JButton - imgCart
        cart.setIcon(imgCart);

  // initialize JButton clear to clear the order
  btnClear = new JButton("Clear the order");
  btnClear.addActionListener(new clearListener());
  
  // initialize JButton btnHistry to show the purchase history
  btnHistory = new JButton("Your credit card");
  btnHistory.addActionListener(new historyListener());
  btnHistory.setIcon(imgCard);
 
  
  // initialize JLabels to show the items selected to the shopping cart
  cartC1 = new JLabel("");
  cartC2 = new JLabel("");
  cartP1 = new JLabel("");
  cartP2 = new JLabel("");
  cartS1 = new JLabel("");
  cartS2 = new JLabel("");
  cartB1 = new JLabel("");
  cartB2 = new JLabel("");
  
//initialize JLabels to show the prices 

//add color black for  lbcartPrice
lbcartPrice = new JLabel("0.00");
lbcartPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//add color black for lbcartTax
lbcartTax = new JLabel("0.00");
lbcartTax.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//add color black for lbcartShip 
lbcartShip = new JLabel("3.00");
lbcartShip.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//add color black for  lbcartGrand
lbcartGrand = new JLabel("0.00");
lbcartGrand.setBorder(BorderFactory.createLineBorder(Color.BLACK));	
cartPrice = 0;
  
  // initialize JButton to enable the user to checkout
  btnCheckout = new JButton("Checkout");
  btnCheckout.addActionListener(new checkoutListener());
  
//initialize JLabels to show the label of prices 
//initialize JLabels to show the label of Subtotal
lbcartPrice1 = new JLabel("Subtotal:");
//initialize JLabels to show the label of Tax:
lbcartTax1 = new JLabel("Tax:");
//initialize JLabels to show the label of Delievry Fee:
lbcartShip1 = new JLabel(" Delievry Fee:");
//initialize JLabels to show the label of Grand Total
lbcartGrand1 = new JLabel("Grand Total");
  
//initialize Jbuttons for the user to select the type of goods to buy
//initialize btnCloth  btnCloth Jbuttons for the user to select the type of goods to buy cloth
btnCloth= new JButton("Cloth");
//initialize btnPant  btnCloth Jbuttons for the user to select the type of goods to buy pant
btnPant = new JButton("Pant");
//initialize btnShoe  btnCloth Jbuttons for the user to select the type of goods to buy Shoes
btnShoe = new JButton("Shoes");
//initialize btnBag  btnCloth Jbuttons for the user to select the type of goods to buy Bag
btnBag = new JButton("Bag");
//initialize  btnCloth set imgCloth
	  btnCloth.setIcon(imgCloth);
	// initialize  btnPant set imgPant2
	  btnPant.setIcon(imgPant2);
	// initialize  btnShoe set imgShoe
	  btnShoe.setIcon(imgShoe);
	// initialize  btnBag set imgBag
	  btnBag.setIcon(imgBag);

  // initialize an array to store the information in the number of items 
     //Add item to comboBox --- show the number of items 
     String [] numItem = {"0","1","2","3","4","5","6"};
     
     // initialize JComboBox for the user to choose the number of items
  cboC1 = new JComboBox<String>(numItem);
  cboC2 = new JComboBox<String>(numItem);
  cboP1 = new JComboBox<String>(numItem);
  cboP2 = new JComboBox<String>(numItem);
  cboS1 = new JComboBox<String>(numItem);
  cboS2 = new JComboBox<String>(numItem);
  cboB1 = new JComboBox<String>(numItem);
  cboB2 = new JComboBox<String>(numItem);



  
  // initialize JLabel for the user to log in
  lbname = new JLabel("Username:");
  lbpw = new JLabel("Password:");
  lbLog = new JLabel("");
  
  // initialize JTextField for the user to log in
  txtname = new JTextField(15);
  txtpw = new JTextField(15);
  
  // initialize JTextField for the user to create an account
  txtCreatePW = new JTextField(15);
  txtCreateName = new JTextField(15);
  
  
  // initialize Jbuttons for the user to confirm their choice of good 
  confirmc1 = new JButton("Add to cart");
  confirmc2 = new JButton("Add to cart");
  confirmp1 = new JButton("Add to cart");
  confirmp2 = new JButton("Add to cart");
  confirms1 = new JButton("Add to cart");
  confirms2 = new JButton("Add to cart");
  confirmb1 = new JButton("Add to cart");
  confirmb2 = new JButton("Add to cart");

  // Add actionListener to confirm buttons --- to add items to the shopping cart
  confirmc1.addActionListener(new confirmc1Listener());
  confirmc2.addActionListener(new confirmc2Listener());
  confirmp1.addActionListener(new confirmp1Listener());
  confirmp2.addActionListener(new confirmp2Listener());
  confirms1.addActionListener(new confirms1Listener());
  confirms2.addActionListener(new confirms2Listener());
  confirmb1.addActionListener(new confirmb1Listener());
  confirmb2.addActionListener(new confirmb2Listener());
  



  
  // Add actionListenr to Jbuttons,and allow the user to see all goods under one category
  btnCloth.addActionListener(new clothListener());
  btnPant.addActionListener(new pantListener());
  btnShoe.addActionListener(new shoeListener());
  btnBag.addActionListener(new bagListener());
  
        // initialize JRadiobuttons to select the size
  sizeSmallC1 = new JRadioButton("Small");
  sizeMediumC1 = new JRadioButton("Medium");
  sizeLargeC1 = new JRadioButton("Large");
  sizeSmallC2 = new JRadioButton("Small");
  sizeMediumC2 = new JRadioButton("Medium");
  sizeLargeC2 = new JRadioButton("Large");
  sizeSmallP1 = new JRadioButton("Small");
  sizeMediumP1 = new JRadioButton("Medium");
  sizeLargeP1 = new JRadioButton("Large");
  sizeSmallP2 = new JRadioButton("Small");
  sizeMediumP2 = new JRadioButton("Medium");
  sizeLargeP2 = new JRadioButton("Large");
  sizeSmallS1 = new JRadioButton("6-8");
  sizeMediumS1 = new JRadioButton("8-10");
  sizeLargeS1 = new JRadioButton("10-12");
  sizeSmallS2 = new JRadioButton("6-8");
  sizeMediumS2 = new JRadioButton("8-10");
  sizeLargeS2 = new JRadioButton("10-12");
  sizeSmallB1 = new JRadioButton("Red");
  sizeMediumB1 = new JRadioButton("Blue");
  sizeLargeB1 = new JRadioButton("Black");
  sizeSmallB2 = new JRadioButton("Red");
  sizeMediumB2 = new JRadioButton("Blue");
  sizeLargeB2 = new JRadioButton("Black");
  
  
  // initialize JLabels to show the name of each item
  lbCloth1 = new JLabel("Jacket");
  lbCloth2 = new JLabel("Hoodie");
  lbPant1 = new JLabel("Jean");
  lbPant2 = new JLabel("Athletic pant");
  lbShoe1 = new JLabel("Oxford Shoe");
  lbShoe2 = new JLabel("Casuel Shoe");  
  lbBag1 = new JLabel("Messenger Bag");
  lbBag2 = new JLabel("Travel Backpack");
  
  // Add button group object for size, let the user can only select one size
     // initialize the ButtonGroup size 
     sizeC1 = new ButtonGroup ();
     // add small size to the buttonGroup
     sizeC1.add (sizeSmallC1);
     // add medium size to buttonGroup
     sizeC1.add (sizeMediumC1);
     // add large size to buttonGroup
     sizeC1.add (sizeLargeC1);
     
     // initialize the ButtonGroup size 
     sizeC2 = new ButtonGroup();
     // add small size to the buttonGroup
     sizeC2.add (sizeSmallC2);
     // add medium size to buttonGroup
     sizeC2.add (sizeMediumC2);
     // add large size to buttonGroup
     sizeC2.add (sizeLargeC2);
     
     // initialize the ButtonGroup size 
     sizeS1 = new ButtonGroup();
     // add small size to the buttonGroup
     sizeS1.add (sizeSmallS1);
     // add medium size to buttonGroup
     sizeS1.add (sizeMediumS1);
     // add large size to buttonGroup
     sizeS1.add (sizeLargeS1);
     
     // initialize the ButtonGroup size 
     sizeS2 = new ButtonGroup();
     // add small size to the buttonGroup
     sizeS2.add (sizeSmallS2);
     // add medium size to buttonGroup
     sizeS2.add (sizeMediumS2);
     // add large size to buttonGroup
     sizeS2.add (sizeLargeS2);
     
     // initialize the ButtonGroup size 
     sizeP1 = new ButtonGroup();
     // add small size to the buttonGroup
     sizeP1.add (sizeSmallP1);
     // add medium size to buttonGroup
     sizeP1.add (sizeMediumP1);
     // add large size to buttonGroup
     sizeP1.add (sizeLargeP1);
     
     // initialize the ButtonGroup size 
     sizeP2 = new ButtonGroup();
     // add small size to the buttonGroup
     sizeP2.add (sizeSmallP2);
     // add medium size to buttonGroup
     sizeP2.add (sizeMediumP2);
     // add large size to buttonGroup
     sizeP2.add (sizeLargeP2);
     

     // initialize the ButtonGroup size 
     sizeB1 = new ButtonGroup();
     // add small size to the buttonGroup
     sizeB1.add (sizeSmallB1);
     // add medium size to buttonGroup
     sizeB1.add (sizeMediumB1);
     // add large size to buttonGroup
     sizeB1.add (sizeLargeB1);

     // initialize the ButtonGroup size for bags 
     sizeB2 = new ButtonGroup();
     // add small size to the buttonGroup
     sizeB2.add (sizeSmallB2);
     // add medium size to buttonGroup
     sizeB2.add (sizeMediumB2);
     // add large size to buttonGroup
     sizeB2.add (sizeLargeB2);
  
  // Initialize Prices
  clothPrice1 = 20;
  clothPrice2 = 30;
  pantPrice1 = 20;
  pantPrice2 = 30;
  shoePrice1 = 60;
  shoePrice2 = 50;
  bagPrice1 = 70;
  bagPrice2 = 60;
  
  
  
  // initialize JLabels to show the prices
  lbCP1 = new JLabel(Double.toString(clothPrice1)+" Each");
  lbCP2 = new JLabel(Double.toString(clothPrice2)+" Each");
  lbPP1 = new JLabel(Double.toString(pantPrice1)+" Each");
  lbPP2 = new JLabel(Double.toString(pantPrice2)+" Each");
  lbSP1 = new JLabel(Double.toString(shoePrice1)+" Each");
  lbSP2 = new JLabel(Double.toString(shoePrice2)+" Each");
  lbBP1 = new JLabel(Double.toString(bagPrice1)+" Each");
  lbBP2 = new JLabel(Double.toString(bagPrice2)+" Each");


//initialize panels
JPanel panel = new JPanel();
//initializa panelCloth of a new JPanel
panelCloth = new JPanel();
//initializa panelPant as a new JPanel
panelPant = new JPanel();
//initializa panelShoe as a new JPanel
panelShoe = new JPanel();
//initializa panelBag to a new JPanel
panelBag = new JPanel();
//initializa panelCart as a new JPanel
panelCart = new JPanel();
//initializa panelLog as a new JPanel
panelLog = new JPanel();
//initializa panelCloth1 as a new JPanel
panelCloth1 = new JPanel();
//initializa panelCloth2 as a new JPanel
panelCloth2 = new JPanel();
//initializa panelLog as a new JPanel
panelPant1 = new JPanel();
//initializa panelPant2 as a new JPanel
panelPant2 = new JPanel();
//initializa panelBag1 as a new JPanel
panelBag1 = new JPanel();
//initializa panelBag2  as a new JPanel
panelBag2 = new JPanel();
//initializa panelShoe1 as a new JPanel
panelShoe1 = new JPanel();
//initializa panelShoe2 as a new JPanel
panelShoe2 = new JPanel();
  panelCreate = new JPanel();

  // add button to main panel
//add panel to main panel as btnCloth
  panel.add(lbPoster);
panel.add(btnCloth);
//add panel to main panel as btnPant
panel.add(btnPant);
//add panel to main panel as btnShoe
panel.add(btnShoe);
//add panel to main panel as btnBag
panel.add(btnBag);
//add panel to main panel as btncart
panel.add(cart);
//add panel to main panel as btnlog
panel.add(btnlog);
//add panel to main panel as lbLog
panel.add(lbLog);
  panel.add(btnHistory);
  
  
  // add component to the create panels
  panelCreate.add(lbCreateName);
  panelCreate.add(txtCreateName);
  panelCreate.add(lbCreatePW);
  panelCreate.add(txtCreatePW);
  panelCreate.add(btnCreateOK);



  
//add component to the cloth panels
//add panelCloth to the lbcloth1 panels
panelCloth1.add(lbCloth1);
//add panelCloth - lbCloth1
panelCloth1.add(lbJacket);
//add panelCloth to the smallc1 panels
panelCloth1.add(sizeSmallC1);
//add panelCloth to the sizeMediumC1 panels
panelCloth1.add(sizeMediumC1);
//add panelCloth to the sizeLargeC1 panels
panelCloth1.add(sizeLargeC1);
//add panelCloth to the lbCP1panels
panelCloth1.add(lbCP1);
//add panelCloth
panelCloth1.add(cboC1);
//add panelCloth
panelCloth1.add(confirmc1);
//set vertical box layout for the first cloth panel. make it looks neat
panelCloth1.setLayout(new BoxLayout(panelCloth1,BoxLayout.Y_AXIS));

// do the same thing for cloth2
  panelCloth2.add(lbCloth2);
  panelCloth2.add(lbHoodie);
  panelCloth2.add(sizeSmallC2);
  panelCloth2.add(sizeMediumC2);
  panelCloth2.add(sizeLargeC2);
  panelCloth2.add(lbCP2);
  panelCloth2.add(cboC2);
  panelCloth2.add(confirmc2);
//set vertical box layout for the first cloth panel. make it looks neat
  panelCloth2.setLayout(new BoxLayout(panelCloth2,BoxLayout.Y_AXIS));

  
  // add two small panels to the big one
  // so that the panel is divided to two parts
  panelCloth.add(panelCloth1);
  panelCloth.add(panelCloth2);


  
//add component to the pant panels
//add panelPant to the labPant1
panelPant1.add(lbPant1);

panelPant1.add(lbJean);
//add panelPant to the sizeSmallP1
panelPant1.add(sizeSmallP1);
//add panelPant to the sizeMediumP1
panelPant1.add(sizeMediumP1);
//add panelPant to the sizeLargeP1
panelPant1.add(sizeLargeP1);
//add panelPant to the lbPP1
panelPant1.add(lbPP1);
panelPant1.add(cboP1);
//add panelPant to the confirmp1
panelPant1.add(confirmp1);
panelPant1.setLayout(new BoxLayout(panelPant1,BoxLayout.Y_AXIS));

  
//add panelPant to the lbPant2
panelPant2.add(lbPant2);
panelPant2.add(lbPant);
//add panelPant to the sizeSmallP2
panelPant2.add(sizeSmallP2);
//add panelPant to the sizeMediumP2
panelPant2.add(sizeMediumP2);
//add panelPant to the sizeLargeP2
panelPant2.add(sizeLargeP2);
//add panelPant to the lbPP2
panelPant2.add(lbPP2);
panelPant2.add(cboP2);
//add panelPant to the confirmp2
panelPant2.add(confirmp2);
//set vertical box layout for the 2nd pant panel. make it looks neat
  panelPant2.setLayout(new BoxLayout(panelPant2,BoxLayout.Y_AXIS));
  
  // add two small panels to the big one
  // so that the panel is divided to two parts
  panelPant.add(panelPant1);
  panelPant.add(panelPant2);

 
  
//add component to shoe panel
//add component to shoe panel as lbShoe1
panelShoe1.add(lbShoe1);
panelShoe1.add(lbOxford);// add component to shoe panel as sizeSmallS1
panelShoe1.add(sizeSmallS1);
//add component to shoe panel as sizeMediumS1
panelShoe1.add(sizeMediumS1);
//add component to shoe panel as sizeLargeS1
panelShoe1.add(sizeLargeS1);
//add component to shoe panel as lbSP1
panelShoe1.add(lbSP1);
panelShoe1.add(cboS1);
//add component to shoe panel as confirms1
panelShoe1.add(confirms1);
  panelShoe1.setLayout(new BoxLayout(panelShoe1,BoxLayout.Y_AXIS));

  
//add component to shoe panel as lbShoe2
panelShoe2.add(lbShoe2);
panelShoe2.add(lbCasuel);
//add component to shoe panel as sizeSmallS2
panelShoe2.add(sizeSmallS2);
//add component to shoe panel as sizeMediumS2
panelShoe2.add(sizeMediumS2);
//add component to shoe panel as sizeLargeS2
panelShoe2.add(sizeLargeS2);
panelShoe2.add(lbSP2);
// add panelShone lbSp2
panelShoe2.add(cboS2);
//add component to shoe panel as confirms2
panelShoe2.add(confirms2);
//set vertical box layout for the 2nd shoe panel. make it looks neat
  panelShoe2.setLayout(new BoxLayout(panelShoe2,BoxLayout.Y_AXIS));
  
  // add two small panels to the big one
  // so that the panel is divided to two parts
  panelShoe.add(panelShoe1);
  panelShoe.add(panelShoe2);





//add component to bag panel
panelBag1.add(lbBag1);
//add component to bag panel of lbMess

panelBag1.add(lbMess);
//add component to bag panel of sizeSmallB1
panelBag1.add(sizeSmallB1);
//add component to bag panel of sizeMediumB1
panelBag1.add(sizeMediumB1);
//add component to bag panel of sizeLargeB1
panelBag1.add(sizeLargeB1);
//add component to bag panel of lbBP1
panelBag1.add(lbBP1);
//add component to bag panel of cboB1
panelBag1.add(cboB1);
//add component to bag panel of confirmb1
panelBag1.add(confirmb1);
//set Y box layout for the first cloth panel. make it looks neat
panelBag1.setLayout(new BoxLayout(panelBag1,BoxLayout.Y_AXIS));


//add Item panelBag2 to lbBag2
panelBag2.add(lbBag2);
//add Item panelBag2 to lbTravel
panelBag2.add(lbTravel);
//add Item panelBag2 to sizeSmallB2
panelBag2.add(sizeSmallB2);
//add Item panelBag2 to sizeMediumB2
panelBag2.add(sizeMediumB2);
//add Item panelBag2 to sizeLargeB2
panelBag2.add(sizeLargeB2);
//add Item panelBag2 to lbBP2
panelBag2.add(lbBP2);
//add Item panelBag2 to cboB2
panelBag2.add(cboB2);
//add Item panelBag2 to confirmb2
panelBag2.add(confirmb2);
//set vertical box layout for the first cloth panel. make it looks neat
panelBag2.setLayout(new BoxLayout(panelBag2,BoxLayout.Y_AXIS));

// add two small panels to the big one
// so that the panel is divided to two parts
panelBag.add(panelBag1);
panelBag.add(panelBag2);

 
  
//set font of the name of items
//set the font-- texe with  the type of serif
cartC1.setFont(new Font("Serif", Font.BOLD, 20));
//set the font texe type of serif
cartC2.setFont(new Font("Serif", Font.BOLD, 20));
//set the font-- texe give the type of serif
cartP1.setFont(new Font("Serif", Font.BOLD, 20));
//set the font-- texe with  the type of serif
cartP2.setFont(new Font("Serif", Font.BOLD, 20));
//set the font-- texe with  the type of serif
cartS1.setFont(new Font("Serif", Font.BOLD, 20));
//set the font-- texe with  the type of serif
cartS2.setFont(new Font("Serif", Font.BOLD, 20));
//set the font-- texe for  the type of serif
cartB1.setFont(new Font("Serif", Font.BOLD, 20));
//set the font-- texe to  the type of serif
cartB2.setFont(new Font("Serif", Font.BOLD, 20));




//add component to cartPanel
//add component to cartPanel of C1
 panelCart.add(cartC1);
//add component to cartPanel of C1
 panelCart.add(cartC2);
//add component to cartPanel ofcartP1
 panelCart.add(cartP1);
//add component to cartPanel of cartP2
 panelCart.add(cartP2);
//add component to cartPanel of cartS1
 panelCart.add(cartS1);
//add component to cartPanel ofcartS2
 panelCart.add(cartS2);
//add component to cartPanel of cartB1
 panelCart.add(cartB1);
//add component to cartPanel of cartB2
 panelCart.add(cartB2);
//add component to cartPanel of lbcartPrice1
 panelCart.add(lbcartPrice1);
//add component to cartPanel of lbcartPrice
 panelCart.add(lbcartPrice);
//add component to cartPanel of lbcartTax1
 panelCart.add(lbcartTax1);
//add component to cartPanel of lbcartTax
 panelCart.add(lbcartTax);
//add component to cartPanel of lbcartShip1
 panelCart.add(lbcartShip1);
//add component to cartPanel of lbcartShip
 panelCart.add(lbcartShip);
//add component to cartPanel oflbcartGrand1
 panelCart.add(lbcartGrand1);
//add component to cartPanel of lbcartGrand
 panelCart.add(lbcartGrand);
//add component to cartPanel of btnClear
     panelCart.add(btnClear);
     //add component to cartPanel of lbAddress
     panelCart.add(lbAddress);
   //add component to cartPanel oftxtAddress
     panelCart.add(txtAddress);
   //add component to cartPanel of lbPhone
     panelCart.add(lbPhone);
   //add component to cartPanel oftxtPhone
     panelCart.add(txtPhone);
   //add component to cartPanelwith btnCheckout
         panelCart.add(btnCheckout);
         // set vertical box layout for the first cloth panel. make it looks neat
         panelCart.setLayout(new BoxLayout(panelCart,BoxLayout.Y_AXIS));



     
  
         // add component to log in panel
         //add component to log in panel as lbname
         panelLog.add(lbname);
         //add component to log in panel as txtname
         panelLog.add(txtname);
         //add component to log in panel lbpw
         panelLog.add(lbpw);
         //add component to log in panel txtpw
         panelLog.add(txtpw);
         //add component to log in panel btnSign
         panelLog.add(btnSign);
         panelLog.add(btnCreate);

  
  // add component to the purchase History panels
  panelHistory = new JPanel();
  panelHistory.add(btnRecharge);
  panelHistory.add(btnDetail);
  
  
  // add component to the purchase detail panels
     panelDetail.setLayout(new GridLayout(0,4));
     
     
  // add windowListener ---- operation when the user clicked the exit button
  addWindowListener(new CloseListener());
  setResizable(false);
  setLocationRelativeTo(null);
//set a new content pane
setContentPane(panel);
//Define the size 700,600
setSize(700,600);
//Set it visible
//when the exit key is pressed, do nothing
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setVisible(true);
 }
 
 // when an section of items is pressed, display the goods in detail
 // show the customer a new panel with all details of cloths 
   //Class declaration: name of class clothListener implements ActionListener
     public class clothListener implements ActionListener
     {
     //The abstract method actionPerformed from class ActionListener is now defined
     public void actionPerformed(ActionEvent e )
     {
      //If the user has selected a value from the drop down options of the btnCloth JComboBox
     if(e.getSource()== btnCloth)
     {
      //set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelCloth 
      UIManager.put("OptionPane.minimumSize",new Dimension(800,500));
      //use JOptionPane to show the cusotmer avaliable clothes — output the panelCloth
      JOptionPane.showMessageDialog(null,panelCloth,"Information",JOptionPane.INFORMATION_MESSAGE);
     }
     }
     }
     
     //Class declaration: name of class pantListenerListener implements ActionListener
     public class pantListener implements ActionListener
     {
      //The abstract method actionPerformed from class ActionListener is now defined
     public void actionPerformed(ActionEvent e )
     {
      //If the user has selected a value from the drop down options of the btnPant JComboBox 
     if(e.getSource()== btnPant)
     {
      //set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelPant
      UIManager.put("OptionPane.minimumSize",new Dimension(800,500));
     //use JOptionPane to show the cusotmer avaliable pants — output the panelCloth
      JOptionPane.showMessageDialog(null,panelPant,"Information",JOptionPane.INFORMATION_MESSAGE);
     }
     }
     }
     
     
     
     //Class declaration: name of class shoeListener implements ActionListener
     public class shoeListener implements ActionListener
     {
      //The abstract method actionPerformed from class ActionListener is now defined
     public void actionPerformed(ActionEvent e )
     {
      //If the user has selected a value from the drop down options of the btnShoe JComboBox   
     if(e.getSource()== btnShoe)
     {
      //set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelShoe 
      UIManager.put("OptionPane.minimumSize",new Dimension(800,500));
     //use JOptionPane to show the cusotmer avaliable shoe — output the panelShoe
      JOptionPane.showMessageDialog(null,panelShoe,"Information",JOptionPane.INFORMATION_MESSAGE);
     }
     }
     }
     
     
     //Class declaration: name of class bagListener implements ActionListener
     public class bagListener implements ActionListener
     {
      //The abstract method actionPerformed from class ActionListener is now defined 
     public void actionPerformed(ActionEvent e )
     {
      //If the user has selected a value from the drop down options of the btnBag JComboBox   
     if(e.getSource()== btnBag)
     {
      //set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelBag
      UIManager.put("OptionPane.minimumSize",new Dimension(800,500));
     //use JOptionPane to show the cusotmer avaliable Bag — output the panelBag
      JOptionPane.showMessageDialog(null,panelBag,"Information",JOptionPane.INFORMATION_MESSAGE);
     }
     }
     }
     
     //Class declaration: name of class cartListener implements ActionListener
     public class cartListener implements ActionListener
     {
      //The abstract method actionPerformed from class ActionListener is now defined   
     public void actionPerformed(ActionEvent e )
     {
      //If the user has selected a value from the drop down options of the cart JComboBox     
     if(e.getSource()== cart)
     {
      //set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelCart
      UIManager.put("OptionPane.minimumSize",new Dimension(800,500));
     //use JOptionPane to show the cusotmer avaliable Cart — output the panelBag
      JOptionPane.showMessageDialog(null,panelCart,"Information",JOptionPane.INFORMATION_MESSAGE);
     }
     }

     }
     
     
   //Class declaration: name of class logListener implements ActionListener
     public class logListener implements ActionListener
     {
      //The abstract method actionPerformed from class ActionListener is now defined
     public void actionPerformed(ActionEvent e )
     {
      //If the user has selected a value from the drop down options of the btnlog JComboBox 
     if(e.getSource()== btnlog)
     {
      //set the dimension of the JOptionPane (300*200) — make it large enough to carry the panelLog
      UIManager.put("OptionPane.minimumSize",new Dimension(300,200));
     //use JOptionPane to show the cusotmer avaliable Log — output the panelLog
      JOptionPane.showMessageDialog(null,panelLog,"Information",JOptionPane.INFORMATION_MESSAGE);
     }
     }

     }
     
     
     
   //Class declaration: name of class signListener implements ActionListener
     public class signListener implements ActionListener
     {
     //The abstract method actionPerformed from class ActionListener is now defined 
     public void actionPerformed(ActionEvent e )
     {
     //If the user has selected a value from the drop down options of the btnSign JComboBox 
     if(e.getSource()== btnSign)
     {

     if(txtname.getText().equals("")|| txtpw.getText().equals(""))
     {
    	//set the dimension of the JOptionPane (800*500) — make it large enough to carry the username
     UIManager.put("OptionPane.minimumSize",new Dimension(800,500)); 
   //use JOptionPane to show the cusotmer avaliable username — output the username
    JOptionPane.showMessageDialog(null, "Username/password is blank", "Hudson's Bay", JOptionPane.ERROR_MESSAGE);
   }
   else
   {
	   if(cpt.read(txtname.getText(), txtpw.getText()) == true)
	   {
		 //set the dimension of the JOptionPane (200*200) — make it large enough to carry the username
     UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   //use JOptionPane to show the cusotmer avaliable welcome — output the welcome
   JOptionPane.showMessageDialog(null, "Welcome, " +  txtname.getText(), "Hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
   lbLog.setText("Hello, " + txtname.getText());
   btnlog.setEnabled(false);
            panelLog.setVisible(false);
	   }
	   else
	   {
			 JOptionPane.showMessageDialog(null, "Invalid Account, please create a new account", "Hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
	   }
   }
   
 }
 }
 }
  // when the user hit"add to cart" button, adding the selected item to the cart
  // display the ordered item in cart
  // add this feature to the first item in cloth section
  //Class declaration: name of class confirmc1Listener implements ActionListener
  public class confirmc1Listener implements ActionListener
  {
  	//The abstract method actionPerformed from class ActionListener is now defined	
  public void actionPerformed(ActionEvent e)
  {
  	//If the user has selected a value from the drop down options of the btnShoe JComboBox	
   if(e.getSource() == confirmc1)
  {
  	 // when none of the size is selected, ask the customer to select one
  	  //  We must know the size to sell clothes

   if(sizeSmallC1.isSelected()== false &&sizeMediumC1.isSelected()== false &&sizeLargeC1.isSelected()== false )
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc1
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelCloth
  JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
   //and store the number of C1 is ordered, used for checkout  
   else if(cboC1.getSelectedIndex() == 0)
   {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc1
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmc1
  JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of C1 is ordered, used for checkout 
  else if(cboC1.getSelectedIndex() != 0)
  {
  // when the radioButton sizeSmallC1 is selected, tell the customer that the size of the cloth is small	
  if(sizeSmallC1.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartC1.setText(lbCloth1.getText()+ "   Size: small " + "   Number of items:" + cboC1.getSelectedIndex());
  }
  //when the radioButton sizeMediumC1 is selected, tell the customer that the size of the cloth is medium
  if(sizeMediumC1.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartC1.setText(lbCloth1.getText()+ "   Size: medium" + "   Number of items:" + cboC1.getSelectedIndex());
  }
  //when the radioButton sizeLarge1 is selected, tell the customer that the size of the cloth is large
  if(sizeLargeC1.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartC1.setText(lbCloth1.getText()+ "   Size: large" + "   Number of items:" + cboC1.getSelectedIndex());
  }	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc1
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmc1
  JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
         // tell customers the information of selected items. including name size and number of items       
  cartPrice = cartPrice + cboC1.getSelectedIndex()*clothPrice1;
  //set the context of lbcartPrice by double  cart price


          	lbcartPrice.setText(Double.toString(cartPrice));
          	//setting the tax based on the original prices, and formatting it to 2 decimal places 

        	    lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
        	    //setting the grand total by using method from the CPT class, and formatting it to 2 decimal places

        	    lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));

  } 
    	    cboC1.setSelectedIndex(0);

  }
  }

  }
  //Class declaration: name of class confirmc2Listener implements ActionListener
  public class confirmc2Listener implements ActionListener
  {
  	//The abstract method actionPerformed from class ActionListener is now defined	
  public void actionPerformed(ActionEvent e)
  {	
  	//If the user has selected a value from the drop down options of the btnShoe JComboBox	
   if(e.getSource() == confirmc2)
  {
  	// when none of the size is selected, ask the customer to select one
  	  //  We must know the size to sell clothes
  if(sizeSmallC2.isSelected()== false &&sizeMediumC2.isSelected()== false &&sizeLargeC2.isSelected()== false )
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry thepanelconfirmc2
  UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmc2
  JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }

  //and store the number of C2 is ordered, used for checkout 
  else if(cboC2.getSelectedIndex() == 0)
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc2
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmc2
  JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of C2 is ordered, used for checkout 
  else if(cboC2.getSelectedIndex() != 0)
  {
  	// when the radioButton sizeSmallC2 is selected, tell the customer that the size of the cloth is small	
  if(sizeSmallC2.isSelected())
  	
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartC2.setText(lbCloth2.getText()+ "   Size: small " + "   Number of items:" + cboC2.getSelectedIndex());
  }
  //when the radioButton sizeMediumC2 is selected, tell the customer that the size of the cloth is medium
  if(sizeMediumC2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartC2.setText(lbCloth2.getText()+ "   Size: medium" + "   Number of items:" + cboC2.getSelectedIndex());
  }
  //when the radioButton sizeLargeC2 is selected, tell the customer that the size of the cloth is large
  if(sizeLargeC2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartC2.setText(lbCloth2.getText()+ "   Size: large" + "   Number of items:" + cboC2.getSelectedIndex());
  }
  //set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc2
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200));
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmc2
  JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
                  cartPrice = cartPrice + cboC2.getSelectedIndex()*clothPrice2;
          // tell customers the information of selected items. including name size and number of items
          
          	lbcartPrice.setText(Double.toString(cartPrice));
          	//set the context of lbcartPrice by double  cart price

        	    lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
        	   // setting the grand total by using method from the CPT class, and formatting it to 2 decimal places

        	    lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));

  }
    	    cboC2.setSelectedIndex(0);

  }
  }
  }
  //Class declaration: name of class confirmpListener implements ActionListener
  public class confirmp1Listener implements ActionListener
  {
  	//The abstract method actionPerformed from class ActionListener is now defined	
  public void actionPerformed(ActionEvent e)
  {
  	//If the user has selected a value from the drop down options of the btnShoe JComboBox	
   if(e.getSource() == confirmp1)
  {

  	// when none of the size is selected, ask the customer to select one
  	  //  We must know the size to sell clothes 
  if(sizeSmallP1.isSelected()== false &&sizeMediumP1.isSelected()== false &&sizeLargeP1.isSelected()== false )
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the confirmpListener
  UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the confirmpListener
  JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of P1 is ordered, used for checkout 
  else if (cboP1.getSelectedIndex() == 0)
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmp
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmp
  JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }


  //and store the number of P1 is ordered, used for checkout 
  else if(cboP1.getSelectedIndex() != 0) 
  	
  {	
  	// when the radioButton sizeSmallP1 is selected, tell the customer that the size of the cloth is small	
  if(sizeSmallP1.isSelected())
  	
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartP1.setText(lbPant1.getText()+ "   Size: small " + "   Number of items:" + cboP1.getSelectedIndex());

  }
  // when the radioButton sizeSmallP1 is selected, tell the customer that the size of the cloth is medium
  if(sizeMediumP1.isSelected())
  	
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartP1.setText(lbPant1.getText()+ "   Size: medium" + "   Number of items:" + cboP1.getSelectedIndex());
  }
  // when the radioButton sizeLargerP1 is selected, tell the customer that the size of the cloth is large
  if(sizeLargeP1.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartP1.setText(lbPant1.getText()+ "   Size: large" + "   Number of items:" + cboP1.getSelectedIndex());
  }
  //set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmp
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmp
   JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
          //tell customers the information of selected items. including name size and number of items       
   cartPrice = cartPrice + cboP1.getSelectedIndex()*pantPrice1;
         //set the context of lbcartPrice by double  cart price
   	
   lbcartPrice.setText(Double.toString(cartPrice));
      //setting the tax based on the original prices, and formatting it to 2 decimal places 
    	  
   lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
        	//setting the grand total by using method from the CPT class, and formatting it to 2 decimal places   
   lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));

  }

    	    cboP1.setSelectedIndex(0);


  }
  }
  }	
  //Class declaration: name of class confirmp2Listener implements ActionListener
  public class confirmp2Listener implements ActionListener
  {
  //The abstract method actionPerformed from class ActionListener is now defined	
  public void actionPerformed(ActionEvent e)
  {
  	//If the user has selected a value from the drop down options of the btnShoe JComboBox	
   if(e.getSource() == confirmp2)
  {
  	 // when none of the size is selected, ask the customer to select one
  	  //  We must know the size to sell clothes
   if(sizeSmallP2.isSelected()== false &&sizeMediumP2.isSelected()== false &&sizeLargeP2.isSelected()== false )
  {
  UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of P1 is ordered, used for checkout  
   else if (cboP2.getSelectedIndex() == 0)
   {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc2 
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmc2
  JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of P2 is ordered, used for checkout 
  else if(cboP2.getSelectedIndex() != 0)
  {	
  	//when the radioButton sizeSmallP1 is selected, tell the customer that the size of the cloth is small	
  if(sizeSmallP2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartP2.setText(lbPant2.getText()+ "   Size: small " + "   Number of items:" + cboP2.getSelectedIndex());
  }
  //when the radioButton sizeMedium1 is selected, tell the customer that the size of the cloth is medium
  if(sizeMediumP2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartP2.setText(lbPant2.getText()+ "   Size: medium" + "   Number of items:" + cboP2.getSelectedIndex());
  }
  //when the radioButton sizeLarge1 is selected, tell the customer that the size of the cloth is large
  if(sizeLargeP2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartP2.setText(lbPant2.getText()+ "   Size: large" + "   Number of items:" + cboP2.getSelectedIndex());
  }
  //set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmp2
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmp2
  JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
                  // tell customers the information of selected items. including name size and number of items
  cartPrice = cartPrice + cboP2.getSelectedIndex()*pantPrice2;
                 //set the context of lbcartPrice by double  cart price
          	lbcartPrice.setText(Double.toString(cartPrice));
          	
  //setting the tax based on the original prices, and formatting it to 2 decimal places 
        	    lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
            // setting the grand total by using method from the CPT class, and formatting it to 2 decimal places

        	    lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));
  }
    	    cboP2.setSelectedIndex(0);

  }
  }
  }	
  //Class declaration: name of class confirmc1Listener implements ActionListener
  public class confirms1Listener implements ActionListener
  {
  	//The abstract method actionPerformed from class ActionListener is now defined	
  public void actionPerformed(ActionEvent e)
  {

  	//If the user has selected a value from the drop down options of the btnShoe JComboBox	
   if(e.getSource() == confirms1)
  {

  	 // when none of the size is selected, ask the customer to select one
  	  //  We must know the size to sell clothes

  if(sizeSmallS1.isSelected()== false &&sizeMediumS1.isSelected()== false &&sizeLargeS1.isSelected()== false )
  {

  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc1

  UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelCloth
  JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of S1 is ordered, used for checkout  
  else if (cboS1.getSelectedIndex() == 0)
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmc1
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   //use JOptionPane to show the cusotmer avaliable clothes — output the panelsonfirmac1
  JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of S1 is ordered, used for checkout 
  else if(cboS1.getSelectedIndex() != 0) 
   {
  	//when the radioButton sizeSmallS1 is selected, tell the customer that the size of the cloth is small	
  if(sizeSmallS1.isSelected())
  {
  	//tell customers the information of selected items. including name size and number of items
  //set the context of lbcartPrice by double  cart price
  	//If this button is selected Then carts this object Write the back brackets content
  cartS1.setText(lbShoe1.getText()+ "   Size: small " + "   Number of items:" + cboS1.getSelectedIndex());
  }
  //when the radioButton sizeMediumC1 is selected, tell the customer that the size of the cloth is medium	
  if(sizeMediumS1.isSelected())
  {
  	
  	//set the context of lbcartPrice by double  cart price	
  	//If this button is selected Then carts this object Write the back brackets content
  cartS1.setText(lbShoe1.getText()+ "   Size: medium" + "   Number of items:" + cboS1.getSelectedIndex());
  }
  //when the radioButton sizeLargeC1 is selected, tell the customer that the size of the cloth is large	
  if(sizeLargeS1.isSelected())
  {
  	//set the context of lbcartPrice by double  cart price
  	//If this button is selected Then carts this object Write the back brackets content
  cartS1.setText(lbShoe1.getText()+ "   Size: large" + "   Number of items:" + cboS1.getSelectedIndex());
  }
  //set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirms1
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200));
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmc1
  JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
         //tell customers the information of selected items. including name size and number of items
          
  cartPrice = cartPrice + cboS1.getSelectedIndex()*shoePrice1;
          //set the context of lbcartPrice by double  cart price

  lbcartPrice.setText(Double.toString(cartPrice));
     //setting the tax based on the original prices, and formatting it to 2 decimal places 

  lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
  // /setting the grand total by using method from the CPT class, and formatting it to 2 decimal places

  lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));
  }
    	    cboS1.setSelectedIndex(0);
  }
  }
  }
  
  
  //Class declaration: name of class confirms2Listener implements ActionListener
  public class confirms2Listener implements ActionListener
  {
  	//The abstract method actionPerformed from class ActionListener is now defined	
  public void actionPerformed(ActionEvent e)
  {

  	//If the user has selected a value from the drop down options of the btnShoe JComboBox	
  if(e.getSource() == confirms2)
  {
  	 // when none of the size is selected, ask the customer to select one
  	  //  We must know the size to sell clothes

  if(sizeSmallS2.isSelected()== false &&sizeMediumS2.isSelected()== false &&sizeLargeS2.isSelected()== false )
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirms2
  UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirms2
  JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //store the number of S1 is ordered, used for checkout 
  else if(cboS2.getSelectedIndex() == 0) 
  {
  	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirms2
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirms2
  JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }

  //store the number of S2 is ordered, used for checkout 
  else if(cboS2.getSelectedIndex() != 0)
  {
  	//when the radioButton sizeSmallC1 is selected, tell the customer that the size of the cloth is small
  if(sizeSmallS2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartS2.setText(lbShoe2.getText()+ "   Size: small " + "   Number of items:" + cboS2.getSelectedIndex());
  }
  //when the radioButton sizeMediumS1 is selected, tell the customer that the size of the cloth is medium
  if(sizeMediumS2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartS2.setText(lbShoe2.getText()+ "   Size: medium" + "   Number of items:" + cboS2.getSelectedIndex());
  }
  //when the radioButton sizeLarge1 is selected, tell the customer that the size of the cloth is large
  if(sizeLargeS2.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartS2.setText(lbShoe2.getText()+ "   Size: large" + "   Number of items:" + cboS2.getSelectedIndex());
  }
  //set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirms2
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable pants — output the panelCloth 
  JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
      //tell customers the information of selected items. including name size and number of items
              
  cartPrice = cartPrice + cboS2.getSelectedIndex()*shoePrice2;
        //set the context of lbcartPrice by double  cart price
    
  lbcartPrice.setText(Double.toString(cartPrice));
  //setting the tax based on the original prices, and formatting it to 2 decimal places 


  lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
   //setting the grand total by using method from the CPT class, and formatting it to 2 decimal places
    
  lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));

  }
    	    cboS2.setSelectedIndex(0);
  }
  }
  }

  //Class declaration: name of class confirmb1Listener implements ActionListener
  public class confirmb1Listener implements ActionListener
  {
  	//The abstract method actionPerformed from class ActionListener is now defined 
  public void actionPerformed(ActionEvent e)
  {
  	//If the user has selected a value from the drop down options of the btnShoe JComboBox   
  if(e.getSource() == confirmb1)
  {
  	
  if(sizeSmallB1.isSelected()== false &&sizeMediumB1.isSelected()== false &&sizeLargeB1.isSelected()== false )
  {
  	//set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelLog
  UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable Log — output the panelLog
  JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }

  else if(cboB1.getSelectedIndex() == 0)
  {
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
  }
  //and store the number of C1 is ordered, used for checkout  
  else if(cboB1.getSelectedIndex() != 0)
  {
  	//when the radioButton sizeSmallB1 is selected, tell the customer that the size of the cloth is small	
  if(sizeSmallB1.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartB1.setText(lbBag1.getText()+ "   Size: small " + "   Number of items:" + cboB1.getSelectedIndex());
  }
  //when the radioButton sizeMediumB1 is selected, tell the customer that the size of the cloth is medium
  if(sizeMediumB1.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartB1.setText(lbBag1.getText()+ "   Size: medium" + "   Number of items:" + cboB1.getSelectedIndex());
  }
  //when the radioButton sizeLargeB1 is selected, tell the customer that the size of the cloth is Large
  if(sizeLargeB1.isSelected())
  {
  	//If this button is selected Then carts this object Write the back brackets content
  cartB1.setText(lbBag1.getText()+ "   Size: large" + "   Number of items:" + cboB1.getSelectedIndex());
  }
  //set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmb1
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
  //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmb1
  JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
         // tell customers the information of selected items. including name size and number of items      
  cartPrice = cartPrice + cboB1.getSelectedIndex()*bagPrice1;
         //set the context of lbcartPrice by double  cart price
   
  lbcartPrice.setText(Double.toString(cartPrice));
  //setting the tax based on the original prices, and formatting it to 2 decimal places 

  lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
   // setting the grand total by using method from the CPT class, and formatting it to 2 decimal places
    
  lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));
  }
    	    cboB1.setSelectedIndex(0);

  }


  }
  }
  
//Class declaration: name of class confirmb2Listener implements ActionListener
 public class confirmb2Listener implements ActionListener
 {
		//The abstract method actionPerformed from class ActionListener is now defined 
  public void actionPerformed(ActionEvent e)
  {
		//If the user has selected a value from the drop down options of the btnShoe JComboBox   
   if(e.getSource() == confirmb2)
   {
    if(sizeSmallB2.isSelected()== false &&sizeMediumB2.isSelected()== false &&sizeLargeB2.isSelected()== false )
    {
    	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelLog
     UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   //use JOptionPane to show the cusotmer avaliable Log — output the panelLog
     JOptionPane.showMessageDialog(null, "Please select size of the item", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
    }
    else if(cboB2.getSelectedIndex() == 0)
    {
      UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
     JOptionPane.showMessageDialog(null, "Please select the number of items", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
    }
  //and store the number of B2 is ordered, used for checkout  
    else if(cboB2.getSelectedIndex() != 0)
    {
    	//when the radioButton sizeSmallB2 is selected, tell the customer that the size of the cloth is small	
     if(sizeSmallB2.isSelected())
     {
    		//If this button is selected Then carts this object Write the back brackets content
     cartB2.setText(lbBag2.getText()+ "   Size: small " + "   Number of items:" + cboB2.getSelectedIndex());
     }
     if(sizeMediumB2.isSelected())
     {
    	//when the radioButton sizeMediumB2 is selected, tell the customer that the size of the cloth is medium
     cartB2.setText(lbBag2.getText()+ "   Size: medium" + "   Number of items:" + cboB2.getSelectedIndex());
     }
     if(sizeLargeB2.isSelected())
     {
    		//If this button is selected Then carts this object Write the back brackets content
     cartB2.setText(lbBag2.getText()+ "   Size: large" + "   Number of items:" + cboB2.getSelectedIndex());
     }
   //set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelconfirmb1
     UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   //use JOptionPane to show the cusotmer avaliable clothes — output the panelconfirmb1
    JOptionPane.showMessageDialog(null, "Your item has been suceesfull added to the cart", "hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
    // tell customers the information of selected items. including name size and number of items      
    cartPrice = cartPrice + cboB2.getSelectedIndex()*bagPrice2;
    //set the context of lbcartPrice by double  cart price
          lbcartPrice.setText(Double.toString(cartPrice));
        //setting the tax based on the original prices, and formatting it to 2 decimal places 
            lbcartTax.setText(mf.format(cpt.taxCaculate(cartPrice)));
            // setting the grand total by using method from the CPT class, and formatting it to 2 decimal places
            lbcartGrand.setText(mf.format(cpt.grandTotal(cartPrice)));
   }

        cboB2.setSelectedIndex(0);
   }
  }
 }
 
 
//Class declaration: name of class historyListener implements ActionListener
public class historyListener implements ActionListener
{
//The abstract method actionPerformed from class ActionListener is now defined  
public void actionPerformed(ActionEvent e)
{

	if(btnlog.isEnabled() == true)
{
//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelhistory
UIManager.put("OptionPane.minimumSize",new Dimension(200,200));
//use JOptionPane to show the customer have to sign in 
JOptionPane.showMessageDialog(null, "Please sign in first", "Hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
//use JOptionPane to show the cusotmer avaliable Log — output the panelLog
JOptionPane.showMessageDialog(null,panelLog,"Information",JOptionPane.INFORMATION_MESSAGE);
}
else
{
//set the amount of rechargeing  to zero, clear rechargeing each time  clicking butten recharge
recharge = 0;
//set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelLog
UIManager.put("OptionPane.minimumSize",new Dimension(800,500));
//use JOptionPane to show the cusotmer avaliable Log — output the panelHistory
JOptionPane.showMessageDialog(null,panelHistory,"Information",JOptionPane.INFORMATION_MESSAGE);
}
}
}


//Class declaration: name of class rechrgeListener implements ActionListener
public class rechargeListener implements ActionListener
{
//The abstract method actionPerformed from class ActionListener is now defined
public void actionPerformed(ActionEvent e)
{
	boolean a = true;
    while(a == true)
    {
try
{
	
//set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelrecharge

UIManager.put("OptionPane.minimumSize",new Dimension(200,200));
//convert the amount of money enter by the user througt textfield to a double 
recharge = Double.parseDouble((String) JOptionPane.showInputDialog(null,"How much do you want to put in your card", "Hudson's bay", JOptionPane.QUESTION_MESSAGE));

recharge2[counter] = recharge;
//counter keep plus one  
counter++;
//use JOptionPane to show the cusotmer avaliable Log — output the panelrecharge
JOptionPane.showMessageDialog(null, "$"+ recharge+ " has been put in your credit card", "Hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
a = false;
}
    
//catch number format exception error to avoid entering a non-number text
catch(NumberFormatException e1)
{
//use a method from class cpt to tell the user to reenter the textfield
cpt.numberError(" recharging");
}
    }

}
}
 
 
 // show all details of purchase and recharing history
// 2-D array
 public class detailListener implements ActionListener 
 {
	 // override the class
  public void actionPerformed(ActionEvent e)
  {
	  // remove everything from the exising panel -- make it clear and avoid duplicate
   panelDetail.removeAll();
   // create a 2-d array
      try1 = new JLabel[counter][4];
      // use nested loop to write all elements in 2-d array
         for(int a = 0 ; a < 4 ; a ++)
         {
        	 // set 4 labels on the very top
          try1[0][a] = cpt.label(a);
          panelDetail.add(try1[0][a]);
         }
      // use nested loop to write the numbers 
         for (int i =  1; i < counter; i++) 
         {
          for(int a = 0 ; a <4 ; a ++)
          {
           // when a index of array is null, change it to 0.00
           if(payment[i] == null)
           {
        	   // set it to 0
            payment[i] = 0.00;
           }
           // when a index of array is null, change it to 0.00
           if(recharge2[i] == null)
           {
        	   // set it to 0
            recharge2[i] = 0.00;
           }
           // use method from class CPT1 to write elements 
            try1[i][a] = new JLabel(cpt.twoDarray(payment[i], a, recharge2[i],start[i]));
            // add the element to the panel
            panelDetail.add(try1[i][a]);
            if(a ==3)
            {
            	// change the staring amount each time
             start[i+1] = Double.parseDouble(try1[i][a].getText());
            }
          }
         }
     	//set the dimension of the JOptionPane (800*500) — make it large enough to carry the panelcheckout1
   UIManager.put("OptionPane.minimumSize",new Dimension(800,500)); 
    JOptionPane.showMessageDialog(null,panelDetail,"Information",JOptionPane.INFORMATION_MESSAGE);
  }
 }
 
//Class declaration: name of class checkoutListenerListener implements ActionListener
public class checkoutListener implements ActionListener
{
	//The abstract method actionPerformed from class ActionListener is now defined	
public void actionPerformed(ActionEvent e)
{
	//If the user has selected a value from the drop down options of the btnShoe JComboBox	
if(btnlog.isEnabled()== true)
{
	//set the dimension of the JOptionPane (200*200) — make it large enough to carry the panelcheckout1
UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   	// tell the user to log in first 
//use JOptionPane to show the cusotmer avaliable clothes — output the panelcheckout1
   	JOptionPane.showMessageDialog(null, "Please log in first", "Husdon's bay", JOptionPane.ERROR_MESSAGE);
JOptionPane.showMessageDialog(null,panelLog,"Information",JOptionPane.INFORMATION_MESSAGE);

}
   // when nothing is selected to the shopping cart
   // The order is not completed, and tell the customer this information
    else if(Double.parseDouble(lbcartGrand.getText())== 0)
      {
    UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
       // tell the user that the order is not completed
       JOptionPane.showMessageDialog(null, "Your order could not be completed! \nNothing is selected", "Critical error!", JOptionPane.ERROR_MESSAGE);
      }
    else if (txtAddress.getText().isEmpty() == true || txtPhone.getText().isEmpty() == true)
    {
     UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
        // tell the user that the order is not completed
        JOptionPane.showMessageDialog(null, "Please enter your address or Phone Number", "Critical error!", JOptionPane.ERROR_MESSAGE);
       
    }


      else 
      {
         try
        {
         double phone = Double.parseDouble(txtPhone.getText());
         // use the write method from class CPT, to write the order to txt for delivery purpose
         cpt.write(txtname.getText(),txtAddress.getText(),checkoutCounter,data[checkoutCounter],  cartC1.getText(), cartC2.getText(), cartP1.getText(), cartP2.getText(), cartS1.getText(), cartS2.getText(), cartB1.getText(), cartB2.getText());
         checkoutCounter++;
         // clear everything to allow the customer start a new shopping 
       txtPhone.setBackground(Color.WHITE);
         payment[counter] = Double.parseDouble(lbcartGrand.getText());
         counter++;
         lbcartGrand.setText("0.00");
         lbcartTax.setText("0.00");
         lbcartPrice.setText("0.00");
         cartC1.setText("");
         cartC2.setText("");
         cartS1.setText("");
         cartS2.setText("");
         cartP1.setText("");
         cartP2.setText("");
         cartB1.setText("");
         cartB2.setText("");
         txtAddress.setText("");
         txtPhone.setText("");
         cartPrice = 0;
         // ask the customer to exit or not 
      UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
      int option = JOptionPane.showConfirmDialog(null, "Thank you for shopping in Hudson's bay, your order will be delived in 3 days! \nDo you want to continue shopping (2D array is in 'Your shopping Card -- Purchase History')", "Hudson's Bay", JOptionPane.YES_NO_OPTION);
      // when customer clicks no, complete the order
      if(option == JOptionPane.NO_OPTION)
      {
              // exit it 
       System.exit(0);
      }
      // when customer click yes, continue shopping
      if(option == JOptionPane.YES_OPTION)
      {
       cpt.shopping();
      }
        }
         // catch error,because phone number has to be a number
        catch(NumberFormatException e1)
        {
        	// use method from class CPT1 to tell customer that the phone number has to be Integers
         cpt.numberError(" Phone Number");
         // set focus to the txtphone JextField when it needs to be changed 
       txtPhone.requestFocusInWindow();
       //set txtphone opaque. so we can change its background
       txtPhone.setOpaque(true);
       // change the color to red. alarm customers that error is occurred
       txtPhone.setBackground(Color.RED);
        }
      


      }
   }
  
  }
 
 // create class clearListener to perform action when the user to clear the info in shoppoing cart
  private class clearListener implements ActionListener
  {
	  // override it 
	  public void actionPerformed(ActionEvent e)
	  {
		  // when the button is clicked
		  if(e.getSource() == btnClear)
		  {
			  // set all information to the default 
			  
		         lbcartGrand.setText("0.00");
		         lbcartTax.setText("0.00");
		         lbcartPrice.setText("0.00");
		         cartC1.setText("");
		         cartC2.setText("");
		         cartS1.setText("");
		         cartS2.setText("");
		         cartP1.setText("");
		         cartP2.setText("");
		         cartB1.setText("");
		         cartB2.setText("");
		         txtAddress.setText("");
		         txtPhone.setText("");
		         cartPrice = 0;
		  }
	  }
  }
  // create class CreateListener to perform action when the user clicks btnCreate
  // To create new accounts
  public class CreateListener implements ActionListener
  {
	  // override it 
	  public void actionPerformed(ActionEvent e)
	  {
		  // when the butten is clicked
		  if(e.getSource()==btnCreate)
		  {
			   // set the UI to dimension(300,200), better layout
		    UIManager.put("OptionPane.minimumSize",new Dimension(300,200)); 
		    // show the panelCreate to user, and enables user to create new Account
		    JOptionPane.showMessageDialog(null,panelCreate,"Creating New Account",JOptionPane.INFORMATION_MESSAGE);
	  }
	  }
  }
  
  // create class OKlistener to perform action when the user clicks btnCreateOK
  public class createOKListener implements ActionListener
  {
	  // override it 
	  public void actionPerformed(ActionEvent e)
	  {
		  // when the btnCreateOK is clicked, perform actions 
		  if(e.getSource()== btnCreateOK)
		  {
			  // if either the name or the password is blank, tell the user to enter something
		   if(txtCreateName.getText().equals("")|| txtCreatePW.getText().equals(""))
		   {
			   // set the UI to dimension(800,500), better layout
		     UIManager.put("OptionPane.minimumSize",new Dimension(800,500)); 
		     // tell the user that either name or password is blank, this error should be fixed
		    JOptionPane.showMessageDialog(null, "Username/password is blank", "Hudson's Bay", JOptionPane.ERROR_MESSAGE);
		   }
		   // when both name and password are filled, perform action 
		   else
		   {
			   // set the UI to dimension(200,200), better layout
		     UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
		     // tell the user that the account is successfully created
		   JOptionPane.showMessageDialog(null, "Your Account has been sucessfully created!", "Hudson's Bay", JOptionPane.INFORMATION_MESSAGE);
           // write the account to a file using method from class CPT1
		   cpt.Account(accountCounter, account[accountCounter], txtCreateName.getText(), txtCreatePW.getText());
		   // create one more account by increasing accoutCounter by one
            accountCounter++;
            // set the text of txtCreateName to nothing, clear it
            txtCreateName.setText("");
            // set the text of txtCreatePW to nothing, clear it
            txtCreatePW.setText("");
		   }
	  }
  }
  }
 // create CloseListener Class --- windows listener
  // when the user clicks the exit button, an operation is pumped up to ask the user whether he wants to quit
  private class CloseListener extends WindowAdapter{
   // override it 
  public void windowClosing(WindowEvent e2) {
   // option is the message whether the user wants to quit
         int option;
         // Use a confirm dialog to ask the user whether he wants to quit
         // click yes or NO
   UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
   option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit" , "Hudson's Bay",JOptionPane.YES_NO_OPTION);
   // when the user clicks "yes" button in the confirm dialog
   if (option == JOptionPane.YES_OPTION)
   {
    // the program is closed
   System.exit(0);
   }

  }
  }
 
 
 
 
 }
 


