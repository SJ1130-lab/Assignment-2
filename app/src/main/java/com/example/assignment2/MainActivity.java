package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup materialRadioGroup;
    private CheckBox expressShippingCheckBox;
    private RatingBar sareeRatingBar;
    private SeekBar discountSeekBar;
    private Switch giftWrapSwitch;
    private TextView discountPercentageText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        materialRadioGroup = findViewById(R.id.materialRadioGroup);
        expressShippingCheckBox = findViewById(R.id.expressShippingCheckBox);
        sareeRatingBar = findViewById(R.id.sareeRatingBar);
        discountSeekBar = findViewById(R.id.discountSeekBar);
        giftWrapSwitch = findViewById(R.id.giftWrapSwitch);
        discountPercentageText = findViewById(R.id.discountPercentageText);
        submitButton = findViewById(R.id.submitButton);


        discountSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                discountPercentageText.setText(progress + "% Discount");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected material
                int selectedMaterialId = materialRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedMaterialRadioButton = findViewById(selectedMaterialId);
                String material = selectedMaterialRadioButton != null ? selectedMaterialRadioButton.getText().toString() : "None";


                boolean expressShipping = expressShippingCheckBox.isChecked();


                float rating = sareeRatingBar.getRating();


                int discount = discountSeekBar.getProgress();


                boolean giftWrap = giftWrapSwitch.isChecked();


                String resultMessage = "Material: " + material +
                        "\nExpress Shipping: " + (expressShipping ? "Yes" : "No") +
                        "\nRating: " + rating + " stars" +
                        "\nDiscount: " + discount + "%" +
                        "\nGift Wrap: " + (giftWrap ? "Yes" : "No");

                Toast.makeText(MainActivity.this, resultMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}
