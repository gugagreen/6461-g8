package analysis.android.soen6461.concordia.ca.analysisandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button submit;
    WebView chartView;
//    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewDataButton();
        initChartView();
        // initFloatingActionButton()
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initViewDataButton() {
        submit = (Button) findViewById(R.id.viewData_btn);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // execute method invokes doInBackground() where we open a Http URL connection using the given Servlet URL
                //and get output response from InputStream and return it.
                new ViewDataTask().execute();
            }
        });
    }

    private void initChartView() {
        chartView = (WebView) findViewById(R.id.chartView);

        // see http://stackoverflow.com/questions/3382188/how-to-set-webview-as-non-fullscreen/3382258#3382258
        chartView.getSettings().setJavaScriptEnabled(true);

        //RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 280);
        //chartView.setLayoutParams(lp);

        chartView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;

            }
        });

        chartView.loadUrl("http://10.0.2.2:8080/chart.html");
    }

//    private void initFloatingActionButton() {
//        fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
