package InterfacePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView {

    public JFrame frame;

    private long personId;
    public LoginView() {
        frame = new JFrame("DATING COMPATIBILITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Image image = new ImageIcon("src/main/resources/hearts.jpg").getImage();
        JPanel panel = new BackgroundPanel(image);

        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 178));

        JLabel l1 = new JLabel("Name");
        l1.setFont(new Font(l1.getFont().getFontName(), Font.PLAIN, 20));
        l1.setBounds(150, 100, 600, 50);
        panel.add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setFont(new Font(l1.getFont().getFontName(), Font.PLAIN, 20));
        l2.setBounds(150, 200, 600, 50);
        panel.add(l2);

        JTextField tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 20));
        tname.setSize(300, 30);
        tname.setLocation(300, 100);
        panel.add(tname);

        JTextField pass = new JTextField();
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(300, 30);
        pass.setLocation(300, 200);
        panel.add(pass);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(300, 300, 300, 50);
        panel.add(loginButton);
        loginButton.setBackground(Color.pink);
        loginButton.addMouseListener(new MouseAdapter() {
            Color color = loginButton.getForeground();
            Color color2 = loginButton.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = loginButton.getForeground();
                loginButton.setBackground(Color.red); // change the color to green when mouse over a button
                loginButton.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent me) {
                loginButton.setBackground(color2);
                loginButton.setForeground(color);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
    //           FinishView view1 = new FinishView(person);
  //             view1.frame.setVisible(true);
            }
        });


        JButton backButton = new JButton("BACK");
        backButton.setBounds(50, 400, 150, 40);
        panel.add(backButton);
        backButton.setBackground(Color.pink);
        backButton.addMouseListener(new MouseAdapter() {
            Color color = backButton.getForeground();
            Color color2 = backButton.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = backButton.getForeground();
                backButton.setBackground(Color.red); // change the color to green when mouse over a button
                backButton.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent me) {
                backButton.setBackground(color2);
                backButton.setForeground(color);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Interface view = new Interface();
                view.frame.setVisible(true);
            }
        });


        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }


}
