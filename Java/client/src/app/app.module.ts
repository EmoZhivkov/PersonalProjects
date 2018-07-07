import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { CarService } from './shared/car/car.service';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CarListComponent } from './car-list/car-list.component';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    CarListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
