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


  SearchCity!: string;
  customer!: Customer;
  customerId!: number;


  constructor() { }

  ngOnInit(): void {
  
  }

  

  



}
