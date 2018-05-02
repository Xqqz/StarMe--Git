package com.valdioveliu.valdio.audioplayer.PitchesAndWords;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 20.03.2018.
 */
public class MakeWordsList {

    List<Pitch> pitches;

    public List<List<Pitch>> getWordsList(List<Pitch> pitchList) {
        return makeWordsList(pitchList);
    }

    List<Pitch> oneWord = new ArrayList<>();
    List<List<Pitch>> wordList = new ArrayList<>();


    public List<List<Pitch>> makeWordsList(List<Pitch> pitchList){
        pitches = pitchList;
        int pauseCounter = 0;

        for (int i = 0; i < pitchList.size(); i++) {
            if(pitchList.get(i).getPitch() > 10000){
                pauseCounter++;
            } else {

                if(pauseCounter > 0){
                    if(pauseCounter >= 5){
                        wordList.add(oneWord);
                        oneWord = new ArrayList<>();
                    }
                    pauseCounter = 0;
                }
                oneWord.add(pitchList.get(i));
            }
        }
        if(oneWord.size() > 0){
            wordList.add(oneWord);
        }
        return wordList;
    }
}
