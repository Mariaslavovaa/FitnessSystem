import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../models/Coach';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environment';
import { IndividualWorkout } from '../models/IndividualWorkout';
import { GroupWorkout } from '../models/GroupWorkout';

@Injectable({
  providedIn: 'root'
})
export class BookWorkoutService {

  constructor(private readonly http: HttpClient) { }

  public getAllCoaches(): Observable<Coach[]> {
    return this.http.get<Coach[]>(`${environment.restApi}/private/api/coaches`);
  }

  public saveIndividualWorkout(date: string, coachEmail: string, userEmail: string): Observable<IndividualWorkout> {
    const body = {
      localDateTime: date,
      coach: coachEmail,
      fitnessUser: userEmail
    }
    return this.http.post<IndividualWorkout>(`${environment.restApi}/private/api/individual-workouts`, body);
  }

  public saveGroupWorkout(date: string, coachEmail: string, userEmail: string,
                          workoutName: string, description: string, hallNumber: number): Observable<GroupWorkout> {
    const currUser = sessionStorage.getItem('email')

    const body = {
      date: date,
      coach: coachEmail,
      fitnessUser: userEmail,
      description: description,
      hallNumber: hallNumber,
      name: workoutName,
      users: [currUser]
    }
    return this.http.post<GroupWorkout>(`${environment.restApi}/private/api/group-workouts`, body);
  }

}
