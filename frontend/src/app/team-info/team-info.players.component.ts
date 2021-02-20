import {Component, Input} from '@angular/core';
import {Footballer} from '../footballer';

@Component({
  selector: 'app-team-info-players',
  templateUrl: './team-info.players.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoPlayersComponent {
  @Input() public players: Footballer[];
}
