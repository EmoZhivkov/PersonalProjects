import {Component, Input, OnInit} from '@angular/core';
import {ApiService} from "../api.service";
import {parseHttpResponse} from "selenium-webdriver/http";

@Component({
  selector: 'app-echo',
  templateUrl: './echo.component.html',
  styleUrls: ['./echo.component.css']
})
export class EchoComponent implements OnInit {

  @Input()
  public input: string;

  constructor(private apiService: ApiService) { }

  ngOnInit() {
  }

  getEcho(input: string) {
    this.apiService.postEcho(input).subscribe((data) => {
      this.input = data[0];
      console.log(data[0]);
    });
  }
}
