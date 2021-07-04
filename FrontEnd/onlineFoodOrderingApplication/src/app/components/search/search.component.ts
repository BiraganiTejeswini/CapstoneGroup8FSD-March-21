import { Component, Input, OnInit } from '@angular/core';
import { Search } from 'src/app/model/search';
import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  //variables declaration
  isToken: boolean = false;
  foodArr: Array<any> = [];
  cartId: number = 0;
  //constructor
  constructor(private service: MenuService, private cartService: CartService, private loginService: CredentialsService) { }
  //init method
  ngOnInit(): void {
    this.foodSearch();
  }

  //to search the food item by name
  foodSearch() {
    this.foodArr = this.service.foodArray;
    console.log("local search ts array" + this.foodArr)
    console.log("Service food array" + this.service.foodArray)
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
