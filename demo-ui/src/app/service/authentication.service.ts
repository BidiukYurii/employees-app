import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  authenticate(username, password) {
    return this.httpClient.post<any>('http://localhost:8080/login', {username, password}, {observe: 'response'}).pipe(
      map(
        response => {
          sessionStorage.setItem('username', username);
          let tokenStr = response.headers.get('authorization');
          sessionStorage.setItem('token', tokenStr);
          return response;
        }
      )
    );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
