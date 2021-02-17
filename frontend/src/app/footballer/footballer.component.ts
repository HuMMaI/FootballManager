import { Component, OnInit } from '@angular/core';
import {Footballer} from '../footballer';
import {FootballerService} from '../footballer.service';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-footballer',
  templateUrl: './footballer.component.html',
  styleUrls: ['./footballer.component.css']
})
export class FootballerComponent implements OnInit {
  public players: Footballer[];
  public editFootballer: Footballer;
  public deleteFootballer: Footballer;

  constructor(private footballerService: FootballerService) { }

  ngOnInit(): void {
    this.getPlayers();
  }

  public getPlayers(): void {
    this.footballerService.getPlayers().subscribe(
      (response: Footballer[]) => {
        this.players = response;
        console.log(this.players);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddFootballer(addForm: NgForm): void {
    this.footballerService.addFootballer(addForm.value).subscribe(
      (response: Footballer) => {
        console.log(response);
        this.getPlayers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateFootballer(footballer: Footballer): void {
    this.footballerService.updateFootballer(footballer).subscribe(
      (response: Footballer) => {
        console.log(response);
        this.getPlayers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteFootBaller(footballerId: number): void {
    this.footballerService.deleteFootballer(footballerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getPlayers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenFootballerModal(footballer: Footballer, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addFootballerModal');
    }
    if (mode === 'edit') {
      this.editFootballer = footballer;
      button.setAttribute('data-target', '#updateEditModal');
    }
    if (mode === 'delete') {
      this.deleteFootballer = footballer;
      button.setAttribute('data-target', '#deleteTeamModal');
    }

    container.appendChild(button);
    button.click();
  }
}
