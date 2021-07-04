import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CredentialsService } from 'src/app/services/credentials.service';

//to check the password matching
function passwordsMatchValidator(form: any) {
  const password = form.get('password')
  const confirmPassword = form.get('confirmPassword')

  if (password.value !== confirmPassword.value) {
    confirmPassword.setErrors({ passwordsMatch: true })
  } else {
    confirmPassword.setErrors(null)
  }

  return null
}

/**
 * If the data is valid return null else return an object
 */
//to check the symbol existence
function symbolValidator(control: any) {
  if (control.hasError('required')) return null;
  if (control.hasError('minlength')) return null;

  if (control.value.indexOf('@') > -1) {
    return null
  } else {
    return { symbol: true }
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  //variables declaration
  [x: string]: any;
  customer: Customer = new Customer();
  //constructor
  constructor(private builder: FormBuilder, private router: Router, private service: CredentialsService) { }
  //init method
  ngOnInit() {
    this.buildForm()
  }
  //to check the validations
  buildForm() {
    this.registerForm = this.builder.group({
      firstName: ['', [Validators.required, Validators.minLength(2)]],
      lastName: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, symbolValidator, Validators.minLength(6), Validators.maxLength(15)]],
      confirmPassword: ''
    }, {
      validators: passwordsMatchValidator
    })
  }
  //To register Customer
  register() {
    this.service.addCustomer(this.customer).subscribe(data => {
      this.service.submitted = true;
      console.log(data);

      this.router.navigateByUrl("/login")
    },
      e => {
        this.responseMessage = e.error.message;
        alert("Email id Already Exits Sign up with Another Email")
        console.log(e);
      })
  }



}