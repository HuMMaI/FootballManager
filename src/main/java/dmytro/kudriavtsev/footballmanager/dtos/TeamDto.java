package dmytro.kudriavtsev.footballmanager.dtos;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;

import java.util.List;

public class TeamDto {
    private String name;
    private int numberOfPlayers;
    private List<Footballer> players;

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
