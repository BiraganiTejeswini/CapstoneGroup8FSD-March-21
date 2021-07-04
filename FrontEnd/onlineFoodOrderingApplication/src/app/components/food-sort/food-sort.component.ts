import { Component, OnInit } from '@angular/core';
import { Search } from 'src/app/model/search';
import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-food-sort',
  templateUrl: './food-sort.component.html',
  styleUrls: ['./food-sort.component.css']
})
export class FoodSortComponent implements OnInit {
  //Variables declaration
  lowToHigh: Array<any> = [];
  highToLow: Array<any> = [];
  price: Array<any> = [];
  cartId: number = 0;
  isToken: boolean = false;
  //Constructor
  constructor(private service: MenuService, private cartService: CartService, private loginService: CredentialsService) { }
  //init method
  ngOnInit(): void {
    this.getByFoodPriceAscending();
    this.getByFoodPriceDescending();

  }
  //to display items in Ascending Order based on price
  getByFoodPriceAscending() {
    this.price = this.service.price;
    console.log(this.price);
  }
  //to display items in Descending Order based on price
  getByFoodPriceDescending() {
    this.price = this.service.price;
  }
  //to add items into the cart
  addToCart(menu1: Search) {
    this.cartId = menu1.foodId
    this.cartService.addCart(menu1).subscribe(
      (data) => {
        alert("Item added successfully into cart.Click cart Icon to check Your Items")
        console.log(data);
      },
      (error) => console.log(error)
    );
  }
  //to confirm the item addition into the cart
  isAdded(menu: Search) {
    return menu.foodId === this.cartId;
  }
  //to check the token existence
  isTokenPresent(): any {
    if (this.loginService.getToken() != null) {
      return this.isToken = true;
    }
    return false;
  }
}
