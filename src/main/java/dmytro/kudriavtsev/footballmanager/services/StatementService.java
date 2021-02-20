package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerAddToTeamDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Statement;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatementService {
    private final StatementRepository statementRepository;

    @Autowired
    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
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

    public void addFootballer(FootballerAddToTeamDto footballerAddToTeamDto) {
        Statement statement = statementRepository.findByFootballerId(footballerAddToTeamDto.getFootballer().getId());
        statement.setTeam(footballerAddToTeamDto.getTeam());

        statementRepository.save(statement);
    }

    public List<Statement> getOtherPlayers() {
        return statementRepository.findAllOtherPlayers();
    }
}
