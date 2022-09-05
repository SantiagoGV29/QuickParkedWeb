import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertarCarroComponent } from './insertar-carro.component';

describe('InsertarCarroComponent', () => {
  let component: InsertarCarroComponent;
  let fixture: ComponentFixture<InsertarCarroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertarCarroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertarCarroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
