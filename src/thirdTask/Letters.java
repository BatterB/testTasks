package thirdTask;

import java.util.*;

public class Letters {
    public static void main(String[] args) {
        class WordInfo{
            private int vowelCount;
            private String word;

            WordInfo(String word){
                this.vowelCount = 0;
                this.word = word;
            }

            public void setVowelCount(int vowelCount) {
                this.vowelCount = vowelCount;
            }

            public int getVowelCount() {
                return vowelCount;
            }

            public String getWord() {
                return word;
            }
        }

        ArrayList<WordInfo> dict = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите предложение:");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");

        for (String word : words){
            char firstLetter = word.charAt(0);
            WordInfo newWord;
            if(firstLetter == 'а' ||firstLetter == 'е' ||firstLetter == 'ё' ||firstLetter == 'и' ||firstLetter == 'о' ||
                    firstLetter == 'у' ||firstLetter == 'ы' ||firstLetter == 'э' ||firstLetter == 'ю' ||firstLetter == 'я') {
                newWord = new WordInfo(word.substring(0, 1).toUpperCase() + word.substring(1));
            }else {
                newWord = new WordInfo(word);
            }
            int cnt =0;
            for (char letter : word.toLowerCase().toCharArray()){
                if(letter == 'а' ||letter == 'е' ||letter == 'ё' ||letter == 'и' ||letter == 'о' ||
                        letter == 'у' ||letter == 'ы' ||letter == 'э' ||letter == 'ю' ||letter == 'я')
                    cnt++;
            }
            newWord.setVowelCount(cnt);
            dict.add(newWord);
        }

        class SortByCount implements Comparator<WordInfo>{
            @Override
            public int compare(WordInfo first, WordInfo second) {
                if ( first.getVowelCount() > second.getVowelCount() ) return -1;
                else if ( first.getVowelCount() == second.getVowelCount() ) return 0;
                else return 1;
            }
        }
        Collections.sort(dict, new SortByCount());
        System.out.println("Отсротированные слова: ");
        for(WordInfo word : dict){
            System.out.println(word.getWord());
        }
    }
}
