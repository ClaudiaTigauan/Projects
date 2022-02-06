package InterfacePackage;

import mockdb.Database;
import person.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;

public class RegisterView {

    private Database db = Database.getInstance();
    public JFrame frame;
    private String dates[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};
    private String months[]
            = {"1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12"};
    private String years[]
            = {"1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021"};

    public RegisterView() {
        frame = new JFrame("DATING COMPATIBILITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Image image = new ImageIcon("src/main/resources/hearts.jpg").getImage();
        JPanel panel = new BackgroundPanel(image);

        ImageIcon icon = new ImageIcon("src/main/resources/love.png");
        Image image1 = icon.getImage();
        Image newImage = image1.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        JLabel label = new JLabel(icon);
        label.setBounds(450, 50, 250, 250);
        panel.add(label);

        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 178));

        JLabel lname = new JLabel("NAME");
        lname.setFont(new Font(lname.getFont().getFontName(), Font.PLAIN, 15));
        lname.setBounds(50, 40, 600, 50);
        panel.add(lname);

        JTextField tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(150, 20);
        tname.setLocation(150, 50);
        panel.add(tname);

        JLabel lpassword = new JLabel("PASSWORD");
        lpassword.setFont(new Font(lpassword.getFont().getFontName(), Font.PLAIN, 15));
        lpassword.setBounds(50, 90, 600, 50);
        panel.add(lpassword);

        JTextField tpassword = new JTextField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(150, 20);
        tpassword.setLocation(150, 100);
        panel.add(tpassword);

        JLabel lgender = new JLabel("GENDER");
        lgender.setFont(new Font(lgender.getFont().getFontName(), Font.PLAIN, 15));
        lgender.setBounds(50, 140, 600, 50);
        panel.add(lgender);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(150, 150);
        panel.add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(225, 150);
        panel.add(female);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        JLabel ldate = new JLabel("DATE");
        ldate.setFont(new Font(ldate.getFont().getFontName(), Font.PLAIN, 15));
        ldate.setSize(80, 20);
        ldate.setLocation(50, 200);
        panel.add(ldate);

        JComboBox date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(150, 200);
        panel.add(date);

        JComboBox month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(205, 200);
        panel.add(month);

        JComboBox year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(270, 200);
        panel.add(year);

        JLabel lheight = new JLabel("HEIGHT");
        lheight.setFont(new Font(lheight.getFont().getFontName(), Font.PLAIN, 15));
        lheight.setSize(80, 20);
        lheight.setLocation(50, 250);
        panel.add(lheight);

        JTextField theight = new JTextField();
        theight.setFont(new Font("Arial", Font.PLAIN, 15));
        theight.setSize(150, 20);
        theight.setLocation(150, 250);
        panel.add(theight);

        JLabel llocation = new JLabel("LOCATION");
        llocation.setFont(new Font(lheight.getFont().getFontName(), Font.PLAIN, 15));
        llocation.setSize(80, 20);
        llocation.setLocation(50, 300);
        panel.add(llocation);

        JTextField tlocation = new JTextField();
        tlocation.setFont(new Font("Arial", Font.PLAIN, 15));
        tlocation.setSize(150, 20);
        tlocation.setLocation(150, 300);
        panel.add(tlocation);


        JButton nextButton = new JButton("NEXT");
        nextButton.setBounds(600, 400, 150, 40);
        panel.add(nextButton);
        nextButton.setBackground(Color.pink);
        nextButton.addMouseListener(new MouseAdapter() {
            Color color = nextButton.getForeground();
            Color color2 = nextButton.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = nextButton.getForeground();
                nextButton.setBackground(Color.red); // change the color to green when mouse over a button
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
                Person person = new Person();
                person.setHeight(Float.parseFloat(theight.getText()));
                person.setName(tname.getText());
                person.setLocation(tlocation.getText());
                if(female.isSelected())
                    person.setGender("female");
                if(male.isSelected())
                    person.setGender("male");

                person.setPass(tpassword.getText());
                int d=Integer.parseInt(date.getSelectedItem().toString());
                int m=Integer.parseInt(month.getSelectedItem().toString());
                int y=Integer.parseInt(year.getSelectedItem().toString());

                LocalDate l1 = LocalDate.of(y,m, d);
                LocalDate now1 = LocalDate.now();
                Period diff1 = Period.between(l1, now1);
                int age = diff1.getYears();

                person.setAge(age);
                /*Person addedPerson = db.addPersonToDatabase(person);*/
                frame.setVisible(false);
                MoralView view1 = new MoralView(person);
                view1.frame.setVisible(true);

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
