import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Backyard } from 'src/app/objects/backyard';
import { Customer } from '../objects/customer';
import { backyards } from '../objects/listOfBackyards';
import { RESTService } from '../REST.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  backyardList!: Backyard[];
  backyard!: Backyard;
  city!: string;
  SearchCity!: string;
  customer!: Customer;
  customerId!: number;


  constructor(private restService: RESTService) { }

  ngOnInit(): void {
  
  }

  getBackyardsByCity (city: string): void {
    this.restService.getBackyardsByCity(city).subscribe(
      (response: Backyard[]) => {
        this.backyardList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  getCustomer(customerId: number): void {
    this.restService.getCustomer(customerId).subscribe(
      (response: Customer) => {
      this.customer = response;
  },
  (error: HttpErrorResponse) => {
    alert(error.message);
  }
    );
  }



}
