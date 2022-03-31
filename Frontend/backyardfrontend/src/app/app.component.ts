import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { PartnerHomeService } from './partner/partnerHome/partnerHome.service';
import { Partner } from './shared/entity/Partner';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'app';
}



// export class AppComponent implements OnInit{
//   public partners: Partner[];
//   constructor(private partnerHomeService: PartnerHomeService) { }

//   ngOnInit() {
//     this.getAllPartner;
//   }

//   public getAllPartner(): void {
//     this.partnerHomeService.getAllPartner().subscribe({
//       next: response => {
//         this.partners = response;
//       },
//       error: error => {
//         alert(error.message);
//       }
//     })
//   }

// }
