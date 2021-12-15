import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './components/product/product.component';
import { ProductsComponent } from './components/products/products.component';
import { NavComponent } from './components/nav/nav.component';
import { LoginComponent } from './components/login/login.component';
import { PaymentComponent } from './components/payment/payment.component';
import { CartComponent } from './components/cart/cart.component';
import { ProductsService } from './components/products/products.service';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { ItemCountComponent } from './components/cart/item-count/item-count.component';

import { RegisterPageComponent } from './components/register-page/register-page.component';
import { AddCustomerService } from './components/register-page/add-customer.service';
import { FormsModule } from '@angular/forms';

import { CustomerComponent } from './components/customer/customer.component';
import { OrderComponent } from './components/order/order.component';
import { OrderService } from './components/order/order.service';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';



@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ProductsComponent,
    NavComponent,
    LoginComponent,
    PaymentComponent,
    CartComponent,
    ContactComponent,
    HomeComponent,
    ItemCountComponent,
    RegisterPageComponent,
    CustomerComponent,
    OrderComponent,
    PageNotFoundComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ProductsService,
    AddCustomerService,
    OrderService
  ],

  bootstrap: [AppComponent]

})
export class AppModule { }
