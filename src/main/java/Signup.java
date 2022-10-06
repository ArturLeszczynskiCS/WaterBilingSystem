import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup implements ActionListener {
    JPanel panel;
    JFrame frame;
    JTextField textField1, textField2, textField3, textField4;
    JLabel label1, label2, label3, label4, label5;
    Choice choice;
    JButton button1, button2;

    Signup() {

        panel = new JPanel();
        panel.setLayout(null);

        label1 = new JLabel("username: ");
        label1.setBounds(30, 10, 100, 20);
        panel.add(label1);

        textField1 = new JTextField();
        textField1.setBounds(100, 10, 150, 20);
        panel.add(textField1);

        label2 = new JLabel("Name: ");
        label2.setBounds(30, 40, 100, 20);
        panel.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(100, 40, 150, 20);
        panel.add(textField2);

        label3 = new JLabel("Password: ");
        label3.setBounds(30, 70, 100, 20);
        panel.add(label3);

        textField3 = new JTextField();
        textField3.setBounds(100, 70, 150, 20);
        panel.add(textField3);

        label4 = new JLabel("Create account as: ");
        label4.setBounds(30, 100, 120, 20);
        panel.add(label4);

        choice = new Choice();
        choice.add("Admin");
        choice.add("Customer");
        choice.setBounds(160, 100, 90, 20);
        panel.add(choice);

        label5 = new JLabel("Meter number: ");
        label5.setBounds(30, 130, 100, 20);
        label5.setVisible(false);
        panel.add(label5);

        textField4 = new JTextField();
        textField4.setBounds(120, 130, 130, 20);
        textField4.setVisible(false);
        panel.add(textField4);

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String userType = choice.getSelectedItem();
                if (userType.equals("Customer")) {
                    label5.setVisible(true);
                    textField4.setVisible(true);
                } else {
                    label5.setVisible(false);
                    textField4.setVisible(false);
                }
            }
        });

        button1 = new JButton("Create");
        button1.setBounds(30, 160, 100, 20);
        panel.add(button1);

        button2 = new JButton("Back");
        button2.setBounds(140, 160, 100, 20);
        panel.add(button2);


        frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 240);
        frame.setTitle("Signup page");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            String username = textField1.getText();
            String name = textField2.getName();
            String password = textField3.getName();
            String meter = textField4.getName();
            String userType = choice.getSelectedItem();

            try {
                MySqlConnection mySqlConnection = new MySqlConnection();
                String str = "";
                if (userType.equals("Admin")) {
                    str = "INSERT INTO login VALUES('" + meter + "', '" + username + "'" +
                            ",'" + name + "','" + password + "','" + userType + "')";
                } else {
                    str = "UPDATE login set username = '" + username + "', name = '" + name + "', password = '" + password + "'" +
                            ", user = '" + userType + "' where meter_no = '" + textField4.getText() + "'";
                }

                mySqlConnection.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                panel.setVisible(false);
                new Login().panel.setVisible(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == button2) {
            panel.setVisible(false);
            new Login().panel.setVisible(true);
        }
    }
}
