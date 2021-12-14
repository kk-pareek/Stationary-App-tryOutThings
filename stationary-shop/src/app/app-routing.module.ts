import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { PaymentComponent } from './components/payment/payment.component';
import { ProductsComponent } from "./components/products/products.component";
import { CartComponent } from './components/cart/cart.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
<<<<<<< HEAD
import { RegisterPageComponent } from './components/register-page/register-page.component';
=======
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
>>>>>>> 55ed99fc9fd8bbeb687e19196b8ff592e9bf122e

const routes: Routes = [
  {path: "login", component: RegisterPageComponent},
  {path: "products", component: ProductsComponent},
  {path: "cart", component: CartComponent},
  {path: "payment", component: PaymentComponent},
  {path: "contact", component: ContactComponent},
  {path: "", component: HomeComponent},
  {path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
