const chartGroups = [

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

export default chartGroups;
