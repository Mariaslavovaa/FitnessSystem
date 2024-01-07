import { Component } from '@angular/core';

import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FitnessUser } from '../../models/FitnessUser';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RegisterService } from '../../services/register.service';
import { FormsModule } from '@angular/forms';
import { NavBarComponent } from '../nav-bar/nav-bar.component';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    MatCardModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    NavBarComponent
  ],
  providers: [HttpClient],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  fitnessUser?: FitnessUser;

  constructor(private readonly router: Router, private readonly registerService: RegisterService) { }

  form: any = {
    email: null,
    username: null,
    password: null,
    confirm_password: null,
    individualWorkouts: null,
    groupWorkouts: null
  };

  email = ""
  username = ""
  password = ""
  confirm_password = ""
  individualWorkouts = []
  groupWorkouts = []
  errorMessage = "";

  passwordsMatch(): boolean {
    return this.form.password === this.form.confirm_password;
  }

  register() {
    // if (!this.passwordsMatch()) {
    //   return;
    // }
    const signupData = {
      email: this.email, username: this.username, password: this.password,
      confirm_password: this.confirm_password, individualWorkouts: this.individualWorkouts,
      groupWorkouts: this.groupWorkouts
    };
    //alert(signupData.email)
    this.registerService.signup(signupData).subscribe((response) => {
      if(response){
        console.log(response)
        this.fitnessUser = response
        window.location.replace('/login')
      }
    }) 


  }

}
