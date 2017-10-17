import { NgModule } from '@angular/core';
import { RouterModule , Routes } from '@angular/router';

import { ProductsComponent } from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { DashboardComponent } from './dashboard.component';
import { ProductEditComponent } from './product-edit.component';
import { AddProductComponent } from './add-product.component';
import { ContactUs } from './contactus.component';
import { CartComponent } from './cart.component';
import { LoginComponent } from './app-login.component';
import { AppHeaderComponent } from './app-header.component';
import { CheckoutComponent } from './checkout.component';
import { MyOrderComponent } from './myorder.component';
import { OrderDetailComponent } from './orderdetail.component';


const routes : Routes = [

  {
    path:'main',
    component : AppHeaderComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent},
      {
        path:'products',
        component : ProductsComponent
      },
      {
        path : 'contactus',
        component : ContactUs
      },
      {
        path : 'cart',
        component : CartComponent,
      },
      {
        path : 'checkout',
        component : CheckoutComponent
      },
      {
        path : 'myorders',
        component : MyOrderComponent
      },
      {
        path : 'orderdetail/:orderId',
        component : OrderDetailComponent
      }
    ]
  },
      
        {
          path : 'dashboard',
          component : DashboardComponent
        },
      {
        path : '',
        component : LoginComponent

      },
      {
        path : 'detail/:id',
        component : ProductDetailComponent
      },
      {
        path : 'edit-product/:id',
        component : ProductEditComponent
      },
      {
        path : 'addProduct',
        component : AddProductComponent
      }
];

@NgModule({
    imports : [ RouterModule.forRoot(routes) ],
    exports : [ RouterModule ]
})

export class AppRoutingModule{

}