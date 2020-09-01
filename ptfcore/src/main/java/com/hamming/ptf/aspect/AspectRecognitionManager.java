package com.hamming.ptf.aspect;


import nl.hmf.core.SpecificConsumer;

import java.util.ArrayList;
import java.util.List;

public class AspectRecognitionManager extends SpecificConsumer<AspectRecognizerResult> {
    private List<AspectResultListener> listeners;

    public AspectRecognitionManager(){
        initialize();
    }

    private void initialize() {
        listeners = new ArrayList<AspectResultListener>();
    }

    @Override
    public void consume(AspectRecognizerResult result) {
        for (AspectResultListener l: listeners) {
            l.receiveAspectResult(result);
        }
    }

    public void addAspectResultListener(AspectResultListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

}
