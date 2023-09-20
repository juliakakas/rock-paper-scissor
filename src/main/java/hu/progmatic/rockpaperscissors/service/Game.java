package hu.progmatic.rockpaperscissors.service;

import java.util.*;

public class Game {
    private String word;
    private String inputs;

    private boolean isEnd = false;
    public Game(){
        List<String> words = ReadFileLineByLine
                .reader("src/main/resources/static/words.txt");
        word = words.get(new Random().nextInt(words.size()));
       // word = "rock";
    }

    public void useChoice(String choice){
        if (Objects.equals(choice, "rock") && Objects.equals(word, "scissor")) {
            isEnd = true;
        } else if (Objects.equals(choice, "scissor") && Objects.equals(word, "paper")) {
            isEnd = true;
        } else if (Objects.equals(choice, "paper") && Objects.equals(word, "rock")) {
            isEnd = true;
        } else {
            isEnd = false;
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getInputs() {
        return inputs;
    }

    public void setInputs(String inputs) {
        this.inputs = inputs;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
