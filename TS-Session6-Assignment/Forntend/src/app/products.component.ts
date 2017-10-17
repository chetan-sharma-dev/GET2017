import { Component,Injectable ,Output, EventEmitter } from '@angular/core';
import { Product } from './Product';
import { ProductService} from './product.service';
import { OnInit } from '@angular/core';
import { CartService } from './cart.service';
import { MiniCart } from './minicart';
import { AppHeaderComponent } from './app-header.component'; 


@Component({
  selector: 'my-products',
  templateUrl: './products.component.html',
  styleUrls:['./products.component.css'],
  providers:[ProductService , CartService ]
})


export class ProductsComponent implements OnInit { 
  
  products : Product[];
  selectedProduct : Product;
  constructor(
    private productservice : ProductService,
    private cartService : CartService,
    private appheadcomp : AppHeaderComponent
  ){}

  @Output() minicart = new EventEmitter<number>();

  getProduct() : void{
    this.productservice.getProducts().then(products => this.products=products);
  }

  ngOnInit():void{
    this.getProduct();
  }

  onSelect(product : Product) : void {
    this.selectedProduct = product;
  }

  delete(product : Product) : void{
    this.productservice.delete(product.id)
    .then( ()=> {
      this.products=this.products.filter( p => p !== product );
      if(this.selectedProduct===product){
        this.selectedProduct=null;
      }
    } )
  }

  addToCart(product : Product) : void {
      this.cartService.addProductToCart(product).then(() => this.appheadcomp.ngOnInit() );
      alert("product has been added to the cart");
      


  }
  

}

