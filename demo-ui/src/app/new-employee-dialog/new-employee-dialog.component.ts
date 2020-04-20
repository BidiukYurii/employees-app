import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {Employee} from "../employee/employee.model";
import {Department} from "../employee/department.model";
import {EmployeeService} from "../service/employee.service";
import {DepartmentService} from "../service/department.service";

@Component({
  selector: 'app-new-employee-dialog',
  templateUrl: './new-employee-dialog.component.html',
  styleUrls: ['./new-employee-dialog.component.css']
})
export class NewEmployeeDialogComponent implements OnInit {

  name:string
  active:boolean
  departmentId:any
  departments: Department[];

  constructor(
    private httpClientService: EmployeeService,
    private departmentService: DepartmentService,
    private activeModal: NgbActiveModal
  ) {
  }

  ngOnInit(): void {
    this.departmentService.getDepartments().subscribe(response => this.departments = response)
  }

  createEmployee(): void {
    this.httpClientService.createEmployee({name: this.name, active: this.active, departmentId: this.departmentId})
      .subscribe(data => {
        this.activeModal.close(data)
      });
  }

  changeDepartment(event) {
    console.log(event)
    this.departmentId = event;
  }

  close() {
    this.activeModal.close();
  }

}
