package com.thededlier.rohan.bookmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText)findViewById(R.id.user_name);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, etUserName.getText().toString());
        startActivity(intent);
    }
}
