import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceHealthComponent } from './service-health.component';

describe('ServiceHealthComponent', () => {
  let component: ServiceHealthComponent;
  let fixture: ComponentFixture<ServiceHealthComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceHealthComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceHealthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
