import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './user.service';
import { User } from './user';

@Component({
    selector: 'app-login',
    templateUrl: './app-login.component.html'
})
export class LoginComponent {
   
    constructor(private router: Router , private userservice : UserService  ){
       
    }

    public onLoginClick(email : string){
        if(email !== undefined || email !== ''){
            this.userservice.saveUser(email);
        }
        console.log(this.userservice.getUser(email).then(response => localStorage.setItem('userId', response.user.id.toString() )));
        this.router.navigate(['main/dashboard']);
    }
}