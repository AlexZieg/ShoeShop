package small_it.shoeshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import small_it.shoeshop.sales.Ladies;

/**
 * Main Class which handles the starting point of the Application
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtUser, edtPass;
    Button btnLogin;

    /**
     * Main Activity start the android Application
     * @param savedInstanceState created Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setViews();
    }

    /**
     * Method to setup the Views
     */
    private void setViews() {
        edtUser = (EditText) findViewById(R.id.edUser);
        edtPass = (EditText) findViewById(R.id.edPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    /**
     * Method to do the onClick Actions
     *
     * ! Hardcoded !
     * This method provides the Login Information for two possible options:
     * a) Administrator
     *      Provides the Setup and Layout Methods
     * b) Customer
     *      Contains the raw Application where the User could choose between the articles
     *
     * ! Hardcoded
     *
     * @param view view of the Buttons
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin){
            if(edtUser.getText().toString().equals(getString(R.string.admin)) && edtPass.getText().toString().equals(getString(R.string.admin))){
                Toast.makeText(this, R.string.comingSoon, Toast.LENGTH_LONG).show();
            }else if (edtUser.getText().toString().equals(getString(R.string.customer)) && edtPass.getText().toString().equals(getString(R.string.customer))){
                // Start App
                Intent intent = new Intent(getApplicationContext(), Ladies.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.wrogPassword, Toast.LENGTH_LONG).show();
            }
        }
    }
}
