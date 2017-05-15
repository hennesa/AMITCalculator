package com.example.hennesa.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator c = new Calculator();
    String ctNum = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_table_layout);
    }

    public void calcBtnPressed(View v) {

        Button b = (Button) findViewById(v.getId());
        TextView tvMain = (TextView) findViewById(R.id.textView);
        TextView tvSec = (TextView) findViewById(R.id.textView2);
        Log.d("ABD_Calc_Main",b.getText().toString());
        Log.d("ABD_Calc_Main",tvSec.getText().toString());
        // check for pressed button type
        //
        if (b.getText().equals(getString(R.string.plus))) {
            if(ctNum.equals("")) {
                if(tvSec.getText().toString().equals("")) {
                    tvSec.setText(tvMain.getText());
                    c.setNumber(tvMain.getText().toString());
                    c.getResult();
                } else {
                    tvSec.setText(tvSec.getText().toString().substring(0, tvSec.getText().length() - 3));
                }
            } else {
                c.setNumber(ctNum);
                ctNum = "";
                tvMain.setText(c.getResult());
            }
            tvSec.append(" + ");
            c.add();
        } else if (b.getText().equals(getString(R.string.minus))) {
            if(ctNum.equals("")) {
                if(tvSec.getText().toString().equals("")) {
                    tvSec.setText(tvMain.getText());
                    c.setNumber(tvMain.getText().toString());
                    c.getResult();
                } else {
                    tvSec.setText(tvSec.getText().toString().substring(0, tvSec.getText().length() - 3));
                }
            } else {
                c.setNumber(ctNum);
                ctNum = "";
                tvMain.setText(c.getResult());
            }
            tvSec.append(" - ");
            c.subtract();
        } else if (b.getText().equals(getString(R.string.multiply))) {
            if(ctNum.equals("")) {
                if(tvSec.getText().toString().equals("")) {
                    tvSec.setText(tvMain.getText());
                    c.setNumber(tvMain.getText().toString());
                    c.getResult();
                } else {
                    tvSec.setText(tvSec.getText().toString().substring(0, tvSec.getText().length() - 3));
                }
            } else {
                c.setNumber(ctNum);
                ctNum = "";
                tvMain.setText(c.getResult());
            }
            tvSec.append(" x ");
            c.multiply();
        } else if (b.getText().equals(getString(R.string.divide))) {
            if(ctNum.equals("")) {
                if(tvSec.getText().toString().equals("")) {
                    tvSec.setText(tvMain.getText());
                    c.setNumber(tvMain.getText().toString());
                    c.getResult();
                } else {
                    tvSec.setText(tvSec.getText().toString().substring(0, tvSec.getText().length() - 3));
                }
            } else {
                c.setNumber(ctNum);
                ctNum = "";
                tvMain.setText(c.getResult());
            }
            tvSec.append(" / ");
            c.divide();
        } else if (b.getText().equals(getString(R.string.del))) {
            if(!ctNum.equals("")) {
                tvSec.setText(tvSec.getText().toString().toCharArray(), 0, tvSec.getText().length() - 1);
                ctNum = ctNum.substring(0,ctNum.length()-1);
            }
        } else if (b.getText().equals(getString(R.string.equal))) {
            if(!ctNum.equals("")) {
                c.setNumber(ctNum);
                ctNum = "";
                tvMain.setText(c.getResult());
            }
            tvSec.setText("");
            c = new Calculator();
        } else if (b.getText().equals(getString(R.string.AC))) {
            tvMain.setText("0");
            tvSec.setText("");
            c = new Calculator();
            ctNum = "";
        } else { // a number was pressed
            if(tvSec.getText().equals("") || tvSec.getText().equals("0")) {
                tvSec.setText(b.getText());
            } else {
                tvSec.append(b.getText());
            }
            ctNum = ctNum + b.getText().toString();
        }
    }
}
