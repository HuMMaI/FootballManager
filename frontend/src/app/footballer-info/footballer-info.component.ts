import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {StatementService} from '../statement.service';
import {Statement} from '../statement';
import {HttpErrorResponse} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-footballer-info',
  templateUrl: './footballer-info.component.html',
  styleUrls: ['./footballer-info.component.css']
})
export class FootballerInfoComponent implements OnInit {
  public footballerPictureUrl = environment.footballerPictureUrl;
  public statementId: number;
  public statement: Statement;

  constructor(private route: ActivatedRoute, private statementService: StatementService) {
    this.route.queryParams.subscribe(params => {
      this.statementId = params.statementId;
    });

    this.getStatement();
  }

  ngOnInit(): void {
  }

  public getStatement(): void {
    this.statementService.getStatementById(this.statementId).subscribe(
      (response: Statement) => {
        this.statement = response;
        console.log(this.statement);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
