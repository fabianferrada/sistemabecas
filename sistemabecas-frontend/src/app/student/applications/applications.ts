import { Component } from '@angular/core';
import { Applications } from '../../services/student/applications';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'student-applications',
  imports: [ FormsModule ],
  templateUrl: './applications.html',
  styleUrl: './applications.css',
})
export class StudentApplications {
	public razonApelacion: string = "";
	public descripcionApelacion: string = "";
	
	constructor(public applicationsService: Applications) {}
	
	public capitalize(text: string) {
		return text[0].toUpperCase() + text.substr(1).toLowerCase();
	}
	
	public appeal() {
		console.log(this.razonApelacion + "; " + this.descripcionApelacion);
	}
}
