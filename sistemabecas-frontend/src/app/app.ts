import { Component, signal } from '@angular/core';

import { State, Globalstate } from './services/globalstate';

import { StudentApplications } from './student/applications/applications';
import { StudentLogin } from './student/login/login';
import { StudentNavbar } from './student/navbar/navbar';
import { StudentProfile } from './student/profile/profile';
import { StudentRegister } from './student/register/register';
import { Scholarship } from './student/scholarship/scholarship';

@Component({
  selector: 'app-root',
  imports: [
	StudentLogin, StudentRegister, StudentApplications, StudentNavbar, StudentProfile, Scholarship
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('sistemabecas-frontend');
  State = State;
  
  constructor(public globalState: Globalstate) {}
}
