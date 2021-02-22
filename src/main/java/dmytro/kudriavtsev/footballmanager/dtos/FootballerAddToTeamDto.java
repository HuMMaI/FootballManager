package dmytro.kudriavtsev.footballmanager.dtos;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Team;

import javax.validation.constraints.NotNull;

public class FootballerAddToTeamDto {
    @NotNull
    private Footballer footballer;

    @NotNull
    private Team team;

    public Footballer getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballer footballer) {
        this.footballer = footballer;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
