import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Backyard } from '../objects/backyard';
import { RESTService } from '../REST.service';

@Component({
  selector: 'app-find-abackyard',
  templateUrl: './find-abackyard.component.html',
  styleUrls: ['./find-abackyard.component.css']
})
export class FindABackyardComponent implements OnInit {
  city!: string;
  backyards!: Backyard[];
  backyard!: Backyard;
  
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
