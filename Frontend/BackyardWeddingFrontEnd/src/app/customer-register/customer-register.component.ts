import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Customer } from '../objects/customer';
import { RESTService } from '../REST.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  customerLoginForm!: FormGroup;
  customer!: Customer;
  stringmessage!: string;
  successMessage!: any;
  errorMessage!: any;
  customers!: Customer[];
  
  
  constructor(private formBuilder: FormBuilder, private rest: RESTService) { }

  customerRegisterForm = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required]
    })

  ngOnInit(): void {

    this.updateCustomerTable();

  }

  addCustomer(){

    this.rest.addCustomer(this.customerRegisterForm.value).subscribe(
      (success) => {this.successMessage = success },
      (error) => { this.errorMessage = error.error.message }
    );
    this.customerRegisterForm.reset;
    this.updateCustomerTable();
  }

  updateCustomerTable() {
    this.rest.getAllCustomers().subscribe(
      (response) => {this.customers = response}
    );
  }

  customerLoggedIn() {
    
  }

}
function updateCustomerTable() {
  throw new Error('Function not implemented.');
}

