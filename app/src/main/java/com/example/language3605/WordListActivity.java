package com.example.language3605;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordListActivity extends AppCompatActivity {
    private static final String TAG = "WordListActivity";

    public static ArrayList<String> tiwi_numbers = new ArrayList<>();
    public static ArrayList<String> kriol_numbers = new ArrayList<>();
    public static ArrayList<String> gurindiji_numbers = new ArrayList<>();
    public static ArrayList<String> warlpiri_numbers = new ArrayList<>();

    public static ArrayList<String> english_numbers = new ArrayList<>();

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist);

        Log.d(TAG, "onCreate: started");

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordListActivity.this, CategoryActivity.class);
                WordListActivity.this.startActivity(intent);
            }
        });




        showWordList();
    }

    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if (getIntent().hasExtra("category_type")) {
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String category = getIntent().getStringExtra("category_type");
        }
    }

    private void showWordList() {
        Log.d(TAG, "showWordList: show wordList");

        tiwi_numbers.add("Natinga");
        kriol_numbers.add("Wan");
        gurindiji_numbers.add("Panturru");
        warlpiri_numbers.add("Jinta");
        english_numbers.add("One");

        tiwi_numbers.add("Ngarrakariki");
        kriol_numbers.add("Du / tu");
        gurindiji_numbers.add("Kujarra");
        warlpiri_numbers.add("Jarra");
        english_numbers.add("Two");

        tiwi_numbers.add("Jajirrima");
        kriol_numbers.add("Dribala");
        gurindiji_numbers.add("Kangunya");
        warlpiri_numbers.add("marnkurrpa");
        english_numbers.add("Three");

        tiwi_numbers.add("Yatawulungurri");
        kriol_numbers.add("Boa / fo");
        gurindiji_numbers.add("Muntupala");
        warlpiri_numbers.add("Matirdiji");
        english_numbers.add("Four");

        tiwi_numbers.add("Punginingita");
        kriol_numbers.add("Baib / faib");
        gurindiji_numbers.add("Marumpukuyany");
        warlpiri_numbers.add("Rdaka");
        english_numbers.add("Five");

        tiwi_numbers.add("Kiringarra");
        kriol_numbers.add("Siks");
        gurindiji_numbers.add("Karni");
        warlpiri_numbers.add("Jilkarla");
        english_numbers.add("Six");

        tiwi_numbers.add("Juwukayi");
        kriol_numbers.add("Seben");
        gurindiji_numbers.add("Yama");
        warlpiri_numbers.add("Wirlki");
        english_numbers.add("Seven");

        tiwi_numbers.add("Punyipunyinga");
        kriol_numbers.add("Eit");
        gurindiji_numbers.add("Murru");
        warlpiri_numbers.add("Paniya-jarra");
        english_numbers.add("Eight");

        tiwi_numbers.add("Punginingita Yatawulungirri");
        kriol_numbers.add("Nain");
        gurindiji_numbers.add("Tulu");
        warlpiri_numbers.add("Jarukutu");
        english_numbers.add("Nine");

        tiwi_numbers.add("Wamutirrara");
        kriol_numbers.add("Ten / tenbala");
        gurindiji_numbers.add("Ngamirri");
        warlpiri_numbers.add("Karlarla");
        english_numbers.add("Ten");

        showWordListRecyclerView();

    }

    private void showWordListRecyclerView() {
        Log.d(TAG, "showWordListRecyclerView: show WordList RecyclerView");
        RecyclerView recyclerView = findViewById(R.id.rv_wordList);

        System.out.println(LanguageAdapter.languagePosition);

//        if (LanguageAdapter.languagePosition == "Tiwi") {
//            LanguageAdapter adapter = new LanguageAdapter(this, tiwi_numbers, english_numbers);
//            recyclerView.setAdapter(adapter);
//        } else if (LanguageAdapter.languagePosition == "Kriol") {
//            LanguageAdapter adapter = new LanguageAdapter(this, kriol_numbers, english_numbers);
//            recyclerView.setAdapter(adapter);
//        } else if (LanguageAdapter.languagePosition == "Gurindiji") {
//            LanguageAdapter adapter = new LanguageAdapter(this, gurindiji_numbers, english_numbers);
//            recyclerView.setAdapter(adapter);
//        }else if (LanguageAdapter.languagePosition == "Warlpiri") {
//            LanguageAdapter adapter = new LanguageAdapter(this, warlpiri_numbers, english_numbers);
//            recyclerView.setAdapter(adapter);
//        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void launchDetailActivity(String message) {
        Intent intent = new Intent(this, PictureActivity.class);
        intent.putExtra(PictureActivity.INTENT_MESSAGE, message);
        startActivity(intent);
    }

    public void onWordClick(Words words, ImageView imageView) {

        Intent send = new Intent(this, PictureActivity.class);
        send.putExtra("indigenousWord", words.getIndigenousWord());
        send.putExtra("englishWord", words.getEnglishWord());
        send.putExtra("imageWord", words.getImageView());
        startActivity(send);
        Toast.makeText(this, "item clicked:" + words.getEnglishWord(), Toast.LENGTH_LONG).show();

        startActivity(send);
    }
}
