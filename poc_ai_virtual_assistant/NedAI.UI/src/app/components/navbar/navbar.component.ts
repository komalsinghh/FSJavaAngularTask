import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter, map } from 'rxjs/operators';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
    headingName:string="transaction";
    headingIcon:string="smart_toy";
    constructor(private router: Router, private route: ActivatedRoute){}

  ngOnInit(): void {
    this.router.events
    .pipe(
      filter((event) => event instanceof NavigationEnd),
      map(() => this.getHeadingFromRoute())
    )
    .subscribe(({heading, icon}) => {
      this.headingName = heading;
      this.headingIcon=icon;
    });
  }
  getHeadingFromRoute(){
    let currentRoute = this.route;
    while (currentRoute.firstChild) {
      currentRoute = currentRoute.firstChild;
    }
    const url = currentRoute.snapshot.url;
    if (url.length > 0 && url[0].path === 'transaction') {
      return {heading:'Transactions', icon:'payments'};
    } else if (url.length > 0 && url[0].path === 'chatbot') {
      return {heading:'Chatbot Assistant', icon:'smart_toy'};
    }
    return {heading:'Chatbot Assistant', icon:'smart_toy'};
  }
}
