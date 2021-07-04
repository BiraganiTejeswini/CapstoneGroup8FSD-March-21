import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart';
import { Search } from '../model/search';
import { CredentialsService } from './credentials.service';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  //variables declaration
  totalPrice: number = 0;
  totalQuantity: number = 0;
  cartArray: Array<Search> = [];
  private baseUrl = 'http://localhost:8082/api/v2/';
  bearerToken: string = "";
  //constructor
  constructor(private http: HttpClient, private service: CredentialsService) {
    this.getToken();
  }
  //to get the token
  getToken() {
    this.bearerToken = this.service.getToken();
    console.log("cartservice Token" + this.bearerToken)
  }

  //to add the Customer
  addCart(cart: any): Observable<any> {
    this.getToken();
    return this.http.post<any>(`${this.baseUrl}addCart`, cart,
      {
        headers: new HttpHeaders().set('Authorization',
          `Bearer ${this.bearerToken}`)
      });
  }
  //to get items from the cart
  getItems(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}getCart`);
  }
  //To remove a single item from the cart 
  deleteItem(foodId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${foodId}`);
  }
  //to remove all items from the cart
  cartClearItems() {
    return this.http.delete<any>(`${this.baseUrl}deleteCartItems`);
  }

}
