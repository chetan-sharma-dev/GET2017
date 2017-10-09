import { Injectable } from '@angular/core';

import { Product } from './product';
import { PRODUCTS } from './mock-product';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProductService {

  //private productsUrl = 'http://localhost:8080/layered-arch/service/product/list'; 
  private productsUrl = 'http://localhost:8080/shoppinghibernate/rest/product'; 
  
  constructor(private http: Http) { }


  getProducts(): Promise<Product[]>{
    //return  Promise.resolve(PRODUCTS);
    return this.http.get(this.productsUrl+"/list")
    .toPromise()
    .then(response => response.json() as Product[])
    .catch(this.handleError);
  }
  
   
private handleError(error: any): Promise<any> {
  console.error('An error occurred', error); // for demo purposes only
  return Promise.reject(error.message || error);
}

  getProduct(id: number): Promise<Product>{
   // return  this.getProducts().then(products => products.find(product => product.id === id));
  const url = `${this.productsUrl+"/get"}/${id}`;
  return this.http.get(url)
    .toPromise()
    .then(response => response.json() as Product)
    .catch(this.handleError);
  }

  private headers = new Headers({'Content-Type': 'application/json'});
  
  update(product: Product): Promise<Product> {
    const url = `${this.productsUrl+"/edit"}/${product.id}`;
    return this.http
      .put(url, JSON.stringify(product), {headers: this.headers})
      .toPromise()
      .then(() => product)
      .catch(this.handleError);
  }

  create(name: string,price:number): Promise<Product> {
    return this.http
      .post(this.productsUrl+"/add", JSON.stringify({name: name,price: price}), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Product)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.productsUrl+"/delete"}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

}