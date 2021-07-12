package com.example.language3605;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PictureActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "com.example.language3605.intent_message";

    private static final String TAG = "PictureActivity";

    private ArrayList<Integer> mPicture = new ArrayList<Integer>();
    private TextView indigPic;
    private TextView englishPic;
    private ImageView picture;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);


        Log.d(TAG, "onCreate:started");

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictureActivity.this, WordListActivity.class);
                PictureActivity.this.startActivity(intent);
            }
        });

        showPictures();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra("word_type")){
            Log.d(TAG, "getIncomingIntent: fount intent extras");

            String language = getIntent().getStringExtra("word_type");
        }
    }

    private void showPictures(){
        Log.d(TAG, "showPictures: show pictures");

        mPicture.add(R.drawable.one);
        mPicture.add(R.drawable.two);
        mPicture.add(R.drawable.three);
        mPicture.add(R.drawable.four);
        mPicture.add(R.drawable.five);
        mPicture.add(R.drawable.six);
        mPicture.add(R.drawable.seven);
        mPicture.add(R.drawable.eight);
        mPicture.add(R.drawable.nine);
        mPicture.add(R.drawable.ten);

        showEverything();

    }

    private void showEverything(){
        Log.d(TAG, "showEverything: show all on page");

        int position = Integer.parseInt(WordListAdapter.wordPosition);

        String indigWord = getIntent().getExtras().getString("indigenousWord");
        String engWord = getIntent().getExtras().getString("englishWord");
        int imgWord = getIntent().getExtras().getInt("imageWord");

        indigPic = findViewById(R.id.indigPic_tv);
        indigPic.setText(indigWord);

        englishPic = findViewById(R.id.englishPic_tv);
        indigPic.setText(engWord);

        picture = findViewById(R.id.imageView);
        picture.setImageResource(imgWord);


        while(Integer.valueOf(CategoryAdapter.categoryPosition) < 6){
            if(Integer.valueOf(LanguageAdapter.languagePosition) == 0){


//                Words.getWordsnPicture() == ;



            }
        }
//            if(Integer.valueOf(LanguageAdapter.categ))
//
//        if(movieTitle.equals("Title: Parasite (2019)")){
//            String movieGenre = "Genre: " + Movie.getMovies().get(0).getGenre();
//            genre = findViewById(R.id.tv_genre);
//            genre.setText(movieGenre);
//            String movieDirector = "Director: " + Movie.getMovies().get(0).getDirector();
//            director = findViewById(R.id.tv_director);
//            director.setText(movieDirector);
//            String movieRunTime = "Runtime: " + Movie.getMovies().get(0).getRunningTime() + " mins";
//            runTime = findViewById(R.id.tv_runTime);
//            runTime.setText(movieRunTime);
//            String movieDescription = "Description: " + Movie.getMovies().get(0).getDescription();
//            description = findViewById(R.id.tv_description);
//            description.setText(movieDescription);
//            play = findViewById(R.id.bt_play);
//            play.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5xH0HfJHsaY"));
//                    startActivity(intent);
//                }
//            });


    }

}
