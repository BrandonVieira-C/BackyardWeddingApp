import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Partner } from "src/app/shared/entity/Partner";
import { environment } from "src/environments/environment";

// when creating service, need to also add to partner.module.ts
@Injectable({
  providedIn: 'root'
})
//TODO: add pipe handleError for connection to backend status?
export class PartnerLoginRegistrationService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' }) // for passing err/success message from backend to html

  constructor(private http: HttpClient) { }

  public getAllPartner(): Observable<Partner[]> {
    let url: string = environment.partnerApiUrl + "/getallpartner";
    return this.http.get<Partner[]>(url);
  }

  public addPartner(partner: Partner): Observable<string> { //return type string to allow success/err messages to be passed
    let url: string = environment.partnerApiUrl + '/addpartner';
    return this.http.post<string>(url, partner, { headers: this.headers, responseType: 'text' as 'json' });
  }

  public deletePartner(partnerId: number): Observable<string> {
    let url: string = environment.partnerApiUrl + '/deletepartner/' + partnerId;
    return this.http.delete<string>(url, { headers: this.headers, responseType: 'text' as 'json' });
  }

  public login(partner: Partner): Observable<Partner> {
    let url = environment.partnerApiUrl + '/login';
    return this.http.post<Partner>(url, partner, {headers: this.headers});
  }



  // public getPartnerById(partnerId: number): Observable<Partner> {
  //   let url: string = environment.partnerApiUrl + '/getpartner/' + partnerId;
  //   return this.http.get<Partner>(url);
  // }

  // //TODO: not implemented in backend
  // public updatePartner(partner: Partner):Observable<Partner> {
  //   return this.http.put<Partner>(`${this.apiServerUrl}/updatepartner`,partner);
  // }



}