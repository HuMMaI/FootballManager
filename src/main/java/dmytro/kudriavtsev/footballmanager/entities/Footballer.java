package dmytro.kudriavtsev.footballmanager.entities;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int age;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "team_id")
//    private Team team;

    private int experience;

    private int price;

    public Footballer() {
    }

//    public Footballer(String firstName, String lastName, int age, Team team, int experience, int price) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.team = team;
//        this.experience = experience;
//        this.price = price;
//    }


    public Footballer(String firstName, String lastName, int age, int experience, int price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.experience = experience;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
