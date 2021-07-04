import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddressService {
  //variable sdeclaration
  private baseUrl = 'http://localhost:8082/api/v2';
  //constructor
  constructor(private http: HttpClient) { }
  //to add the address
  addAddress(address: any): Observable<any> {
    console.log(address);
    return this.http.post(`${this.baseUrl}/address`, address);
  }
  //to retrieve all the states
  getAllStates(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getAllStates`)
  }
}

