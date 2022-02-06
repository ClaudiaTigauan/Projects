package service;

import mockdb.Database;
import person.Interest;
import person.Moral;
import person.Person;

import java.io.*;
import java.util.Scanner;

public class ReadService {
    private static final Database db = Database.getInstance();

    public static void readPersonFromFile() {
        File file = new File("C:/Users/ctiga/OneDrive/Desktop/isp/30123_2_tigauan_claudia_isp_labs/Proiect/src/main/resources/persons.txt");
        String s;

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                for (int j = 0; j < 4; j++) {
                    Person person = new Person();
                    Moral moral = new Moral();
                    Interest interest = new Interest();
                    for (int i = 0; i < 3; i++) {
                        s = myReader.nextLine();
                        String[] strings = s.split(",");
                        if (i == 0) {
                            person.setName(strings[0]);
                            person.setPass(strings[1]);
                            person.setAge(Integer.parseInt(strings[2]));
                            person.setGender(strings[3]);
                            person.setHeight(Float.parseFloat(strings[4]));
                            person.setLocation(strings[5]);
                        } else if (i == 1) {
                            moral.setN1(Byte.parseByte(strings[0]));
                            moral.setN2(Byte.parseByte(strings[1]));
                            moral.setN3(Byte.parseByte(strings[2]));
                            moral.setN4(Byte.parseByte(strings[3]));
                            moral.setN5(Byte.parseByte(strings[4]));
                            moral.setN6(Byte.parseByte(strings[5]));
                            person.setMoral(moral);
                        } else {
                            interest.setMovie(strings[0]);
                            interest.setMusic(strings[1]);
                            interest.setHobby(strings[2]);
                            interest.setGender(strings[3]);
                            person.setInterest(interest);
                            db.addPersonToDatabase(person);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
