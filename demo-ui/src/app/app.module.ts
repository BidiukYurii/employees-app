import {BrowserModule} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {EmployeeComponent} from './employee/employee.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {HeaderComponent} from './header/header.component';
import {LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component';
import {AuthHttpInterceptorService} from "./service/auth-http-interceptor.service";
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {NewEmployeeDialogComponent} from './new-employee-dialog/new-employee-dialog.component';
import {EmployeeDetailsDialogComponent} from './employee-details-dialog/employee-details-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent,
    NewEmployeeDialogComponent,
    EmployeeDetailsDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NoopAnimationsModule,
    NgbModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthHttpInterceptorService, multi: true},
  ],
  entryComponents: [NewEmployeeDialogComponent, EmployeeDetailsDialogComponent],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {
}
