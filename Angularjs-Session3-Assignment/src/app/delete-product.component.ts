import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';
import 'rxjs/add/operator/switchMap';

import { ProductService } from './product.service';
import { Product } from './product';

@Component({
    selector: 'delete-product',
    template : ` `
  })
  export class DeleteProductComponent implements OnInit {

    constructor(
      private productService: ProductService,
      private route: ActivatedRoute,
      private location: Location
    ) {}

    ngOnInit(): void {
      this.route.paramMap
        .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
        .subscribe(product => this.product = product);
       
    }
    @Input() product: Product;

    goBack(): void {
        this.location.back();
      }

    delete(product: Product): void {
        
        this.productService
            .delete(product.id)
            .then(() => this.goBack());
      }
    
    

  }

