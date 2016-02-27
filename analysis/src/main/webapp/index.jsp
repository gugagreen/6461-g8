<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Mushrooms', 3],
          ['Onions', 1],
          ['Olives', 1],
          ['Zucchini', 1],
          ['Pepperoni', 2]
        ]);

        // Set chart options
        var options = {'title':'How Much Pizza I Ate Last Night',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('diagram'));
        chart.draw(data, options);
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
    <p/>
    <div id="main_div">
    	<table style="width: 600px; height: 400px;">
    		<tr>
    			<td style="width: 70%; height: 100%;">
    				<div id="diagram" style="border: thin solid black; height: 100%;"></div>
    			</td>
    			<td style="width: 30%; height: 100%;">
    				<table style="height: 100%;">
    					<tr style="height: 10%;">
    						<td>
    							<button>Help</button>
    						</td>
    					</tr>
    					<tr style="height: 80%;">
    						<td>
	    						<div id="data_selection" style="border: thin solid black; height: 100%;">
	    							<input type="checkbox" name="scrap" value="score">Score<br>
			    					<input type="checkbox" name="scrap" value="title">Title<br>
			    					<input type="checkbox" name="scrap" value="datePublished">Date Published<br>
			    					<input type="checkbox" name="scrap" value="numDownloads">Number of Downloads<br>
			    					<input type="checkbox" name="scrap" value="contentRating">Content Rating<br>
			    				</div>
		    				</td>
    					</tr>
    					<tr style="height: 10%;">
    						<td>
    							<button>Graph</button>
    							<button>Table</button>
    						</td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    	</table>
    </div>
  </body>
</html>