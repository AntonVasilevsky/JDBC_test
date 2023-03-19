public class Guest {
    private int id;
    private String name;
    private String city;
    private int gender;
    private int age;

    public Guest(int id, String name, String city, int gender, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.age = age;
    }
    public Guest(String name, String city, int gender, int age) {

        this.name = name;
        this.city = city;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
