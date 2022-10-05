import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;

public class About extends JFrame implements ActionListener {

    JButton buttonExit = new JButton("Exit");
    JLabel labelProject = new JLabel("About Project");
    Font fontTimesRoman = new Font("TimesRoman", Font.ITALIC, 40);
    Font fontCourier = new Font("Courier", Font.PLAIN, 18);

    TextArea textArea;
    String aboutStr =
            "Water Billing System is an automated system that was based on paying water bills." +
                    "This system can manage transaction such as creating an invoice and paying the bills of customers. " +
                    "It will track all the records of the customer if they have paid on the due date or not.";


    public About() {

        setBounds(500, 220, 500, 400);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);


        setFont(fontTimesRoman);

        setLayout(null);
        add(buttonExit);
        buttonExit.setBounds(180, 300, 120, 20);
        buttonExit.addActionListener(this);

        textArea = new TextArea(aboutStr, 10, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea.setEditable(false);
        textArea.setBounds(25, 100, 450, 150);
        textArea.setFont(fontCourier);

        add(textArea);

        labelProject.setBounds(120, 10, 300, 80);
        labelProject.setForeground(Color.ORANGE);
        labelProject.setFont(fontTimesRoman);

        add(labelProject);
    }


    public static void main(String[] args) {
        new About();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
