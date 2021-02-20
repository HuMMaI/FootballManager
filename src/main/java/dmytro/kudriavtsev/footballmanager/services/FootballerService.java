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
//        List<FootballerGetDto> players = footballerRepository.getAllPlayers();
//        return players;
        return footballerRepository.findAll();
    }

    public Footballer addNewFootballer(FootballerAddDto footballerAddDto) {
        Optional<Team> teamMaybe = teamRepository.findById(footballerAddDto.getTeam());

        Footballer footballer = new Footballer();

        footballer.setFirstName(footballerAddDto.getFirstName());
        footballer.setLastName(footballerAddDto.getLastName());
        footballer.setAge(footballerAddDto.getAge());
        footballer.setExperience(footballerAddDto.getExperience());
        footballer.setPrice(footballerAddDto.getPrice());

        Footballer newFootballer = footballerRepository.save(footballer);

        Statement statement = new Statement();

        statement.setFootballer(newFootballer);

        if (teamMaybe.isPresent()) {
            statement.setTeam(teamMaybe.get());
        } else {
            statement.setTeam(null);
        }

        statementRepository.save(statement);

        return newFootballer;
    }

    public Footballer updateFootballer(Footballer footballer) {
        return footballerRepository.save(footballer);
    }

    public void deleteFootballer(int id) {
        statementRepository.deleteByFootballerId(id);
        footballerRepository.deleteById(id);
    }

    public Footballer findFootballerById(int id) {
        return footballerRepository.findById(id).get();
    }
}
