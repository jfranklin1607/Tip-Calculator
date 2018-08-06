package com.joshuafranklinjava.tipcalculator.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private EditText enteredAmount;
  private SeekBar seekBar;
  private Button calculateButton;
  private TextView totalResulttextview;
  private TextView textViewSeekbar;
  private int seekBarPercentage;
  private float enteredBillFloat;
  private TextView totalBillTv;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    enteredAmount = (EditText)findViewById(R.id.billAmountID);
    seekBar = (SeekBar)findViewById(R.id.percentageSeekBar);
    calculateButton = (Button)findViewById(R.id.calculateButton);
    totalResulttextview = (TextView)findViewById(R.id.resultID);
    textViewSeekbar = (TextView)findViewById(R.id.textViewSeekbar);
    totalBillTv = (TextView)findViewById(R.id.totalBillTextView);

    calculateButton.setOnClickListener(this);

    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        textViewSeekbar.setText(String.valueOf(seekBar.getProgress() + "%"));

      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

        seekBarPercentage = seekBar.getProgress();

      }
    });
  }
  @Override
  public void onClick(View view){
    calculate();

  }

  public void calculate(){
    float result = 0.0f;

    if (!enteredAmount.getText().toString().equals("")){

      enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString());
      result = enteredBillFloat * seekBarPercentage / 100;
      totalResulttextview.setText("Your tip will be" + " $" +String.valueOf(result) + " dollars");
      totalBillTv.setText("Total bill: " + " $" +String.valueOf(enteredBillFloat + result) + " dollars");

    }else {
      Toast.makeText(MainActivity.this, "Please enter the bill amount", Toast.LENGTH_LONG).show();
    }

  }
}
