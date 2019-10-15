package com.journaldev.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddUserActivity extends Activity implements OnClickListener {

    private Button btnAdd;
    private EditText etUsername;
    private EditText etNumber;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_record);

        etUsername = (EditText) findViewById(R.id.et_username);
        etNumber = (EditText) findViewById(R.id.et_number);

        btnAdd = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = etUsername.getText().toString();
                final String number = etNumber.getText().toString();

                dbManager.insert(name, number);

                Intent main = new Intent(AddUserActivity.this, UserListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

}