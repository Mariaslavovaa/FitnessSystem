import { Component } from '@angular/core';

import { MatCardModule } from '@angular/material/card';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { CommonModule } from '@angular/common';
import { IndividualWorkout } from '../../models/IndividualWorkout';
import { GroupWorkout } from '../../models/GroupWorkout';
import { MyWorkoutsService } from '../../services/my-workouts.service';

@Component({
  selector: 'app-my-workouts',
  standalone: true,
  imports: [
    MatCardModule,
    NavBarComponent,
    CommonModule
  ],
  templateUrl: './my-workouts.component.html',
  styleUrl: './my-workouts.component.css'
})
export class MyWorkoutsComponent {
  individualWorkouts: IndividualWorkout[] = []
  groupWorkouts: GroupWorkout[] = [];

  em = sessionStorage.getItem('email');
  constructor(private readonly myWorkoutService: MyWorkoutsService) {
    this.getAllIndividualWorkouts()
    this.getAllGroupWorkouts()

  }

  getAllIndividualWorkouts() {
    this.myWorkoutService.getAllIndividualWorkouts().subscribe(response => {
      if (response) {
        response = response.filter(response => response.fitnessUser == this.em)
        console.log(response);
        this.individualWorkouts = response;
      }
    })
  }

  getAllGroupWorkouts() {
    this.myWorkoutService.getAllGroupWorkouts().subscribe(response => {
      if (response) {
        
        if(this.em){
          response = response.filter(response => response.users.find(user => user == this.em) != undefined)
          this.groupWorkouts = response; 
        }
        console.log(response);
      }
    })
  }

}




