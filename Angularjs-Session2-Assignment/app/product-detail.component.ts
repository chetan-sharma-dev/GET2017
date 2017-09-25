import { Component, Input } from '@angular/core';

import { Product } from './product';

@Component({
    selector: 'product-detail',
    templateUrl: `./product-details-templete.html`
  })
  export class ProductDetailComponent {
    @Input() product: Product;
  }

