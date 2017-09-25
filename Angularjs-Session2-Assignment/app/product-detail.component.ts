import { Component, Input } from '@angular/core';

import { Product } from './product';

@Component({
    selector: 'product-detail',
    template: `
    <div class="container text-center">
    <div *ngIf="product" class="col-xs-12 col-sm-6 ">
      <div class="panel panel-primary">
          <div class="panel-heading">
            <h3>  {{product.name}} details!</h3>
          </div>
          <div class="panel-body">
              <table class="table table-bordered">
                  <tbody>
                      <tr>
                            <td>
                                <label>id: </label>
                            </td>
                          <td>
                              {{product.id}}
                          </td>
                      </tr>
    
                      <tr>
                          <td>
                              <label>Name: </label>
                          </td>
                        <td>
                            {{product.name}}
                        </td>
                    </tr>
    
                    <tr>
                        <td>
                            <label>Price: </label>
                        </td>
                      <td>
                          {{product.price}}
                        <!-- <input [(ngModel)]="selectedProduct.price" placeholder="price"/>-->
                      </td>
                  </tr>
                    </tbody>
                </table>
            
          </div>
      </div>
    </div>
    </div>
    `
  })
  export class ProductDetailComponent {
    @Input() product: Product;
  }

