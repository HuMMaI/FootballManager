import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Footballer} from './footballer';
import {FootballerDto} from './footballer.dto';

@Injectable({providedIn: 'root'})
export class FootballerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getPlayers(): Observable<Footballer[]> {
    return this.http.get<Footballer[]>(`${this.apiServerUrl}/footballer/api/`);
  }

  public addFootballer(footballer: FootballerDto): Observable<Footballer> {
    return this.http.post<Footballer>(`${this.apiServerUrl}/footballer/api/add`, footballer);
  }

  public updateFootballer(footballer: Footballer): Observable<Footballer> {
    return this.http.put<Footballer>(`${this.apiServerUrl}/footballer/api/update`, footballer);
  }

  public deleteFootballer(footballerId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/footballer/api/delete/${footballerId}`);
  }
}
