import { Component, OnInit } from '@angular/core';
import { PRODUCTS } from './mock-product';
import { ProductService } from './product.service';

import {Product} from './product';


@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
    styleUrls : ['./app.component.css'],
})



export class AppComponent {
  title = 'List of Products';
  products : Product[];
  selectedProduct: Product;

  constructor(private productService: ProductService) { }
  
   getProducts(): void {
     this.products = this.productService.getProducts();
   }
  
   ngOnInit(): void {
     this.getProducts();
   }

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }
}

