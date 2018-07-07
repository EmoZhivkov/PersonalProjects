import { Component, OnInit } from '@angular/core';
import {ApiService} from "../api.service";

@Component({
  selector: 'app-service-health',
  templateUrl: './service-health.component.html',
  styleUrls: ['./service-health.component.css']
})
export class ServiceHealthComponent implements OnInit {

  public health: string;

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getHealth();
  }

  public getHealth() {
    this.apiService.getHealth().subscribe((data) => {
     this.health = data[0];
     console.log(data[0]);
    },
      (msg) => { console.log('Error: ', msg);
      console.log(msg);
    });
  }

}
