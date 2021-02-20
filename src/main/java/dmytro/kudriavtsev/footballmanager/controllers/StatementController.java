package dmytro.kudriavtsev.footballmanager.controllers;

import dmytro.kudriavtsev.footballmanager.entities.Statement;
import dmytro.kudriavtsev.footballmanager.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
