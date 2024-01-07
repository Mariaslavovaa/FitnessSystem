import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';  

import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';

import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { Coach } from '../../models/Coach';
import { BookWorkoutService } from '../../services/book-workout.service';
import { IndividualWorkout } from '../../models/IndividualWorkout';
import { GroupWorkout } from '../../models/GroupWorkout';
import {
  IgxTimePickerModule,
  IgxInputGroupModule,
  IgxIconModule,
  PickerInteractionMode
} from "igniteui-angular";


@Component({
  selector: 'app-workout-form',
  standalone: true,
  imports: [
    NavBarComponent,
    MatDatepickerModule,
    MatInputModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatSelectModule,
    MatIconModule,
    IgxIconModule,
    IgxInputGroupModule,
    IgxTimePickerModule,
    CommonModule

  ],
  templateUrl: './workout-form.component.html',
  styleUrl: './workout-form.component.css'
})
export class WorkoutFormComponent {

  coaches: Coach[] = [];
  foundIndWorkout?: IndividualWorkout;
  foundGroupWorkout?: GroupWorkout;
  selectedCoach: string = ''
  indWorkout = 'Individual workout'
  groupWorkout = 'Group workout'
  groupWorkoutName = 'Crossfit';


  public mode: PickerInteractionMode = PickerInteractionMode.DropDown;
  public format = 'hh:mm tt';
  public date: Date = new Date();

  constructor(private readonly bookWorkoutService: BookWorkoutService) {
    this.getAllCoaches();
  }

  getAllCoaches() {
    this.bookWorkoutService.getAllCoaches().subscribe(response => {
      if (response) {
        this.coaches = response;
      }
    })
  }

  findCoachEmailByUsername(coachName: string) {
    let result = ''
    this.coaches.forEach(coach => {
      if (coach.username == coachName) {
        result = coach.email
      }
    })
    return result
  }

  saveWorkout(date: string, time: string | Date, coach: string, workout: string, workoutName: string) {

    const dateTime = date.concat(" ").concat(time.toString());
    const em = sessionStorage.getItem('email');
    let foundEmail = this.findCoachEmailByUsername(coach);
    if (em) {

      if (workout == "Individual workout") {
        this.bookWorkoutService.saveIndividualWorkout(dateTime, foundEmail, em).subscribe(responce => {
          if (responce) {
            alert("success")
            this.foundIndWorkout = responce;
            window.location.reload();
          }
        })
      }
      else {
        if (time === "17:00:00") {
          this.bookWorkoutService.saveGroupWorkout(dateTime, foundEmail, em, workoutName).subscribe(responce => {
            if (responce) {
              alert("success")
              this.foundGroupWorkout = responce;
              window.location.reload();
            }
          })
        }
        else {
          alert("Груповите тренировки са само в 17:00 часа. Моля променете избрания от Вас час!");
          // съобщение че няма групова тренировка в този час!
        }
      }
    }
  }

}
