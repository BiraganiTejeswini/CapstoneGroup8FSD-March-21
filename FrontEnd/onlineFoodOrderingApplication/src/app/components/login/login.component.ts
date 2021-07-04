import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/login';
import { CredentialsService } from 'src/app/services/credentials.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  //variable declaration 
  customerEmail: string = "";
  model: any = {}
  login2: Login = new Login();
  email: string = "";
  customerId: number = 0;
  lastName: string = "";
  firstName: string = "";
  id: number = 0;
  //constructor
  constructor(private router: Router, private service: CredentialsService, private credService: CredentialsService) { }
  //init method
  ngOnInit(): void {
  }

  //to  login into application
  login(email: string, password: string) {
    this.service.getLoginCredentails(email, password).subscribe(data => {
      this.service.customerEmail = this.customerEmail;
      this.service.setToken(data.token);
      this.service.submitted = true;
      this.router.navigateByUrl("/Adigas")
    },
      e => {
        console.log(e)
        alert("Please enter correct credentials")
      }
    )
  }
}
