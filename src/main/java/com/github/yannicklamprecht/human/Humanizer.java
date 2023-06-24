package com.github.yannicklamprecht.human;

import com.github.yannicklamprecht.human.gender.Female;
import com.github.yannicklamprecht.human.gender.Gender;
import com.github.yannicklamprecht.human.gender.Male;
import com.github.yannicklamprecht.human.gender.Other;
import java.util.List;

import static java.lang.StringTemplate.STR;

public class Humanizer {

    private List<Mammal> mammals;

    public Humanizer() {

        var peter = new Human("Peter", new PersonalData(30, Gender.MALE));
        var karen = new Human("Karen", new PersonalData(46, Gender.FEMALE));
        var lilly = new Human("Lilly", new PersonalData(25, Gender.other("gender-fluid")));

        this.mammals = List.of(peter, karen, lilly);
    }

    public void print() {
        for (Mammal mammal : this.mammals) {
            if(mammal instanceof Human(var name, PersonalData(var _, var gender))){
                print(name, gender);
            }

        }
    }

    private void print(String name, Gender gender) {
        switch (gender) {
            case Male _ -> System.out.println(STR."Person named \{name} is man");
            case Female _ -> System.out.println(STR."Person named \{name} is a woman");
            case Other(var genderName) -> System.out.println(STR."Person named \{name} is \{genderName}");
        }
    }

}
