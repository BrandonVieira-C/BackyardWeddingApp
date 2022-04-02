import { Component } from '@angular/core';

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
