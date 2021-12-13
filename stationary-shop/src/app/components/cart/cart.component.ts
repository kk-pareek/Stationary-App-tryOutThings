import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartProducts : Product[] = [];
  totalPrice = 0;

  constructor(private cartService : CartService) { }

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

}
