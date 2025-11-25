import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FilterModel } from '../../../app/shared/models/filter.model';

@Component({
  selector: 'app-filter',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './filter.html',
  styleUrls: ['./filter.css']
})
export class Filter {
  filter: FilterModel = { name: '', city: '', vat: undefined };

  @Output() filterChanged = new EventEmitter<FilterModel>();

  onSubmit(form: any) {
    if (form.valid) {
      this.filter.name = this.filter.name.toLowerCase();
      this.filter.city = this.filter.city.toLowerCase();
      this.filterChanged.emit(this.filter);
    }
  }
}
