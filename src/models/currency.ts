export class Currency {

  public id: number;
  public name: string;

  constructor(template: any) {
    if(template != null) {
      this.id = template.id;
      this.name = template.name;
    } else {
      this.id = 0;
      this.name = '';
    }
  }
}

