import { Component, OnInit } from '@angular/core';
import { PRODUCTS } from './mock-product';
import { ProductService } from './product.service';

export class Product {
  id: number;
  name: string;
  phone:number;
}



@Component({
  selector: 'my-app',
  template: `
  <h1>{{title}}</h1>
  <h2>My Products</h2>
  <ul class="products">
    <li *ngFor="let product of products"
      [class.selected]="product === selectedProduct"
      (click)="onSelect(product)">
      <span class="badge">{{product.id}}</span> {{product.name}}
    </li>
  </ul>
  <div *ngIf="selectedProduct">
    <h2>{{selectedProduct.name}} details!</h2>
    <div><label>id: </label>{{selectedProduct.id}}</div>
    <div>
      <label>name: </label>
      <input [(ngModel)]="selectedProduct.name" placeholder="name"/>
    </div>
  </div>
    `,
    styles: [`
    .selected {
      background-color: #CFD8DC !important;
      color: white;
    }
    .products {
      margin: 0 0 2em 0;
      list-style-type: none;
      padding: 0;
      width: 15em;
    }
    .products li {
      cursor: pointer;
      position: relative;
      left: 0;
      background-color: #EEE;
      margin: .5em;
      padding: .3em 0;
      height: 1.6em;
      border-radius: 4px;
    }
    .products li.selected:hover {
      background-color: #BBD8DC !important;
      color: white;
    }
    .products li:hover {
      color: #607D8B;
      background-color: #DDD;
      left: .1em;
    }
    .products .text {
      position: relative;
      top: -3px;
    }
    .products .badge {
      display: inline-block;
      font-size: small;
      color: white;
      padding: 0.8em 0.7em 0 0.7em;
      background-color: #607D8B;
      line-height: 1em;
      position: relative;
      left: -1px;
      top: -4px;
      height: 1.8em;
      margin-right: .8em;
      border-radius: 4px 0 0 4px;
    }
  `]
})



export class AppComponent {
  title = 'Tour of Products';
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

