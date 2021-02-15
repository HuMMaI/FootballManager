package dmytro.kudriavtsev.footballmanager.entities;

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

    @OneToMany(mappedBy = "team")
    private List<Footballer> players;

    public Team(String name, int numberOfPlayers, List<Footballer> players) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
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
}
