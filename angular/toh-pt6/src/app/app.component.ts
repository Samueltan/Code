import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of Heroes';

  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  legendTitle = 'Legend';
  legendPosition = 'right';
  showXAxisLabel = true;
  tooltipDisabled = false;
  xAxisLabel = 'Country';
  showYAxisLabel = true;
  yAxisLabel = 'GDP Per Capita';
  showGridLines = true;
  innerPadding = '10%';
  barPadding = 8;
  groupPadding = 16;
  roundDomains = false;
  maxRadius = 10;
  minRadius = 3;
  showSeriesOnHover = true;
  roundEdges: boolean = true;
  animations: boolean = true;
  xScaleMin: any;
  xScaleMax: any;
  yScaleMin: number;
  yScaleMax: number;
  showDataLabel = false;

  view = [700, 300];
  
  bubble = [
    {
      name: 'Germany',
      series: [
        {
          name: '2010',
          x: new Date(2010, 0, 1),
          y: 80.3,
          r: 80.4
        },
        {
          name: '2000',
          x: new Date(2000, 0, 1),
          y: 80.3,
          r: 78
        },
        {
          name: '1990',
          x: new Date(1990, 0, 1),
          y: 75.4,
          r: 79
        }
      ]
    },
    {
      name: 'United States',
      series: [
        {
          name: '2010',
          x: new Date(2010, 0, 1),
          y: 78.8,
          r: 310
        },
        {
          name: '2000',
          x: new Date(2000, 0, 1),
          y: 76.9,
          r: 283
        },
        {
          name: '1990',
          x: new Date(1990, 0, 1),
          y: 75.4,
          r: 253
        }
      ]
    },
    {
      name: 'France',
      series: [
        {
          name: '2010',
          x: new Date(2010, 0, 1),
          y: 81.4,
          r: 63
        },
        {
          name: '2000',
          x: new Date(2000, 0, 1),
          y: 79.1,
          r: 59.4
        },
        {
          name: '1990',
          x: new Date(1990, 0, 1),
          y: 77.2,
          r: 56.9
        }
      ]
    },
    {
      name: 'United Kingdom',
      series: [
        {
          name: '2010',
          x: new Date(2010, 0, 1),
          y: 80.2,
          r: 62.7
        },
        {
          name: '2000',
          x: new Date(2000, 0, 1),
          y: 77.8,
          r: 58.9
        },
        {
          name: '1990',
          x: new Date(1990, 0, 1),
          y: 75.7,
          r: 57.1
        }
      ]
    }
  ];
}
