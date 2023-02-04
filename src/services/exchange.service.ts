import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'
import { map, Observable } from 'rxjs';
import { Currency } from 'src/models/currency';

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {

  constructor(private http: HttpClient) { }

  public getCurrencies(): Observable<Array<Currency>> {
    return this.http.get('http://localhost:8080/symbols').pipe(
      map((result:any) => {
        return result.map((it: any) => new Currency(it));
      })
    );
  }

  public calculateExchange(queryParams: HttpParams): Observable<number> {
    return this.http.post<number>('http://localhost:8080/convert ', queryParams).pipe(
      map((result: number) => {
        return result;
      })
    );
  }

}
