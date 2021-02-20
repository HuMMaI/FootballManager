import {Component, Input} from '@angular/core';
import {Footballer} from '../footballer';
import {Statement} from '../statement';

@Component({
  selector: 'app-team-info-other-players',
  templateUrl: './team-info.other-players.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoOtherPlayersComponent {
  @Input() statements: Statement[];
}
