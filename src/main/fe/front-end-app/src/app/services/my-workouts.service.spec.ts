import { TestBed } from '@angular/core/testing';

import { MyWorkoutsService } from './my-workouts.service';

describe('MyWorkoutsService', () => {
  let service: MyWorkoutsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyWorkoutsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
