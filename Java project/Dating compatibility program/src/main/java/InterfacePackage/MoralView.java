package InterfacePackage;

import mockdb.Database;
import person.Moral;
import person.Person;
import service.CompatibilityCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

public class MoralView {
    public JFrame frame;
    private Person person;
    private Database db = Database.getInstance();

    private JRadioButton getSelectedRadioButton(ButtonGroup buttonGroup) {

        Enumeration<AbstractButton> abstractButtons = buttonGroup.getElements();
        JRadioButton radioButton = null;

        while (abstractButtons.hasMoreElements()) {
            radioButton = (JRadioButton) abstractButtons.nextElement();
            if (radioButton.isSelected()) {
                break;
            }
        }
        return radioButton;
    }

    public MoralView(Person person) {
        this.person = person;
        frame = new JFrame("DATING COMPATIBILITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Image image = new ImageIcon("src/main/resources/hearts.jpg").getImage();
        JPanel panel = new BackgroundPanel(image);
        panel.setOpaque(false);

        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 178));

        JLabel lname = new JLabel("PERSONALITY TEST");
        lname.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 25));
        lname.setBounds(50, 0, 600, 50);
        panel.add(lname);

        JLabel l1 = new JLabel("1. You regularly make new friends.");
        l1.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        l1.setBounds(50, 50, 600, 50);
        panel.add(l1);

        JLabel p11 = new JLabel("Agree");
        p11.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p11.setBounds(25, 80, 600, 50);
        panel.add(p11);

        JRadioButton j11 = new JRadioButton("1");
        j11.setFont(new Font("Arial", Font.PLAIN, 15));
        j11.setSelected(true);
        j11.setSize(25, 20);
        j11.setLocation(75, 100);
        panel.add(j11);

        JRadioButton j12 = new JRadioButton("2");
        j12.setFont(new Font("Arial", Font.PLAIN, 15));
        j12.setSelected(true);
        j12.setSize(25, 20);
        j12.setLocation(125, 100);
        panel.add(j12);

        JRadioButton j13 = new JRadioButton("3");
        j13.setFont(new Font("Arial", Font.PLAIN, 15));
        j13.setSelected(true);
        j13.setSize(25, 20);
        j13.setLocation(175, 100);
        panel.add(j13);

        JRadioButton j14 = new JRadioButton("4");
        j14.setFont(new Font("Arial", Font.PLAIN, 15));
        j14.setSelected(true);
        j14.setSize(25, 20);
        j14.setLocation(225, 100);
        panel.add(j14);

        JRadioButton j15 = new JRadioButton("5");
        j15.setFont(new Font("Arial", Font.PLAIN, 15));
        j15.setSelected(true);
        j15.setSize(25, 20);
        j15.setLocation(275, 100);
        panel.add(j15);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(j11);
        gengp.add(j12);
        gengp.add(j13);
        gengp.add(j14);
        gengp.add(j15);

        JLabel p12 = new JLabel("Disagree");
        p12.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p12.setBounds(325, 80, 600, 50);
        panel.add(p12);


        JLabel l2 = new JLabel("2. Your mood can change very quickly.");
        l2.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        l2.setBounds(50, 150, 800, 50);
        panel.add(l2);

        JLabel p21 = new JLabel("Agree");
        p21.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p21.setBounds(25, 180, 600, 50);
        panel.add(p21);

        JRadioButton j21 = new JRadioButton("1");
        j21.setFont(new Font("Arial", Font.PLAIN, 15));
        j21.setSelected(true);
        j21.setSize(25, 20);
        j21.setLocation(75, 200);
        panel.add(j21);

        JRadioButton j22 = new JRadioButton("2");
        j22.setFont(new Font("Arial", Font.PLAIN, 15));
        j22.setSelected(true);
        j22.setSize(25, 20);
        j22.setLocation(125, 200);
        panel.add(j22);

        JRadioButton j23 = new JRadioButton("3");
        j23.setFont(new Font("Arial", Font.PLAIN, 15));
        j23.setSelected(true);
        j23.setSize(25, 20);
        j23.setLocation(175, 200);
        panel.add(j23);

        JRadioButton j24 = new JRadioButton("4");
        j24.setFont(new Font("Arial", Font.PLAIN, 15));
        j24.setSelected(true);
        j24.setSize(25, 20);
        j24.setLocation(225, 200);
        panel.add(j24);

        JRadioButton j25 = new JRadioButton("5");
        j25.setFont(new Font("Arial", Font.PLAIN, 15));
        j25.setSelected(true);
        j25.setSize(25, 20);
        j25.setLocation(275, 200);
        panel.add(j25);

        ButtonGroup gengp2 = new ButtonGroup();
        gengp2.add(j21);
        gengp2.add(j22);
        gengp2.add(j23);
        gengp2.add(j24);
        gengp2.add(j25);

        JLabel p22 = new JLabel("Disagree");
        p22.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p22.setBounds(325, 180, 600, 50);
        panel.add(p22);


        JLabel l3 = new JLabel("3. Seeing other people cry can easily make you feel like you want to cry too.");
        l3.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        l3.setBounds(50, 250, 800, 50);
        panel.add(l3);

        JLabel p31 = new JLabel("Agree");
        p31.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p31.setBounds(25, 280, 600, 50);
        panel.add(p31);

        JRadioButton j31 = new JRadioButton("1");
        j31.setFont(new Font("Arial", Font.PLAIN, 15));
        j31.setSelected(true);
        j31.setSize(25, 20);
        j31.setLocation(75, 300);
        panel.add(j31);

        JRadioButton j32 = new JRadioButton("2");
        j32.setFont(new Font("Arial", Font.PLAIN, 15));
        j32.setSelected(true);
        j32.setSize(25, 20);
        j32.setLocation(125, 300);
        panel.add(j32);

        JRadioButton j33 = new JRadioButton("3");
        j33.setFont(new Font("Arial", Font.PLAIN, 15));
        j33.setSelected(true);
        j33.setSize(25, 20);
        j33.setLocation(175, 300);
        panel.add(j33);

        JRadioButton j34 = new JRadioButton("4");
        j34.setFont(new Font("Arial", Font.PLAIN, 15));
        j34.setSelected(true);
        j34.setSize(25, 20);
        j34.setLocation(225, 300);
        panel.add(j34);

        JRadioButton j35 = new JRadioButton("5");
        j35.setFont(new Font("Arial", Font.PLAIN, 15));
        j35.setSelected(true);
        j35.setSize(25, 20);
        j35.setLocation(275, 300);
        panel.add(j35);

        ButtonGroup gengp3 = new ButtonGroup();
        gengp3.add(j31);
        gengp3.add(j32);
        gengp3.add(j33);
        gengp3.add(j34);
        gengp3.add(j35);

        JLabel p32 = new JLabel("Disagree");
        p32.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p32.setBounds(325, 280, 600, 50);
        panel.add(p32);


        JLabel l4 = new JLabel("4. You often make a backup plan for a backup plan.");
        l4.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        l4.setBounds(50, 350, 800, 50);
        panel.add(l4);

        JLabel p41 = new JLabel("Agree");
        p41.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p41.setBounds(25, 380, 600, 50);
        panel.add(p41);

        JRadioButton j41 = new JRadioButton("1");
        j41.setFont(new Font("Arial", Font.PLAIN, 15));
        j41.setSelected(true);
        j41.setSize(25, 20);
        j41.setLocation(75, 400);
        panel.add(j41);

        JRadioButton j42 = new JRadioButton("2");
        j42.setFont(new Font("Arial", Font.PLAIN, 15));
        j42.setSelected(true);
        j42.setSize(25, 20);
        j42.setLocation(125, 400);
        panel.add(j42);

        JRadioButton j43 = new JRadioButton("3");
        j43.setFont(new Font("Arial", Font.PLAIN, 15));
        j43.setSelected(true);
        j43.setSize(25, 20);
        j43.setLocation(175, 400);
        panel.add(j43);

        JRadioButton j44 = new JRadioButton("4");
        j44.setFont(new Font("Arial", Font.PLAIN, 15));
        j44.setSelected(true);
        j44.setSize(25, 20);
        j44.setLocation(225, 400);
        panel.add(j44);

        JRadioButton j45 = new JRadioButton("5");
        j45.setFont(new Font("Arial", Font.PLAIN, 15));
        j45.setSelected(true);
        j45.setSize(25, 20);
        j45.setLocation(275, 400);
        panel.add(j45);

        ButtonGroup gengp4 = new ButtonGroup();
        gengp4.add(j41);
        gengp4.add(j42);
        gengp4.add(j43);
        gengp4.add(j44);
        gengp4.add(j45);

        JLabel p42 = new JLabel("Disagree");
        p42.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p42.setBounds(325, 380, 600, 50);
        panel.add(p42);


        JLabel l5 = new JLabel("5. You are very sentimental.");
        l5.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        l5.setBounds(50, 450, 800, 50);
        panel.add(l5);

        JLabel p51 = new JLabel("Agree");
        p51.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p51.setBounds(25, 480, 600, 50);
        panel.add(p51);

        JRadioButton j51 = new JRadioButton("1");
        j51.setFont(new Font("Arial", Font.PLAIN, 15));
        j51.setSelected(true);
        j51.setSize(25, 20);
        j51.setLocation(75, 500);
        panel.add(j51);

        JRadioButton j52 = new JRadioButton("2");
        j52.setFont(new Font("Arial", Font.PLAIN, 15));
        j52.setSelected(true);
        j52.setSize(25, 20);
        j52.setLocation(125, 500);
        panel.add(j52);

        JRadioButton j53 = new JRadioButton("3");
        j53.setFont(new Font("Arial", Font.PLAIN, 15));
        j53.setSelected(true);
        j53.setSize(25, 20);
        j53.setLocation(175, 500);
        panel.add(j53);

        JRadioButton j54 = new JRadioButton("4");
        j54.setFont(new Font("Arial", Font.PLAIN, 15));
        j54.setSelected(true);
        j54.setSize(25, 20);
        j54.setLocation(225, 500);
        panel.add(j54);

        JRadioButton j55 = new JRadioButton("5");
        j55.setFont(new Font("Arial", Font.PLAIN, 15));
        j55.setSelected(true);
        j55.setSize(25, 20);
        j55.setLocation(275, 500);
        panel.add(j55);

        ButtonGroup gengp5 = new ButtonGroup();
        gengp5.add(j51);
        gengp5.add(j52);
        gengp5.add(j53);
        gengp5.add(j54);
        gengp5.add(j55);

        JLabel p52 = new JLabel("Disagree");
        p52.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p52.setBounds(325, 480, 600, 50);
        panel.add(p52);


        JLabel l6 = new JLabel("6. You are more inclined to follow your head than your heart.");
        l6.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        l6.setBounds(50, 550, 800, 50);
        panel.add(l6);

        JLabel p61 = new JLabel("Agree");
        p61.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p61.setBounds(25, 580, 600, 50);
        panel.add(p61);

        JRadioButton j61 = new JRadioButton("1");
        j61.setFont(new Font("Arial", Font.PLAIN, 15));
        j61.setSelected(true);
        j61.setSize(25, 20);
        j61.setLocation(75, 600);
        panel.add(j61);

        JRadioButton j62 = new JRadioButton("2");
        j62.setFont(new Font("Arial", Font.PLAIN, 15));
        j62.setSelected(true);
        j62.setSize(25, 20);
        j62.setLocation(125, 600);
        panel.add(j62);

        JRadioButton j63 = new JRadioButton("3");
        j63.setFont(new Font("Arial", Font.PLAIN, 15));
        j63.setSelected(true);
        j63.setSize(25, 20);
        j63.setLocation(175, 600);
        panel.add(j63);

        JRadioButton j64 = new JRadioButton("4");
        j64.setFont(new Font("Arial", Font.PLAIN, 15));
        j64.setSelected(true);
        j64.setSize(25, 20);
        j64.setLocation(225, 600);
        panel.add(j64);

        JRadioButton j65 = new JRadioButton("5");
        j65.setFont(new Font("Arial", Font.PLAIN, 15));
        j65.setSelected(true);
        j65.setSize(25, 20);
        j65.setLocation(275, 600);
        panel.add(j65);

        ButtonGroup gengp6 = new ButtonGroup();
        gengp6.add(j61);
        gengp6.add(j62);
        gengp6.add(j63);
        gengp6.add(j64);
        gengp6.add(j65);


        JLabel p62 = new JLabel("Disagree");
        p62.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        p62.setBounds(325, 580, 600, 50);
        panel.add(p62);


        JButton nextButton = new JButton("NEXT");
        nextButton.setBounds(600, 700, 150, 40);
        panel.add(nextButton);
        nextButton.setBackground(Color.pink);
        nextButton.addMouseListener(new MouseAdapter() {
            Color color = nextButton.getForeground();
            Color color2 = nextButton.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = nextButton.getForeground();
                nextButton.setBackground(Color.red);
                nextButton.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent me) {
                nextButton.setBackground(color2);
                nextButton.setForeground(color);
            }
        });


        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Moral moral = new Moral();

                String selectedRadioButtonText1 = getSelectedRadioButton(gengp).getText();
                byte n1 = Byte.valueOf(selectedRadioButtonText1);
                moral.setN1(n1);

                String selectedRadioButtonText2 = getSelectedRadioButton(gengp2).getText();
                byte n2 = Byte.valueOf(selectedRadioButtonText2);
                moral.setN2(n2);

                String selectedRadioButtonText3 = getSelectedRadioButton(gengp3).getText();
                byte n3 = Byte.valueOf(selectedRadioButtonText3);
                moral.setN3(n3);

                String selectedRadioButtonText4 = getSelectedRadioButton(gengp4).getText();
                byte n4 = Byte.valueOf(selectedRadioButtonText4);
                moral.setN4(n4);

                String selectedRadioButtonText5 = getSelectedRadioButton(gengp5).getText();
                byte n5 = Byte.valueOf(selectedRadioButtonText5);
                moral.setN5(n5);

                String selectedRadioButtonText6 = getSelectedRadioButton(gengp6).getText();
                byte n6 = Byte.valueOf(selectedRadioButtonText6);
                moral.setN6(n6);
                person.setMoral(moral);
                /*db.addPersonToDatabase(person);*/
                InterestView view1 = new InterestView(person);
                view1.frame.setVisible(true);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(50, 700, 150, 40);
        panel.add(backButton);
        backButton.setBackground(Color.pink);
        backButton.addMouseListener(new MouseAdapter() {
            Color color = backButton.getForeground();
            Color color2 = backButton.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = backButton.getForeground();
                backButton.setBackground(Color.red);
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
                RegisterView view = new RegisterView();
                view.frame.setVisible(true);
            }
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}
