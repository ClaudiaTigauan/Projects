package InterfacePackage;

import mockdb.Database;
import person.Person;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinishView {

    public JFrame frame;
    private Person matchedPerson;
    private Database db = Database.getInstance();

    public FinishView(Person matchedPerson) {
        this.matchedPerson = matchedPerson;
        frame = new JFrame("DATING COMPATIBILITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Image image = new ImageIcon("src/main/resources/hearts.jpg").getImage();
        JPanel panel = new BackgroundPanel(image);

        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 178));

        JLabel lname = new JLabel("RESULTS");
        lname.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 25));
        lname.setBounds(50, 0, 600, 50);
        panel.add(lname);


        JTextArea tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(400, 400);
        tout.setLocation(100, 50);
        tout.setLineWrap(true);
        tout.setEditable(false);
        panel.add(tout);

        tout.setText("Your perfect date is : " + matchedPerson.getName() + "\n" + "Personal info : \n" + "Age : "
        + matchedPerson.getAge() + "\nGender : " + matchedPerson.getGender() + "\nHeight : " + matchedPerson.getHeight()
        + "\nLocation : " + matchedPerson.getLocation());

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(600, 100, 150, 40);
        panel.add(exitButton);
        exitButton.setBackground(Color.pink);
        exitButton.addMouseListener(new MouseAdapter() {
            Color color = exitButton.getForeground();
            Color color2 = exitButton.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = exitButton.getForeground();
                exitButton.setBackground(Color.red); // change the color to green when mouse over a button
                exitButton.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent me) {
                exitButton.setBackground(color2);
                exitButton.setForeground(color);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
            }
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}


