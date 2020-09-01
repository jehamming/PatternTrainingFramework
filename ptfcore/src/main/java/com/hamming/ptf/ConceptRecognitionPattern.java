package com.hamming.ptf;

import com.hamming.ptf.aspect.AspectRecognizerResult;
import com.hamming.ptf.util.UUIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class ConceptRecognitionPattern {

    private String id;
    private String name;
    private List<AspectRecognizerResult> expectedResults;

    public ConceptRecognitionPattern(){
        id = UUIDGenerator.getInstance().generateUUID();
        expectedResults = new ArrayList<AspectRecognizerResult>();
    }

    public void addExpectedResult(AspectRecognizerResult expectedResult) {
        if (! expectedResults.contains(expectedResult)) {
            expectedResults.add(expectedResult);
        }
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
