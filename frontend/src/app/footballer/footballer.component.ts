import { Component, OnInit } from '@angular/core';
import {Footballer} from '../footballer';
import {FootballerService} from '../footballer.service';
import {HttpErrorResponse} from '@angular/common/http';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {TeamService} from '../team.service';
import {Team} from '../team';
import {StatementService} from '../statement.service';
import {Statement} from '../statement';

@Component({
  selector: 'app-footballer',
  templateUrl: './footballer.component.html',
  styleUrls: ['./footballer.component.css']
})
export class FootballerComponent implements OnInit {
  public players: Footballer[];
  public editFootballer: Footballer;
  public deleteFootballer: Footballer;
  public currentFootballer: Footballer;
  public teams: Team[];
  public statements: Statement[];

  footballerForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    age: new FormControl('', [Validators.required, Validators.min(1), Validators.max(100)]),
    experience: new FormControl('', [Validators.required, Validators.min(0)])
  });

  constructor(private footballerService: FootballerService, private teamService: TeamService, private statementService: StatementService) { }

  ngOnInit(): void {
    this.getPlayers();
  }

  public getTeams(): void {
    this.teamService.getTeams().subscribe(
      (response: Team[]) => {
        this.teams = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getPlayers(): void {
    this.statementService.getStatements().subscribe(
      (response: Statement[]) => {
        this.statements = response;
        console.log(this.statements);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddFootballer(addForm: FormGroupDirective): void {
    console.log(addForm.value);

    this.footballerService.addFootballer(addForm.value).subscribe(
      (response: Footballer) => {
        console.log(response);
        this.getPlayers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateFootballer(footballer: Footballer): void {
    this.footballerService.updateFootballer(footballer).subscribe(
      (response: Footballer) => {
        console.log(response);
        this.getPlayers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteFootBaller(footballerId: number): void {
    this.footballerService.deleteFootballer(footballerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getPlayers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenFootballerModal(footballer: Footballer, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addFootballerModal');
      this.getTeams();
    }
    if (mode === 'edit') {
      this.editFootballer = footballer;
      button.setAttribute('data-target', '#updateEditModal');
    }
    if (mode === 'delete') {
      this.deleteFootballer = footballer;
      button.setAttribute('data-target', '#deleteTeamModal');
    }

    container.appendChild(button);
    button.click();
  }
}
