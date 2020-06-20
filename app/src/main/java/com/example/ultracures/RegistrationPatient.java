package com.example.ultracures;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrationPatient extends AppCompatActivity {
    EditText ep_username,ep_email, ep_age, ep_gender, ep_address, ep_town,ep_district,ep_pincode, ep_phone, ep_password,ep_confirmp;
    String stp_name,stp_email, stp_age, stp_gender, stp_address,stp_town,stp_district,stp_phone, stp_pincode, stp_password, stp_confirmp;
    String url = "https://bikashmysql.000webhostapp.com/registerPatient.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_patient);

        ep_username = findViewById(R.id.ep_username);
        ep_email=findViewById(R.id.ep_email);
        ep_age=findViewById(R.id.ep_age);
        ep_gender=findViewById(R.id.ep_gender);
        ep_address=findViewById(R.id.ep_address);
        ep_town = findViewById(R.id.ep_town);
        ep_district=findViewById(R.id.ep_district);
        ep_phone=findViewById(R.id.ep_phone);
        ep_pincode=findViewById(R.id.ep_pincode);
        ep_password = findViewById(R.id.ep_password);
        ep_confirmp=findViewById(R.id.ep_confirmp);

    }

    public void moveToLogin(View view) {
        startActivity(new Intent(getApplicationContext(),LoginPatient.class));
        finish();
    }

    public void RegisterP(View view) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");


        if (ep_username.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        } else if (ep_email.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if (ep_age.getText().toString().equals("")) {
            Toast.makeText(this, "Age is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_gender.getText().toString().equals("")) {
            Toast.makeText(this, "Gender is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_address.getText().toString().equals("")) {
            Toast.makeText(this, "Address is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_town.getText().toString().equals("")) {
            Toast.makeText(this, "Town is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_district.getText().toString().equals("")) {
            Toast.makeText(this, "District is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_phone.getText().toString().equals("")) {
            Toast.makeText(this, "Phone No. is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_pincode.getText().toString().equals("")) {
            Toast.makeText(this, "Pincode is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_password.getText().toString().equals("")) {
            Toast.makeText(this, "Password is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ep_confirmp.getText().toString().equals("")) {
            Toast.makeText(this, "Please Confirm your Password", Toast.LENGTH_SHORT).show();
        }
        else {

            stp_name = ep_username.getText().toString().trim();
            stp_age = ep_age.getText().toString().trim();
            stp_gender = ep_gender.getText().toString().trim();
            stp_address = ep_address.getText().toString().trim();
            stp_town = ep_town.getText().toString().trim();
            stp_district = ep_district.getText().toString().trim();
            stp_phone = ep_phone.getText().toString().trim();
            stp_pincode=ep_pincode.getText().toString().trim();
            stp_email = ep_email.getText().toString().trim();
            stp_password = ep_password.getText().toString().trim();
            stp_confirmp = ep_confirmp.getText().toString().trim();

            if (stp_password.equals(stp_confirmp)) {
                progressDialog.show();

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        ep_username.setText("");
                        ep_email.setText("");
                        ep_address.setText("");
                        ep_age.setText("");
                        ep_town.setText("");
                        ep_district.setText("");
                        ep_phone.setText("");
                        ep_pincode.setText("");
                        ep_gender.setText("");
                        ep_password.setText("");
                        ep_confirmp.setText("");
                        Toast.makeText(RegistrationPatient.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationPatient.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();

                        params.put("name", stp_name);
                        params.put("email", stp_email);
                        params.put("age", stp_age);
                        params.put("gender", stp_gender);
                        params.put("address", stp_address);
                        params.put("town", stp_town);
                        params.put("district", stp_district);
                        params.put("phone", stp_phone);
                        params.put("pincode", stp_pincode);
                        params.put("password", stp_password);
                        params.put("confirmp", stp_confirmp);
                        return params;

                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(RegistrationPatient.this);
                requestQueue.add(request);

            }
            else{
                Toast.makeText(this, "Password Doesn't Match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
