import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CardApiResponse } from '../../models/CardApiResponse';

import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CardModel } from "../../models/CardModel";

import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';


@Component({
  selector: 'app-payment-api',
  standalone: true,
  imports: [
    MatInputModule,
    MatFormFieldModule,
    // MatIconModule,
    // MatDividerModule, 
    MatButtonModule
  ],
  templateUrl: './payment-api.component.html',
  styleUrl: './payment-api.component.css'
})
export class PaymentApiComponent {

  cardApiRes : CardApiResponse | null = null
  card?: CardModel
  
  constructor(private readonly http: HttpClient){

  }

  
  validate(bin: string){
    bin = bin.substring(0,6);
    var myHeaders = new Headers();
    myHeaders.set("apikey", "GF4h4f94xkqKbD0fo2qNWWEmmxkzWwie");

    this.http.get<CardApiResponse>(`https://api.apilayer.com/bincheck/` + bin,  
    {
      headers: {"apiKey": "GF4h4f94xkqKbD0fo2qNWWEmmxkzWwie"}
    }
    ).subscribe(response => {
      if(response){
        console.log(response);
        this.cardApiRes = response
        
      }
    })
  }
}
