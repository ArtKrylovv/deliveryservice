package com.solvd.deliveryservice.utilities;

public final class Utilities {

    // checks if state length == 2
    public static boolean stateChecker(String state) {
        return state.length() == 2;
    }

    // checks if name consists only of characters w/o integers and special characters
    public static boolean nameChecker(String str) {
        return str.matches("[a-zA-Z]+");
    }
}

