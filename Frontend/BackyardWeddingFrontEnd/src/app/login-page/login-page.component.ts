import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../objects/customer';
import { RESTService } from '../REST.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  customerId!: number;
  customer!: Customer;

  constructor(private rest: RESTService) { }

  ngOnInit(): void {
  }

  getCustomer(id: number): void {
    this.rest.getCustomer(id).subscribe(
      (response: Customer) => {
      this.customer = response;
  },
  (error: HttpErrorResponse) => {
    alert(error.message);
  }
    );
  }
}
