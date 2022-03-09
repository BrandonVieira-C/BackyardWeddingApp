import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './objects/customer';
import { Partner } from './objects/partner';
import { Backyard } from './objects/backyard';


@Injectable({
  providedIn: 'root'
})
export class RESTService {

  private baseUrl = 'http://localhost:8080/wedding';

  constructor(private http: HttpClient) { }

// customer CRUD methods

  public addCustomer(customer: Customer): Observable<number> {
    return this.http.post<number>(this.baseUrl, customer);
  }

  public getCustomer(customerId: number): Observable<Customer> {
    return this.http.get<Customer>(this.baseUrl+"/getcustomer/"+customerId);
  }

  public updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(this.baseUrl+"/updatecustomer", customer);
  }

  public deleteCustomer(customerId: number): Observable<string> {
    return this.http.delete<string>(this.baseUrl+"/deletepartner/"+customerId);
  }
  
// partner CRUD methods

public addPartner(partner: Partner): Observable<number> {
  return this.http.post<number>(this.baseUrl+'/addcustomer', partner);
}

public getPartner(partnerId: number): Observable<Partner> {
  return this.http.get<Partner>(this.baseUrl+'/getpartner/'+partnerId);
}

public updatePartner(partner: Partner): Observable<Partner> {
  return this.http.put<Partner>(this.baseUrl+'/updatepartner', partner);
}

public deletePartner(partnerId: number): Observable<string> {
  return this.http.delete<string>(this.baseUrl+'/deletepartner/'+partnerId);
}

// backyard CRUD methods

public addBackyard(backyard: Backyard): Observable<number> {
  return this.http.post<number>(this.baseUrl+'/addbackyard', backyard);
}

public getBackyard(backyardId: number): Observable<Backyard> {
  return this.http.get<Backyard>(this.baseUrl+'/getbackyard/'+backyardId);
}

public getBackyardsByCity(city: string): Observable<Backyard[]> {
  return this.http.get<Backyard[]>(this.baseUrl+'/getbackyards/'+city);
}

public updateBackyard(backyard: Backyard): Observable<Backyard> {
  return this.http.put<Backyard>(this.baseUrl+'/updatebackyard', backyard);
}

public deleteBackyard(backyardId: number): Observable<string> {
  return this.http.delete<string>(this.baseUrl+'/deletebackyard/'+backyardId);
}
// event CRUD methods

public addEvent(event: Event): Observable<number> {
  return this.http.post<number>(this.baseUrl+'/addevent', event);
}

public getEvent(eventId: number): Observable<Event> {
  return this.http.get<Event>(this.baseUrl+'/getevent/'+eventId);
}

public updateEvent(event: Event): Observable<Event> {
  return this.http.put<Event>(this.baseUrl+'/updateevent', event);
}

public deleteEvent(eventId: number): Observable<string> {
  return this.http.delete<string>(this.baseUrl+'/deleteevent/'+eventId);
}
}
