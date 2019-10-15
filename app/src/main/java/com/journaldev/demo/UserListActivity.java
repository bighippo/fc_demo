package com.journaldev.demo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class UserListActivity extends Activity {

    private DBManager dbManager;

    private ListView listView;

    private TextView btnAdd;

    private TextView btnDelete;

    private TextView btnGroup;

    private TextView btnClear;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.NAME, DatabaseHelper.PHONE };

    final int[] to = new int[] { R.id.id, R.id.tv_name, R.id.tv_number };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.item_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
//                TextView idTextView = (TextView) view.findViewById(R.id.id);
//                TextView titleTextView = (TextView) view.findViewById(R.id.title);
//                TextView descTextView = (TextView) view.findViewById(R.id.desc);
//
//                String id = idTextView.getText().toString();
//                String title = titleTextView.getText().toString();
//                String desc = descTextView.getText().toString();
//
//                Intent modify_intent = new Intent(getApplicationContext(), ModifyUserActivity.class);
//                modify_intent.putExtra("title", title);
//                modify_intent.putExtra("desc", desc);
//                modify_intent.putExtra("id", id);
//
//                startActivity(modify_intent);
            }
        });


        btnAdd = (TextView) findViewById(R.id.btn_add);
        btnDelete = (TextView) findViewById(R.id.btn_delete);
        btnGroup = (TextView) findViewById(R.id.btn_group);
        btnClear = (TextView) findViewById(R.id.btn_clear);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_mem = new Intent(getApplication(), AddUserActivity.class);
                startActivity(add_mem);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}