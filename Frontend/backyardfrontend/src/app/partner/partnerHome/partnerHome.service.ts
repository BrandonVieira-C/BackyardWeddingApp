import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { catchError, Observable, throwError } from "rxjs";
import { Partner } from "src/app/shared/entity/Partner";
import { environment } from "src/environments/environment";

// when creating service, need to also add to partner.module.ts
@Injectable({
  providedIn: 'root'
})

export class PartnerHomeService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' }) // for passing err/success message from backend to html

  constructor(private http: HttpClient) { }

  // // GETTING SPECIFIC PARTNER: how to get partner when implanting partnerDTO in GET that is not in the url?
  // public getPartnerWithId(partnerId: number): Observable<Partner> {
  //   return this.http.get<Partner>(`${this.apiServerUrl}/getpartner`, partnerId);
  // }

  // public getPartner(partnerId: number): Observable<Partner> {
  //   return this.http.get<Partner>(`${this.apiServerUrl}/getpartner/${partnerId}`)
  // }

  private handleError(err: HttpErrorResponse) {
    console.log(err)
    let errMsg: string = '';
    if (err.error instanceof Error) {
      errMsg = err.error.message;
      console.log(errMsg)
    }
    else if (typeof err.error === 'string') {
      errMsg = JSON.parse(err.error).errorMessage
    }
    else {
      if (err.status == 0) {
        errMsg = "A connection to back end can not be established.";
      } else {
        errMsg = err.error.message;
      }
    }
    return throwError(() => errMsg);
  }

  public getAllPartner(): Observable<Partner[]> {
    let url: string = environment.partnerApiUrl + "/getallpartner";
    return this.http.get<Partner[]>(url);
  }

  public addPartner(partner: Partner): Observable<string> { //return type string to allow success/err messages to be passed
    let url: string = environment.partnerApiUrl + '/addpartner'
    return this.http.post<string>(url, partner, { headers: this.headers, responseType: 'text' as 'json' });
  }

  public deletePartner(partnerId: number): Observable<string> {
    let url: string = environment.partnerApiUrl + '/deletepartner/' + partnerId;
    return this.http.delete<string>(url, { headers: this.headers, responseType: 'text' as 'json' });
  }

  public getPartnerById(partnerId: number): Observable<Partner> {
    let url: string = environment.partnerApiUrl + '/getpartner/' + partnerId;
    return this.http.get<Partner>(url);
  }


  // public addPartner(partner: Partner): Observable<Partner> {
  //   return this.http.post<Partner>(`${this.apiServerUrl}/addpartner`, partner);
  // }

  // //TODO: not implemented in backend
  // public updatePartner(partner: Partner):Observable<Partner> {
  //   return this.http.put<Partner>(`${this.apiServerUrl}/updatepartner`,partner);
  // }



}