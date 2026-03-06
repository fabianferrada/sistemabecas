import { Component } from '@angular/core';

import { AppealService } from '../../services/student/appeal-service';

@Component({
  selector: 'student-appeals',
  imports: [],
  templateUrl: './appeals.html',
  styleUrl: './appeals.css',
})
export class StudentAppeals {
	constructor(public appealsService: AppealService) {}
}
