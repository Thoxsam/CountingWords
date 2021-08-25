import java.util.*;

public class WordFrequencyAnalyzer {
    
    List<WordFrequency> createList(String text) {
        List<WordFrequency> list = new ArrayList<>();
        String[] split = text.split("\\s+");
        ArrayList<String> dupli = new ArrayList<String>();
        int count = 0;
                
        for (int i=0; i < split.length; i++) {
            if (!(dupli.contains(split[i].toLowerCase()))) {
                for (int j=0; j < split.length; j++) {
                    if (split[i].toLowerCase().equals(split[j].toLowerCase())) {
                        count++;
                    }
                }
                dupli.add(split[i].toLowerCase());
                list.add(new WordFrequency(split[i].toLowerCase(), count));
                count = 0;
            }
        
        }
        return list;
    }
    
    int calculateHighestFrequency(String text) {
        List<WordFrequency> list = createList(text);
        int max = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).getFrequency()) {
                max = list.get(i).getFrequency();
            }
        }
        return max;
    }
    
    int calculateFrequencyForWord(String text, String word) {
        List<WordFrequency> list = createList(text);
        
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getWord().toLowerCase().equals(word)) {
                return list.get(i).getFrequency();
            }
        }
        return 0;
    }
    
    List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        List<WordFrequency> list = createList(text);
        List<WordFrequency> result = new ArrayList<>();
        int curr = 0;
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(curr).getFrequency() < list.get(i).getFrequency()) {
                    curr = i;
                }
            }
            result.add(list.get(curr));
            list.remove(curr);
            curr = 0;
        }
        
        Collections.sort(result, new Comparator<WordFrequency>() {
            @Override
            public int compare(final WordFrequency object1, final WordFrequency object2) {
                return object1.getWord().compareTo(object2.getWord());
            }
        });
        
        result.sort(Comparator.comparingInt(WordFrequency::getFrequency)
            .reversed());
        
        return result;
    }
    
    public static void main(String[] args) {
      WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzer();
      
      List<WordFrequency> list = analyzer.calculateMostFrequentNWords("I Test test test working working alot alot", 3);
      
      for (WordFrequency w : list) {
          System.out.println(w);
      }
    }
}

