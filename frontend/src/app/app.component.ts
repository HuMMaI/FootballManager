import { Component, OnInit } from '@angular/core';
import {Team} from './team';
import {NgForm} from '@angular/forms';
import {TeamService} from './team.service';
import {HttpErrorResponse} from '@angular/common/http';
import {FootballerService} from './footballer.service';
import {TeamComponent} from './team/team.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }


}
