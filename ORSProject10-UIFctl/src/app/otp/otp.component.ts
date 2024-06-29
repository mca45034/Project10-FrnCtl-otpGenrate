import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { DataValidator } from '../utility/data-validator';
import { CookieService } from 'ngx-cookie-service';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css']
})
export class OtpComponent implements OnInit {

  endpoint = "http://localhost:8084/Code";



  
  form = {
    error: false,
    message: '',
    codeId: '',
  };

  inputerror = {};
  message = '';

  userparams = {
    url: '',
    sessionExpiredMsg: '',
    methodType: '',
  };


  constructor(private httpService: HttpServiceService, private dataValidator: DataValidator, private router: Router,
    private cookieService: CookieService, private route: ActivatedRoute, private serviceLocator: ServiceLocatorService) {

  }

  ngOnInit() {
  }

  validate(){
    let flag = true;
    flag = flag && this.dataValidator.isNotNull(this.form.codeId);
    return flag;
  }
  limitInput(event: any, maxLength: number) {
    const target = event.target;
    const value = target.value;
    if (value.length >= maxLength) {
      event.preventDefault();
    } else if (!/^\d{0,9}$/.test(value + event.key)) {
      event.preventDefault();
    }
  }

  cancel(){
    this.router.navigateByUrl('/login');
  }

  submit(){

    var _self = this;
    const requestedUrl = this.httpService.userparams.url;//to get the URI
    this.httpService.post(this.endpoint + "/CodeOTP", this.form, function (res) {
  
     

      if (_self.dataValidator.isNotNullObject(res.result.message)) {
        _self.form.message = res.result.message;
      }

      if (_self.dataValidator.isNotNullObject(res.result.inputerror)) {
        _self.inputerror = res.result.inputerror;
      }


      if(_self.dataValidator.isTrue(res.success)){

        console.log('otp valid===================================')

       localStorage.setItem("otp", res.result.otp);
  
      _self.router.navigateByUrl('dashboard');
      }


      if (_self.dataValidator.isTrue(res.success)) {

    
        localStorage.setItem("loginId", res.result.loginId);
  
       
        localStorage.setItem("role", res.result.role);
        localStorage.setItem("fname", res.result.fname);
        localStorage.setItem("lname", res.result.lname);
        localStorage.setItem("userid", res.result.data.id);
      
        //   console.log(res.result.data.id + 'sessionId set ----');
        //   console.log(res.result.token + '  Token set ----');
       
         const URL= localStorage.getItem('url');
         if(URL !=null && URL != ''){
          _self.router.navigateByUrl(URL);
  
        } else{
          _self.router.navigateByUrl('dashboard');
        }

       
         
        
      }
});
}

}