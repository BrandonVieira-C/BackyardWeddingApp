import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Backyard } from '../objects/backyard';


import { backyards } from '../objects/listOfBackyards';
import { RESTService } from '../REST.service';

@Component({
  selector: 'app-backyard-clicked',
  templateUrl: './backyard-clicked.component.html',
  styleUrls: ['./backyard-clicked.component.css']
})
export class BackyardClickedComponent implements OnInit {
  backyard!: Backyard;
  customerId!: number;
  
  constructor(private route : ActivatedRoute, private fb: FormBuilder, private rest: RESTService) { }

  eventRegisterForm = this.fb.group({
    eventName: ['', Validators.required],
    eventDate: ['', Validators.required],
    customerId: ['', Validators.required]

  })

  ngOnInit(): void {
  //   const routeParams = this.route.snapshot.paramMap;
  //   const id = Number(routeParams.get('backyardId'));
  //   this.backyard = backyards.find(yard => yard.backyardId == id);

  }

  addEvent() {
    this.rest.addEventForCustomer(this.eventRegisterForm.value, this.customerId).subscribe(

    )
    
  }

}
