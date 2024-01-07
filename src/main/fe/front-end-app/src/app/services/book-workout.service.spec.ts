import { TestBed } from '@angular/core/testing';

import { BookWorkoutService } from './book-workout.service';

describe('BookWorkoutService', () => {
  let service: BookWorkoutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookWorkoutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
