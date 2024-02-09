// Import packages
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

// The calculator class
class Calculator implements ActionListener {

    // First create a frame
    static JFrame f;

    // create a text-field
    static JTextField tf;

    // create variables for storing operators and operands
    String f0, f1, f2;

    // default constructor for the class
    Calculator(){
        f0 = f1 = f2 = "";
    }


    // The main function
    public static void main(String args[])
    {
        f =  new JFrame("calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

        // create an object of the class
        Calculator c = new Calculator();

        // textfield
        tf = new JTextField(20);

        // set that the textfield can be edited
        tf.setEditable(false);

        // create number buttons and operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, bdot, bc, beq;

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // create other buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        bc = new JButton("C");
        bdot = new JButton(".");
        beq = new JButton("=");

        // a panel
        JPanel p = new JPanel();
        
        // add the action listeners
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        bc.addActionListener(c);
        bdot.addActionListener(c);
        beq.addActionListener(c);

        // add the different elements to the panel
        p.add(tf);
        p.add(b0);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(ba);
        p.add(bs);
        p.add(bd);
        p.add(bm);
        p.add(bdot);  
        p.add(bc);
        p.add(beq);

        // set the backgroundcolor of the panel
        p.setBackground(Color.green);

        // add the panel to the frame
        f.add(p);
        
        f.setSize(300, 300);
        // f.show();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        // check is the value is a number
        if((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.'){
            if (!f1.equals(""))
                f2 = f2 + s;
            else 
                f0 = f0 + s;

            // set the value of text
            tf.setText(f0 + f1 + f2);
        }
        else if (s.charAt(0) == 'C'){
            // clear the textfield
            f0 = f1 = f2 = "";

            // set the value of the text
            tf.setText(f0 + f1 + f2);
        }
        else if (s.charAt(0) == '='){
            double te;

            // store the value in 1st
            if (f1.equals("+"))
                te = (Double.parseDouble(f0) + Double.parseDouble(f2));
            else if (f1.equals("-"))
                te = (Double.parseDouble(f0) - Double.parseDouble(f2));
            else if (f1.equals("/"))
                te = (Double.parseDouble(f0) / Double.parseDouble(f2));
            else
                te = (Double.parseDouble(f0) * Double.parseDouble(f2));

            // set the value of text
            tf.setText(f0 + f1 + f2 + "=" + te);
 
            // convert it to string
            f0 = Double.toString(te);
 
            f1 = f2 = "";
        }
        else{
            // check if there was an operand
            if (f1.equals("") || f2.equals(""))
                f1 = s;
            // else evaluate
            else {
                double te;
 
                // store the value in 1st
                if (f1.equals("+"))
                    te = (Double.parseDouble(f0) + Double.parseDouble(f2));
                else if (f1.equals("-"))
                    te = (Double.parseDouble(f0) - Double.parseDouble(f2));
                else if (f1.equals("/"))
                    te = (Double.parseDouble(f0) / Double.parseDouble(f2));
                else
                    te = (Double.parseDouble(f0) * Double.parseDouble(f2));
 
                // convert it to string
                f0 = Double.toString(te);
 
                // place the operator
                f1 = s;
 
                // make the operand blank
                f2 = "";
            }
            // set the value of text
            tf.setText(f0 + f1 + f2);
 
        }


    }






}