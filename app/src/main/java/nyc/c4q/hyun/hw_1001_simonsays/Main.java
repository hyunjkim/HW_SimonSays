package nyc.c4q.hyun.hw_1001_simonsays;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static nyc.c4q.hyun.hw_1001_simonsays.R.id.blue_button;
import static nyc.c4q.hyun.hw_1001_simonsays.R.id.green_button;
import static nyc.c4q.hyun.hw_1001_simonsays.R.id.red_button;
import static nyc.c4q.hyun.hw_1001_simonsays.R.id.score;
import static nyc.c4q.hyun.hw_1001_simonsays.R.id.yellow_button;


public class Main extends AppCompatActivity implements View.OnClickListener {

    final static String TAG = "TAG";
    Button redbtn;
    Button bluebtn;
    Button greenbtn;
    Button yellowbtn;
    int scoreBoard=0;
    private String[] colorArray = {"blue", "red", "green", "yellow"};
    private String readColor = null;
    Handler handler = new Handler();
    ArrayList<String> simonsPatt = new ArrayList<>();                  // to hold the pattern of the random colors
    ArrayList<String> usersPatt = new ArrayList<>();                  // to hold the pattern of the random colors


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                randomSimon();
            }
        }, 1000);

        buttonIdentifier();
        // pick a random color and add into array
    }
// generate a random Color
    private void randomSimon() {
        Random random = new Random();
        int index = random.nextInt(colorArray.length);
        readColor = colorArray[index];                   // readColor = "red
        simonsPatt.add(readColor);                      // add random color to simonsPatt
        goHere();
    }
// we're going to display every color in Simon's random color
    private void goHere() {
        Log.d(TAG , "computerflashingGOHERE");
        for(int i = 0; i<simonsPatt.size();i++) {
            clicks(simonsPatt.get(i), i);
        }
    }
// display the colors
    private void clicks(String read,int i) {
        switch (read) {
            case "red":
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        redFlash();
                        }
                }, (500*i) + 750);
                Log.d(TAG , "redcompflash");
                break;
            case "blue":
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blueFlash();
                    }
                }, (500*i) + 750);
                Log.d(TAG , "bluecompflash");
                break;
            case "green":
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        greenFlash();
                    }
                }, (500*i) + 750);
                Log.d(TAG , "greencompflash");
                break;
            case "yellow":
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yellowFlash();
                    }
                }, (500*i) + 750);
                Log.d(TAG , "yellowcompflash");
                break;
        }
    }
    private void buttonIdentifier(){
        redbtn = (Button) findViewById(red_button);
        redbtn.setOnClickListener(this);
        bluebtn = (Button) findViewById(blue_button);
        bluebtn.setOnClickListener( this);
        greenbtn = (Button) findViewById(green_button);
        greenbtn.setOnClickListener(this);
        yellowbtn = (Button) findViewById(yellow_button);
        yellowbtn.setOnClickListener(this);
    }
    // Red color code
    private void redFlash() {
        Log.d(TAG,"redflashANIMATION");
        Animation mAnime = new AlphaAnimation(1, 0);
        mAnime.setDuration(90);
        mAnime.setInterpolator(new LinearInterpolator());
        mAnime.setRepeatCount(1);
        mAnime.setRepeatMode(Animation.REVERSE);
        redbtn.startAnimation(mAnime);
    }
    // blue color code

    private void blueFlash() {
        Log.d(TAG,"blueflashANIMATION");
        Animation mAnime = new AlphaAnimation(1, 0);
        mAnime.setDuration(90);
        mAnime.setInterpolator(new LinearInterpolator());
        mAnime.setRepeatCount(1);
        mAnime.setRepeatMode(Animation.REVERSE);
        bluebtn.startAnimation(mAnime);
    }
    // green color code

    private void greenFlash() {
        Log.d(TAG,"greenflashANIMATION");
        Animation mAnime = new AlphaAnimation(1, 0);
        mAnime.setDuration(90);
        mAnime.setInterpolator(new LinearInterpolator());
        mAnime.setRepeatCount(1);
        mAnime.setRepeatMode(Animation.REVERSE);
        greenbtn.startAnimation(mAnime);
    }
    // yellow color code

    private void yellowFlash() {

        Log.d(TAG,"yellowflashANIMATION");
        Animation mAnime = new AlphaAnimation(1, 0);
        mAnime.setDuration(90);
        mAnime.setInterpolator(new LinearInterpolator());
        mAnime.setRepeatCount(1);
        mAnime.setRepeatMode(Animation.REVERSE);
        yellowbtn.startAnimation(mAnime);
    }

    // When button is clicked by the user
    // we will add the user's input into an empty array.
    // We check the values for every time a color button is clicked
    @Override
    public void onClick(View v) {
        MediaPlayer soundOne = MediaPlayer.create(getApplicationContext(), R.raw.sound_one);
        MediaPlayer soundTwo = MediaPlayer.create(getApplicationContext(), R.raw.sound_two);
        MediaPlayer soundThree = MediaPlayer.create(getApplicationContext(), R.raw.sound_three);
        MediaPlayer soundFour = MediaPlayer.create(getApplicationContext(), R.raw.sound_four);
        switch (v.getId()) {
            case red_button:
                soundOne.start();
                Log.d("red button :" , "clickedred");
                usersPatt.add("red");
//                Toast(0);
                checkValues();
                break;
            case blue_button:
                soundTwo.start();
                Log.d("blue button :" , "clickedblue");
                usersPatt.add("blue");
//                Toast(1);
                checkValues();
                break;
            case  green_button:
                soundThree.start();
                Log.d("green button :" , "clickedgreen");
                usersPatt.add("green");
//                Toast(2);
                checkValues();
                break;
            case  yellow_button:
                soundFour.start();
                Log.d("yellow button :" , "clickedyellow");
                usersPatt.add("yellow");
//                Toast(3);
                checkValues();
                break;
            }
    }


    private void checkValues() {

            // when the user's input does not match with simon's color pattern
        if(usersPatt.size() != simonsPatt.size()){
            Log.d(TAG , "simonPatts.size != userpatts.size");
            for (int i = 0; i < usersPatt.size(); i++) {
                Log.d(TAG, "WHAT IS HAPPENING");
                if (usersPatt.get(i) != simonsPatt.get(i)) {
                    Log.d(TAG, "Gameover");
                    gameover();
                }
                Log.d("check value one :", "this");
            }

            // if the user's color pick and simon's click are the same,
            // then we can give a score for each round and
            // continue the game

        }else if(usersPatt.size()==(simonsPatt.size())){
            Context context = Main.this;
            CharSequence note = "Leveled Up!";
            int duration = Toast.LENGTH_SHORT;
            Log.d(TAG , "simonPatts.size == userpatts.size");
            if (usersPatt.equals(simonsPatt)) {
                Log.d(TAG, "userPatt == SimonPatt");
                scoreBoard++;
                TextView scoreB = (TextView) findViewById(score);
                String sc = String.valueOf(scoreBoard);
                scoreB.setText(sc);
                usersPatt.clear();
                randomSimon();
                Toast nextRound = Toast.makeText(context, note, duration);
                nextRound.show();
            }
        }  else {
            gameover();
        }
    }

    private void gameover() {
        Intent intent = new Intent (Main.this, GameOver.class);
        startActivity(intent);
    }

//    private void Toast(int input) {
//        Context context = Main.this;
//        CharSequence r = "red";
//        CharSequence b = "blue";
//        CharSequence g = "green";
//        CharSequence y = "yellow";
//        int duration = Toast.LENGTH_SHORT;
//
//        switch (input) {
//            case 0:
//                Toast red = Toast.makeText(context, r, duration);
//                red.show();
//                break;
//            case 1:
//                Toast blue = Toast.makeText(context, b, duration);
//                blue.show();
//                break;
//            case 2:
//                Toast green = Toast.makeText(context, g, duration);
//                green.show();
//                break;
//            case 3:
//                Toast yellow = Toast.makeText(context, y, duration);
//                yellow.show();
//                break;
//        }
//    }

}
