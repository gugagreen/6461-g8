<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="/js/googleChart.js"></script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
    <p/>
    <form action="/main" method="post">
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
		    							<input type="checkbox" name="dataPoint" value="score">Score<br>
				    					<input type="checkbox" name="dataPoint" value="title">Title<br>
				    					<input type="checkbox" name="dataPoint" value="datePublished">Date Published<br>
				    					<input type="checkbox" name="dataPoint" value="numDownloads">Number of Downloads<br>
				    					<input type="checkbox" name="dataPoint" value="contentRating">Content Rating<br>
				    				</div>
			    				</td>
	    					</tr>
	    					<tr style="height: 10%;">
	    						<td>
	    							<button type="submit">Graph</button>
	    							<button type="submit">Table</button>
	    						</td>
	    					</tr>
	    				</table>
	    			</td>
	    		</tr>
	    	</table>
	    </div>
    </form>
  </body>
</html>