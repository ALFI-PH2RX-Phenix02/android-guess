package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int randomnum;
    TextView t1,t2;
    android.widget.ImageView btnup,btndown,btncheck,btnup_gray,btndown_gray,btncheck_gray,imgcorrect,imgwrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomnum = (int) (Math.random() * 999 + 1);
        t1=(TextView)(findViewById(R.id.t_number));
        t2=(TextView)(findViewById(R.id.t_hint));
        btnup=findViewById(R.id.btn_1up);
        btnup_gray=findViewById(R.id.btn_1up_gray);
        btndown=findViewById(R.id.btn_1down);
        btndown_gray=findViewById(R.id.btn_1down_gray);
        btncheck=findViewById(R.id.btn_check);
        btncheck_gray=findViewById(R.id.btn_check_gray);
        imgcorrect=findViewById(R.id.img_correct);
        imgwrong=findViewById(R.id.img_wrong);

        btnup.setVisibility(View.INVISIBLE);
        btndown.setVisibility(View.INVISIBLE);
        btncheck.setVisibility(View.INVISIBLE);
        btnup_gray.setVisibility(View.VISIBLE);
        btndown_gray.setVisibility(View.VISIBLE);
        btncheck_gray.setVisibility(View.VISIBLE);
        imgcorrect.setVisibility(View.INVISIBLE);
        imgwrong.setVisibility(View.INVISIBLE);

        t1.addTextChangedListener(textWatcher);
    }

    android.text.TextWatcher textWatcher = new android.text.TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(android.text.Editable s) {
            String temp = (t1.getText().toString());
            if(isNumber(temp)) {
                btnup.setVisibility(View.VISIBLE);
                btndown.setVisibility(View.VISIBLE);
                btncheck.setVisibility(View.VISIBLE);
                btnup_gray.setVisibility(View.INVISIBLE);
                btndown_gray.setVisibility(View.INVISIBLE);
                btncheck_gray.setVisibility(View.INVISIBLE);
            }
            else {
                btnup_gray.setVisibility(View.VISIBLE);
                btndown_gray.setVisibility(View.VISIBLE);
                btncheck_gray.setVisibility(View.VISIBLE);
                btnup.setVisibility(View.INVISIBLE);
                btndown.setVisibility(View.INVISIBLE);
                btncheck.setVisibility(View.INVISIBLE);
            }
            imgcorrect.setVisibility(View.INVISIBLE);
            imgwrong.setVisibility(View.INVISIBLE);
        }
    };
    public void check(android.view.View view){
        btncheck.setVisibility(View.INVISIBLE);
        int num=Integer.parseInt(t1.getText().toString());
        if(num>randomnum) {
            t2.setText("Too high");
            imgwrong.setVisibility(View.VISIBLE);
        }
        else if(num<randomnum) {
            t2.setText("Too low");
            imgwrong.setVisibility(View.VISIBLE);
        }
        else {
            t2.setText("Congratulations! You've got the right number!");
            imgcorrect.setVisibility(View.VISIBLE);
        }
    }
    public void Oneup(android.view.View view){
        int num=Integer.parseInt(t1.getText().toString());
        num++;
        t1.setText(String.valueOf(num));
        imgcorrect.setVisibility(View.INVISIBLE);
        imgwrong.setVisibility(View.INVISIBLE);
    }
    public void Onedown(android.view.View view){
        int num=Integer.parseInt(t1.getText().toString());
        num--;
        t1.setText(String.valueOf(num));
        imgcorrect.setVisibility(View.INVISIBLE);
        imgwrong.setVisibility(View.INVISIBLE);
    }


    public boolean isNumber(String str) {
        if(str.equals("")) return false;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

