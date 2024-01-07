import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../models/Coach';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class AllCoachesService {

  constructor(private readonly http: HttpClient) { }

  public getAllCoaches() : Observable<Coach[]>{
    return this.http.get<Coach[]>(`${environment.restApi}/private/api/coaches`);
  }
}
