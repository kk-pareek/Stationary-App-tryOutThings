import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductsService } from 'src/app/components/products/products.service';
import { CartService } from '../cart/cart.service';
import { Cart } from 'src/app/model/cart';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products : Product[];

  constructor(private productsService : ProductsService, private cartService : CartService) {
    this.products = this.productsService.getProducts();
   }

  ngOnInit(): void {
    // this.products = this.productsService.getProducts();
    // console.log(this.products);
    // console.log(typeof this.products);
  }

  addToCart(product : Product){
    this.cartService.addToCart(product);
  }
}
