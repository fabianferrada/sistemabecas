import { Component } from '@angular/core';
import { Applications } from '../../services/student/applications';

@Component({
  selector: 'student-applications',
  imports: [],
  templateUrl: './applications.html',
  styleUrl: './applications.css',
})
export class StudentApplications {
	constructor(public applicationsService: Applications) {}
	
	public capitalize(text: string) {
		return text[0].toUpperCase() + text.substr(1).toLowerCase();
	}
}
