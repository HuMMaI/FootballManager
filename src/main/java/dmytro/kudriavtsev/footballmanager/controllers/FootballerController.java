package dmytro.kudriavtsev.footballmanager.controllers;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.services.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballer/api")
public class FootballerController {
    @Autowired
    private FootballerService footballerService;

    @GetMapping
    public ResponseEntity<List<Footballer>> getPlayers() {
        List<Footballer> teams = footballerService.getPlayers();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Footballer> addNewTeam(@RequestBody FootballerDto footballerDto) {
        Footballer newFootballer = footballerService.addNewFootballer(footballerDto);
        return new ResponseEntity<>(newFootballer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Footballer> updateTeam(@RequestBody Footballer footballer) {
        Footballer updateFootballer = footballerService.updateFootballer(footballer);
        return new ResponseEntity<>(updateFootballer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable("id") int id) {
        footballerService.deleteFootballer(id);
    }

    @GetMapping("/{id}")
    public Footballer getTeam(@PathVariable("id") int id) {
        return footballerService.findFootballerById(id);
    }
}
