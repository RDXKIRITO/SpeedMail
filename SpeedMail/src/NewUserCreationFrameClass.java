import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import java.util.Vector;

public class NewUserCreationFrameClass extends JFrame implements ActionListener
{
    JFrame NewUserCreationFrame;
    JLabel namelabel,agelabel,genderlabel,organisationlabel,contactlabel,maillabel,otplabel;
    JTextField namefield,agefield,organisationfield,contactfield,mailfield,otpfield;
    JComboBox genderfield;
    Color frameclr,labelclr,controlclr;
    JButton createaccount,reset,back;
    Vector mailwithotp;
    NewUserCreationFrameClass()
    {
        NewUserCreationFrame = new JFrame("Speed-Mail : User Creation");
        namelabel = new JLabel("Name:-");
        agelabel = new JLabel("Age:-");
        genderlabel = new JLabel("Gender:-");
        organisationlabel = new JLabel("Organisation Name:-");
        contactlabel = new JLabel("Contact No. :-");
        maillabel = new JLabel("EMail ID:-");
        otplabel = new JLabel("Verification Code:-");
        namefield = new JTextField();
        agefield = new JTextField();
        genderfield = new JComboBox();
        genderfield.addItem("Please Select");
        genderfield.addItem("Male");
        genderfield.addItem("Female");
        genderfield.addItem("Others");
        organisationfield = new JTextField();
        contactfield = new JTextField();
        mailfield = new JTextField();
        otpfield = new JTextField();
        createaccount = new JButton("Create Account");
        reset = new JButton("Reset");
        back = new JButton("Back");



        frameclr = new Color(65,65,65);
        labelclr = new Color(255,255,255);
        controlclr = new Color(200,200,200);




        //setting Bounds

        namelabel.setBounds(100,50,80,30);
        agelabel.setBounds(100,100,80,30);
        genderlabel.setBounds(100,150,80,30);
        organisationlabel.setBounds(100,200,120,30);
        contactlabel.setBounds(100,250,80,30);
        maillabel.setBounds(100,300,80,30);
        otplabel.setBounds(100,350,120,30);

        namefield.setBounds(220,50,180,30);
        agefield.setBounds(220,100,180,30);
        genderfield.setBounds(220,150,180,30);
        organisationfield.setBounds(220,200,180,30);
        contactfield.setBounds(220,250,180,30);
        mailfield.setBounds(220,300,180,30);
        otpfield.setBounds(220,350,100,30);
        createaccount.setBounds(100,400,150,30);
        reset.setBounds(260,400,150,30);
        back.setBounds(0,0,80,30);



        //Setting EventListeners
        createaccount.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);


        //Coloring Code
        namelabel.setForeground(labelclr);
        agelabel.setForeground(labelclr);
        genderlabel.setForeground(labelclr);
        organisationlabel.setForeground(labelclr);
        contactlabel.setForeground(labelclr);
        maillabel.setForeground(labelclr);
        otplabel.setForeground(labelclr);
        back.setBackground(controlclr);
        namefield.setBackground(controlclr);
        agefield.setBackground(controlclr);
        genderfield.setBackground(controlclr);
        organisationfield.setBackground(controlclr);
        contactfield.setBackground(controlclr);
        mailfield.setBackground(controlclr);
        otpfield.setBackground(controlclr);
        createaccount.setBackground(controlclr);
        reset.setBackground(controlclr);


        // Adding Components to Frame

        NewUserCreationFrame.add(namelabel);
        NewUserCreationFrame.add(agelabel);
        NewUserCreationFrame.add(genderlabel);
        NewUserCreationFrame.add(organisationlabel);
        NewUserCreationFrame.add(contactlabel);
        NewUserCreationFrame.add(maillabel);
        NewUserCreationFrame.add(otplabel);
        NewUserCreationFrame.add(namefield);
        NewUserCreationFrame.add(agefield);
        NewUserCreationFrame.add(genderfield);
        NewUserCreationFrame.add(organisationfield);
        NewUserCreationFrame.add(contactfield);
        NewUserCreationFrame.add(mailfield);
        NewUserCreationFrame.add(otpfield);
        NewUserCreationFrame.add(createaccount);
        NewUserCreationFrame.add(reset);
        NewUserCreationFrame.add(back);



        otplabel.setVisible(false);
        otpfield.setVisible(false);


        NewUserCreationFrame.getContentPane().setBackground(new Color(65,65,65));
        NewUserCreationFrame.setSize(500,500);
        NewUserCreationFrame.setLayout(null);
        NewUserCreationFrame.setResizable(false);
        NewUserCreationFrame.setVisible(true);
        NewUserCreationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        mailwithotp = new Vector();
        boolean isotpsend=false;
        if(ae.getSource()==createaccount)
        {
            boolean check = checkdetails();
            String otp="";
            if(check == true)    //&& !mailwithotp.contains(mailfield.getText())
            {
                otpfield.setVisible(true);
                otplabel.setVisible(true);
                otp = generaterandomnumber();
                while(!(otp.length()==6))
                {
                    otp = generaterandomnumber();
                }
                otpfield.setText(otp);
                isotpsend = sendotp(otp);
                mailwithotp.add(mailfield.getText());
                mailwithotp.add(otp);
            }
        }
        if(ae.getSource()==reset)
        {
            int check = JOptionPane.showConfirmDialog(NewUserCreationFrame,"Are You Sure You want to Reset All above mentioned Details?","Reset Data",JOptionPane.YES_NO_CANCEL_OPTION);
            if(check==0)
            {
                namefield.setText("");
                agefield.setText("");
                genderfield.setSelectedItem("Please Select");
                organisationfield.setText("");
                contactfield.setText("");
                mailfield.setText("");
                otpfield.setText("");
                otplabel.setVisible(false);
                otpfield.setVisible(false);
            }
        }
        if(ae.getSource()==back)
        {
            NewUserCreationFrame.setVisible(false);
            LoginFrameClass.main(new String[]{});
        }
    }
    public boolean sendotp(String otp)
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        String username = "harshitmalik58@gmail.com";
        String pass = "Lucifer2work@";
        String tomail = mailfield.getText();
        String subject = "OTP FOR SPEED MAIL";
        String mess ="The Verification Code for Creating account  in SpeedMail is "+otp;
        Session session = Session.getInstance(props,new LoginAuthenticator("harshitmalik58@gmail.com","Lucifer2work@"));
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(tomail));
            message.setText(mess);
            message.setSubject(subject);
            Transport.send(message);
            JOptionPane.showMessageDialog(NewUserCreationFrame,"Verification code is sent to your email:-"+mailfield.getText(),"Verification Code Sent Successfully",JOptionPane.INFORMATION_MESSAGE);
        }catch(MessagingException e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }
    class LoginAuthenticator extends javax.mail.Authenticator {
        PasswordAuthentication authentication = null;

        public LoginAuthenticator(String username, String password) {
            authentication = new PasswordAuthentication(username,password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }

    }
    public String generaterandomnumber()
    {
        String otp = (String.valueOf((int)(Math.random()*1000000)));
        return otp;
    }
    public boolean checkcontact(String contactno)
    {
        boolean check = true;
        for(int i=0;i<10;i++)
        {
            if(!Character.isDigit(contactno.charAt(i)))
            {
                check = false;
            }
        }
        return check;
    }
    public boolean checkdetails()
    {
        boolean check = true;
        if(namefield.getText().equals("") || agefield.getText().equals("") || genderfield.getSelectedIndex()==0 || organisationfield.getText().equals("") || mailfield.getText().equals("") || contactfield.getText().equals("") )
        {
            JOptionPane.showMessageDialog(NewUserCreationFrame,"All the details are not Filled Properly","Empty Fields",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else
        {
            if(!mailfield.getText().endsWith("@gmail.com"))
            {
                JOptionPane.showMessageDialog(NewUserCreationFrame,"Wrong EMail Format","Invalid EMail format",JOptionPane.ERROR_MESSAGE);
                check = false;
            }
            if(!(contactfield.getText().length()==10) || !checkcontact(contactfield.getText()))
            {
                JOptionPane.showMessageDialog(NewUserCreationFrame,"Invalid Contact Number","Invalid Contact",JOptionPane.ERROR_MESSAGE);
                check = false;
            }
            if(checkage(agefield.getText()))
            {
                if(!(agefield.getText().length()<=3) ||  !(Integer.parseInt(agefield.getText())>=0 && Integer.parseInt(agefield.getText())<=115))
                {
                    JOptionPane.showMessageDialog(NewUserCreationFrame,"Invalid Age","Wrong Age Input",JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(NewUserCreationFrame,"Age Should be a Integer/Valid Value","Invalid Age",JOptionPane.ERROR_MESSAGE);
                check = false;
            }
        }
        return check;
    }
    public boolean checkage(String age)
    {
        boolean check = true;
        for (int i = 0; i < age.length(); i++)
        {
            if(!Character.isDigit(age.charAt(i)))
            {
                check = false;
            }
        }
        return check;
    }

    public static void main(String[] args)
    {
        new NewUserCreationFrameClass();
    }
}
