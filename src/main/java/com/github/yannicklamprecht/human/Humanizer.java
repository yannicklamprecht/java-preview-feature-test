package com.github.yannicklamprecht.human;

import com.github.yannicklamprecht.human.gender.Female;
import com.github.yannicklamprecht.human.gender.Gender;
import com.github.yannicklamprecht.human.gender.Male;
import com.github.yannicklamprecht.human.gender.Other;
import com.github.yannicklamprecht.human.mammal.Dolphin;
import com.github.yannicklamprecht.human.mammal.Human;
import java.util.Arrays;
import java.util.List;

import static java.lang.StringTemplate.STR;

public class Humanizer {

    private List<Mammal> mammals;

    public Humanizer() {

        var peter = new Human("Peter", new PersonalData(30, Gender.MALE));
        var karen = new Human("Karen", new PersonalData(46, Gender.FEMALE));
        var lilly = new Human("Lilly", new PersonalData(25, Gender.other("gender-fluid")));
        var meemaw = new Human(null, new PersonalData(70, Gender.FEMALE));

        var flipper = new Dolphin(Arrays.asList("whistles", "clicks"));

        this.mammals = List.of(peter, karen, lilly, flipper, meemaw);
    }

    public void print() {
        for (Mammal mammal : this.mammals) {
            switch (mammal) {
                case Human(var name, PersonalData(var _, var gender)) when name != null -> print(name, gender);
                case Human(var _, PersonalData(var age, var gender)) ->
                        System.out.println(STR."Unamed person with age \{age} \{formatGender(gender)}");
                case Dolphin dolphin -> dolphin.playSound();
            }
        }
    }

    private void print(String name, Gender gender) {
        var formattedGender = formatGender(gender);
        System.out.println(STR."Person named \{name} \{formattedGender}");
    }

    private String formatGender(Gender gender) {
        return switch (gender) {
            case Male _ -> "is a man";
            case Female _ -> "is a woman";
            case Other(var name) -> STR."is \{name}";
        };
    }
}
