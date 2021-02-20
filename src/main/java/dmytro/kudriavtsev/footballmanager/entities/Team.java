package dmytro.kudriavtsev.footballmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
//@NamedEntityGraph(name = "TeamInfo.detail", attributeNodes = @NamedAttributeNode("players"))
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(name = "number_of_players")
    private int numberOfPlayers;

    private String country;

//    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
//    private Set<Footballer> players;

    public Team() {
    }

//    public Team(String name, int numberOfPlayers, String country, Set<Footballer> players) {
//        this.name = name;
//        this.numberOfPlayers = numberOfPlayers;
//        this.country = country;
//        this.players = players;
//    }


    public Team(String name, int numberOfPlayers, String country) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.country = country;
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

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

//    public Set<Footballer> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(Set<Footballer> players) {
//        this.players = players;
//    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
