import {Component, Input} from '@angular/core';
import {Footballer} from '../footballer';
import {Statement} from '../statement';
import {Team} from '../team';
import {StatementService} from '../statement.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-team-info-other-players',
  templateUrl: './team-info.other-players.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoOtherPlayersComponent {
  @Input() statements: Statement[];
  @Input() public team: Team;

  constructor(private statementService: StatementService) {
  }

  onBuyFootballer(footballer: Footballer): void {
    this.statementService.addFootballer(footballer, this.team).subscribe(
      (response: void) => {
        window.location.reload();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
