import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms'; // <-- NgModel lives here
import { RouterModule }   from '@angular/router';
import { HttpModule }    from '@angular/http';

// Imports for loading & configuring the in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';
import { AppRoutingModule }     from './app-routing.module';

import { AppComponent }  from './app.component';
import { ProductsComponent } from './products.component';
import { DashboardComponent } from './dashboard.component';
import { ContactusComponent } from './contactus.component';
import { ProductService }  from './product.service';
import {ProductDetailComponent } from './product-detail.component';
import {ProductDetailEditComponent} from './product-detail-edit.component';
import {AddProductComponent} from './add-product.component';
import { ProductSearchComponent} from './product-search.component';
import { DeleteProductComponent } from './delete-product.component';

@NgModule({
  imports:      [ 
        BrowserModule ,
        FormsModule ,
        HttpModule,
        InMemoryWebApiModule.forRoot(InMemoryDataService),
        AppRoutingModule
      ],
  declarations: [ 
      AppComponent ,
      ProductDetailComponent ,
      ProductsComponent,
      DashboardComponent,
      ContactusComponent,
      ProductDetailEditComponent,
      AddProductComponent,
      ProductSearchComponent,
      DeleteProductComponent
      ],
  bootstrap:    [ AppComponent ],
  providers: [ProductService]
})
export class AppModule { }
