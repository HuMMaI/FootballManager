import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Statement} from './statement';
import {Footballer} from './footballer';
import {FootballerAddDto} from './footballer.add.dto';
import {Team} from './team';

@Injectable({providedIn: 'root'})
export class StatementService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getStatements(): Observable<Statement[]> {
    return this.http.get<Statement[]>(`${this.apiServerUrl}/statement/api/`);
  }

  public getStatementsByTeamId(teamId: number): Observable<Footballer[]> {
    return this.http.get<Footballer[]>(`${this.apiServerUrl}/statement/api/${teamId}`);
  }

  public getPlayersWithoutTeam(): Observable<Footballer[]> {
    return this.http.get<Footballer[]>(`${this.apiServerUrl}/statement/api/players/without-team`);
  }

  public addFootballer(footballer: Footballer, team: Team): Observable<void> {
    // let params: HttpParams;
    // params = new HttpParams().set('footballer', '').set('team', team);
    return this.http.put<void>(`${this.apiServerUrl}/statement/api/players/add`, {footballer, team});
  }
}
