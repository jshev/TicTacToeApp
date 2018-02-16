package ser210.quinnipiac.edu.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onStart(View view) {
        EditText nameView = (EditText) findViewById(R.id.name);
        String nameText = nameView.getText().toString();
        String welcomeText = "Hello, " + nameText + "!";

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_WELCOME, welcomeText);
        startActivity(intent);
    }
}
