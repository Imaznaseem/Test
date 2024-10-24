package com.example.Cariogram_Backend.Model;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;

public class CariogramInput {

    @NotEmpty(message = "Input values cannot be empty")
    private String[] inputValues;

    // Default constructor
    public CariogramInput() {
    }

    // Constructor with parameters
    public CariogramInput(String[] inputValues) {
        this.inputValues = inputValues;
    }

    // Getter for inputValues
    public String[] getInputValues() {
        return inputValues;
    }

    // Setter for inputValues
    public void setInputValues(String[] inputValues) {
        this.inputValues = inputValues;
    }

    @Override
    public String toString() {
        return "CariogramInput{" +
                "inputValues=" + Arrays.toString(inputValues) +
                '}';
    }
}
