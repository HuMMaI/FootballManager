import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Statement} from './statement';

@Injectable({providedIn: 'root'})
export class StatementService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getStatements(): Observable<Statement[]> {
    return this.http.get<Statement[]>(`${this.apiServerUrl}/statement/api/`);
  }
}
