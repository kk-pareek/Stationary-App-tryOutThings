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

  createOrderUrl = "http://localhost:8083/api/order/create";

  constructor(private httpClient : HttpClient) { 
    this.order = {
      customerId : this.customerId,
      products : []
    };
  }

  createOrder(cartProducts : Product[]){
    this.order.products = cartProducts;
    
    this.httpClient.post(this.createOrderUrl, this.order).subscribe(data => {
      console.log(data);
    });
  }




}
