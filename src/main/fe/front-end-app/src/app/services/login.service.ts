import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FitnessUser } from '../models/FitnessUser';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private readonly http: HttpClient) { }

  public login(username: string, password: string): Observable<FitnessUser> {
    
    const params = new HttpParams().append("username", username).append("password", password);
    console.log(params);
    return this.http.post<FitnessUser>(`${environment.restApi}/private/api/users/login`, params);
  }

}
