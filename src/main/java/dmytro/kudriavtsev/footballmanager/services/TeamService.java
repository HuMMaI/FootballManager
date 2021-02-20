package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.StatementRepository;
import dmytro.kudriavtsev.footballmanager.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final StatementRepository statementRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, StatementRepository statementRepository) {
        this.teamRepository = teamRepository;
        this.statementRepository = statementRepository;
    }


    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team addNewTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team findTeamById(int id) {
        return teamRepository.findById(id).get();
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(int id) {
        int allByTeamId = statementRepository.countByTeamId(id);

        if (allByTeamId != 0) {
            statementRepository.deleteByTeamId(id);
        }

        teamRepository.deleteById(id);
    }


}
