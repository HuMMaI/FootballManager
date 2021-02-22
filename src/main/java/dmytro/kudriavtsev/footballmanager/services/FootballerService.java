package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerAddDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Statement;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.FootballerRepository;
import dmytro.kudriavtsev.footballmanager.repos.StatementRepository;
import dmytro.kudriavtsev.footballmanager.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final TeamRepository teamRepository;
    private final StatementRepository statementRepository;

    @Autowired
    public FootballerService(FootballerRepository footballerRepository, TeamRepository teamRepository, StatementRepository statementRepository) {
        this.footballerRepository = footballerRepository;
        this.teamRepository = teamRepository;
        this.statementRepository = statementRepository;
    }

    public List<Footballer> getPlayers() {
        return footballerRepository.findAll();
    }

    public Footballer addNewFootballer(FootballerAddDto footballerAddDto) {
        Optional<Team> teamMaybe = teamRepository.findById(footballerAddDto.getTeam());

        Footballer footballer = new Footballer();

        footballer.setFirstName(footballerAddDto.getFirstName());
        footballer.setLastName(footballerAddDto.getLastName());
        footballer.setAge(footballerAddDto.getAge());
        footballer.setExperience(footballerAddDto.getExperience());

        int price = footballer.getExperience() * 100000 / footballer.getAge();

        Statement statement = new Statement();

        if (teamMaybe.isPresent()) {
            Team team = teamMaybe.get();
            int commission = team.getCommission() * price / 100;
            int fullPrice = price + commission;
            footballer.setPrice(fullPrice);
            int numberOfPlayers = team.getNumberOfPlayers();
            team.setNumberOfPlayers(++numberOfPlayers);
            teamRepository.save(team);
            statement.setTeam(team);
        } else {
            footballer.setPrice(price);
            statement.setTeam(null);
        }

        Footballer newFootballer = footballerRepository.save(footballer);

        statement.setFootballer(newFootballer);

        statementRepository.save(statement);

        return newFootballer;
    }

    public Footballer updateFootballer(Footballer footballer) {
        Footballer oldFootballer = footballerRepository.findById(footballer.getId()).get();
        Statement statement = statementRepository.findByFootballerId(footballer.getId());

        if (oldFootballer.getAge() != footballer.getAge() || oldFootballer.getExperience() != footballer.getExperience()) {
            int price = footballer.getExperience() * 100000 / footballer.getAge();

            Team team = statement.getTeam();
            if (team != null) {
                int commission = team.getCommission() * price / 100;
                int fullPrice = price + commission;
                footballer.setPrice(fullPrice);
            } else {
                footballer.setPrice(price);
            }
        }

        return footballerRepository.save(footballer);
    }

    public void deleteFootballer(int id) {
        Statement statement = statementRepository.findByFootballerId(id);

        if (statement.getTeam() != null) {
            Team team = statement.getTeam();
            int numberOfPlayers = team.getNumberOfPlayers();
            team.setNumberOfPlayers(--numberOfPlayers);
            teamRepository.save(team);
        }

        statementRepository.deleteByFootballerId(id);
        footballerRepository.deleteById(id);
    }

    public Footballer findFootballerById(int id) {
        return footballerRepository.findById(id).get();
    }
}
