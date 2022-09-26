import { Component, OnInit } from '@angular/core';
import { Loader } from '@googlemaps/js-api-loader';
import { ElementRef } from '@angular/core';
import { Map } from '@angular/google-maps';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  // user:User = new User();
  // errorMessage = "";

  // constructor(private authService:AuthService, private routingService:RoutingService) { }

  // ngOnInit(): void {
  // }
  map:Map = new Map();
  errorMessage = "";

  constructor()
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
 
  
  const center: google.maps.LatLngLiteral = {lat: 30, lng: -110};
  
  function initMap(): void {
    map = new google.maps.Map(document.getElementById("map") as HTMLElement, {
      center,
      zoom: 8
    });
  }