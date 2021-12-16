import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../../model/order';
import { Product } from 'src/app/model/product';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  order : Order;
  customerId : number = 7;

  OrderUrl = "http://localhost:8083/api/order/";

  constructor(private httpClient : HttpClient) { 
    this.order = {
      customerId : this.customerId,
      products : []
    };
  }

  createOrder(cartProducts : Product[]){
    this.order.products = cartProducts;
   
    // console.log(this.order.products);
    
    this.httpClient.post(this.OrderUrl+"create", this.order).subscribe(data => {
      console.log(data);
    });
  }




}
