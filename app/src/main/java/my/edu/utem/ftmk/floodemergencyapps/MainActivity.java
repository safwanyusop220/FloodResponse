package my.edu.utem.ftmk.floodemergencyapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView backBtn;
    private CardView gyroscopeCard,floodLevelCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backBtn = findViewById(R.id.backBtn);
        gyroscopeCard = findViewById(R.id.gyroscopeCard);
        floodLevelCard = findViewById(R.id.floodLevelCard);
        //handle click go back
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        gyroscopeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gyroscopeSensorActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Directing to gyroscopeSensorActivity Menu", Toast.LENGTH_SHORT).show();
            }
        });

        floodLevelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FloodLevelActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Directing to FloodLevelActivity Menu", Toast.LENGTH_SHORT).show();
            }
        });

    }
}