import { Component } from '@angular/core';
import { ProductsService } from './components/products/products.service';
import { CartService } from './components/cart/cart.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'stationary-shop';

  constructor(private productService : ProductsService, private cartService : CartService){
    productService.getProducts();
    cartService.getallProductsinCart();
  }
}
