package com.entity.game1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton imgPlay;
    TextView tvDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;

    int diem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        EnableSeekBar();
        run();

    }

    private void DisableCheckBox() {

        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);

    }

    private void EnableCheckBox() {

        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);

    }

    private void EnableSeekBar() {
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
    }

    private void run() {
        tvDiem.setText(diem + "");
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                tvDiem.setText(diem + "");
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);


                skOne.setProgress(skOne.getProgress() + 3 + one);
                skTwo.setProgress(skTwo.getProgress() + 3 + two);
                skThree.setProgress(skThree.getProgress() + 3 + three);

                if (skOne.getProgress() >= skOne.getMax()) {
                    this.cancel();
                    imgPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();

                    if (cbOne.isChecked()) {
                        diem += 10;
                    } else {
                        diem -= 5;
                    }
                    tvDiem.setText(diem + "");
                    EnableCheckBox();

                }
                if (skTwo.getProgress() >= skTwo.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    imgPlay.setVisibility(View.VISIBLE);
                    if (cbTwo.isChecked()) {
                        diem += 10;
                    } else {
                        diem -= 5;
                    }
                    tvDiem.setText(diem + "");
                    EnableCheckBox();

                }
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                    imgPlay.setVisibility(View.VISIBLE);
                    if (cbThree.isChecked()) {
                        diem += 10;
                    } else {
                        diem -= 5;
                    }
                    tvDiem.setText(diem + "");
                    EnableCheckBox();

                }

            }

            @Override
            public void onFinish() {


            }
        };

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {


                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    imgPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    DisableCheckBox();
                } else {
                    Toast.makeText(MainActivity.this, "Tick di mong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });

    }

    private void initViews() {


        tvDiem = findViewById(R.id.tvDiem);
        cbOne = findViewById(R.id.checkboxOne);
        cbTwo = findViewById(R.id.checkboxTwo);
        cbThree = findViewById(R.id.checkboxThree);
        skOne = findViewById(R.id.seekbarOne);
        skTwo = findViewById(R.id.seekbarTwo);
        skThree = findViewById(R.id.seekbarThree);
        imgPlay = findViewById(R.id.btn);


    }


}
