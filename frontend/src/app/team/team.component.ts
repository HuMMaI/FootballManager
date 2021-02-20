import { Component, OnInit } from '@angular/core';
import {Team} from '../team';
import {TeamService} from '../team.service';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  public teams: Team[];
  public editTeam: Team;
  public deleteTeam: Team;

  constructor(private teamService: TeamService) { }

  ngOnInit(): void {
    this.getTeams();
  }

  public getTeams(): void {
    this.teamService.getTeams().subscribe(
      (response: Team[]) => {
        this.teams = response;
        console.log(this.teams);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddTeam(addForm: NgForm): void {
    this.teamService.addTeam(addForm.value).subscribe(
      (response: Team) => {
        console.log(response);
        this.getTeams();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateTeam(team: Team): void {
    this.teamService.updateTeam(team).subscribe(
      (response: Team) => {
        console.log(response);
        this.getTeams();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTeam(teamId: number): void {
    this.teamService.deleteTeam(teamId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTeams();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenTeamModal(team: Team, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addTeamModal');
    }
    if (mode === 'edit') {
      this.editTeam = team;
      button.setAttribute('data-target', '#updateEditModal');
    }
    if (mode === 'delete') {
      this.deleteTeam = team;
      button.setAttribute('data-target', '#deleteTeamModal');
    }

    container.appendChild(button);
    button.click();
  }
}
