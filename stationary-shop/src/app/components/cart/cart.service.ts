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
    for (let cartProduct of this.cartProducts){
      if(cartProduct.productId === product.productId){
        // window.alert("Item is already in cart");
        return;
      }
    }
    this.cartProducts.push(product);
    // console.log(this.cartProducts);
  }

  removeFromCart(productId : number){
    this.cartProducts = this.cartProducts.filter(product => product.productId !== productId);
    return this.cartProducts;
  }

  getCartProducts(){
    return this.cartProducts;
  }
}
