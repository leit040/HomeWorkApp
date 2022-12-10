package WordsGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};


    private final StringBuilder userWord;
    private StringBuilder word;

    private final Scanner sc;

    public Game(){
        this.userWord = new StringBuilder();
        this.word = new StringBuilder();
        this.sc  = new Scanner(System.in);
        this.init();
    }
    public void init() {
        word = new StringBuilder(this.words[new Random().nextInt(0, 24)]);
    //    System.out.println("Cheating: "+word);
    }


    private void userInput() {
        System.out.print("Please, enter your word: ");
        userWord.replace(0,userWord.length(),sc.next());

    }

    private boolean check() {
        return userWord.toString().equals(word.toString());
    }

    private void printResult() {
        int userWordLen = Math.min(userWord.length(), word.length());
        char[] resultArray = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        char[] userWordArray = userWord.toString().toCharArray();
        char[] wordArray = word.toString().toCharArray();
        for (int i = 0; i < userWordLen; i++) {
            if (userWordArray[i] == wordArray[i]) {
                resultArray[i] = wordArray[i];
                continue;
            }
            resultArray[i] = '#';
        }

        System.out.println(Arrays.toString(resultArray));

    }

    public void play() {
        System.out.println("Welcome to the WORD game !\nTry to guess the word that we thought of? \nList of words :");
        System.out.println(Arrays.toString(words));
        do {
            userInput();
            printResult();
        } while (!check());
        System.out.println("You are win!!! word is "+word);
    }


}
