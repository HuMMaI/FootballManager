package dmytro.kudriavtsev.footballmanager.controllers;

import dmytro.kudriavtsev.footballmanager.dtos.TeamDto;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Team> addNewTeam(@RequestBody Team team) {
        Team newTeam = teamService.addNewTeam(team);
        return new ResponseEntity<>(newTeam, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        Team updateTeam = teamService.updateTeam(team);
        return new ResponseEntity<>(updateTeam, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable("id") int id) {
        teamService.deleteTeam(id);
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable("id") int id) {
        return teamService.findTeamById(id);
    }
}
