package dmytro.kudriavtsev.footballmanager.controllers;

import dmytro.kudriavtsev.footballmanager.dtos.TeamDto;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team/api")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping("/add")
    public void addNewTeam(@ModelAttribute Team team) {
        teamService.addNewTeam(team);
    }

    @PutMapping("/update/{id}")
    public void updateTeam(@ModelAttribute TeamDto teamDto, @PathVariable("id") int id) {
        teamService.updateTeam(teamDto, id);
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
