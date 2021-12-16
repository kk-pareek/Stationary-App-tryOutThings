import { Injectable } from '@angular/core';
import { Product } from 'src/app/model/product';
import { HttpClient } from '@angular/common/http';
import { Cart } from 'src/app/model/cart';
// import { products } from 'src/assets/json/products';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  remoteUrlToHit :string ="http://localhost:8084/api/cart/";
  
  customerId : number = 7;
  cart : Cart = {
    customerId : this.customerId,
    products : []
  }
  constructor(private httpClient : HttpClient) { }

  addToCart(product : Product){
    if(this.checkCart(product)){
      window.alert("Item is already available in cart");
      return;
    }
    this.httpClient.post(this.remoteUrlToHit+"add/product/"+this.customerId, product).subscribe(data => {     
    });
    window.alert("Item added to cart");
    this.getallProductsinCart();
  }

  checkCart(product : Product){
    for(let cartProduct of this.cart.products){
      if(cartProduct.productId === product.productId){
        return true;
      }
    }

    return false;
  }

  getallProductsinCart(){
    this.httpClient.get(this.remoteUrlToHit+this.cart.customerId).subscribe(data => {
      this.cart = data as Cart;
      // console.log(this.cart);
    });
  }

  deleteProductByProductId(productId : number){
    this.httpClient.delete(this.remoteUrlToHit+"delete/"+this.cart.customerId+"/"+productId).subscribe(
      data => {
        this.getallProductsinCart();        
    });
    this.getallProductsinCart();
  }

  deleteAllProducts(){
    this.httpClient.delete(this.remoteUrlToHit+"delete/"+this.cart.customerId).subscribe(data => {
      this.getallProductsinCart();
    });
    this.getallProductsinCart();
  }

}
