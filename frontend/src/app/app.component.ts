import { Component, OnInit } from '@angular/core';
import {Team} from './team';
import {NgForm} from '@angular/forms';
import {TeamService} from './teamService';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public teams: Team[];

  constructor(private teamService: TeamService) {
  }

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
}
