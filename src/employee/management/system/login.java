package src.employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton Login, Back;

    login(){
       JLabel username = new JLabel("Username");
       username.setBounds(40,20,40,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);



        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        Login= new JButton("Login");
        Login.setBounds(150,140,150,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        Back= new JButton("Back");
        Back.setBounds(150,180,150,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("src/icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(350,10,600,400);
        add(image);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setSize(600,300);
        setLayout(null);
        setLocation(450,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Login){
            try{
                String username = tusername.getText();
                String password = tpassword.getText();
                conn conn1 = new conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                System.out.println(username);System.out.println(password);
                ResultSet resultSet = conn1.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }catch (Exception E){
                E.printStackTrace();
            }

        }
        else{
            System.exit(90);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
