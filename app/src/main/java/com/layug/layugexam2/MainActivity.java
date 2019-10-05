package com.layug.layugexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
    }

    public void Save(View v){
        FileOutputStream writer = null;
        String input = cb1.getText().toString() + ",";
        String input2 = cb2.getText().toString() + ",";
        String input3 = cb3.getText().toString() + ",";
        String input4 = cb4.getText().toString() + ",";
        String input5 = cb5.getText().toString() + ",";
        String input6 = cb6.getText().toString() + ",";
        String input7 = cb7.getText().toString() + ",";
        String input8 = cb8.getText().toString();
        try {
            writer = openFileOutput("data.txt", MODE_APPEND);
            writer.write(input.getBytes());
            writer.write(input2.getBytes());
            writer.write(input3.getBytes());
            writer.write(input4.getBytes());
            writer.write(input5.getBytes());
            writer.write(input6.getBytes());
            writer.write(input7.getBytes());
            writer.write(input8.getBytes());
        }catch (IOException e){
            Log.d("error", "IOException");
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found 2");
            }
        }
        Toast.makeText(this, "Courses Saved", Toast.LENGTH_LONG).show();
    }

    public void Next(View v)
    {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

}
