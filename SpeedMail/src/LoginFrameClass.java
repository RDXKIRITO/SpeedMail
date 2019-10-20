import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrameClass extends JFrame implements ActionListener
{
    JFrame LoginFrame;
    JMenuBar mb;
    JMenu menu;
    JMenuItem menuitem1,menuitem2,menuitem3;
    JLabel loginlabel,passwordlabel;
    JTextField text;
    JPasswordField pass;
    JButton login,reset;
    Color btnclr,mbclr,frameclr,labelclr,controlclr;
    LoginFrameClass()
    {
        LoginFrame = new JFrame("Speed-Mail");
        btnclr = new Color(59,89,152);
        mbclr = new Color(153,153,153);
        frameclr = new Color(65,65,65);
        labelclr = new Color(255,255,255);
        controlclr = new Color(200,200,200);
        mb = new JMenuBar();
        menu = new JMenu("Menu");
        menuitem1 = new JMenuItem("Login");
        menuitem2 = new JMenuItem("New User");
        menuitem3 = new JMenuItem("Configure");
        loginlabel = new JLabel("Login ID");
        passwordlabel = new JLabel("Password");
        text = new JTextField(100);
        pass = new JPasswordField(100);
        login = new JButton("Login");

        reset = new JButton("Reset");


        //setting EventListeners
        login.addActionListener(this);
        reset.addActionListener(this);
        menuitem1.addActionListener(this);
        menuitem2.addActionListener(this);
        menuitem3.addActionListener(this);



        // Coloring Code

        mb.setOpaque(true);
        mb.setBackground(mbclr);
        LoginFrame.getContentPane().setBackground(frameclr);
        loginlabel.setForeground(labelclr);
        passwordlabel.setForeground(labelclr);
        login.setBackground(controlclr);
        reset.setBackground(controlclr);
        text.setBackground(controlclr);
        pass.setBackground(controlclr);



        //Bounds Setting

        loginlabel.setBounds(130,100,50,30);
        passwordlabel.setBounds(130,150,80,30);
        text.setBounds(200,100,150,30);
        pass.setBounds(200,150,150,30);
        login.setBounds(160,200,80,30);
        reset.setBounds(260,200,80,30);

        menu.add(menuitem1);
        menu.add(menuitem2);
        menu.add(menuitem3);

        login.setForeground(Color.white);
        login.setBackground(btnclr);
        reset.setForeground(Color.white);
        reset.setBackground(btnclr);

        mb.add(menu);
        LoginFrame.add(loginlabel);
        LoginFrame.add(passwordlabel);
        LoginFrame.add(text);
        LoginFrame.add(pass);
        LoginFrame.add(login);
        LoginFrame.add(reset);
        LoginFrame.setJMenuBar(mb);
        LoginFrame.setSize(500, 500);
        LoginFrame.setLayout(null);
        LoginFrame.setResizable(false);
        LoginFrame.setVisible(true);
        //LoginFrame.pack();
        LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            if(pass.getPassword().length==0 || text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(LoginFrame,"Fields Are Empty","Empty",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                LoginFrame.setVisible(false);
                GeneralLoggedinFrameClass.main(new String[]{});
            }
        }
        if(ae.getSource()==reset)
        {
            text.setText("");
            pass.setText("");
        }
        if(ae.getSource()==menuitem2)
        {
            LoginFrame.setVisible(false);
            NewUserCreationFrameClass.main(new String[]{});
        }
    }

    public static void main(String[] args)
    {
        new LoginFrameClass();
    }
}
