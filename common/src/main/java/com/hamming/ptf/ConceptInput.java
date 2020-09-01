package com.hamming.ptf;

public class ConceptInput {
    private String id;
    private Object data;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ConceptInput{" +
                "id='" + id + '\'' +
                ", data=" + data +
                '}';
    }
}
