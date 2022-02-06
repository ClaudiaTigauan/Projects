package InterfacePackage;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interface {

    public JFrame frame;

    public Interface(){

        frame = new JFrame("DATING COMPATIBILITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Image image = new ImageIcon("src/main/resources/hearts.jpg").getImage();
        JPanel panel = new BackgroundPanel(image);

        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 178));

        JLabel l1 = new JLabel("Are you ready to find your soulmate?");
        l1.setFont(new Font(l1.getFont().getFontName(), Font.PLAIN, 30));
        l1.setBounds(125, 100, 600, 50);
        panel.add(l1);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(250, 200,300,50);
        panel.add(registerButton);
        registerButton.setBackground(Color.pink);
        registerButton.addMouseListener(new MouseAdapter() {
            Color color = registerButton.getForeground();
            Color color2 = registerButton.getBackground();
            public void mouseEntered(MouseEvent me) {
                color = registerButton.getForeground();
                registerButton.setBackground(Color.red); // change the color to green when mouse over a button
                registerButton.setForeground(Color.white);
            }
            public void mouseExited(MouseEvent me) {
                registerButton.setBackground(color2);
                registerButton.setForeground(color);
            }
        });

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(250, 300,300,50);
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

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                RegisterView view=new RegisterView();
                view.frame.setVisible(true);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                LoginView view=new LoginView();
                view.frame.setVisible(true);
            }
        });


        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}
