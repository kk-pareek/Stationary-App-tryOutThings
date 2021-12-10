import { Injectable } from '@angular/core';
import { Product } from 'src/app/model/product';
import { products } from 'src/assets/json/products';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartProducts : Product[] = [];

  constructor() { }

  addToCart(product : Product){
    this.cartProducts.push(product);
    console.log(this.cartProducts);
  }

  removeFromCart(product : Product){
    // this.cartProducts.;
  }

  getCartProducts(){
    return this.cartProducts;
  }
}
