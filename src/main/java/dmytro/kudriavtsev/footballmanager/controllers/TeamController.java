package dmytro.kudriavtsev.footballmanager.controllers;

import dmytro.kudriavtsev.footballmanager.dtos.TeamAddDto;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/team/api")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> teams = teamService.getTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Team> addNewTeam(@Valid @RequestBody TeamAddDto teamAddDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Team newTeam = teamService.addNewTeam(teamAddDto);
        return new ResponseEntity<>(newTeam, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Team> updateTeam(@Valid @RequestBody Team team) {
        Team updateTeam = teamService.updateTeam(team);
        return new ResponseEntity<>(updateTeam, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable("id") int id) {
        teamService.deleteTeam(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable("id") int id) {
        Team teamById = teamService.findTeamById(id);
        return new ResponseEntity<>(teamById, HttpStatus.OK);
    }
}
