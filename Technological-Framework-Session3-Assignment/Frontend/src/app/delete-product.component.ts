import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';
import 'rxjs/add/operator/switchMap';

import { ProductService } from './product.service';
import { Product } from './product';

@Component({
    selector: 'delete-product',
    template : `
    DELETING PRODUCT
        
     `
  })
  export class DeleteProductComponent implements OnInit {

    id: number;
    private sub: any;
  
   
    constructor(
      private productService: ProductService,
      private route: ActivatedRoute,
      private location: Location,
    ) {}

    ngOnInit(): void {
        this.sub = this.route.params.subscribe(params => {
          this.id = +params['id']; 
          this.delete();
       });
        
        
       
    }
    
    goBack(): void {
      
        this.location.back();
      }


      delete(): void {
        alert('product deleted successfully');
        this.productService
            .delete(this.id)
            .then(() => this.goBack());
      }
    
    

  }

