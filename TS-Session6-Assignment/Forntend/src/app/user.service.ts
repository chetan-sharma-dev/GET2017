import { Injectable } from '@angular/core';
import { Headers,Http } from '@angular/http';
import { MiniCart } from './minicart';
import 'rxjs/add/operator/toPromise';

import { User } from './user';


@Injectable()
export class UserService{

    private headers = new Headers({'Content-Type': 'application/json'});

    private userAddUrl = 'http://localhost:8080/shoppinghibernate/rest/user/add'; // Add product URL
    private userGetUrl = 'http://localhost:8080/shoppinghibernate/rest/user/get';
    
    minicart : MiniCart;
    constructor(private http : Http  ){
        
    }

    private handleError (error : any) : Promise<any> {
        console.error('an errored ocured',error);
        return Promise.reject(error.message||error);
    }

     getLoggedInUser() :string{
         let email = localStorage.getItem('useremail');
         console.log(email);
         return email;
     }

     getLoggedInUserId() : number {
         let userId = localStorage.getItem('userId');
         return +userId;
     }

     getTotalCost() : number {
         let totalcost = localStorage.getItem('totalcost');
         return +totalcost;
     }
     



    getUser(email : string) : Promise<MiniCart> {
        const url = `${this.userGetUrl}/${email}`;
        return this.http.get(url)
        .toPromise()
       .then(response => response.json() as MiniCart )
        .catch(this.handleError); 
    }

    

    saveUser(email: string) {
        localStorage.setItem('useremail',email);
    }

}