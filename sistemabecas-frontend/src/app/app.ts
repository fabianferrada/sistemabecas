import { Component, signal } from '@angular/core';

import { State, Globalstate } from './services/globalstate';

import { StudentLogin } from './student/login/login';
import { StudentRegister } from './student/register/register';

@Component({
  selector: 'app-root',
  imports: [ StudentLogin, StudentRegister ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('sistemabecas-frontend');
  State = State;
  
  constructor(public globalState: Globalstate) {}
}
