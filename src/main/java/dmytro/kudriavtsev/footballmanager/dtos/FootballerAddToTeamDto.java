package dmytro.kudriavtsev.footballmanager.dtos;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Team;

public class FootballerAddToTeamDto {
    private Footballer footballer;
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
