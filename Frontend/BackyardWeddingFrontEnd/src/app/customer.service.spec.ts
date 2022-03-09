import { TestBed } from '@angular/core/testing';

import { RESTService } from './REST.service';

describe('RESTService', () => {
  let service: RESTService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RESTService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
