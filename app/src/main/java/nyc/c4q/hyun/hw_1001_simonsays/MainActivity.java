package nyc.c4q.hyun.hw_1001_simonsays;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button playbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playbutton = (Button) findViewById(R.id.play_button);
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            startSplash();

            }
        });
    }

    public void startSplash(){
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }
}
