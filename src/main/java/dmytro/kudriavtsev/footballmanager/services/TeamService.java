package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.dtos.TeamDto;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public void addNewTeam(Team team) {
        teamRepository.save(team);
    }

    public Team findTeamById(int id) {
        return teamRepository.findById(id).get();
    }

    public void updateTeam(TeamDto teamDto, int id) {
        Team team = findTeamById(id);

        team.setName(teamDto.getName());
        team.setNumberOfPlayers(teamDto.getNumberOfPlayers());
        team.setPlayers(teamDto.getPlayers());

        teamRepository.save(team);
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}
