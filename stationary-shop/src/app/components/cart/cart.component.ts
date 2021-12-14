import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/model/order';
import { Product } from 'src/app/model/product';
import { products } from 'src/assets/json/products';
import { OrderService } from '../order/order.service';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartProducts : Product[] = [];
  customerId : number = 7;
  totalPrice = 0;

  constructor(private cartService : CartService, private orderService : OrderService) { }

  ngOnInit(): void { 
    this.cartProducts = this.cartService.getCartProducts();
    for (const product of this.cartProducts) {
      this.totalPrice = this.totalPrice + product.productPrice;
    }
   }

  onRemove(productId: number) {
    if(confirm("Do you want to remove this item")){
      this.cartProducts = this.cartService.removeFromCart(productId);
      this.totalPrice = 0;
      for (const product of this.cartProducts) {
       this.totalPrice = this.totalPrice + product.productPrice;
      } 
    }
  }

  priceIncrease(price: number) {
    this.totalPrice = this.totalPrice + price;
  }

  priceDecrease(price: number) {
    this.totalPrice = this.totalPrice - price;
  }

  createOrder() {
    this.orderService.createOrder(this.cartProducts);
  }

}
