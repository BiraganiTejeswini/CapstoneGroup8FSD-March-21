import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { Login } from 'src/app/model/login';
import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  // variables declaration
  customerEmail: string = "";
  total_price: number = 0;
  total_quantity: number = 0;
  foodName: string = "";
  dish: Array<any> = [];
  responseMessage: string = "";
  customer: Customer = new Customer();
  totalCost1: number = 0;
  totalQuantity: number = 0;
  search: any;
  cartItem: number = 0;
  isToken: boolean = false;
  email: string = "";
  customerId: number = 0;
  lastName: string = "";
  id: number = 0;
  firstName: string = "";

  //constructor
  constructor(private service: MenuService, private cartService: CartService,
    public service2: CredentialsService, private router: Router, private builder: FormBuilder) { }

  // init method
  ngOnInit(): void {

    this.buildForm();
    this.cartItem = JSON.parse(localStorage.getItem('count') || '{}');
  }
  buildForm() {
    this.search = this.builder.group({
      foodName: ['', Validators.required]
    })
  }

  //getCustomerName
  login2: Login = new Login();
  getCustomername(email: string, password: string) {
    this.customerEmail = this.service2.customerEmail
    this.service2.getLoginCredentails(email, password).subscribe(data => {
      this.customerEmail = this.service2.customerEmail
    }
    )
  }
  //To Search Food
  searchFood(name: string) {
    this.service.getFoodByName(name).subscribe((data) => {
      this.service.b = true;
      this.service.foodArray = data;
      this.router.navigateByUrl("/searchPage")
    },
      e => {
        alert("Food Item Not available")
        this.router.navigateByUrl("/Adigas")
        console.log(e);
      })
  }

  //to check the token existence
  isTokenPresent(): any {
    if (this.service2.getToken() != null) {
      return this.isToken = true;
    }
    return false;
  }
  //to Logout from the application
  LogOut() {
    this.service2.removeToken();
    this.cartClearItems();
    this.router.navigateByUrl("/Adigas")
  }
  //to remove all cart items
  cartClearItems() {
    this.cartService.cartClearItems().subscribe((data) => {
    })
  }
  //to cart page
  redirectCart() {
    this.router.navigateByUrl("/cart")
  }

}
