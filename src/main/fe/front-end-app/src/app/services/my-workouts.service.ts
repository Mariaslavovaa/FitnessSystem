import { Injectable } from '@angular/core';
import { IndividualWorkout } from '../models/IndividualWorkout';
import { environment } from '../../environment/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GroupWorkout } from '../models/GroupWorkout';

@Injectable({
  providedIn: 'root'
})
export class MyWorkoutsService {

  constructor(private readonly http: HttpClient) { }

  public getAllIndividualWorkouts() : Observable<IndividualWorkout[]>{
    return this.http.get<IndividualWorkout[]>(`${environment.restApi}/private/api/individual-workouts`);
  }

  public getAllGroupWorkouts() : Observable<GroupWorkout[]>{
    return this.http.get<GroupWorkout[]>(`${environment.restApi}/private/api/group-workouts`);  
  }
}
