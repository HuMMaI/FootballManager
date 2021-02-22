import {Component, Input} from '@angular/core';
import {Footballer} from '../footballer';
import {Statement} from '../statement';
import {StatementService} from '../statement.service';
import {HttpErrorResponse} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-team-info-players',
  templateUrl: './team-info.players.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoPlayersComponent {
  @Input() public players: Footballer[];
  public statement: Statement;

  constructor(private statementService: StatementService, private router: Router) {
  }

  onShowFootballer(footballerId: number): void {
    this.statementService.getStatementByFootballerId(footballerId).subscribe(
      (response: Statement) => {
        this.statement = response;
        this.router.navigate(['/footballer'], {queryParams: {statementId: this.statement.id}});
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
