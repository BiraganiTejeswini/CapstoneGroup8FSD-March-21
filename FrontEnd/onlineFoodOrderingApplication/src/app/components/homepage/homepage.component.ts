import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';
import { Search } from 'src/app/model/search';
import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  //variables declaration
  menu: Array<Search> = [];
  decision: string = '';
  name: string = "";
  cartArray: Array<Search> = [];
  result: boolean = false;
  cartId: number = 0;
  resultofCart: boolean = false;
  isToken: boolean = false;
  //constructor
  constructor(private router: ActivatedRoute, private service: MenuService, private cartService: CartService
    , private loginService: CredentialsService, private route: Router) { }
  //init method
  ngOnInit(): void {
    this.iterateroute();
  }
  //to get the menu list based on the restuarant name
  getMenu(name: string) {
    this.service.getMenuList(name).subscribe((data) => {
      this.menu = data;
      console.log(this.menu);
    },
      e => {
        console.log(e);
      }
    )
  }
  //to get particular restuarant link
  iterateroute() {
    this.router.url.subscribe((url: UrlSegment[]) => {
      this.decision = url[0].path.toString();
      this.getMenu(this.decision);
    });
  }

  //Item is added to cart on clicking the button
  addToCart(menu1: Search) {
    this.cartId = menu1.foodId
    this.cartService.addCart(menu1).subscribe(
      (data) => {
        alert("Item Added Successfully into Item added successfully into cart.Click cart Icon to check Your Items")
        console.log(data);
      },
      (error) => console.log(error)
    );
  }
  //to check the item added or not
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

  //to display the food items based on price in ascending order
  getFoodPriceAsc() {
    this.service.getByFoodPrice().subscribe(data => {
      // this.service.lowToHigh=data;
      this.service.price = data;
      this.route.navigateByUrl("/sort")
      console.log(data);
    })
  }

  //to display the food items based on price in descending order
  getFoodPriceDesc() {
    this.service.getByFoodPriceDesc().subscribe(data => {
      //this.service.highToLow=data;
      this.service.price = data;
      this.route.navigateByUrl("/sort")
      console.log(data);
    })
  }

}
