package com.github.yannicklamprecht;


import com.github.yannicklamprecht.gender.Female;
import com.github.yannicklamprecht.gender.Gender;
import com.github.yannicklamprecht.gender.Male;
import com.github.yannicklamprecht.gender.Other;
import java.util.List;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        var humanizer = new Humanizer();
        humanizer.print();
    }
}
