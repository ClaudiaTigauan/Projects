package service;

import mockdb.Database;
import person.Interest;
import person.Moral;
import person.Person;

import java.io.*;

public class CompatibilityCalculator {

    private Database db = Database.getInstance();
//    Person person = new Person();
//    Moral moral = new Moral();
//    Interest interest = new Interest();
 //   File file = new File("persons.txt");


    public static int comparePersons(Person fromUI, Person fromMemory) {
        int compatibility = 0;
       // System.out.println(fromMemory.toString());
       // System.out.println(fromUI.toString());
        if(fromUI.getInterest().getGender().equals(fromMemory.getGender())) {

            if (fromUI.getMoral().getN1() == fromMemory.getMoral().getN1()) {
                compatibility++;
            }
            if (fromUI.getMoral().getN2() == fromMemory.getMoral().getN2()) {
                compatibility++;
            }
            if (fromUI.getMoral().getN3() == fromMemory.getMoral().getN3()) {
                compatibility++;
            }
            if (fromUI.getMoral().getN4() == fromMemory.getMoral().getN4()) {
                compatibility++;
            }
            if (fromUI.getMoral().getN5() == fromMemory.getMoral().getN5()) {
                compatibility++;
            }
            if (fromUI.getMoral().getN6() == fromMemory.getMoral().getN6()) {
                compatibility++;
            }

            if (fromUI.getInterest().getHobby().equals(fromMemory.getInterest().getHobby())) {
                compatibility++;
            }
            if (fromUI.getInterest().getMovie().equals(fromMemory.getInterest().getMovie())) {
                compatibility++;
            }
            if (fromUI.getInterest().getMusic().equals(fromMemory.getInterest().getMusic())) {
                compatibility++;
            }
            compatibility++;
        }
        return compatibility;
    }


}


