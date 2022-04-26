package my.edu.utem.ftmk.floodemergencyapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class test extends AppCompatActivity {

    private boolean passwordShowing = false;
    private boolean conPasswordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq);

        final EditText fullNameEt = findViewById(R.id.fullNameEt);
        final EditText phoneEt = findViewById(R.id.phoneEt);
        final EditText usernameEt = findViewById(R.id.usernameEt);

        final EditText passwordEt = findViewById(R.id.passwordEt);
        final EditText confirmPasswordEt = findViewById(R.id.confirmPasswordEt);
        final ImageView passwordIconIv = findViewById(R.id.passwordIconIv);
        final ImageView passwordIconConfirmIv = findViewById(R.id.passwordIconConfirmIv);

        final AppCompatButton signUpBtn = findViewById(R.id.signUpBtn);
        final TextView SignInTv = findViewById(R.id.SignInTv);

        passwordIconIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passwordShowing){
                    passwordShowing = false;

                    passwordEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIconIv.setImageResource(R.drawable.show_password);
                }
                else{
                    passwordShowing = true;

                    passwordEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIconIv.setImageResource(R.drawable.hide_password);

                }

                //move the cursor at last of the text
                passwordEt.setSelection(passwordEt.length());

            }
        });

        passwordIconConfirmIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conPasswordShowing){
                    conPasswordShowing = false;

                    confirmPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIconIv.setImageResource(R.drawable.show_password);
                }
                else{
                    conPasswordShowing = true;

                    confirmPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIconIv.setImageResource(R.drawable.hide_password);

                }

                //move the cursor at last of the text
                confirmPasswordEt.setSelection(confirmPasswordEt.length());

            }
        });



        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        SignInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(test.this, LoginActivity.class ));
            }
        });



    }
}