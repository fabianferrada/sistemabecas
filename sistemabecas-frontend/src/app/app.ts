import { Component, signal } from '@angular/core';

import { StudentLogin } from './student/login/login';

@Component({
  selector: 'app-root',
  imports: [ StudentLogin ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('sistemabecas-frontend');
}
