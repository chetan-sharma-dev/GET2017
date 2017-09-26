import { Injectable } from '@angular/core';

import { Product } from './app.component';
import { PRODUCTS } from './mock-product';

@Injectable()
export class ProductService {
  getProducts(): Product[] {
    return PRODUCTS;
  }
}