package com.example.language3605;

import java.util.ArrayList;

public class Words {

    String indigenousWord;
    String englishWord;
    int imageView;

    public Words(String indigenousWord, String englishWord, int imageView) {
        this.indigenousWord = indigenousWord;
        this.englishWord = englishWord;
        this.imageView = imageView;
    }

    public Words(String indigenousWord, String englishWord) {
        this.indigenousWord = indigenousWord;
        this.englishWord = englishWord;
    }

    public String getIndigenousWord() {
        return indigenousWord;
    }

    public void setIndigenousWord(String indigenousWord) {
        this.indigenousWord = indigenousWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public static void getWords(){
        ArrayList<Words> tiwiWords = new ArrayList<>();
        tiwiWords.add(new Words("Natinga", "One"));
        tiwiWords.add(new Words("Ngarrakariki", "Two"));
        tiwiWords.add(new Words("Jajirrima", "Three"));
        tiwiWords.add(new Words("Yatawulungurri", "Four"));
        tiwiWords.add(new Words("Punginingita", "Five"));
        tiwiWords.add(new Words("Kiringarra", "Six"));
        tiwiWords.add(new Words("Juwukayi", "Seven"));
        tiwiWords.add(new Words("Punyipunyinga", "Eight"));
        tiwiWords.add(new Words("Punginingita yatawulungirri", "Nine"));
        tiwiWords.add(new Words("Wamutirrara", "Ten"));

        ArrayList<Words> kriolWords = new ArrayList<>();
        kriolWords.add(new Words("Wan", "One"));
        kriolWords.add(new Words("Du / tu", "Two"));
        kriolWords.add(new Words("Dribala ", "Three"));
        kriolWords.add(new Words("Boa / fo", "Four"));
        kriolWords.add(new Words("Baib / faib", "Five"));
        kriolWords.add(new Words("Siks", "Six"));
        kriolWords.add(new Words("Seben", "Seven"));
        kriolWords.add(new Words("Eit", "Eight"));
        kriolWords.add(new Words("Nain", "Nine"));
        kriolWords.add(new Words("Ten / tenbala", "Ten"));

        ArrayList<Words> gurindijiWords = new ArrayList<>();
        gurindijiWords.add(new Words("Panturru", "One"));
        gurindijiWords.add(new Words("Kujarra", "Two"));
        gurindijiWords.add(new Words("Kangunya", "Three"));
        gurindijiWords.add(new Words("Muntupala", "Four"));
        gurindijiWords.add(new Words("Marumpukuyany", "Five"));
        gurindijiWords.add(new Words("Karni", "Six"));
        gurindijiWords.add(new Words("Yama", "Seven"));
        gurindijiWords.add(new Words("Murru", "Eight"));
        gurindijiWords.add(new Words("Tulu", "Nine"));
        gurindijiWords.add(new Words("Ngamirri", "Ten"));

        ArrayList<Words> warlpiriWords = new ArrayList<>();
        warlpiriWords.add(new Words("Jinta", "One"));
        warlpiriWords.add(new Words("Jarra", "Two"));
        warlpiriWords.add(new Words("Marnkurrpa", "Three"));
        warlpiriWords.add(new Words("Matirdiji", "Four"));
        warlpiriWords.add(new Words("Rdaka", "Five"));
        warlpiriWords.add(new Words("Jilkarla", "Six"));
        warlpiriWords.add(new Words("Wirlki", "Seven"));
        warlpiriWords.add(new Words("Paniya-jarra ", "Eight"));
        warlpiriWords.add(new Words("Jarukutu", "Nine"));
        warlpiriWords.add(new Words("Karlarla", "Ten"));

    }

    public static void getWordsnPicture(){
        ArrayList<Words> tiwiPic = new ArrayList<>();
        tiwiPic.add(new Words("Natinga", "One", R.drawable.one));
        tiwiPic.add(new Words("Ngarrakariki", "Two", R.drawable.two));
        tiwiPic.add(new Words("Jajirrima", "Three", R.drawable.three));
        tiwiPic.add(new Words("Yatawulungurri", "Four", R.drawable.four));
        tiwiPic.add(new Words("Punginingita", "Five", R.drawable.five));
        tiwiPic.add(new Words("Kiringarra", "Six", R.drawable.six));
        tiwiPic.add(new Words("Juwukayi", "Seven", R.drawable.seven));
        tiwiPic.add(new Words("Punyipunyinga", "Eight", R.drawable.eight));
        tiwiPic.add(new Words("Punginingita yatawulungirri", "Nine", R.drawable.nine));
        tiwiPic.add(new Words("Wamutirrara", "Ten", R.drawable.ten));

        ArrayList<Words> kriolPic = new ArrayList<>();
        kriolPic.add(new Words("Wan", "One", R.drawable.one));
        kriolPic.add(new Words("Du / tu", "Two", R.drawable.two));
        kriolPic.add(new Words("Dribala ", "Three", R.drawable.three));
        kriolPic.add(new Words("Boa / fo", "Four", R.drawable.four));
        kriolPic.add(new Words("Baib / faib", "Five", R.drawable.five));
        kriolPic.add(new Words("Siks", "Six", R.drawable.six));
        kriolPic.add(new Words("Seben", "Seven", R.drawable.seven));
        kriolPic.add(new Words("Eit", "Eight", R.drawable.eight));
        kriolPic.add(new Words("Nain", "Nine", R.drawable.nine));
        kriolPic.add(new Words("Ten / tenbala", "Ten", R.drawable.ten));

        ArrayList<Words> gurindijiPic = new ArrayList<>();
        gurindijiPic.add(new Words("Panturru", "One", R.drawable.one));
        gurindijiPic.add(new Words("Kujarra", "Two", R.drawable.two));
        gurindijiPic.add(new Words("Kangunya", "Three", R.drawable.three));
        gurindijiPic.add(new Words("Muntupala", "Four", R.drawable.four));
        gurindijiPic.add(new Words("Marumpukuyany", "Five", R.drawable.five));
        gurindijiPic.add(new Words("Karni", "Six", R.drawable.six));
        gurindijiPic.add(new Words("Yama", "Seven", R.drawable.seven));
        gurindijiPic.add(new Words("Murru", "Eight", R.drawable.eight));
        gurindijiPic.add(new Words("Tulu", "Nine", R.drawable.nine));
        gurindijiPic.add(new Words("Ngamirri", "Ten", R.drawable.ten));

        ArrayList<Words> warlpiriPic = new ArrayList<>();
        warlpiriPic.add(new Words("Jinta", "One", R.drawable.one));
        warlpiriPic.add(new Words("Jarra", "Two", R.drawable.two));
        warlpiriPic.add(new Words("Marnkurrpa", "Three", R.drawable.three));
        warlpiriPic.add(new Words("Matirdiji", "Four", R.drawable.four));
        warlpiriPic.add(new Words("Rdaka", "Five", R.drawable.five));
        warlpiriPic.add(new Words("Jilkarla", "Six", R.drawable.six));
        warlpiriPic.add(new Words("Wirlki", "Seven", R.drawable.seven));
        warlpiriPic.add(new Words("Paniya-jarra ", "Eight", R.drawable.eight));
        warlpiriPic.add(new Words("Jarukutu", "Nine", R.drawable.nine));
        warlpiriPic.add(new Words("Karlarla", "Ten", R.drawable.ten));
    }


}


