import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../service/employee.service";
import {Employee} from "./employee.model";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NewEmployeeDialogComponent} from "../new-employee-dialog/new-employee-dialog.component";
import {EmployeeDetailsDialogComponent} from "../employee-details-dialog/employee-details-dialog.component";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];

  selectedPage: any;
  totalItems: any;
  page: PageEmployee;

  searchForm: string;
  isSearching: boolean;

  constructor(
    private httpClientService: EmployeeService,
    private modalService: NgbModal
  ) {
  }

  ngOnInit(): void {
    this.totalItems = 10;
    this.selectedPage = 0;
    this.httpClientService.getPageClient(0).subscribe(
      response => {
        this.handleSuccessfulResponse(response)
      }
    )
  }

  deleteEmployee(employee: Employee): void {
    this.httpClientService.deleteEmployee(employee)
      .subscribe(() => {
        this.getPageClient(this.selectedPage);
      })
  };

  handleSuccessfulResponse(response) {
    this.employees = response.content;
    this.page = response;
  }

  getPageClient(page: number): void {
    this.httpClientService.getPageClient(page)
      .subscribe(response => this.handleSuccessfulResponse(response));
  }

  onSearch(name): void {
    this.httpClientService.getByName(name)
      .subscribe(response => {
        this.employees = response
        this.isSearching = true;
      });
  }

  onSelect(page: number): void {
    this.selectedPage = page;
    this.getPageClient(page);
  }

  onCloseSearch() {
    this.searchForm = '';
    this.isSearching = false;
    this.getPageClient(0);
  }

  openCreateDialog() {
    const modalRef = this.modalService.open(NewEmployeeDialogComponent);
    modalRef.result.then(result => {
      this.getPageClient(this.selectedPage)

      // if (result) {
      //   // this.employees.push(result)
      //   this.page.content.push(result)
      // }
    })
  }

  openUpdateDialog(employee) {
    const modalRef = this.modalService.open(EmployeeDetailsDialogComponent);
    modalRef.componentInstance.edit = true;
    modalRef.componentInstance.user = employee;

    modalRef.result.then(result => this.updateItem(result))

  }

  openViewDialog(employee) {
    const modalRef = this.modalService.open(EmployeeDetailsDialogComponent);
    modalRef.componentInstance.edit = false;
    modalRef.componentInstance.user = employee;
  }

  private updateItem(updatedEmployee) {
    let update = this.employees.find(empl => empl.id == updatedEmployee.id);
    let index = this.employees.indexOf(update);

    this.employees[index] = updatedEmployee;
  }

}

export class PageEmployee {
  content: Employee[];
  totalPages: number;
  last: boolean;
  size: number;
  first: boolean;
  sort: string;
}
