import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user.component.css']
})
export class UserListComponent extends BaseListCtl {
  imageToShow: any;
  myKey = "";

createImageFromBlob(image: Blob) {
   let reader = new FileReader();
   reader.addEventListener("load", () => {
      this.imageToShow = reader.result;
   
   }, false);

   if (image) {
      reader.readAsDataURL(image);
   }
}

  public form = {

    error: false, //error 
    firstName:'',
    lastName:'',
    roleId:'',
    message: null, //error or success message
    preload: [], // preload data
    preloads: [], // preload data
    data: { id: null}, //form data
    inputerror: {}, // form input error messages
    searchParams: {}, //search form
    searchMessage: null, //search result message
    list: [ ], // search list 
    pageNo: 0
  };



  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;
  isValidfirstNameInput:boolean=true;
  isValidlastNameInputs:boolean=true
  isValidQuantityInput:boolean=true;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient,private router:Router) {
    super(locator.endpoints.USER, locator, route);
  }

 
  limitInputw(event: any, maxLength: Text) {
    const target = event.target;
    const value = target.value;
    if (value.length >= maxLength) {
      event.preventDefault();
    } 
  }




  formField(event: any, field: string) {
    const value = event.target.value;
  
    switch(field) {
      case 'firstName':
        const containsNonAlphabetic = /[^\sa-zA-Z]/.test(value);
        this.isValidfirstNameInput = !containsNonAlphabetic;
        break;

      case 'lastName':
        const containsNonAlphabetics = /[^\sa-zA-Z]/.test(value);
        this.isValidlastNameInputs = !containsNonAlphabetics;
        break;


  
     
 case 'quantity':
        // Validate if input is a valid integer
        this.isValidQuantityInput = /^[0-9]*$/.test(value);
        break;

       
     
  
      default:
        break;
    }
  }


  preloads() {
    var self = this;
    this.serviceLocator.httpService.get('http://localhost:8084/User/preloads', function (res: any) {
      self.form.preloads = res.result;
    })
  }

  
  

  getImage(id) {
    //Make a call to Sprinf Boot to get the Image Bytes.
    this.form.data.id = id;
    console.log(this.form.data.id);
    
    this.httpClient.get('http://localhost:8084/Auth/profilePic/'+this.form.data.id, { responseType: 'blob' }).subscribe(data => {
      this.createImageFromBlob(data);
      this.myKey= this.form.data.id;
    }, error => {
      
      console.log(error);
    });

  }

 


}
 