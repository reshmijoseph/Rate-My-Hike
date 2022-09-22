import { Component, OnInit } from '@angular/core';
import { RoutingService } from '../services/routing.service';

@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.css']
})
export class ResourcesComponent implements OnInit {

  constructor(private routingService: RoutingService) { }

  ngOnInit(): void {
  }

  resources(){
    this.routingService.goToResources();
  }

}
