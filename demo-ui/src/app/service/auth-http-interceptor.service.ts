import {Injectable} from '@angular/core';
import {HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";

@Injectable()
export class AuthHttpInterceptorService implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    console.log('!!1111111111111111111111111111111111111111111111')
    console.log(sessionStorage.getItem('username'))
    console.log(sessionStorage.getItem('token'))
    if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
      req = req.clone({
        headers: req.headers.set('Authorization', sessionStorage.getItem('token'))
      })
    }

    return next.handle(req);

  }
}
