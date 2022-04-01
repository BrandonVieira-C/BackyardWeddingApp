import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-form-page',
  templateUrl: './register-form-page.component.html',
  styleUrls: ['./register-form-page.component.css']
})
export class RegisterFormPageComponent implements OnInit {
  registerUserForm!: FormGroup;
  
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registerUserForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.pattern("/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/")],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
      })
  }

}
