import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';
import { Customer } from './objects/customer';
import { Partner } from './objects/partner';
import { Backyard } from './objects/backyard';


@Injectable({
  providedIn: 'root'
})

export class RESTService {
  
    private baseUrl = "http://localhost:8080/wedding"

 // private baseUrl = 'http://backyardwedding-env.eba-a9satvjy.us-east-1.elasticbeanstalk.com/wedding';

  constructor(private http: HttpClient) { }

  public addCustomer(customer: Customer): Observable<string> {
    return this.http.post<string>(this.baseUrl + "/addcustomer", customer);
  }

  public getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl+"/getAllCustomers");
  }

  // public getCustomerWithId(customer: Customer): Observable<Customer[]> {
  //   return this.http.get<Customer[]>(this.baseUrl+"/getcustomer", customer);

  // }

  public addEventForCustomer(event: Event, customerId: number): Observable<String> {
    return this.http.post<String>(this.baseUrl+"/addevent/"+customerId, event);
  }


  // public deleteEventForCustomer(event: Event, customerId: number): Observable<String> {
  //   return this.http.delete<String>(this.baseUrl + "/deleteevent"+customerId, event);
  // }

public addPartner(partner: Partner): Observable<String> {
  return this.http.post<String>(this.baseUrl+'/addcustomer', partner);
}

public getPartnerWithId(partner: Partner): Observable<Partner> {
  return this.http.post<Partner>(this.baseUrl+"/getpartner/", partner);
}

public addBackyardForPartner(partnerId:  number, backyard: Backyard): Observable<String> {
  return this.http.post<String>(this.baseUrl+'/addbackyard/'+partnerId, backyard);
}

public getAllBackyards(): Observable<Backyard[]> {
  return this.http.get<Backyard[]>(this.baseUrl+"/getallbackyards");
}
// ------------- unneeded methods -------------------

// public updatePartner(partner: Partner): Observable<Partner> {
//   return this.http.put<Partner>(this.baseUrl+'/updatepartner', partner);
// }

// public deletePartner(partnerId: number): Observable<string> {
//   return this.http.delete<string>(this.baseUrl+'/deletepartner/'+partnerId);
// }

// backyard CRUD methods

// public addBackyard(backyard: Backyard): Observable<number> {
//   return this.http.post<number>(this.baseUrl+'/addbackyard', backyard);
// }

// public getBackyard(backyardId: number): Observable<Backyard> {
//   return this.http.get<Backyard>(this.baseUrl+'/getbackyard/'+backyardId);
// }

// public getBackyards(city: string): Observable<Backyard[]> {
//   return this.http.get<Backyard[]>(this.baseUrl+'/getbackyards/'+city);
// }

// public updateBackyard(backyard: Backyard): Observable<Backyard> {
//   return this.http.put<Backyard>(this.baseUrl+'/updatebackyard', backyard);
// }
//************************************************************************************* */
// public deleteBackyardForPartner(partnerId: number, backyard: Backyard): Observable<string> {
//   return this.http.delete<string>(this.baseUrl+'/deletebackyard/'+partnerId, backyard);
// }
// event CRUD methods

// public addEvent(event: Event): Observable<number> {
//   return this.http.post<number>(this.baseUrl+'/addevent', event);
// }

// public getEvent(eventId: number): Observable<Event> {
//   return this.http.get<Event>(this.baseUrl+'/getevent/'+eventId);
// }

// public updateEvent(event: Event): Observable<Event> {
//   return this.http.put<Event>(this.baseUrl+'/updateevent', event);
// }

// public deleteEvent(eventId: number): Observable<string> {
//   return this.http.delete<string>(this.baseUrl+'/deleteevent/'+eventId);
// }
  // public updateCustomer(customer: Customer): Observable<Customer> {
  //   return this.http.put<Customer>(this.baseUrl+"/updatecustomer", customer);
  // }

// public getPartner(partner: Partner): Observable<Partner> {
//   return this.http.get<Partner>(this.baseUrl+'/getpartner', partner);
// }
}

