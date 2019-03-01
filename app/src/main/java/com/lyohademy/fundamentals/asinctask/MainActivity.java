package com.lyohademy.fundamentals.asinctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        MyAsyncTask myAsyncTask = new MyAsyncTask(textView);
        myAsyncTask.execute("1", "2", "3", "4", "5", "6", "7", "8", "9");

    }

    public static class MyAsyncTask extends AsyncTask<String, String, String> {
        private TextView myTextView;

        public MyAsyncTask(TextView textView) {
            myTextView = textView;
        }


        @Override
        protected String doInBackground(String... strings) {
            for (String string : strings) {

                Log.d("ZAQ", string);
                publishProgress(string);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finished";
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("ZAQ", result);
            myTextView.setText(result);


        }

        @Override
        protected void onPreExecute() {
            Log.d("ZAQ", "onPreExecute");

        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.d("ZAQ", "onProgressUpdate: " + values[0]);

            myTextView.setText(values[0]);
        }

    }
}
