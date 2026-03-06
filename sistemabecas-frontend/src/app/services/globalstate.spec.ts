import { TestBed } from '@angular/core/testing';

import { Globalstate } from './globalstate';

describe('Globalstate', () => {
  let service: Globalstate;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Globalstate);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
