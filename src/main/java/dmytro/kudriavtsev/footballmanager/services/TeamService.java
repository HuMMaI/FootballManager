package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.dtos.TeamAddDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Statement;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.FootballerRepository;
import dmytro.kudriavtsev.footballmanager.repos.StatementRepository;
import dmytro.kudriavtsev.footballmanager.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final StatementRepository statementRepository;
    private final FootballerRepository footballerRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, StatementRepository statementRepository, FootballerRepository footballerRepository) {
        this.teamRepository = teamRepository;
        this.statementRepository = statementRepository;
        this.footballerRepository = footballerRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team addNewTeam(TeamAddDto teamAddDto) {
        Team team = new Team();

        team.setName(teamAddDto.getName());
        team.setCountry(teamAddDto.getCountry());
        team.setNumberOfPlayers(teamAddDto.getNumberOfPlayers());
        team.setBudget(teamAddDto.getBudget());
        team.setCommission(teamAddDto.getCommission());

        return teamRepository.save(team);
    }

    public Team findTeamById(int id) {
        return teamRepository.findById(id).get();
    }

    public Team updateTeam(Team team) {
        List<Statement> statements = statementRepository.findAllByTeamId(team.getId());

        List<Footballer> players = statements.stream().map(Statement::getFootballer).collect(Collectors.toList());

        Iterator<Footballer> iterator = players.iterator();
        while (iterator.hasNext()) {
            Footballer next = iterator.next();

            int price = next.getExperience() * 100000 / next.getAge();
            int commission = team.getCommission() * price / 100;
            int fullPrice = price + commission;

            next.setPrice(fullPrice);
        }

        footballerRepository.saveAll(players);

        return teamRepository.save(team);
    }

    public void deleteTeam(int id) {
        List<Statement> allByTeamId = statementRepository.findAllByTeamId(id);

        if (!allByTeamId.isEmpty()) {
            for (Statement statement : allByTeamId) {
                statement.setTeam(null);
            }

            List<Footballer> players = allByTeamId.stream().map(Statement::getFootballer).collect(Collectors.toList());
            players.stream().forEach(footballer -> {
                int price = footballer.getExperience() * 100000 / footballer.getAge();
                footballer.setPrice(price);
            });

            footballerRepository.saveAll(players);
            statementRepository.saveAll(allByTeamId);
        }

        teamRepository.deleteById(id);
    }


}
