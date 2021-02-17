import {Footballer} from './footballer';

export interface Team {
  id: number;
  name: string;
  numberOfPlayers: number;
  // players: Footballer[];
  country: string;
}
