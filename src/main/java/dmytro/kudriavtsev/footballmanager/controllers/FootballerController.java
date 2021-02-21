package dmytro.kudriavtsev.footballmanager.controllers;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerAddDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.services.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/footballer/api")
public class FootballerController {
    @Autowired
    private FootballerService footballerService;

    @GetMapping
    public ResponseEntity<List<Footballer>> getPlayers() {
        List<Footballer> players = footballerService.getPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Footballer> addNewFootballer(@Valid @RequestBody FootballerAddDto footballerAddDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Footballer newFootballer = footballerService.addNewFootballer(footballerAddDto);
        return new ResponseEntity<>(newFootballer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Footballer> updateFootballer(@Valid @RequestBody Footballer footballer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Footballer updateFootballer = footballerService.updateFootballer(footballer);
        return new ResponseEntity<>(updateFootballer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFootballer(@PathVariable("id") int id) {
        footballerService.deleteFootballer(id);
    }

    @GetMapping("/{id}")
    public Footballer getFootballer(@PathVariable("id") int id) {
        return footballerService.findFootballerById(id);
    }
}
