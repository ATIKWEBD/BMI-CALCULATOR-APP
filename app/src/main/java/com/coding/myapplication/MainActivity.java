package com.coding.myapplication;

import static com.coding.myapplication.R.id.clmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 // Correct import statement
import com.coding.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextFT, editTextIN, editTextKG;
        Button button;
        TextView textresult;
        ConstraintLayout clmain;

        editTextFT = findViewById(R.id.editTextFT);
        editTextKG = findViewById(R.id.editTextKG);
        editTextIN = findViewById(R.id.editTextIN);
        button = findViewById(R.id.button);
        textresult = findViewById(R.id.textresult);
        clmain = findViewById(R.id.clmain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weightStr = editTextKG.getText().toString();
                String feetStr = editTextFT.getText().toString();
                String inchesStr = editTextIN.getText().toString();

                // Check for empty inputs
                if (weightStr.isEmpty() || feetStr.isEmpty() || inchesStr.isEmpty()) {
                    textresult.setText("Please fill in all fields");
                    return;
                }

                // Parse the input values
                int Wt = Integer.parseInt(weightStr);
                int Ft = Integer.parseInt(feetStr);
                int In = Integer.parseInt(inchesStr);

                // Calculate height in meters
                int totalin = Ft * 12 + In;
                double Mt = totalin * 0.0254; // Correct conversion from inches to meters
                // Calculate BMI
                double bmi = Wt / (Mt * Mt);

                // Set the result
                if (bmi > 25) {
                    textresult.setText("You are Overweight");
                    clmain.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (bmi < 18) {
                    textresult.setText("You are underweight");
                    clmain.setBackgroundColor(getResources().getColor(R.color.yellow));
                } else {
                    textresult.setText("You are Fit");
                    clmain.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });
    }
}
