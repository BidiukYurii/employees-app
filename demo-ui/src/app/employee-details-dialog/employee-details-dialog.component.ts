import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Employee} from "../employee/employee.model";
import {Department} from "../employee/department.model";
import {EmployeeService} from "../service/employee.service";
import {DepartmentService} from "../service/department.service";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-employee-details-dialog',
  templateUrl: './employee-details-dialog.component.html',
  styleUrls: ['./employee-details-dialog.component.css']
})
export class EmployeeDetailsDialogComponent implements OnInit {

  public edit: boolean;

  user: Employee;
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

  updateEmployee(): void {
    this.httpClientService.updateEmployee(this.user)
      .subscribe(data => {
        this.activeModal.close(data)
      });
  }

  changeDepartment(event) {
    console.log(event)
    this.user.department.id = event;
  }

  close() {
    this.activeModal.dismiss();
  }

}
