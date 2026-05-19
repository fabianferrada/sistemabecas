import { Component } from '@angular/core';

import { ScholarshipService } from '../../services/student/scholarship';
import { Globalstate } from '../../services/globalstate';

@Component({
  selector: 'student-scholarship',
  imports: [],
  templateUrl: './scholarship.html',
  styleUrl: './scholarship.css',
})
export class Scholarship {
	constructor(
    public scholarshipService: ScholarshipService,
    public globalState: Globalstate
  ) {}
}
