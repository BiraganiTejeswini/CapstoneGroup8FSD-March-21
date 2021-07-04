import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Address } from 'src/app/model/address';
import { Card } from 'src/app/model/Card';
import { Customer } from 'src/app/model/customer';
import { orderDetails } from 'src/app/model/orderDetails';
import { State } from 'src/app/model/state';
import { AddressService } from 'src/app/services/address.service';
import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';
import { OrderService } from 'src/app/services/order.service';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  //variables declaration
  customer: Customer = new Customer();
  card: Card = new Card();
  address: Address = new Address();
  orderDetails: orderDetails = new orderDetails();
  email: string = "";
  customerId: number = 0;
  lastName: string = "";
  firstName: string = "";
  id: number = 0;
  registerForm: any;
  //constructor
  constructor(
    private addressService: AddressService,
    private orderService: OrderService,
    private menuService: MenuService,
    private builder: FormBuilder,
    private cartService: CartService, private credentialService: CredentialsService
  ) { }
  //init method
  ngOnInit(): void {
    this.getStates();
    this.buildForm();
    this.getCustomerDetails(this.email);
  }
  //to validate customer details
  buildForm() {
    this.registerForm = this.builder.group({
      FirstName: ['', Validators.required, Validators.minLength(2)],
      LastName: ['', Validators.required, Validators.minLength(2)],
      email: ['', [Validators.required, Validators.email]],
    })
  }
  //to remove all cart items
  cartClearItems() {
    this.cartService.cartClearItems().subscribe((data) => {
    })
  }
  //to store the order details 
  saveOrderDetails() {
    alert('Your Order is placed successfully');
    this.address.totalPrice = this.menuService.totalPrice;
    this.address.totalQuantity = this.menuService.totalQuantity;
    this.orderService.addOrderDetails(this.address).subscribe((data => {
    }))
  }

  //to get states for displaying in dropdown
  states: Array<State> = [];
  getStates() {
    this.addressService.getAllStates().subscribe(data => {
      this.states = data;
      console.log(data);
    })
  }
  //to get predefined values in customer form
  getCustomerDetails(email: string) {
    this.email = this.credentialService.customerEmail;
    console.log("my email: ", this.email)
    this.credentialService.getCustomerDetails(this.email).subscribe((data) => {
      this.id = data.customerId;
      this.firstName = data.firstName;
      this.lastName = data.lastName;
    });
  }
}


