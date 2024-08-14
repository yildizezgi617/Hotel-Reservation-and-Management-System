import { TestBed } from '@angular/core/testing';

import { HotelImageService } from './hotel-image.service';

describe('HotelImageService', () => {
  let service: HotelImageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HotelImageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
