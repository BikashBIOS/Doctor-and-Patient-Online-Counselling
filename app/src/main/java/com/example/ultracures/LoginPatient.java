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

public class LoginPatient extends AppCompatActivity {

    EditText ep_email, ep_password;
    String stp_email, stp_password;
    String url = "https://bikashmysql.000webhostapp.com/loginPatient.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);

        ep_email = findViewById(R.id.ep_email);
        ep_password = findViewById(R.id.ep_password);
    }

    public void LoginP(View view) {

        if (ep_email.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
        } else if (ep_password.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
        } else {


            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait..");

            progressDialog.show();

            stp_email = ep_email.getText().toString().trim();
            stp_password = ep_password.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if (response.equalsIgnoreCase("Logged In Successfully")) {

                        ep_email.setText("");
                        ep_password.setText("");
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        Toast.makeText(LoginPatient.this, response, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginPatient.this, response, Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginPatient.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email", stp_email);
                    params.put("password", stp_password);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(LoginPatient.this);
            requestQueue.add(request);

        }
    }

    public void moveToRegistration(View view) {
        startActivity(new Intent(getApplicationContext(), RegistrationPatient.class));
        finish();
    }
}
