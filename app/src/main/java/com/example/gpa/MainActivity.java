package com.example.gpa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    protected int gradePoint(String grade) {
        switch (grade) {
            case "S":
                return 10;
            case "A":
                return 9;
            case "B":
                return 8;
            case "C":
                return 7;
            case "D":
                return 6;
            case "E":
                return 5;
            case "F":
            case "Select Credit":
                return 0;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14;
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn = findViewById(R.id.btn);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txtView1 = findViewById(R.id.txtView1);

        s1 = findViewById(R.id.sp1);
        s2 = findViewById(R.id.sp2);
        s3 = findViewById(R.id.sp3);
        s4 = findViewById(R.id.sp4);
        s5 = findViewById(R.id.sp5);
        s6 = findViewById(R.id.sp6);
        s7 = findViewById(R.id.sp7);
        s8 = findViewById(R.id.sp8);
        s9 = findViewById(R.id.sp9);
        s10 = findViewById(R.id.sp10);
        s11 = findViewById(R.id.sp11);
        s12 = findViewById(R.id.sp12);
        s13 = findViewById(R.id.sp13);
        s14 = findViewById(R.id.sp14);

        String[] credits = {"1", "2", "3", "4"};
        String[] grade = {"S", "A", "B", "C", "D", "E", "F"};

        ArrayAdapter aa1 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, credits);
        ArrayAdapter aa2 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, grade);

        s1.setAdapter(aa1);
        s3.setAdapter(aa1);
        s5.setAdapter(aa1);
        s7.setAdapter(aa1);
        s9.setAdapter(aa1);
        s11.setAdapter(aa1);
        s13.setAdapter(aa1);

        s2.setAdapter(aa2);
        s4.setAdapter(aa2);
        s6.setAdapter(aa2);
        s8.setAdapter(aa2);
        s10.setAdapter(aa2);
        s12.setAdapter(aa2);
        s14.setAdapter(aa2);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int sub1Credit = Integer.parseInt(s1.getSelectedItem().toString());
                int sub2Credit = Integer.parseInt(s3.getSelectedItem().toString());
                int sub3Credit = Integer.parseInt(s5.getSelectedItem().toString());
                int sub4Credit = Integer.parseInt(s7.getSelectedItem().toString());
                int sub5Credit = Integer.parseInt(s9.getSelectedItem().toString());
                int sub6Credit = Integer.parseInt(s11.getSelectedItem().toString());
                int sub7Credit = Integer.parseInt(s13.getSelectedItem().toString());

                int sub1Grade = gradePoint(s2.getSelectedItem().toString());
                int sub2Grade = gradePoint(s4.getSelectedItem().toString());
                int sub3Grade = gradePoint(s6.getSelectedItem().toString());
                int sub4Grade = gradePoint(s8.getSelectedItem().toString());
                int sub5Grade = gradePoint(s10.getSelectedItem().toString());
                int sub6Grade = gradePoint(s12.getSelectedItem().toString());
                int sub7Grade = gradePoint(s14.getSelectedItem().toString());

                int totalCredits = sub1Credit + sub2Credit + sub3Credit + sub4Credit + sub5Credit + sub6Credit + sub7Credit;

                double gpa = (double)(sub1Credit * sub1Grade + sub2Credit * sub2Grade + sub3Credit * sub3Grade + sub4Credit * sub4Grade + sub5Credit * sub5Grade + sub6Credit * sub6Grade + sub7Credit * sub7Grade)/(totalCredits);
                DecimalFormat f = new DecimalFormat("##.00");

                txtView1.setText("Your GPA is "+ f.format(gpa));
            }});
}
}