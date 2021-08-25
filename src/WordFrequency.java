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
    
    void setFrequency(int n) {
        this.freq = n;
    }
    
    public String toString() {
        return "(" + getWord() + ", " + getFrequency() + ")";
    }
    
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof WordFrequency)) return false;
        
        WordFrequency o = (WordFrequency) obj;
        return o.word == this.word;
    }
}
