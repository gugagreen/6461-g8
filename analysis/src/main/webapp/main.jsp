<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <script type="text/javascript">
	    var titles = new Array();
	    var scores = new Array();
	    <c:forEach var="app" items="${apps}">
	    	titles.push("${app.title}");
	    	scores.push("${app.score}");
	    </c:forEach>
    </script>
    
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <!-- <script type="text/javascript" src="/js/googleChart.js"></script> -->
    <script type="text/javascript" src='<c:url value="/js/bar_score.js" />'></script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <form action="/main" method="post"> 
	    <div id="main_div">
	    	<table style="width: 600px; height: 400px;">
	    		<tr>
	    			<td style="width: 70%; height: 100%;">
	    				<div id="mouseoverdiv" style="border: thin solid black;"></div>
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
		    							<input type="radio" name="dataPoint" value="sizeRanking">Size vs. Ranking<br>
				    					<input type="radio" name="dataPoint" value="dateDownloads">Date vs. Downloads<br>
				    					<input type="radio" name="dataPoint" value="downloadsRanking">Downloads vs. ranking<br>
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
    
    <input type="button" onclick="location.href='/scrapped';" value="View Scrapped Data" />
  </body>
</html>