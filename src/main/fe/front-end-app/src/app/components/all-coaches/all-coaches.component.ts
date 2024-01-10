import { Component } from '@angular/core';

import { MatCardModule } from '@angular/material/card';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { CommonModule } from '@angular/common';
import { Coach } from '../../models/Coach';
import { AllCoachesService } from '../../services/all-coaches.service';

@Component({
  selector: 'app-all-coaches',
  standalone: true,
  imports: [
    NavBarComponent,
    MatCardModule,
    CommonModule
  ],
  templateUrl: './all-coaches.component.html',
  styleUrl: './all-coaches.component.css'
})
export class AllCoachesComponent {

  coaches: Coach[]=[];

  constructor(private readonly allCoachesService: AllCoachesService){
    this.getAllCoaches()
  } 
  
  getAllCoaches(){
    this.allCoachesService.getAllCoaches().subscribe( response =>{
      if(response){
        this.coaches = response;
      }
    } )
  }

}
