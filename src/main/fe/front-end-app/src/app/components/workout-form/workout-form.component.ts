import { Component, Inject } from '@angular/core';
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
import { PaymentApiComponent } from '../payment-api/payment-api.component';

import {
  MatDialog,  
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';


export interface DialogData {
  nameOnCard: string;
  cardNumber: string;
  expDate: string;
  cvv: string;
}

export class DialogOverviewExampleDialog {
  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

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
    CommonModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose

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

  nameOnCard?: string;
  cardNumber?: string;
  expDate?: string;
  cvv?: string;
  email = sessionStorage.getItem('email')
  constructor(private readonly bookWorkoutService: BookWorkoutService, public dialog: MatDialog) {
    this.getAllCoaches();
  }

  openDialog(date: string, time: string | Date, coach: string, workout: string, workoutName: string): void {
    if(!date || !time || !coach || !workout || !workoutName){
      alert("Please fill in each field!")
      window.location.reload()
      return
    }
    const dialogRef = this.dialog.open(PaymentApiComponent, {
      height: '400px',
      width: '500px',
    });

    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed' + dialogRef.componentInstance.cardApiRes?.bin);
      if(dialogRef.componentInstance.cardApiRes){
        this.saveWorkout(date, time, coach, workout, workoutName)
      }
      
    });
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
    const hallNumber = 4
    const description = "CrossFit is a strength and conditioning fitness workout consisting of a mix of aerobic and bodyweight exercises"
    let foundEmail = this.findCoachEmailByUsername(coach);
    if (em) {

      if (workout == "Individual workout") {
        this.bookWorkoutService.saveIndividualWorkout(dateTime, foundEmail, em).subscribe(responce => {
          if (responce) {
            alert("success")
            this.foundIndWorkout = responce;
            window.location.replace('my-workouts');
          }
        })
      }
      else {
        if (time === "17:00:00") {
          this.bookWorkoutService.saveGroupWorkout(dateTime, foundEmail, em, workoutName, description, hallNumber).subscribe(responce => {
            if (responce) {
              alert("success")
              this.foundGroupWorkout = responce;
              window.location.replace('my-workouts');
            }
          })
        }
        else {
          alert("Груповите тренировки са само в 17:00 часа. Моля променете избрания от Вас час!");
        }
      }
    }
  }

}
