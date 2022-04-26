package my.edu.utem.ftmk.floodemergencyapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private boolean passwordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText usernameEt = findViewById(R.id.usernameEt);
        final EditText passwordEt = findViewById(R.id.passwordEt);
        TextView forgotPasswordTv = findViewById(R.id.forgotPasswordTv);
        final ImageView passwordIconIv = findViewById(R.id.passwordIconIv);
        TextView loginBtn = findViewById(R.id.loginBtn);
        TextView SignUpTv = findViewById(R.id.SignUpTv);

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

//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, RegisterActivity.class ));
//            }
//        });

        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }
}