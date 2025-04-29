import { Routes } from '@angular/router';
import { baseGuard } from '../../guards/base.guard';

export const routes: Routes = [
  {
    path: '',
    data: {
      title: 'ia'
    },
    children: [
      {
        path: '',
        redirectTo: 'cards',
        pathMatch: 'full'
      },
     
      {
        path: 'test',
        loadComponent: () => import('./test/ia.component').then(m => m.IaComponent),
       
      },
     
     
    ]
  }
];


