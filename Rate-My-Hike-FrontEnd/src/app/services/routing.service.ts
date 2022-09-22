import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { userInfo } from 'os';

@Injectable({
    providedIn: 'root'
})
export class RoutingService {

    constructor(private router : Router) { }

    goToLogin(){
        this.router.navigate(['login'])
    }
    goToHome(){
        this.router.navigate(['home'])
    }
}