package org.helper;

public class ArgsInfo {

    public static String showHelpInfo(){
        return  "I take following arguments\n" +
                "[-a] all websites, followed by technology, city or level\n" +
                "Example: -a tech city level\n" +
                "[-nofluff] nofluffjobs.com jobs followed by the same arguments as above\n" +
//              "[-justjoin] justjoin.it jobs followed by the same arguments as above\n" +
                "[!!!] Make sure you provided arguments in right order otherwise results can be incorrect!";

    }

    private ArgsInfo(){}



}
