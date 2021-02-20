package dmytro.kudriavtsev.footballmanager.controllers;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerAddToTeamDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Statement;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statement/api")
public class StatementController {
    @Autowired
    private StatementService statementService;

    @GetMapping
    public ResponseEntity<List<Statement>> getStatements() {
        List<Statement> statements = statementService.getStatements();
        return new ResponseEntity<>(statements, HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<List<Footballer>> getStatementsByTeamId(@PathVariable("teamId") int teamId) {
        List<Footballer> players = statementService.getPlayers(teamId);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/players/without-team")
    public ResponseEntity<List<Footballer>> getPlayersWithoutTeam() {
        List<Footballer> playersWithoutTeam = statementService.getPlayersWithoutTeam();
        return new ResponseEntity<>(playersWithoutTeam, HttpStatus.OK);
    }

    @PutMapping("/players/add")
    public void addFootballer(@RequestBody FootballerAddToTeamDto footballerAddToTeamDto) {
        statementService.addFootballer(footballerAddToTeamDto);
    }

    @GetMapping("/players/other/{id}")
    public ResponseEntity<List<Statement>> getOtherPlayers(@PathVariable("id") int teamId) {
        List<Statement> statements = statementService.getOtherPlayers(teamId);
        return new ResponseEntity<>(statements, HttpStatus.OK);
    }
}
