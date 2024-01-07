import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCoachesComponent } from './all-coaches.component';

describe('AllCoachesComponent', () => {
  let component: AllCoachesComponent;
  let fixture: ComponentFixture<AllCoachesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllCoachesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllCoachesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
