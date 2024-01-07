import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterModule } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { FitnessUser } from '../../models/FitnessUser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NavBarComponent } from '../nav-bar/nav-bar.component';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatCardModule,
    MatFormFieldModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    RouterModule,
    HttpClientModule,
    NavBarComponent
  ],
  providers: [HttpClient],
  templateUrl: './login.component.html',
  styleUrls: ['login.component.css', '../../app.component.css']
})
export class LoginComponent {

  found?: FitnessUser;

  constructor(private readonly router: Router, private readonly loginService: LoginService) { }

  login(username: string, password: string) {
    // console.log(username);
    // console.log(password);
    this.loginService.login(username, password).subscribe(response => {
      // console.log(response);
      if(response){
        alert("Welcome " + response.username)
        this.found = response;
        sessionStorage.setItem("username", this.found.username)
        sessionStorage.setItem("email", this.found.email)
        window.location.reload()
      }
    })
  }

  redirectToReg(){
    this.router.navigate(['/register'])
  }

}
