package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {

    private CircleImageView circImage;
    private TextView tvName,tvPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        circImage= findViewById(R.id.imgPhoto);
        tvName= findViewById(R.id.tvName);
        tvPhone= findViewById(R.id.tvPhone);

        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            circImage.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvPhone.setText(bundle.getString("phone"));
        }
    }
}
