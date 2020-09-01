package com.hamming.ptf;

import com.hamming.ptf.aspect.AspectRecognitionManager;
import com.hamming.ptf.aspect.AspectRecognizerResult;
import com.hamming.ptf.aspect.AspectResultListener;
import com.hamming.ptf.util.UUIDGenerator;
import nl.hmf.core.GenericProducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConceptRecognizer implements AspectResultListener {
    private AspectRecognitionManager aspectRecognitionManager;
    private PatternStore patternStore;
    private GenericProducer conceptInputProducer;


    public ConceptRecognizer() {
        initialize();
    }

    private void initialize() {
        aspectRecognitionManager = new AspectRecognitionManager();
        aspectRecognitionManager.addAspectResultListener(this);
        aspectRecognitionManager.startConsuming();
        patternStore = new PatternStore();
        conceptInputProducer = new GenericProducer(ConceptInput.class.getName());
    }

    @Override
    public void receiveAspectResult(AspectRecognizerResult result) {
        System.out.println("receiveAspectResult:" + result.toString());

    }

    public void sendInput(ConceptInput input) {
        conceptInputProducer.produce(input);
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        ConceptRecognizer recognizer = new ConceptRecognizer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("What sentence?: ");
            String input = reader.readLine();
            if (!input.trim().isEmpty()) {
                System.out.println("Trying to recognize:" + input);
                recognizer.sendInput(getInput(input));
            }
            Thread.sleep(100);
        }
    }

    private static ConceptInput getInput(String data) {
        ConceptInput input = new ConceptInput();
        input.setId(UUIDGenerator.getInstance().generateUUID());
        input.setData(data);
        return input;
    }

}
