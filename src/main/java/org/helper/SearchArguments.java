package org.helper;


import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class SearchArguments {

    private static final SearchArguments INSTANCE = new SearchArguments();
    private String city;
    private String technology;
    private String level;


    private SearchArguments(){}

    public static SearchArguments getInstance(){
        return INSTANCE;
    }

}
