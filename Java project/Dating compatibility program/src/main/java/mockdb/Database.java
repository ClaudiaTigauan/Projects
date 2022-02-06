package mockdb;

import person.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final List<Person> personList;

    private static Database instance;


    private Database() {
        this.personList = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Person addPersonToDatabase(Person person) {
        if (person.getId() == null) {
            Long maxId = personList.stream()
                    .map(Person::getId)
                    .max(Long::compareTo)
                    .orElse(0L);

            person.setId(maxId + 1);
            //person.getId().intValue(),
            personList.add(person);

            System.out.println(person.toString());
        } else {
            Person existingPerson = personList.stream()
                    .filter(person1 -> person1.getId().equals(person.getId()))
                    .findFirst().orElse(null);
            if (existingPerson != null) {
                personList.remove(person);
                personList.add(person);
            }
           // System.out.println(person.toString());
        }

       // person.getId().intValue(),
        return person;
    }

    public Person getPersonById(long id) {
        return personList.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public List<Person> getPersonList() {
        return personList;
    }
}
