package com.bwally.blackjack;

public class Face {
    private int value;
    private String name;

    public Face(String name) {
        this.name = name;
        setValue();
    }

    private void setValue() {
        switch (this.name) {
            case "ACE":
                value = 1;
                break;
            case "TWO":
                value = 2;
                break;
            case "THREE":
                value = 3;
                break;
            case "FOUR":
                value = 4;
                break;
            case "FIVE":
                value = 5;
                break;
            case "SIX":
                value = 6;
                break;
            case "SEVEN":
                value = 7;
                break;
            case "EIGHT":
                value = 8;
                break;
            case "NINE":
                value = 9;
                break;
            case "TEN":
            case "JACK":
            case "QUEEN":
            case "KING":
                value = 10;
                break;
            default:
                System.out.println("Card name does not match value.");
        }
    }

    public void switchAce() {
        if (this.name.equals("ACE") && this.value == 1) {
            this.value = 11;
        }
        if (this.name.equals("ACE") && this.value == 11) {
            this.value = 1;
        }
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


}
