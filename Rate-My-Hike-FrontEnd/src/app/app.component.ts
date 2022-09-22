import { Component } from '@angular/core';
import { Router, RouterConfigOptions } from '@angular/router';
import { RoutingService } from './services/routing.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Rate-My-Hike';

  constructor(private router: Router){}

  clickAccount(){
    this.router.navigate(['account']);
  }
}
