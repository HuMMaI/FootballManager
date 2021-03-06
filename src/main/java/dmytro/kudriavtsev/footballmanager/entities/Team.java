package dmytro.kudriavtsev.footballmanager.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @Column(name = "number_of_players")
    @NotNull
    @Min(0)
    private int numberOfPlayers;

    @NotNull
    private String country;

    @NotNull
    @Min(0)
    @Max(10)
    private int commission;

    @NotNull
    @Min(0)
    private int budget;

    public Team() {
    }

    public Team(String name, int numberOfPlayers, String country, int commission, int budget) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.country = country;
        this.commission = commission;
        this.budget = budget;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
