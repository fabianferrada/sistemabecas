import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Appeals } from './appeals';

describe('Appeals', () => {
  let component: Appeals;
  let fixture: ComponentFixture<Appeals>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Appeals]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Appeals);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
