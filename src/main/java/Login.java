import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JPanel panel;
    JFrame frame;
    JLabel label1, label2, label3, label4;
    JTextField textField;
    JPasswordField passwordField;
    JButton button1, button2, button3;
    Choice choice;

    Login() {
        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame();
        frame.add(panel);

        label1 = new JLabel("username: ");
        label1.setBounds(30, 10, 100, 20);
        panel.add(label1);

        textField = new JTextField(40);
        textField.setBounds(100, 10 ,150,20);
        panel.add(textField);

        label2 = new JLabel("password: ");
        label2.setBounds(30, 40, 100, 20);
        panel.add(label2);

        passwordField = new JPasswordField(40);
        passwordField.setBounds(100, 40 ,150,20);
        panel.add(passwordField);

        label3 = new JLabel("Logging in as: ");
        label3.setBounds(30, 70, 100, 20);
        panel.add(label3);

        choice = new Choice();
        choice.add("Admin");
        choice.add("Customer");
        choice.setBounds(130, 70, 80, 20);
        panel.add(choice);

        button1 = new JButton("Login");
        button1.setBounds(30, 100,80,20);
        panel.add(button1);

        button2 = new JButton("Cancel");
        button2.setBounds(120, 100,80,20);
        panel.add(button2);

        button3 = new JButton("Signup");
        button3.setBounds(210, 100,80,20);
        panel.add(button3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,180);
        frame.setTitle("Login page");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1) {
            try{
                MySqlConnection mySqlConnection = new MySqlConnection();
                String username = textField.getText();
                String password = passwordField.getText();
                String userType = choice.getSelectedItem();
                String queryCommand = "SELECT * FROM login where username = '"+username+"' and password = '"+password+"' and user = '"+userType+"'";
                ResultSet resultSet = MySqlConnection.statement.executeQuery(queryCommand);

                if(resultSet.next()) {
                    String meter = resultSet.getString("meter_no");
                    //new Project(meter, user).setVisible(true);
                    panel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    textField.setText("");
                    passwordField.setText("");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error " + ex);
            }
        } else if (e.getSource() == button2) {
            panel.setVisible(false);
        } else if (e.getSource() == button3) {
            panel.setVisible(false);
            new Signup().panel.setVisible(true);
        }
    }
}
