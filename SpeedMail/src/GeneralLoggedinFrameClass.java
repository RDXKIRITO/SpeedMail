import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GeneralLoggedinFrameClass extends JFrame implements ActionListener
{
    JFrame GeneralLoggedinFrame;
    JMenuBar mb;
    JMenu menu1;
    JMenuItem menuitem1,menuitem2,menuitem3;
    JLabel tolabel,subjectlabel,messagelabel;
    JTextField tofield,subjectfield;
    TextArea messagearea;
    JButton send,reset;
    Color frameclr,labelclr,controlclr,mbclr;

    GeneralLoggedinFrameClass()
    {
        GeneralLoggedinFrame = new JFrame();
        mb = new JMenuBar();
        menu1 = new JMenu("Menu");
        menuitem1 = new JMenuItem("One");
        menuitem2 = new JMenuItem("Two");
        menuitem3 = new JMenuItem("Logout");
        tolabel = new JLabel("To:-");
        subjectlabel = new JLabel("Subject:-");
        messagelabel = new JLabel("Message:-");
        tofield = new JTextField();
        subjectfield = new JTextField();
        messagearea = new TextArea();
        send = new JButton("Send");
        reset = new JButton("Reset");
        frameclr = new Color(65,65,65);
        labelclr = new Color(255,255,255);
        controlclr = new Color(200,200,200);
        mbclr = new Color(153,153,153);



        //Setting EventListeners
        send.addActionListener(this);
        reset.addActionListener(this);
        menuitem1.addActionListener(this);
        menuitem2.addActionListener(this);
        menuitem3.addActionListener(this);


        //Setting Bounds
        tolabel.setBounds(50,50,80,30);
        subjectlabel.setBounds(50,100,80,30);
        messagelabel.setBounds(50,150,80,30);
        tofield.setBounds(150,50,300,30);
        subjectfield.setBounds(150,100,300,30);
        messagearea.setBounds(150,150,300,200);
        send.setBounds(150,380,80,30);
        reset.setBounds(250,380,80,30);
        menu1.add(menuitem1);
        menu1.add(menuitem2);
        mb.add(menu1);
        mb.setOpaque(true);



        //Coloring code
        GeneralLoggedinFrame.getContentPane().setBackground(frameclr);
        tolabel.setForeground(labelclr);
        subjectlabel.setForeground(labelclr);
        messagelabel.setForeground(labelclr);
        tofield.setBackground(controlclr);
        subjectfield.setBackground(controlclr);
        messagearea.setBackground(controlclr);
        send.setBackground(controlclr);
        reset.setBackground(controlclr);
        mb.setBackground(mbclr);



        GeneralLoggedinFrame.add(tolabel);
        GeneralLoggedinFrame.add(subjectlabel);
        GeneralLoggedinFrame.add(messagelabel);
        GeneralLoggedinFrame.add(tofield);
        GeneralLoggedinFrame.add(subjectfield);
        GeneralLoggedinFrame.add(messagearea);
        GeneralLoggedinFrame.add(send);
        GeneralLoggedinFrame.add(reset);

        GeneralLoggedinFrame.add(mb);
        GeneralLoggedinFrame.setResizable(false);
        GeneralLoggedinFrame.setJMenuBar(mb);
        GeneralLoggedinFrame.setSize(600,500);
        GeneralLoggedinFrame.setLayout(null);
        GeneralLoggedinFrame.setVisible(true);
        GeneralLoggedinFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==send)
        {
            if(tofield.getText().equals("") || subjectfield.getText().equals("") || messagearea.getText().equals(""))
            {
                JOptionPane.showMessageDialog(GeneralLoggedinFrame,"Field are not filled Properly","Missing Values",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(ae.getSource()==reset)
        {
            int check = JOptionPane.showConfirmDialog(GeneralLoggedinFrame,"Are You Sure You want to Reset All above mentioned Details?","Reset Data",JOptionPane.YES_NO_CANCEL_OPTION);
            if(check==0)
            {
                tofield.setText("");
                subjectfield.setText("");
                messagearea.setText(String.valueOf('\0'));
            }
        }
    }
    public static void main(String[] args)
    {
        new GeneralLoggedinFrameClass();
    }
}
