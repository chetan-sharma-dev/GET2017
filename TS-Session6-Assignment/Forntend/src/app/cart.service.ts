import { Injectable } from '@angular/core';
import { Product } from './Product';
import { Headers,Http, RequestOptionsArgs } from '@angular/http';
import { UserService } from './user.service';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class CartService {

    private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http : Http , private userService : UserService){}

    private AddToCart = 'http://localhost:8080/shoppinghibernate/rest/user/add';
    private GetCartProducts = 'http://localhost:8080/shoppinghibernate/rest/user/getcart';
    private DeleteProductFromCart = 'http://localhost:8080/shoppinghibernate/rest/user/delete';

    static products : Product[] = [];

    getCartProducts() : Promise<Product[]>{

        let userId = this.userService.getLoggedInUserId();
        const url = `${this.GetCartProducts}/${userId}`;
        
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as Product[]);
        
    }

    addProductToCart(product : Product) : Promise<Product>
    {
        let userId = this.userService.getLoggedInUserId();
        const url = `${this.AddToCart}`;
        
        return this.http.post( url , JSON.stringify({
            productId : product.id , userId : userId 
        }), {headers:this.headers} )
        .toPromise()
        .then(res => res.json());
        

    }
    deleteProductFromCart(product : Product){
        let userId = this.userService.getLoggedInUserId();
        const url = `${this.DeleteProductFromCart}`;
        let options: RequestOptionsArgs;
        options = {};
        options.headers = this.headers;
        options.body = JSON.stringify({
            productId : product.id , userId : userId 
        });
        return this.http.delete(url , options)
        .toPromise()
        .then((response)=> console.log(response.json()));
    }
}