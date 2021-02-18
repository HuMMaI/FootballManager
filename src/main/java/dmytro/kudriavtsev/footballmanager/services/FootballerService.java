package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.FootballerRepository;
import dmytro.kudriavtsev.footballmanager.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public FootballerService(FootballerRepository footballerRepository, TeamRepository teamRepository) {
        this.footballerRepository = footballerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Footballer> getPlayers() {
        return footballerRepository.findAll();
    }

    public Footballer addNewFootballer(FootballerDto footballerDto) {
        Team team = teamRepository.findById(footballerDto.getTeam()).get();

        Footballer footballer = new Footballer();

        footballer.setFirstName(footballerDto.getFirstName());
        footballer.setLastName(footballerDto.getLastName());
        footballer.setAge(footballerDto.getAge());
        footballer.setExperience(footballerDto.getExperience());
        footballer.setTeam(team);
        footballer.setPrice(footballerDto.getPrice());

        return footballerRepository.save(footballer);
    }

    public Footballer updateFootballer(Footballer footballer) {
        return footballerRepository.save(footballer);
    }

    public void deleteFootballer(int id) {
        footballerRepository.deleteById(id);
    }

    public Footballer findFootballerById(int id) {
        return footballerRepository.findById(id).get();
    }
}
