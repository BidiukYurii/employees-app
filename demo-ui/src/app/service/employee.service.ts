import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Employee} from "../employee/employee.model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {PageEmployee} from "../employee/employee.component";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getEmployees() {
    return this.httpClient.get<Employee[]>(environment.BASE_URL + '/api/employee/');
  }


  getEmployeeById(id) {
    return this.httpClient.get<Employee>(environment.BASE_URL + '/api/employee/' + id);
  }

  createEmployee(employee) {
    return this.httpClient.post<Employee>(environment.BASE_URL + '/api/employee/', employee);
  }

  updateEmployee(employee) {
    return this.httpClient.put<Employee>(environment.BASE_URL + '/api/employee/', employee);
  }

  public deleteEmployee(employee) {
    return this.httpClient.delete(environment.BASE_URL + '/api/employee/' + employee.id);
  }

  getPageClient(page: number) {
    var url = environment.BASE_URL + '/api/employee/page?page=';
    url = url + page + "&size=10";
    return this.httpClient.get<PageEmployee>(url);
  }

  getByName(name: string) {
    let url = environment.BASE_URL + '/api/employee/search?name=';
    url = url + name;
    return this.httpClient.get<Employee[]>(url);
  }

}
