import {Team} from './team';

export interface Footballer {
  id: number;
  firstName: string;
  lastName: string;
  age: number;
  team: Team;
  experience: number;
  price: number;
}
