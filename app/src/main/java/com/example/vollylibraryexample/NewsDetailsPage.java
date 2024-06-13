package com.example.vollylibraryexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewsDetailsPage extends AppCompatActivity {

    int itemPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details_page);

        itemPosition=getIntent().getIntExtra("key",0);
        Toast.makeText(this, ""+MainActivity.list.get(itemPosition).getTitle(), Toast.LENGTH_SHORT).show();



    }
}