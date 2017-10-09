import { Component, OnInit } from '@angular/core';
import { PRODUCTS } from './mock-product';
import { ProductService } from './product.service';

import {Product} from './product';
import { Router } from '@angular/router';
@Component({
  selector: 'cart-products',
  templateUrl: './product-component-templete.html',
    styleUrls : ['./product.component.css'],
})



export class ProductsComponent {
  title = 'List of Products';
  products : Product[];
  selectedProduct: Product;

  constructor(private router: Router,private productService: ProductService) { }

  
  getProducts(): void {
    this.productService
        .getProducts()
        .then(products => this.products = products);
  }
   ngOnInit(): void {
    this.getProducts();
  /*  this.productService.getProducts()
    .then(products => this.products = products);*/
  }

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  gotoDetail( selectedProduct:Product): void {
    this.selectedProduct = selectedProduct;
    this.router.navigate(['/detail', this.selectedProduct.id]);
  }
  gotoAddPage(): void {
    
    this.router.navigate(['/addproduct']);
  }

  gotoDetailEdit( selectedProduct:Product): void {
    this.selectedProduct = selectedProduct;
    this.router.navigate(['/editdetail', this.selectedProduct.id]);
  }

  gotoDelete( selectedProduct:Product): void {
    this.selectedProduct = selectedProduct;
    this.router.navigate(['/delete', this.selectedProduct.id]);
  }
  add(name: string,price:string): void {
    name = name.trim();
  
    if (!name) { return; }
    this.productService.create(name,+price)
    
      .then(product => {
        this.products.push(product);
        this.selectedProduct = null;
      });
  }
/*
  delete(product: Product): void {
    this.productService
        .delete(product.id)
        .then(() => {
          this.products = this.products.filter(h => h !== product);
          if (this.selectedProduct === product) { this.selectedProduct = null; }
        });
  }
  */
}

