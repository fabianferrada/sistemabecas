import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Profile } from '../../services/student/profile';

@Component({
  selector: 'student-profile',
  imports: [ FormsModule ],
  templateUrl: './profile.html',
  styleUrl: './profile.css',
})
export class StudentProfile {
	constructor(public profileService: Profile) {}
}
