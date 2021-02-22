import {Team} from './team';
import {Footballer} from './footballer';

export interface Statement {
  id: number;
  team: Team;
  footballer: Footballer;
}
