package com.example.romana.weightconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread infinity = new Thread(new Runnable() {
            TextView output;
            EditText input;
            Spinner to,from;
            double[][] convert;
            double finalOutput;

            @Override
            public void run() {
                output = (TextView) findViewById(R.id.output);
                input = (EditText) findViewById(R.id.input);
                to = (Spinner) findViewById(R.id.to);
                from = (Spinner) findViewById(R.id.from);


                convert = new double[5][5];

                convert[0][0] = 1;
                convert[0][1] = 1000;
                convert[0][2] = 0.157473;
                convert[0][3] = 2.204623;
                convert[0][4] = 35.27396;

                convert[1][0] = .01;
                convert[1][1] = 1;
                convert[1][2] = 0.000157478;
                convert[1][3] = .002204623;
                convert[1][4] = .30527396;

                convert[2][0] = 6.350293;
                convert[2][1] = 6350.293;
                convert[2][2] = 1;
                convert[2][3] = 14;
                convert[2][4] = 224;

                convert[3][0] = .4535924;
                convert[3][1] = 453.5924;
                convert[3][2] = .07142857;
                convert[3][3] = 1;
                convert[3][4] = 16;

                convert[4][0] = .02834952;
                convert[4][1] = 28.34952;
                convert[4][2] = .004467286;
                convert[4][3] = .0625;
                convert[4][4] = 1;

                try {

                    Runnable r1 = new Runnable() {
                        @Override
                        public void run() {
                            to.setSelection(3);
                        }
                    };

                    runOnUiThread(r1);

//
                    while (true) {
                        Thread.sleep(100);
//
                        if (input.getText().toString().equals("")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    output.setText("No Input Given");
                                }
                            });
                            //

                        } else {
                            String inputText = input.getText().toString();
                            double finalInput = Double.parseDouble(inputText);
                            int fromIndex = from.getSelectedItemPosition();
                            int toIndex = to.getSelectedItemPosition();
                            finalOutput = convert[fromIndex][toIndex] * finalInput;

                            Runnable r=new Runnable() {
                                @Override
                                public void run() {
                                    output.setText(Double.toString(finalOutput));
                                }
                            };

                            runOnUiThread(r);
//
                        }
                    }
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error happended", Toast.LENGTH_LONG).show();
                }
            }
        });

        infinity.start();

    }
}