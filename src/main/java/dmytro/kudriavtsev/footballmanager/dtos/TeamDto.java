package dmytro.kudriavtsev.footballmanager.dtos;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;

import java.util.List;

public class TeamDto {
    private int id;
    private String name;
    private int numberOfPlayers;
//    private List<Footballer> players;
    private String country;

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

//    public List<Footballer> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(List<Footballer> players) {
//        this.players = players;
//    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
