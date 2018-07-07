import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from "./app-routing.module";
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from './app.component';
import { ServiceHealthComponent } from './service-health/service-health.component';
import { UiComponent } from './ui/ui.component';
import { EchoComponent } from './echo/echo.component';

@NgModule({
  declarations: [
    AppComponent,
    ServiceHealthComponent,
    UiComponent,
    EchoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
