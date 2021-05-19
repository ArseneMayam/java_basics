package com.pluralsight.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args){
        // Regular expressions are case sensitive
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I","You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee","YYY")); // replaces first 3 chars with YYY

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee","YYY"));

        System.out.println(alphanumeric.matches("^hello")); // returns false
        System.out.println(alphanumeric.matches("^abcDeee")); // returns false because the string a whole does not match
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijkl99z")); // returns true cuz entire string matches

        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END")); // replaces the end of the string
        System.out.println(alphanumeric.replaceAll("[aei]","X")); // replaces a set a chars, here it'll replace "a", "e", "i"
        System.out.println(alphanumeric.replaceAll("[aei]","I replaced a letter here"));

        System.out.println(alphanumeric.replaceAll("[aei][Fj]","X")); // replace each letter in the brackets with X if any of them is followed by and F or j

        // CHARACTER CLASSES AND BOUNDARY MATCHES
        System.out.println("Harry".replaceAll("[Hh]arry","Harry")); // replace the string

        String newAlphanumeric  = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]","X")); // replace every single letter except "e" and "j", the reg will match all chars that are not "e" and "j"

        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]","X"));
        System.out.println(newAlphanumeric.replaceAll("a-f3-8","X"));
        System.out.println(newAlphanumeric.replaceAll("a-fA-F3-8","X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]","X")); // turns off case sensitivity

        System.out.println(newAlphanumeric.replaceAll("[0-9]","X")); // replace all the numbers in the string
        System.out.println(newAlphanumeric.replaceAll("\\d","X")); // replace all the numbers in the string
        System.out.println(newAlphanumeric.replaceAll("\\D","X")); // replace all the non-numbers in the string

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s","")); // remove all whitespaces from the string
        System.out.println(hasWhitespace.replaceAll("\t","X")); // remove specific whitespace
        System.out.println(hasWhitespace.replaceAll("\\S","")); // replace all non-whitespace chars

        System.out.println(newAlphanumeric.replaceAll("\\w","X")); // replace everything except the whitespace chars
        System.out.println(hasWhitespace.replaceAll("\\w","X"));
        System.out.println(hasWhitespace.replaceAll("\\W","X")); // replace only the whitespace chars

        System.out.println(hasWhitespace.replaceAll("\\b","X")); // each word will be surrounded by the replacement string

        // QUANTIFIERS and the PATTERN and MATCHER classes

        System.out.println(alphanumeric.replaceAll("^abcDeee","YYY"));

        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDeee","YYY"));

        // quantifiers express how often an element can occur
        // Use case of quantifiers -> verifying user input and part of that is optional
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}","YYY")); // the 3 in curly braces indicates how many (3) the preceding char "e" are in the string
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+","YYY")); // "+" to say any number of the preceding char "e" instead of using curly braces
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*","YYY")); // "+" to say any number of e instead of using curly braces

        System.out.println(thirdAlphanumericString.replaceAll("^abcde{2,5}","YYY")); // check for the string with 2 or 5 occurence of the preceding char "e"

        String fourthAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(fourthAlphanumericString.replaceAll("h+i*j","Y")); // replace all occurence of "h" followed by any number of "i", followed by at least one "j"

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something</p>");
        htmlText.append("<p>This is a paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        //String h2Pattern = "<h2>";
        String h2Pattern = ".*<h2>.*"; // anything before and after "<h2>"
        //Pattern pattern = Pattern.compile(h2Pattern);
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches()); // returns a boolean, matches the string as a whole/ the entire text

    }
}
