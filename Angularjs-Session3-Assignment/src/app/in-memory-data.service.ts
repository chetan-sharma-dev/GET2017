import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Product } from './product';
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const products: Product[] = [
        { id: 1, name: 'Fastrack Watch' ,price:1700},
        { id: 2, name: 'Puma Shoe' ,price:2050},
        { id: 3, name: 'Basket ball' ,price:591},
        { id: 4, name: 'Football' ,price:991},
        { id: 5, name: 'Sports T-shirt' ,price:561},
        { id: 6, name: 'Trouser',price:631 },
        { id: 7, name: 'Bat',price:1621},
        { id: 8, name: 'Seabags Bag' ,price:5611},
        { id: 9, name: 'Baseball',price:591},
        { id: 10, name: 'Badminton',price:601 }
      ];
    return {products};
  }
}