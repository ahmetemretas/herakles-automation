package com.herakles.step_definitions;

import com.herakles.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;

public class Mission1_stepdefinition {

    @Given("Find first character that is not repeated in the string")
    public void find_first_character_that_is_not_repeated_in_the_string() {
        String str = ConfigurationReader.get("string");
        boolean flag = true;
        boolean flag2 = true;
        char firstNonRepeatedChar = ' ';

        // This for loop check char values of the string except last char value of the string

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }

            }
            if (flag) {
                System.out.println(str.charAt(i) + " is the first non repeated char");
                firstNonRepeatedChar = str.charAt(i);
                break;
            }
        }

        // This part is executed if there no non repeated values except last char value.
        // This for loop check the last char of the string if there is no non repeated char value until the last char value

        if (firstNonRepeatedChar == ' ') {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(str.length() - 1) == str.charAt(i)) {
                    flag2 = false;
                    break;
                } else {
                    flag2 = true;
                }
            }
            if (flag2) {
                firstNonRepeatedChar = str.charAt(str.length() - 1);
                System.out.println(str.charAt(str.length() - 1) + " is the first non repeated char");
            } else {
                System.out.println("There is no non repeated char in this string");
            }
        }

    }
}
