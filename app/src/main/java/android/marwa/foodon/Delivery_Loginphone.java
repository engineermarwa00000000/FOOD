package android.marwa.foodon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.food.R;
import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class Delivery_Loginphone extends AppCompatActivity {

    EditText num;
    Button sendotp,signinemail;
    TextView signup;
    CountryCodePicker cpp;
    FirebaseAuth Fauth;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery__loginphone);

        num = (EditText)findViewById(R.id.Dphonenumber);
        sendotp = (Button)findViewById(R.id.Sendotp);
        cpp=(CountryCodePicker)findViewById(R.id.countrycode);
        signinemail=(Button)findViewById(R.id.DbtnEmail);
        signup = (TextView)findViewById(R.id.Signupif);

        Fauth = FirebaseAuth.getInstance();

        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=num.getText().toString().trim();
                String Phonenumber = cpp.getSelectedCountryCodeWithPlus()+number;
                Intent b = new Intent(Delivery_Loginphone.this,Delivery_sendotp.class);

                b.putExtra("Phonenumber",Phonenumber);
                startActivity(b);
                finish();
            }
        });

        signinemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delivery_Loginphone.this,Delivery_Registration.class));
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Delivery_Loginphone.this,Delivery_Login.class));
                finish();
            }
        });
    }
}