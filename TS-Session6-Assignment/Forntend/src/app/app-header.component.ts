import { Component, Input,OnInit } from '@angular/core';
import { UserService } from './user.service';
import { MiniCart } from './minicart';
import { Product } from './product';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-header',
    templateUrl: './app-header.component.html',
    styleUrls : ['./app-header.component.css']
})
export class AppHeaderComponent implements OnInit {
    @Input() public title = "Shopping Cart";
    @Input() public isUserLoggedIn: boolean;
    @Input() minicart : MiniCart;
    constructor(private userservice : UserService ,  private router: Router){}

    ngOnInit(){
        this.userservice.getUser(this.userservice.getLoggedInUser()).then((response) => {
            this.minicart = response;localStorage.setItem('totalcost',this.minicart.totalCost.toString());
        });
         

    }

    LogOut(){
        localStorage.clear();
        this.router.navigate(['']);
    }
    


}