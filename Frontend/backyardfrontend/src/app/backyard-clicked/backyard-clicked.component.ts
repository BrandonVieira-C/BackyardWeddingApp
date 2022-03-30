import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Backyard } from '../objects/backyard';

import { backyards } from '../objects/listOfBackyards';

@Component({
  selector: 'app-backyard-clicked',
  templateUrl: './backyard-clicked.component.html',
  styleUrls: ['./backyard-clicked.component.css']
})
export class BackyardClickedComponent implements OnInit {
  backyard: Backyard | undefined;
  
  constructor(private route : ActivatedRoute) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const id = Number(routeParams.get('backyardId'));
    this.backyard = backyards.find(yard => yard.backyardId == id);

  }

}
