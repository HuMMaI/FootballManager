package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerAddToTeamDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Statement;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.StatementRepository;
import dmytro.kudriavtsev.footballmanager.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatementService {
    private final StatementRepository statementRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public StatementService(StatementRepository statementRepository, TeamRepository teamRepository) {
        this.statementRepository = statementRepository;
        this.teamRepository = teamRepository;
    }

    public List<Statement> getStatements() {
        return statementRepository.findAll();
    }

    public List<Footballer> getPlayers(int teamId) {
        List<Statement> statements = statementRepository.findAllByTeamId(teamId);
        List<Footballer> players = statements.stream().map(Statement::getFootballer).collect(Collectors.toList());
        return players;
    }

    public List<Footballer> getPlayersWithoutTeam() {
        List<Statement> statements = statementRepository.findAllWithoutTeam();
        List<Footballer> players = statements.stream().map(Statement::getFootballer).collect(Collectors.toList());
        return players;
    }

    public boolean addFootballer(FootballerAddToTeamDto footballerAddToTeamDto) {
        Statement statement = statementRepository.findByFootballerId(footballerAddToTeamDto.getFootballer().getId());

        Team team = footballerAddToTeamDto.getTeam();
        team.setBudget(team.getBudget() - footballerAddToTeamDto.getFootballer().getPrice());

        if (team.getBudget() < 0) {
            return false;
        }

        int numberOfPlayers = team.getNumberOfPlayers();
        team.setNumberOfPlayers(++numberOfPlayers);
        teamRepository.save(team);

        if (statement.getTeam() != null) {
            Team oldTeam = statement.getTeam();
            oldTeam.setBudget(oldTeam.getBudget() + footballerAddToTeamDto.getFootballer().getPrice());
            int oldTeamNumberOfPlayers = oldTeam.getNumberOfPlayers();
            oldTeam.setNumberOfPlayers(--oldTeamNumberOfPlayers);
            teamRepository.save(oldTeam);
        }

        statement.setTeam(footballerAddToTeamDto.getTeam());

        statementRepository.save(statement);

        return true;
    }

    public List<Statement> getOtherPlayers(int teamId) {
        return statementRepository.findAllOtherPlayers(teamId);
    }
}
