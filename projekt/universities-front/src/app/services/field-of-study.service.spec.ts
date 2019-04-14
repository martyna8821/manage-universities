import { TestBed } from '@angular/core/testing';

import { FieldOfStudyService } from './field-of-study.service';

describe('FieldOfStudyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FieldOfStudyService = TestBed.get(FieldOfStudyService);
    expect(service).toBeTruthy();
  });
});
