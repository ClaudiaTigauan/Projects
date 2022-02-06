package InterfacePackage;

import mockdb.Database;
import person.Interest;
import person.Moral;
import person.Person;
import service.CompatibilityCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterestView {

    private Database db = Database.getInstance();
    public JFrame frame;
    private Person person;
    private String musicc[]
            = {"rock", "jazz", "classical music", "pop",
            "hip hop", "electric", "reggae", "popular music"
    };
    private String movies[]
            = {"action", "comedies", "romantic", "adventure",
            "musical", "horror", "SF", "dramas"
    };

    private String hobbies[]
            = {"cycling", "camping", "running", "dancing",
            "baking", "chess", "gaming", "volunteering"
    };


    private String genders[]
            = {"male", "female", "neutral"
    };


    public InterestView(Person person) {
        this.person = person;
        frame = new JFrame("DATING COMPATIBILITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Image image = new ImageIcon("src/main/resources/hearts.jpg").getImage();
        JPanel panel = new BackgroundPanel(image);

        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 178));

        JLabel l1 = new JLabel("MOVIES");
        l1.setFont(new Font(l1.getFont().getFontName(), Font.PLAIN, 20));
        l1.setBounds(100, 50, 600, 50);
        panel.add(l1);

        JComboBox movie = new JComboBox(movies);
        movie.setFont(new Font("Arial", Font.PLAIN, 20));
        movie.setSize(100, 25);
        movie.setLocation(200, 65);
        panel.add(movie);

        JLabel l2 = new JLabel("MUSIC");
        l2.setFont(new Font(l1.getFont().getFontName(), Font.PLAIN, 20));
        l2.setBounds(100, 100, 600, 50);
        panel.add(l2);

        JComboBox music = new JComboBox(musicc);
        music.setFont(new Font("Arial", Font.PLAIN, 20));
        music.setSize(100, 25);
        music.setLocation(200, 115);
        panel.add(music);

        JLabel l3 = new JLabel("HOBBY");
        l3.setFont(new Font(l1.getFont().getFontName(), Font.PLAIN, 20));
        l3.setBounds(100, 150, 600, 50);
        panel.add(l3);

        JComboBox hobby = new JComboBox(hobbies);
        hobby.setFont(new Font("Arial", Font.PLAIN, 20));
        hobby.setSize(100, 25);
        hobby.setLocation(200, 165);
        panel.add(hobby);

        JLabel l4 = new JLabel("GENDER");
        l4.setFont(new Font(l1.getFont().getFontName(), Font.PLAIN, 20));
        l4.setBounds(100, 200, 600, 50);
        panel.add(l4);

        JComboBox gender = new JComboBox(genders);
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 25);
        gender.setLocation(200, 215);
        panel.add(gender);

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


                Moral moral = new Moral();
                person.setMoral(moral);
                MoralView view = new MoralView(person);
                view.frame.setVisible(true);
            }
        });


        JButton nextButton = new JButton("NEXT");
        nextButton.setBounds(600, 400, 150, 40);
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
                Interest interest = new Interest();

                interest.setGender(gender.getSelectedItem().toString());
                interest.setHobby(hobby.getSelectedItem().toString());
                interest.setMovie(movie.getSelectedItem().toString());
                interest.setMusic(music.getSelectedItem().toString());
                person.setInterest(interest);
                /*db.addPersonToDatabase(person);*/
                List<Person> personListFromDb = db.getPersonList();

                Map<Person, Integer> compatibilityMap = new HashMap<>(personListFromDb.size());
                for (Person personFromDb : personListFromDb) {
                    compatibilityMap.put(personFromDb, CompatibilityCalculator.comparePersons(person, personFromDb));
                }

                Map.Entry<Person, Integer> personIntegerEntry = compatibilityMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(null);
                Person matchedPerson=null;
                if (personIntegerEntry != null) {
                    matchedPerson = personIntegerEntry.getKey();
                }

                FinishView view = new FinishView(matchedPerson);
                view.frame.setVisible(true);
            }
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }


}
