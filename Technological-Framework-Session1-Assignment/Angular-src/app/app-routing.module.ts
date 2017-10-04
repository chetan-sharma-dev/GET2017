import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { DashboardComponent }   from './dashboard.component';
import { ProductsComponent } from './products.component';
import {ProductDetailComponent } from './product-detail.component';
import { ContactusComponent } from './contactus.component';
import { ProductDetailEditComponent } from './product-detail-edit.component';
import { AddProductComponent } from './add-product.component';
import { DeleteProductComponent } from './delete-product.component';

const routes: Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'dashboard',  component: DashboardComponent },
    { path: 'detail/:id', component: ProductDetailComponent },
    { path: 'editdetail/:id', component: ProductDetailEditComponent },
    { path: 'products',     component:  ProductsComponent },
    { path: 'contactus',  component: ContactusComponent},
    { path: 'addproduct', component:AddProductComponent },
    { path: 'delete/:id' , component:DeleteProductComponent}
  
  
  ];
   
  @NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
  })
  export class AppRoutingModule {}