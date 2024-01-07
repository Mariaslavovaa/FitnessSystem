import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentApiComponent } from './payment-api.component';

describe('PaymentApiComponent', () => {
  let component: PaymentApiComponent;
  let fixture: ComponentFixture<PaymentApiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaymentApiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PaymentApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
