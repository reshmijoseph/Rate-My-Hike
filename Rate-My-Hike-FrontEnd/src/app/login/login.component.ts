import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { AuthService } from '../services/auth.service';
import { RoutingService } from '../services/routing.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User = new User();
  errorMessage = "";

  constructor(private authService:AuthService, private routingService:RoutingService) { }

  ngOnInit(): void {
  }

  login(){
    let users = {username: this.user.username, password: this.user.password};
    this.authService.authenticateUser(this.user).subscribe({
      next:(response)=>{
        console.log(response);
        this.authService.setToken(response['token']);
        console.log(this.authService.getToken())
        this.user = new User();
        this.routingService.goToHome();
      },
      error:()=>{console.log('error');}
    })
  }

}
