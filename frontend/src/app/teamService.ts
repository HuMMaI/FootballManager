import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Team} from './team';

@Injectable({providedIn: 'root'})
export class TeamService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(`${this.apiServerUrl}/team/api/`);
  }

  public addTeam(team: Team): Observable<Team> {
    return this.http.post<Team>(`${this.apiServerUrl}/team/api/add`, team);
  }
}
