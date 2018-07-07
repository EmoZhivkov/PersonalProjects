import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ServiceHealthComponent} from "./service-health/service-health.component";
import {UiComponent} from "./ui/ui.component";


const routes: Routes = [
  {
    path:  'api/health',
    component:  ServiceHealthComponent
  },
  {
    path:  'ui',
    component:  UiComponent
  }/*,
  {
    path: 'api/echo',
    component: EchoComponent
  }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
