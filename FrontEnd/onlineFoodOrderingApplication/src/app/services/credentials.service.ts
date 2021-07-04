import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CredentialsService {
  //variables declaration
  private baseUrl = 'http://localhost:8082/api/v2/';
  customer: string = "";
  submitted: boolean = false;
  customerEmail: string = "";
  firstName: string = "";
  //constructor
  constructor(private http: HttpClient) { }
  //to add the Customer
  addCustomer(customer: any): Observable<object> {
    return this.http.post<object>(`${this.baseUrl}addCustomer`, customer);
  }
  //to get credentials
  getLoginCredentails(email: string, password: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}getCredentails/${email}/${password}`,);
  }

  //toset token details
  getToken(): any {
    return localStorage.getItem("authToken");
  }
  //to set token details
  setToken(token: string): void {
    localStorage.setItem("authToken", token);
  }
  //to remove token
  removeToken(): void {
    localStorage.removeItem('authToken');
  }
  //getCustomerDetails
  getCustomerDetails(email: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}getCustomerDetails/${email}`);
  }
}
