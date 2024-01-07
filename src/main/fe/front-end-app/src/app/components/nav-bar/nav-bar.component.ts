import { Component, ViewChild, ViewEncapsulation } from '@angular/core';

import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { RouterModule } from '@angular/router';
import { BreakpointObserver } from '@angular/cdk/layout';
import { MatSidenav } from '@angular/material/sidenav';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    RouterModule,
    CommonModule,
    HttpClientModule
  ],
  providers: [HttpClient],
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css', '../../app.component.css']
})
export class NavBarComponent {


  title = 'material-responsive-sidenav';
  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;
  isMobile = true;
  isCollapsed = true;

  constructor(private observer: BreakpointObserver) { }
  username :string  | null = ""
  ngOnInit() {
    this.observer.observe(['(max-width: 800px)']).subscribe((screenSize) => {
      if (screenSize.matches) {
        this.isMobile = true;
      } else {
        this.isMobile = false;
      }
    });
    this.username = sessionStorage.getItem("username")
  }

  toggleMenu() {
    this.isCollapsed == true ? this.sidenav.open() : this.sidenav.close();
    this.isCollapsed = !this.isCollapsed;
  }

  redirectToRoute(route: string){
    window.location.replace(route)
  }

}
