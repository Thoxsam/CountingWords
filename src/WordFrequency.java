import java.util.*;

public class WordFrequency {
    private String word;
    private int freq;

    WordFrequency(String s, int f) {
        word = s;
        freq = f;
    }

    String getWord() {
        return word;
    }

    int getFrequency() {
        return this.freq;
    }
    
    public String toString() {
        return "(" + getWord() + ", " + getFrequency() + ")";
    }
}
