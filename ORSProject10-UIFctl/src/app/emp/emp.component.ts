import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent extends BaseCtl {
  selected = null;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.EMP, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.firstName);
    flag = flag && validator.isNotNullObject(form.lastName);
    flag = flag && validator.isNotNullObject(form.email);
    flag = flag && validator.isNotNullObject(form.department);
    flag = flag && validator.isNotNullObject(form.address);

    return flag;
  }
  populateForm(form, data) {
    form.id = data.id;
    form.firstName = data.firstName;
    form.lastName = data.lastName;
    
    form.email = data.email;
    form.department=data.department;
    form.address=data.address;

    //let ndate = new Date(data.dob);
   
    //console.log(form.dob + 'date ------',ndate)
   
    
  }

}