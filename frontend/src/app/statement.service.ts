import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Statement} from './statement';
import {Footballer} from './footballer';
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
    return this.http.put<void>(`${this.apiServerUrl}/statement/api/players/add`, {footballer, team});
  }

  public getOtherPlayers(teamId: number): Observable<Statement[]> {
    return this.http.get<Statement[]>(`${this.apiServerUrl}/statement/api/players/other/${teamId}`);
  }

  public getStatementById(statementId: number): Observable<Statement> {
    return this.http.get<Statement>(`${this.apiServerUrl}/statement/api/get/${statementId}`);
  }

  public getStatementByFootballerId(footballerId: number): Observable<Statement> {
    return this.http.get<Statement>(`${this.apiServerUrl}/statement/api/footballer/${footballerId}`);
  }
}
