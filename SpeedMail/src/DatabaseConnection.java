import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseConnection
{
    private boolean isDatabasePresent;
    private boolean isDataPresent;
    DatabaseConnection()
    {
        isDatabasePresent = true;
        isDataPresent = true;
    }
    public static void main(String[] args)
    {
        new DatabaseConnection();
    }
    public Boolean checkdata(String dbname,String username,String password,String email)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from mailregisteration where email='"+email+"'");
            if(!rs.next())
            {
                isDataPresent = false;
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return isDataPresent;
    }
    public Boolean checkdatabase(String dbname,String username,String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/",username,password);
            Statement st = con.createStatement();
            st.executeQuery("use "+dbname);
            con.close();
            System.out.println("Connection Successful");
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException dbnotfound)
        {
            JOptionPane.showMessageDialog(null, "Database Not Found");
            isDatabasePresent = false;
        }
        catch(java.sql.SQLException validationfailed)
        {
            JOptionPane.showMessageDialog(null, "Cannot Access SQL Server Due to Wrong Username or Password");
            isDatabasePresent = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(isDatabasePresent)
        {
            return isDatabasePresent;
        }
        return isDatabasePresent;
    }
    public Boolean createdatabase(String dbname,String username,String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306",username,password);
            Statement st = con.createStatement();
            st.executeUpdate("create database "+dbname);
            isDatabasePresent = true;
            st.executeUpdate("use "+dbname+";");
            st.executeUpdate("create table mailregisteration(name varchar(30),email varchar(50),Primary Key(email));");
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
}
