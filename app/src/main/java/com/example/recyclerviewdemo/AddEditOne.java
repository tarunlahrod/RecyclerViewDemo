package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    EditText et_presName, et_presDate, et_presImageUrl;
    TextView tv_presId;

    int id;

    List<President> presidentList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        presidentList = myApplication.getPresidentList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_presName = findViewById(R.id.et_president_name);
        et_presDate = findViewById(R.id.et_dateElection);
        et_presImageUrl = findViewById(R.id.et_pictureURL);
        tv_presId = findViewById(R.id.tv_presId);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);

        President president = null;

        if (id >= 0) {

            // edit the president
            for (President p: presidentList) {
                if (p.getId() == id) {
                    president = p;
                    break;
                }
            }
            
            et_presName.setText(president.getName());
            et_presDate.setText(String.valueOf(president.getDateOfElection()));
            et_presImageUrl.setText(president.getImageURL());
            tv_presId.setText(String.valueOf(id));
        }
        else {
            // create new president
            // leave it as it is
        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id >= 0) {
                    // update
                    // create a new pres and replace with the target pres
                    President updatedPresident = new President(id, et_presName.getText().toString(), Integer.parseInt(et_presDate.getText().toString()), et_presImageUrl.getText().toString());
                    presidentList.set(id, updatedPresident);
                }
                else {
                    // add new president
                    // create President object
                    int nextId = myApplication.getNextId();
                    President newPresident = new President(nextId, et_presName.getText().toString(), Integer.parseInt(et_presDate.getText().toString()), et_presImageUrl.getText().toString());

                    // add object to the global list
                    presidentList.add(newPresident);
                    myApplication.setNextId(nextId++);
                }

                // go back to the main activity
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}