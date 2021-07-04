import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Search } from '../model/search';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  //variables declaration
  private baseUrl = 'http://localhost:8082/api/v2';
  food: Array<Search> = [];
  price: Array<Search> = [];
  totalPrice: number = 0;
  totalQuantity: number = 0;
  b: boolean = false;
  foodArray: Array<Search> = [];
  totalCost: number = 0;
  //constrcutor
  constructor(private http: HttpClient) { }
  //to display all menu details
  getMenuList(rname: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/restuarantName/${rname}`)
  }
  //to search food based on food name
  getFoodByName(foodName: any): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/searchByFood/${foodName}`)
  }
  //to get food items based on food price in ascending order
  getByFoodPrice(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getByPriceAsc`)
  }
  //to get food items based on food price in descending order  
  getByFoodPriceDesc(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getByPriceDesc`)
  }

}
