import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {TeamService} from './team.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TeamComponent } from './team/team.component';
import { FootballerComponent } from './footballer/footballer.component';

const appRoutes: Routes = [
  {path: 'teams', component: TeamComponent},
  {path: 'players', component: FootballerComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    TeamComponent,
    FootballerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, FormsModule, NgbModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [TeamService],
  bootstrap: [AppComponent]
})
export class AppModule { }
