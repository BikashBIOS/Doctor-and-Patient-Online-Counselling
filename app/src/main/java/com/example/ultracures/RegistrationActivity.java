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
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    EditText ed_username,ed_speciality, ed_qualification, ed_designation, ed_institution, ed_email,ed_mobile,ed_account, ed_hours, ed_password,ed_confirmp;
    String str_name,str_speciality, str_qualification, str_designation, str_institution,str_email,str_mobile,str_account, str_hours, str_password, str_confirmp;
    String url = "https://bikashmysql.000webhostapp.com/registerDoctor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ed_username = findViewById(R.id.ed_username);
        ed_speciality=findViewById(R.id.ed_speciality);
        ed_qualification=findViewById(R.id.ed_qualification);
        ed_designation=findViewById(R.id.ed_designation);
        ed_institution=findViewById(R.id.ed_institution);
        ed_email = findViewById(R.id.ed_email);
        ed_mobile=findViewById(R.id.ed_mobile);
        ed_account=findViewById(R.id.ed_account);
        ed_hours=findViewById(R.id.ed_hours);
        ed_password = findViewById(R.id.ed_password);
        ed_confirmp=findViewById(R.id.ed_confirmp);

    }

    public void moveToLogin(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }

    public void Register(View view) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");


        if (ed_username.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        } else if (ed_speciality.getText().toString().equals("")) {
            Toast.makeText(this, "If not Present, Type NONE", Toast.LENGTH_SHORT).show();
        }
        else if (ed_qualification.getText().toString().equals("")) {
            Toast.makeText(this, "If not Present, Type NONE", Toast.LENGTH_SHORT).show();
        }
        else if (ed_designation.getText().toString().equals("")) {
            Toast.makeText(this, "If not Present, Type NONE", Toast.LENGTH_SHORT).show();
        }
        else if (ed_institution.getText().toString().equals("")) {
            Toast.makeText(this, "If not Present, Type NONE", Toast.LENGTH_SHORT).show();
        }
        else if (ed_email.getText().toString().equals("")) {
            Toast.makeText(this, "Email is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ed_mobile.getText().toString().equals("")) {
            Toast.makeText(this, "Mobile No. is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ed_account.getText().toString().equals("")) {
            Toast.makeText(this, "Account No. is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ed_hours.getText().toString().equals("")) {
            Toast.makeText(this, "Working Hours are Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ed_password.getText().toString().equals("")) {
            Toast.makeText(this, "Password is Mandatory", Toast.LENGTH_SHORT).show();
        }
        else if (ed_confirmp.getText().toString().equals("")) {
            Toast.makeText(this, "Please Confirm your Password", Toast.LENGTH_SHORT).show();
        }
        else {

            progressDialog.show();
            str_name = ed_username.getText().toString().trim();
            str_speciality = ed_speciality.getText().toString().trim();
            str_qualification = ed_qualification.getText().toString().trim();
            str_designation = ed_designation.getText().toString().trim();
            str_institution = ed_institution.getText().toString().trim();
            str_email = ed_email.getText().toString().trim();
            str_mobile = ed_mobile.getText().toString().trim();
            str_account=ed_account.getText().toString().trim();
            str_hours = ed_hours.getText().toString().trim();
            str_password = ed_password.getText().toString().trim();
            str_confirmp = ed_confirmp.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    ed_username.setText("");
                    ed_speciality.setText("");
                    ed_qualification.setText("");
                    ed_designation.setText("");
                    ed_institution.setText("");
                    ed_email.setText("");
                    ed_mobile.setText("");
                    ed_account.setText("");
                    ed_hours.setText("");
                    ed_password.setText("");
                    ed_confirmp.setText("");
                    Toast.makeText(RegistrationActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(RegistrationActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("name", str_name);
                    params.put("speciality", str_speciality);
                    params.put("qualification", str_qualification);
                    params.put("designation", str_designation);
                    params.put("institution", str_institution);
                    params.put("email", str_email);
                    params.put("mobile", str_mobile);
                    params.put("account", str_account);
                    params.put("hours", str_hours);
                    params.put("password", str_password);
                    params.put("confirmp", str_confirmp);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);
            requestQueue.add(request);


        }
    }
}
