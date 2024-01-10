import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AllCoachesComponent } from './components/all-coaches/all-coaches.component';
import { WorkoutFormComponent } from './components/workout-form/workout-form.component';
import { PaymentApiComponent } from './components/payment-api/payment-api.component';
import { MyWorkoutsComponent } from './components/my-workouts/my-workouts.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/login', 
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'all-coaches',
        component: AllCoachesComponent
    },
    {
        path: 'workout-form',
        component: WorkoutFormComponent
    },
    {
        path: 'payment-api',
        component: PaymentApiComponent
    },
    {
        path: 'my-workouts',
        component: MyWorkoutsComponent
    }
];
