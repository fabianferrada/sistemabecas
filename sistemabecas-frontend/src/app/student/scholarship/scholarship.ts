import { Component } from '@angular/core';

import { ScholarshipService } from '../../services/student/scholarship';

@Component({
  selector: 'student-scholarship',
  imports: [],
  templateUrl: './scholarship.html',
  styleUrl: './scholarship.css',
})
export class Scholarship {
	constructor(public scholarshipService: ScholarshipService) {}
}
