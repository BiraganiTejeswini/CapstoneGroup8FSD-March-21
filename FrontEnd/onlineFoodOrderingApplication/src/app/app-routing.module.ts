import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { FoodSortComponent } from './components/food-sort/food-sort.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginComponent } from './components/login/login.component';
import { PaymentComponent } from './components/payment/payment.component';
import { RegisterComponent } from './components/register/register.component';
import { SearchComponent } from './components/search/search.component';
const routes: Routes = [
  { path: '', redirectTo: 'Adigas', pathMatch: 'full' },
  { path: 'Adigas', component: HomepageComponent },
  { path: 'Udipi', component: HomepageComponent },
  { path: 'Rotighar', component: HomepageComponent },
  { path: 'PunjabiRasoi', component: HomepageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'cart', component: CartComponent },
  { path: 'search', component: HomepageComponent },
  { path: 'searchPage', component: SearchComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'sort', component: FoodSortComponent }

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
