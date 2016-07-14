package rus.praneet.jiraporn.rusrun;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private ImageView imageView;
    private static final String urlLogo = "http://swiftcodingthai.com/rus/image/logo_rus.png";
    private String userString, passwordString;
    private static final String urlJSON = "http://swiftcodingthai.com/rus/get_user_jiraporn.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);
        imageView = (ImageView) findViewById(R.id.imageView6);

        //Load Image from Server

        Picasso.with(this).load(urlLogo).into(imageView);

    }  //Main Method

    //Create Inner Class
    private class SynUser extends AsyncTask<Void, Void, String> {

        //Explicit
        private String myJSONString, myUserString, myPasswordString;
        private Context context;

        public SynUser(String myJSONString,
                       String myUserString,
                       String myPasswordString,
                       Context context) {
            this.myJSONString = myJSONString;
            this.myUserString = myUserString;
            this.myPasswordString = myPasswordString;
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... voids) {



            return null;
        } //doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        } //onPost


    } //SynUser Class


    public void clickSignIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Have Space",
                    "Please Fill All Every Blank");
        } else {
            //No space
            SynUser synUser = new SynUser(urlJSON, userString, passwordString, this);
            synUser.execute();

        } //if


    }//clickSign


    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
    }
}   //main Class นี่คือคลาสหลักนะจ้ะ
