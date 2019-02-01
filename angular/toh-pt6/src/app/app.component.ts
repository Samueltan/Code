import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  title = 'Tour of Heroes';

  theme = 'dark';
  chartType: string;
  chartGroups: any[];
  chart: any;
  realTimeData: boolean = false;
  fiscalYearReport: any[];
  dateData: any[];
  dateDataWithRange: any[];
  calendarData: any[];
  statusData: any[];
  sparklineData: any[];
  timelineFilterBarData: any[];
  graph: { links: any[]; nodes: any[] };
  bubble: any;
  linearScale: boolean = false;
  range: boolean = false;

  view: any[];
  width: number = 700;
  height: number = 300;
  fitContainer: boolean = false;

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

  colorSets: any;
  colorScheme: any;
  schemeType: string = 'ordinal';
  selectedColorScheme: string;
  rangeFillOpacity: number = 0.15;

  constructor() {
  }

  ngOnInit() {
    this.view = [this.width, this.height];

    this.colorScheme = {
        name: 'cool',
        selectable: true,
        group: 'Ordinal',
        domain: [
          '#a8385d', '#7aa3e5', '#a27ea8', '#aae3f5', '#adcded', '#a95963', '#8796c0', '#7ed3ed', '#50abcc', '#ad6886'
        ]
    };
    this.bubble = [
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

      this.chartGroups = [

        {
          name: 'Other Charts',
          charts: [
            {
              name: 'Bubble Chart',
              selector: 'bubble-chart',
              inputFormat: 'bubble',
              options: [
                'animations',
                'colorScheme',
                'schemeType',
                'showXAxis',
                'showYAxis',
                'showLegend',
                'legendTitle',
                'legendPosition',
                'showXAxisLabel',
                'xAxisLabel',
                'showYAxisLabel',
                'yAxisLabel',
                'showGridLines',
                'roundDomains',
                'autoScale',
                'minRadius',
                'maxRadius',
                'tooltipDisabled',
                'xScaleMin',
                'xScaleMax',
                'yScaleMin',
                'yScaleMax'
              ],
              defaults: {
                xAxisLabel: 'Census Date',
                yAxisLabel: 'Life expectancy [years]'
              }
            }
          ]
        }
      ];
  }
  
}
