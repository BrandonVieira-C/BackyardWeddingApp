import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Backyard } from 'src/app/objects/backyard';
import { Customer } from '../objects/customer';
import { RESTService } from '../REST.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  backyards!: Backyard[];
  backyard!: Backyard;
  city!: string;
  SearchCity!: string;
  customer!: Customer;
  customerId!: number;


  constructor(private restService: RESTService) { }

  ngOnInit(): void {
  
  }

  getBackyardsByCity (city: string): void {
    this.restService.getBackyards(city).subscribe(
      (response: Backyard[]) => {
        this.backyards = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  



}
