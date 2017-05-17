package com.example.hennesa.calculator;

import java.io.Serializable;

/**
 * Created by AbdelMoh05 on 5/5/2017.
 */

public class Calculator implements Serializable {
    private double number;
    private double result;
    private Instruction inst = Instruction.ADD;

    public void add() {

        inst = Instruction.ADD;

    }

    public void subtract() {

        inst = Instruction.SUBTRACT;

    }

    public void multiply() {

        inst = Instruction.MULTIPLY;
    }

    public void divide () {

        inst = Instruction.DIVIDE;

    }

    public String getResult() {
        switch (inst) {
            case ADD:
                result = result + number;
                break;
            case SUBTRACT:
                result = result - number;
                break;
            case MULTIPLY:
                result = result * number;
                break;
            case DIVIDE:
                result = result / number;
                break;
        }
        return Double.toString(result);
    }

    public void setNumber(String num) {

        this.number = Double.parseDouble(num);
    }

}
