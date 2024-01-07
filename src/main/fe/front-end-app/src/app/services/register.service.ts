import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FitnessUser } from '../models/FitnessUser';
import { environment } from '../../environment/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private readonly http: HttpClient) { }

  public signup(fitnessUser: FitnessUser) : Observable<FitnessUser>{
    return this.http.post<FitnessUser>(`${environment.restApi}/private/api/users`, fitnessUser);
  }

}
