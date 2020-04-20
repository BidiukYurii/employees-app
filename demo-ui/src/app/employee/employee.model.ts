import {Department} from "./department.model";

export class Employee{
  constructor(
    public id:bigint,
    public name:string,
    public active:boolean,
    public department:Department
  ) {}
}
