import { Component, OnInit } from '@angular/core';
import { RoutingService } from '../services/routing.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(private routingService: RoutingService) { }

  ngOnInit(): void {
  }

  account(){
    this.routingService.goToAccount();
  }
}
