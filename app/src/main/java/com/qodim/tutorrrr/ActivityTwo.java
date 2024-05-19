package com.qodim.tutorrrr;

    import android.content.Intent;
    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.RadioButton;
    import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, t6, t10, genderTextView, kompetensiTextView ;
    Button b1;
    TextView nationalityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        t1 = findViewById(R.id.text_view1);
        t2 = findViewById(R.id.text_view2);
        t3 = findViewById(R.id.text_view3);
        t4 = findViewById(R.id.text_view4);
        t5 = findViewById(R.id.text_view5);
        t6 = findViewById(R.id.text_view6);
        t10 = findViewById(R.id.text_view10);
        genderTextView = findViewById(R.id.text_view_gender);
        nationalityTextView = findViewById(R.id.text_view_nationality);
        kompetensiTextView = findViewById(R.id.text_view_kompetensi);


        b1 = findViewById(R.id.back);

        Intent intent = getIntent();
        String text1 = intent.getStringExtra("NIK");
        String text2 = intent.getStringExtra("nama");
        String text3 = intent.getStringExtra("datepicker");
        String text4 = intent.getStringExtra("tempatlahir");
        String text5 = intent.getStringExtra("alamat");
        String text6 = intent.getStringExtra("usia");
        String text10 = intent.getStringExtra("email");
        String gender = intent.getStringExtra("gender");
        String nationality = intent.getStringExtra("nationality");
        String kompetensi = intent.getStringExtra("kompetensi");
        kompetensiTextView.setText(kompetensi);


        t1.setText(text1);
        t2.setText(text2);
        t3.setText(text3);
        t4.setText(text4);
        t5.setText(text5);
        t6.setText(text6);
        t10.setText(text10);
        genderTextView.setText(gender);
        nationalityTextView.setText(nationality);
        kompetensiTextView.setText(kompetensi);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

