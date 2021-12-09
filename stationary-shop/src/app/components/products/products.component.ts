import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductsService } from 'src/app/components/products/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products : Product[] = [];

  constructor(private productsService : ProductsService) { }

  ngOnInit(): void {
    this.products = this.productsService.getProducts();
    console.log(this.products);
    // console.log(typeof this.products);
  }

}
