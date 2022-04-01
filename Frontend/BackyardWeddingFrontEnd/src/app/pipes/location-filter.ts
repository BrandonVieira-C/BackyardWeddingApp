import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'locationFilter'
})
export class LocationFilterPipe implements PipeTransform {

  transform(value: any[], filterLocation: string, location: string): any[] {
    const resultArray = [];

    if (value.length === 0 || filterLocation === '' || location === '') {
      return value;
    }

    for (const item of value) {
      if (item[location] === filterLocation) {
        resultArray.push(item);
      }
    }
    return resultArray;
  }

}
