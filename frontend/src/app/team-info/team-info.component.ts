import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {Team} from '../team';
import {TeamService} from '../team.service';
import {HttpErrorResponse} from '@angular/common/http';
import {FootballerService} from '../footballer.service';
import {StatementService} from '../statement.service';
import {Footballer} from '../footballer';
import {Statement} from '../statement';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-team-info',
  templateUrl: './team-info.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoComponent implements OnInit {

  public teamPictureUrl = environment.teamPictureUrl;
  public teamId: number;
  public team: Team;
  public players: Footballer[];
  public freePlayers: Footballer[];
  public statements: Statement[];
  @ViewChild('freePlayersEl') freePlayersEl: ElementRef;
  @ViewChild('teamPlayersEl') playersEl: ElementRef;
  @ViewChild('otherPlayersEl') otherPlayersEl: ElementRef;

  constructor(private route: ActivatedRoute, private teamService: TeamService, private statementService: StatementService) {
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.teamId = params.teamId;
    });

    this.getTeam();
  }

  public getTeam(): void {
    this.teamService.getTeamById(this.teamId).subscribe(
      (response: Team) => {
        this.team = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

    this.statementService.getStatementsByTeamId(this.teamId).subscribe(
      (response: Footballer[]) => {
        this.players = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

    this.statementService.getPlayersWithoutTeam().subscribe(
      (response: Footballer[]) => {
        this.freePlayers = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

    this.statementService.getOtherPlayers(this.teamId).subscribe(
      (response: Statement[]) => {
        this.statements = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  onChangeContent(mode: string): void {
    if (mode === 'players') {
      this.freePlayersEl.nativeElement.classList.add('hidden');
      this.otherPlayersEl.nativeElement.classList.add('hidden');
      this.playersEl.nativeElement.classList.remove('hidden');
    }
    if (mode === 'free-players') {
      this.otherPlayersEl.nativeElement.classList.add('hidden');
      this.playersEl.nativeElement.classList.add('hidden');
      this.freePlayersEl.nativeElement.classList.remove('hidden');
    }
    if (mode === 'other-players') {
      this.playersEl.nativeElement.classList.add('hidden');
      this.freePlayersEl.nativeElement.classList.add('hidden');
      this.otherPlayersEl.nativeElement.classList.remove('hidden');
    }
  }
}
