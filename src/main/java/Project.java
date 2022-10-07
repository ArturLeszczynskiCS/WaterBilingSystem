import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {

    String meter;
    Project(String meter, String person) {
        super("Water Biling System");
        this.meter= meter;

        setSize(1920,1080);

        JMenuBar menuBar = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem menuItem1 = new JMenuItem("New Customer");
        JMenuItem menuItem2 = new JMenuItem("Customer Details");
        JMenuItem menuItem3 = new JMenuItem("Deposit details");
        JMenuItem menuItem4 = new JMenuItem("Calculate Bill");
        master.setForeground(Color.cyan);

        menuItem1.setMnemonic('D');
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

        menuItem2.setMnemonic('M');
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));

        menuItem3.setMnemonic('N');
        menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        menuItem4.setMnemonic('B');
        menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);

        JMenu info = new JMenu("Information");
        JMenuItem menuInfo1 = new JMenuItem("Update Information");
        JMenuItem menuInfo2 = new JMenuItem("View Information");

        menuInfo1.setMnemonic('P');
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        menuInfo2.setMnemonic('L');
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        menuInfo1.addActionListener(this);
        menuInfo2.addActionListener(this);


        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");

        JMenuItem u3 = new JMenuItem("Bill Details");

        u1.setMnemonic('P');
        menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        u3.setMnemonic('L');
        menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        u1.addActionListener(this);
        u3.addActionListener(this);

        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");

        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));

        r1.addActionListener(this);

        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");

        ut1.setMnemonic('C');
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        ut2.setMnemonic('X');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        ut3.setMnemonic('W');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);

        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Logout");

        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));

        ex.addActionListener(this);

        master.add(menuItem1);
        master.add(menuItem2);
        master.add(menuItem3);
        master.add(menuItem4);

        info.add(menuItem1);
        info.add(menuItem2);
        info.add(menuItem3);

        user.add(u1);
        user.add(u3);

        report.add(r1);

        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);

        exit.add(ex);

        menuBar.add(utility);
        menuBar.add(exit);

        setJMenuBar(menuBar);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Project("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
