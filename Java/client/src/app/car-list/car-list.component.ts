import { Component, OnInit } from '@angular/core';
import { CarService } from '../shared/car/car.service';

export class CarListComponent implements OnInit {
  cars: Array<any>;

  constructor(private carService: CarService) { }

  ngOnInit() {
    this.carService.getAll().subscribe(data => {
      this.cars = data;
    });
  }
}
