"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
require("rxjs/add/operator/toPromise");
var UserService = (function () {
    function UserService(http) {
        this.http = http;
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        this.userAddUrl = 'http://localhost:8080/shoppinghibernate/rest/user/add'; // Add product URL
        this.userGetUrl = 'http://localhost:8080/shoppinghibernate/rest/user/get';
    }
    UserService.prototype.handleError = function (error) {
        console.error('an errored ocured', error);
        return Promise.reject(error.message || error);
    };
    UserService.prototype.getLoggedInUser = function () {
        var email = localStorage.getItem('useremail');
        console.log(email);
        return email;
    };
    UserService.prototype.getLoggedInUserId = function () {
        var userId = localStorage.getItem('userId');
        return +userId;
    };
    UserService.prototype.getTotalCost = function () {
        var totalcost = localStorage.getItem('totalcost');
        return +totalcost;
    };
    UserService.prototype.getUser = function (email) {
        var url = this.userGetUrl + "/" + email;
        return this.http.get(url)
            .toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    UserService.prototype.saveUser = function (email) {
        localStorage.setItem('useremail', email);
    };
    return UserService;
}());
UserService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], UserService);
exports.UserService = UserService;
//# sourceMappingURL=user.service.js.map