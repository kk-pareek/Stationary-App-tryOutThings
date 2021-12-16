import { Component, OnInit, OnChanges } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CartService } from './cart.service';
import { Product } from 'src/app/model/product';
import { OrderService } from '../order/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  remoteUrlToHit :string ="http://localhost:8084/api/cart/";
  totalSum : number = 0;
  cartProducts : Product[] = [];

  constructor(private theHttpClient : HttpClient, private cartService : CartService, private orderService : OrderService) {  }

  ngOnInit(): void {
    this.cartService.getallProductsinCart();
    this.cartProducts = this.cartService.cart.products;
    this.amount();
  }
  
  deleteProduct(productId : number){
    if(confirm("You want to remove this item from you cart")){
      this.cartService.deleteProductByProductId(productId);
      window.alert("Item removed from cart");
    }
  }

  deleteAllProducts(){
    if(confirm("You want to remove all items from you cart")){
      this.cartService.deleteAllProducts();
      window.alert("All items removed from cart");
    }
  }

  amount(){
    let totalSum : number = 0;
    for(let product of this.cartProducts){
      totalSum = totalSum + (product.productPrice * product.productQty);
    }

    this.totalSum=totalSum;
  }

  increaseCount(product : Product){
    ++product.productQty;
    this.amount();
  }

  decreaseCount(product : Product){
    if(product.productQty > 1){
      product.productQty--;
    }
    this.amount();
  }

  createOrder(){
    this.orderService.createOrder(this.cartProducts);
    window.alert("Order Placed. Thank you for shopping")
  }
}
