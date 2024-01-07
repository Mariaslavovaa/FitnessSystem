import { TestBed } from '@angular/core/testing';

import { AllCoachesService } from './all-coaches.service';

describe('AllCoachesService', () => {
  let service: AllCoachesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllCoachesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
