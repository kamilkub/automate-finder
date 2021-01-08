package org.helper;

public class ArgsInfo {

    public static String showHelpInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append("I take following arguments\n");
        builder.append("[-a] all websites, followed by technology, city or level\n");
        builder.append("Example: -a tech city level\n");
        builder.append("[-nofluff] nofluffjobs.com jobs followed by the same arguments as above\n");
//        builder.append("[-justjoin] justjoin.it jobs followed by the same arguments as above\n");
        builder.append("[!!!] Make sure you provided arguments in right order otherwise results can be incorrect!");

        return builder.toString();
    }



}
