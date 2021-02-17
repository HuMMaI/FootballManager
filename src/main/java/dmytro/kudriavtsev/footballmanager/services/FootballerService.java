package dmytro.kudriavtsev.footballmanager.services;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.repos.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;

    @Autowired
    public FootballerService(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    public List<Footballer> getPlayers() {
        return footballerRepository.findAll();
    }

    public Footballer addNewFootballer(Footballer footballer) {
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
