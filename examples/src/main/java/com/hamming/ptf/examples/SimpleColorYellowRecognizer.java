package com.hamming.ptf.examples;


import com.hamming.ptf.ConceptInput;
import com.hamming.ptf.aspect.AspectRecognizer;
import com.hamming.ptf.aspect.AspectRecognizerResult;
import nl.hmf.core.GenericProducer;
import nl.hmf.core.SpecificConsumer;

public class SimpleColorYellowRecognizer extends SpecificConsumer<ConceptInput> implements AspectRecognizer {

    private GenericProducer aspectRecognitionResultProducer;


    public SimpleColorYellowRecognizer() {
        aspectRecognitionResultProducer = new GenericProducer(getClass().getName()+"-RESULT");
    }

    @Override
    public String getAspect() {
        return "COLOR";
    }


    @Override
    public void consume(ConceptInput input) {
        System.out.println("Received input:" + input);
        if (input.getData() != null && input.getData() instanceof String) {
            String data = (String) input.getData();
            if (data.toLowerCase().contains("yellow")) {
                AspectRecognizerResult recognizerResult;
                recognizerResult = new AspectRecognizerResult(input.getId(), "COLOR", "YELLOW");
                aspectRecognitionResultProducer.produce(recognizerResult);
            }
        }
    }

    public static void main(String[] args) {
        SimpleColorYellowRecognizer recognizer = new SimpleColorYellowRecognizer();
        recognizer.startConsuming();
        try {
            while (true) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            recognizer.stopConsuming();
        }
    }

}
