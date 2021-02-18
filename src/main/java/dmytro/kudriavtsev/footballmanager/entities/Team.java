package dmytro.kudriavtsev.footballmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(name = "number_of_players")
    private int numberOfPlayers;

    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private List<Footballer> players;

    public Team() {
    }

    public Team(String name, int numberOfPlayers, String country, List<Footballer> players) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.country = country;
        this.players = players;
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

    public List<Footballer> getPlayers() {
        return players;
    }

    public void setPlayers(List<Footballer> players) {
        this.players = players;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
