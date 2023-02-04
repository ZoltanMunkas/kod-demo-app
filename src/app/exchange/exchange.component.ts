import { HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { map } from 'rxjs';
import { Currency } from 'src/models/currency';
import { ExchangeService } from 'src/services/exchange.service';

@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent {

  public currencies: Array<Currency> = [];
  public toCurrencies: Array<Currency> = [];
  public selectedFrom: Currency | undefined;
  public selectedTo: Currency | undefined;
  public amount = 0;
  public exchangeValue = 0;

  constructor(private exchangeService: ExchangeService) {
    exchangeService.getCurrencies().subscribe((result => {
      result.forEach(it => {
        this.currencies.push(it)
      })
    }));
    this.toCurrencies = [];
  }

  public onSelectFrom(selected: any): void {
    console.log(selected);
    this.selectedFrom = selected;
    this.currencies.forEach((curr: Currency) => {
      if(this.selectedFrom?.id != curr.id) {
        this.toCurrencies.push(curr);
      }
    })
  }

  public onSelectTo(selected:any): void {
    this.selectedTo = selected;
  }


  public onSubmit(): void {
    console.log(this.selectedFrom);

    if(typeof this.selectedFrom === 'undefined' || typeof this.selectedTo === 'undefined') {
      return;
    }
    let queryParams = new HttpParams();
    queryParams = queryParams.append('from', this.selectedFrom.toString());
    queryParams = queryParams.append('to', this.selectedTo.toString());
    queryParams = queryParams.append('amount', this.amount);
    this.exchangeService.calculateExchange(queryParams).subscribe((result) => {
      this.exchangeValue = result;
    });
  }

}
