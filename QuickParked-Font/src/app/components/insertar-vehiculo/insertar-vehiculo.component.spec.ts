import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertarVehiculoComponent } from './insertar-vehiculo.component';

describe('InsertarVehiculoComponent', () => {
  let component: InsertarVehiculoComponent;
  let fixture: ComponentFixture<InsertarVehiculoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertarVehiculoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertarVehiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
