import { TestBed } from '@angular/core/testing';

import { DocumentDescription } from './document-description';

describe('DocumentDescription', () => {
  let service: DocumentDescription;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocumentDescription);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
