import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Employee} from "../employee/employee.model";
import {Department} from "../employee/department.model";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(
    private httpClient:HttpClient
  ) { }

  getDepartments() {
    return this.httpClient.get<Department[]>("http://localhost:8080/api/department/");
  }
}
