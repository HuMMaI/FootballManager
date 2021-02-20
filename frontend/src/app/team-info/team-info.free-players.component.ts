import {Component, Input} from '@angular/core';
import {Footballer} from '../footballer';
import {StatementService} from '../statement.service';
import {FootballerAddDto} from '../footballer.add.dto';
import {Team} from '../team';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-team-info-free-players',
  templateUrl: './team-info.free-players.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoFreePlayersComponent {
  @Input() public players: Footballer[];
  @Input() public team: Team;
  public footballerDto: FootballerAddDto;

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
