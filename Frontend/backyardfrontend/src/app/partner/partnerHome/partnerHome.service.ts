import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { catchError, Observable, throwError } from "rxjs";
import { Partner } from "src/app/shared/entity/Partner";
import { environment } from "src/environments/environment";

// when creating service, need to also add to partner.module.ts
@Injectable({
  providedIn: 'root'
})

export class PartnerHomeService {

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
    return this.http.get<Partner[]>(url).pipe(catchError(this.handleError))
  }

  public getPartnerById(partnerId: number):Observable<Partner> {
    let url: string = environment.partnerApiUrl+'/getpartner/'+partnerId;
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