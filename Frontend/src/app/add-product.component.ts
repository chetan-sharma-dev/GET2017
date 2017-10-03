import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Location }                 from '@angular/common';
import 'rxjs/add/operator/switchMap';

import { ProductService } from './product.service';
import { Product } from './product';

@Component({
    selector: 'add-product-component',
    templateUrl: `./add-product-component.html`
  })


  
export class AddProductComponent {
  
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
   add(name: string,price:string): void {
      name = name.trim();
    
      if (!name) { return; }
      this.productService.create(name,+price)
        .then(product => {
          this.products.push(product);
          this.selectedProduct = null;
        });
        alert('product successfully added ');
        this.router.navigate(['/products']);
    }
  
  
  }