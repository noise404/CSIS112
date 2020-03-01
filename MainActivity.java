package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Slide;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText bill;
    private TextView slidePercent;
    private SeekBar slider;
    private TextView tipOut;
    private TextView totalOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = (EditText) findViewById(R.id.billIn);
        slidePercent = (TextView) findViewById(R.id.tipPercent);
        slider = (SeekBar) findViewById(R.id.tipSeek);
        tipOut = (TextView) findViewById(R.id.tipAmount);
        totalOut = (TextView) findViewById(R.id.totalAmount);

        slider.setOnSeekBarChangeListener(seekBarListener);
    }



    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int selection = slider.getProgress();
            slidePercent.setText(String.valueOf(selection + "%"));


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            double selection;
            try{
                selection = (slider.getProgress() * .01);
            String s = bill.getText().toString();
            double d = Double.parseDouble(s);
            d = d * selection;
            tipOut.setText("$" + String.format("%.2f", d));
            totalOut.setText("$" + String.format("%.2f", (d + Double.parseDouble(s))));}

            catch (Exception e){
                tipOut.setText("$0.00");
                totalOut.setText("$0.00");
            }


        }
    };
}
