import { Component } from '@angular/core';

import { DocumentDescription } from '../../services/student/document-description';

@Component({
  selector: 'student-application',
  imports: [],
  templateUrl: './application.html',
  styleUrl: './application.css',
})
export class StudentApplication {
  constructor(public documentDesc: DocumentDescription) {}
}
