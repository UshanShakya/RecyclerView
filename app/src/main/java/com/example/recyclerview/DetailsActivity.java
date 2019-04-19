package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {

    private CircleImageView circImage;
    private TextView tvName,tvPhone,tvAddress,tvEmail;
    private Button btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        circImage= findViewById(R.id.imgPhoto);
        tvName= findViewById(R.id.tvName);
        tvPhone= findViewById(R.id.tvPhone);
        tvAddress= findViewById(R.id.tvAddress);
        tvEmail= findViewById(R.id.tvEmail);
        btnBack= findViewById(R.id.btnBack);




        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            circImage.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvPhone.setText(bundle.getString("phone"));
            tvEmail.setText(bundle.getString("email"));
            tvAddress.setText(bundle.getString("address"));
        }
        else
        {
            Toast.makeText(this,"No message",Toast.LENGTH_LONG).show();
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                                           intent.putExtra("message","You came back!");
                                           DetailsActivity.this.startActivity(intent);

                                       }
                                   }
        );


    }

}
