package com.qodim.tutorrrr;


import android.app.DatePickerDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2, editText3, editText4, editText5, editText6, editText10;
    Button submit, datePickerButton;
    Calendar calendar;
    RadioGroup jkewarganegaraan;
    CheckBox checkboxDevelopment, checkboxAI, checkboxDesign, checkboxWriting, checkboxFinance;



    @Override
           protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                   setContentView(R.layout.activity_main);

                   editText1=(EditText)findViewById(R.id.NIK);
                   editText2=(EditText)findViewById(R.id.nama);
                   editText3 = findViewById(R.id.datepicker);
                   editText4=(EditText)findViewById(R.id.tempatlahir);
                   editText5=(EditText)findViewById(R.id.alamat);
                   editText6=(EditText)findViewById(R.id.usia);
                   editText10=(EditText)findViewById(R.id.email);
                   jkewarganegaraan = findViewById(R.id.kewarganegaraan);
                   checkboxDevelopment = findViewById(R.id.checkbox_development);
                   checkboxAI = findViewById(R.id.checkbox_ai);
                   checkboxDesign = findViewById(R.id.checkbox_design);
                   checkboxWriting = findViewById(R.id.checkbox_writing);
                   checkboxFinance = findViewById(R.id.checkbox_finance);




                   //Spinnnnerrrr QODIMBALIGHONIM21083000098
                   Spinner genderSpinner = findViewById(R.id.gender);
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                           R.array.gender_array, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   genderSpinner.setAdapter(adapter);


               submit=(Button) findViewById(R.id.submit1);
                   datePickerButton = findViewById(R.id.datepicker_button);

//CAAAALLEEEENNDAAAAR QODIMBALIGHGHONIM21083000098

               calendar = Calendar.getInstance();

               datePickerButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       int year = calendar.get(Calendar.YEAR);
                       int month = calendar.get(Calendar.MONTH);
                       int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                       // Create date picker dialog
                       DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                               new DatePickerDialog.OnDateSetListener() {
                                   @Override
                                   public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                       // Set selected date to text view
                                       String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                       editText3.setText(date);
                                   }
                               }, year, month, dayOfMonth);
                       datePickerDialog.show();
                   }
               });




               submit.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {

                               String NIKText = editText1.getText().toString().trim();
                               if (NIKText.length() != 16) {
                                   Toast.makeText(getApplicationContext(), "NIK harus terdiri dari 16 digit", Toast.LENGTH_SHORT).show();
                                   return; // Berhenti eksekusi jika NIK tidak valid
                               }

                               // Validasi hanya angka di NIK
                               if (!NIKText.matches("[0-9]+")) {
                                   Toast.makeText(getApplicationContext(), "NIK hanya boleh berisi angka", Toast.LENGTH_SHORT).show();
                                   return; // Berhenti eksekusi jika NIK tidak valid
                               }

                               int selectedRadioButtonId = jkewarganegaraan.getCheckedRadioButtonId();
                               RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);


                                   String namaText=editText2.getText().toString().trim();
                                   String dateText = editText3.getText().toString().trim();
                                   String tempatlahirText=editText4.getText().toString().trim();
                                   String alamatText=editText5.getText().toString().trim();
                                   String usiaText=editText6.getText().toString().trim();
                                   String emailText=editText10.getText().toString().trim();
                                   String genderText = genderSpinner.getSelectedItem().toString();
                                   String nationalityText = selectedRadioButton.getText().toString();

                                   StringBuilder kompetensiBuilder = new StringBuilder();
                                   if (checkboxDevelopment.isChecked()) {
                                       kompetensiBuilder.append("Development & IT, ");
                                   }
                                   if (checkboxAI.isChecked()) {
                                       kompetensiBuilder.append("AI Services, ");
                                   }
                                   if (checkboxDesign.isChecked()) {
                                       kompetensiBuilder.append("Design Creative, ");
                                   }
                                   if (checkboxWriting.isChecked()) {
                                       kompetensiBuilder.append("Writing, ");
                                   }
                                   if (checkboxFinance.isChecked()) {
                                       kompetensiBuilder.append("Finance & Accounting, ");
                                   }
                                   String kompetensiText = kompetensiBuilder.toString().trim();


                               if (NIKText.equals("") || namaText.equals("")|| dateText.equals("")|| tempatlahirText.equals("")|| alamatText.equals("")|| usiaText.equals("")|| usiaText.equals("")){
                                       Toast.makeText(getApplicationContext(),"Plz fill all the fields",Toast.LENGTH_SHORT).show();
                                   }else {
                                       Intent intent=new Intent(getApplicationContext(), ActivityTwo.class);
                                       intent.putExtra("NIK",NIKText);
                                       intent.putExtra("nama",namaText);
                                       intent.putExtra("datepicker", dateText);
                                       intent.putExtra("tempatlahir",tempatlahirText);
                                       intent.putExtra("alamat",alamatText);
                                       intent.putExtra("usia",usiaText);
                                       intent.putExtra("email",emailText);
                                       intent.putExtra("gender", genderText);
                                       intent.putExtra("nationality", nationalityText);
                                       intent.putExtra("kompetensi", kompetensiText);

                                   startActivity(intent);
                                   }
                              }
                       });


               }
       }