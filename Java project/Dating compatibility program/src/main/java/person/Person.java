package person;

public class Person {

    private Long id;
    private String name;
    private int age;
    private String gender;
    private float height;
    private String location;
    private Moral moral;
    private Interest interest;
    private ZodiacSigns zodiacSigns;
    private String pass;

    public Person(Long id) {
        this.id = id;
    }

    public Person() {

    }

    public Person(String name, int age, String gender, float height, String location, String pass) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.name = name;
        this.location = location;
        this.pass=pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Moral getMoral() {
        return moral;
    }

    public void setMoral(Moral moral) {
        this.moral = moral;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public ZodiacSigns getZodiacSigns() {
        return zodiacSigns;
    }

    public void setZodiacSigns(ZodiacSigns zodiacSigns) {
        this.zodiacSigns = zodiacSigns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", location='" + location + '\'' +
                '}';
    }
}