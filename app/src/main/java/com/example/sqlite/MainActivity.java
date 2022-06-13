package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        dbHandler = new DBHandler(MainActivity.this);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = courseNameEdt.getText().toString();
                String courseDuration = courseDurationEdt.getText().toString();
                if (courseName.isEmpty() && courseDuration.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_LONG).show();
                    return;
                }
                dbHandler.addNewCourse (courseName, courseDuration);
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_LONG).show();
                courseNameEdt.setText("");
                courseDurationEdt.setText("");
                courseTracksEdt.setText("");
                courseDescriptionEdt.setText("");
            }
        });
    }
}
