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
import { TeamInfoComponent } from './team-info/team-info.component';
import {TeamInfoPlayersComponent} from './team-info/team-info.players.component';
import {TeamInfoFreePlayersComponent} from './team-info/team-info.free-players.component';

const appRoutes: Routes = [
  {path: 'teams', component: TeamComponent},
  {path: 'players', component: FootballerComponent},
  {path: 'team', component: TeamInfoComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    TeamComponent,
    FootballerComponent,
    TeamInfoComponent,
    TeamInfoPlayersComponent,
    TeamInfoFreePlayersComponent
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
