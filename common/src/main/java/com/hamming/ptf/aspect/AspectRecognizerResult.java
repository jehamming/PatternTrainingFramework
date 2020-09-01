package com.hamming.ptf.aspect;

import nl.hmf.core.GenericProducer;

import java.util.Objects;

public class AspectRecognizerResult {

    private String inputId;
    private final String aspect;
    private final String result;

    public AspectRecognizerResult( String inputId, String aspect, String result) {
        this.inputId = inputId;
        this.aspect = aspect;
        this.result = result;
    }

    public String getAspect() {
        return aspect;
    }

    public String getResult() {
        return result;
    }

    public String getInputId() {
        return inputId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AspectRecognizerResult that = (AspectRecognizerResult) o;
        return aspect.equals(that.aspect) &&
                result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aspect, result);
    }

    @Override
    public String toString() {
        return "AspectRecognizerResult{" +
                "inputId='" + inputId + '\'' +
                ", aspect='" + aspect + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
