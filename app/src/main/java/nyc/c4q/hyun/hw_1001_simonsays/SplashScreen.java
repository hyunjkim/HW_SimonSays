package nyc.c4q.hyun.hw_1001_simonsays;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class SplashScreen extends AppCompatActivity implements View.OnClickListener {

    private Button redbutt;
    private Button bluebutt;
    private Button greenbutt;
    private Button yellowbutt;
    private Stack<Integer> randomIndices;
    private String [] colorArray ={"blue","red","green","yellow"};

//    public static SimonSays simon = new SimonSays();
    ArrayList<String> userPattern = new ArrayList<>();                  // to hold the pattern of the random colors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // generate a random number
        int index = generateRandom();
        String readColor = colorArray[index];
        // add the value of the color to the  userPattern array
        userPattern.add(readColor);
        // display to user
        display(index);

        butts();
        clickbutts();

    }

    // random # generator
    public int generateRandom() {
        Random random = new Random();
        int fun = random.nextInt(colorArray.length);
        return fun;
    }

    // instantiate buttons
    private void butts() {
        redbutt = (Button) findViewById(R.id.red_button);
        bluebutt = (Button) findViewById(R.id.blue_button);
        greenbutt = (Button) findViewById(R.id.green_button);
        yellowbutt = (Button) findViewById(R.id.yellow_button);
    }

    // listen to button clicks
    private void clickbutts() {
        redbutt.setOnClickListener(this);
        bluebutt.setOnClickListener(this);
        greenbutt.setOnClickListener(this);
        yellowbutt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        int index = generateRandom();
        String readColor = colorArray[index];

        if(readColor.equalsIgnoreCase("red")){
            Toast(0);
            userPattern.add(readColor);
        } else if (readColor.equalsIgnoreCase("blue")){
            Toast(1);
            userPattern.add(readColor);
        } else if (readColor.equalsIgnoreCase("green")){
            Toast(2);
            userPattern.add(readColor);
        } else {
            Toast(3);
            userPattern.add(readColor);
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void Toast(int input) {
        Context context = getApplicationContext();
        CharSequence r = "red";
        CharSequence b = "blue";
        CharSequence g = "green";
        CharSequence y = "yellow";
        int duration = Toast.LENGTH_SHORT;

        switch (input) {
            case 0:
                Toast red = Toast.makeText(context, r, duration);
                red.show();
                break;
            case 1:
                Toast blue = Toast.makeText(context, b, duration);
                blue.show();
                break;
            case 2:
                Toast green = Toast.makeText(context, g, duration);
                green.show();
                break;
            case 3:
                Toast yellow = Toast.makeText(context, y, duration);
                yellow.show();
                break;
        }
    }
    private void display(int input){
        Context context = getApplicationContext();
        CharSequence r = "red";
        CharSequence b = "blue";
        CharSequence g = "green";
        CharSequence y = "yellow";
        int duration = Toast.LENGTH_SHORT;

        switch (input) {
            case 0:
                redbutt.setOnClickListener(this);
                break;
            case 1:
                bluebutt.setOnClickListener(this);
                break;
            case 2:
                greenbutt.setOnClickListener(this);
                break;
            case 3:
                yellowbutt.setOnClickListener(this);
                break;
        }

    }
}
