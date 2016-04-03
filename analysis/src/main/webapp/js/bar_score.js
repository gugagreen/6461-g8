// barsVisualization must be global in our script tag to be able
// to get and set selection.
var barsVisualization;

google.charts.load('current', {'packages':['bar']});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawMouseoverVisualization);

function drawMouseoverVisualization() {
	var div = document.getElementById('mouseoverdiv');
	if (typeof columns !== 'undefined' && columns.length > 0) {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Apps by score');
		data.addColumn('string', 'Score');
		for (var i = 0; i < columns.length; i++) {
			// TODO - adjust title better
			data.addRow([columns[i].substring(0, 10), values[i]]);
		}
		
		// Set chart options
		var options = {
			'title' : title,
			'width' : 400,
			'height' : 300
		};
	
		barsVisualization = new google.charts.Bar(div);
		barsVisualization.draw(data, options);
	
		// Add our over/out handlers.
		google.visualization.events.addListener(barsVisualization, 'onmouseover', barMouseOver);
		google.visualization.events.addListener(barsVisualization, 'onmouseout', barMouseOut);
	} else {
		div.innerHTML="No data yet. Please select data points.";
	}
}

function barMouseOver(e) {
	barsVisualization.setSelection([ e ]);
}

function barMouseOut(e) {
	barsVisualization.setSelection([ {
		'row' : null,
		'column' : null
	} ]);
}