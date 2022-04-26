package my.edu.utem.ftmk.floodemergencyapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class OTPVerification extends AppCompatActivity {

    private EditText otpEt1, otpEt2, otpEt3, otpEt4;
    private TextView otpEmailTv, otpPhoneTv, resendCodeTv;
    private AppCompatButton verifyBtn;

    // true after every 60 second
    private boolean resendEnabled = false;

    // resend time in second
    private int resendTime = 60;

    private  int selectedETPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        otpEt1 = findViewById(R.id.otpET1);
        otpEt2 = findViewById(R.id.otpET2);
        otpEt3 = findViewById(R.id.otpET3);
        otpEt4 = findViewById(R.id.otpET4);

        resendCodeTv = findViewById(R.id.resendCodeTv);

        final TextView otpEmailTv = findViewById(R.id.otpEmailTv);
        final TextView otpPhoneTv = findViewById(R.id.otpPhoneTv);

        // getting email
        final String getEmailTxt = getIntent().getStringExtra("email");
        final String getPhoneNumberTxt = getIntent().getStringExtra("mobile");

        // setting email and phone to textview

//        otpEmailTv.setText(getEmailTxt);
//        otpPhoneTv.setText(getPhoneNumberTxt);

        otpEt1.addTextChangedListener(textWatcher);
        otpEt2.addTextChangedListener(textWatcher);
        otpEt3.addTextChangedListener(textWatcher);
        otpEt4.addTextChangedListener(textWatcher);

        //by default open keyboard at otpET1
        showKeyboard(otpEt1);

        resendCodeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resendEnabled){

                    //start new resend count
                    startCountDownTimer();
                }
            }
        });

//        verifyBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final  String generateOtp = otpEt1.getText().toString()+otpEt2.getText().toString()+
//                        otpEt3.getText().toString()+otpEt4.getText().toString();
//
//                if(generateOtp.length() == 4) {
//
//                }
//            }
//        });

    }


    private void  showKeyboard(EditText otpET){
        otpET.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpET, InputMethodManager.SHOW_IMPLICIT);

    }
    private void startCountDownTimer(){

        resendEnabled = false;
        resendCodeTv.setTextColor(Color.parseColor("#9900000000"));

        new CountDownTimer(resendTime * 60, 100){

            @Override
            public void onTick(long l) {
                resendCodeTv.setText("Resend Code ("+(l/60)+")");
            }

            @Override
            public void onFinish() {
                resendEnabled = true;
                resendCodeTv.setText("Resend Code");
                resendCodeTv.setTextColor(getResources().getColor(R.color.design_default_color_on_primary));
            }
        }.start();
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if(editable.length() > 0){
                if(selectedETPosition == 0){

                    selectedETPosition = 1;
                    showKeyboard(otpEt2);
                }
                else if(selectedETPosition == 1){

                    selectedETPosition = 2;
                    showKeyboard(otpEt3);
                }
                else if(selectedETPosition == 2){

                    selectedETPosition = 3;
                    showKeyboard(otpEt4);
                }
            }

        }
    };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_DEL){
            if(selectedETPosition == 3){
                selectedETPosition =2;
                showKeyboard(otpEt3);
            }
            else if(selectedETPosition == 2){
                selectedETPosition =1;
                showKeyboard(otpEt2);
            }
            else if(selectedETPosition == 1){
                selectedETPosition =0;
                showKeyboard(otpEt1);
            }
            return true;
        }
        else{

            return super.onKeyUp(keyCode, event);
        }

    }
}