package com.example.zhaopeng08.myapplicationfirst;

import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response.ErrorListener;
import com.example.superindicatorlibray.TestActivity;
import com.hejunlin.superindicatorlibray.CircleIndicator;


import org.json.JSONObject;







public class MainActivity extends AppCompatActivity {
    LinearLayout currentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout currentLayouttest= (LinearLayout) getLayoutInflater().inflate(R.layout.testlayoutone,null);
        setContentView(currentLayouttest);

        currentLayout= (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main,null);

//        setContentView(currentLayout);

        Button btn=new Button(MainActivity.this);

        btn.setText("zhaopeng");

        Button btn2=new Button(MainActivity.this);

        btn2.setText("zhaopeng2");



//        RequestQueue mQue= Volley.newRequestQueue(MainActivity.this);
//        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET,urltest,null,new Response.Listener<JSONObject>(){
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                Log.e("volley",jsonObject.toString());
//            }
//        },new ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Log.e("sdfasfas","dsfsfdasf");
//            }
//        });
//        mQue.add(jr);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urltest="http://www.weather.com.cn/adat/cityinfo/101010100.html";

                Toast.makeText(MainActivity.this,"nimade",Toast.LENGTH_SHORT).show();
                RequestQueue mQue= Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, urltest, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.e("volley", jsonObject.toString());
                        TextView tv=new TextView(MainActivity.this);

                        tv.setText(jsonObject.toString());
                        currentLayout.addView(tv);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("sdfasfas","dsfsfdasf");


                    }
                });


//                        new ErrorListener(){
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        Log.e("sdfasfas","dsfsfdasf");
//                    }
//                });


                        mQue.add(jr);

            }
        });

//        RelativeLayout.LayoutParams rl= new RelativeLayout.LayoutParams(200,150);
//
//        rl.topMargin=200;

//        RelativeLayout.la
//        btn.setLayoutParams(rl);

//        currentLayout.addView(btn,rl);
//
        LinearLayout.LayoutParams ll=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//
          btn.setLayoutParams(ll);
        ll.topMargin=200;
//        currentLayout.setGravity(LinearLayout.VERTICAL);





        currentLayout.setOrientation(LinearLayout.VERTICAL);

        currentLayout.addView(btn,ll);

        currentLayout.setGravity(Gravity.RIGHT);

        currentLayout.addView(btn2);

        System.out.println("dfasfdsa");

        currentLayouttest.addView(currentLayout);

        CircleIndicator ccc=new CircleIndicator(this);

        TestActivity test=new TestActivity();



    }
}
