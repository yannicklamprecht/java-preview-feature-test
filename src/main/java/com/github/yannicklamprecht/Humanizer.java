package com.github.yannicklamprecht;

import com.github.yannicklamprecht.gender.Female;
import com.github.yannicklamprecht.gender.Gender;
import com.github.yannicklamprecht.gender.Male;
import com.github.yannicklamprecht.gender.Other;
import java.util.List;

import static java.lang.StringTemplate.STR;

public class Humanizer {

    private List<Human> humans;

    public Humanizer() {

        var peter = new Human("Peter", new PersonalData(30, Gender.MALE));
        var karen = new Human("Karen", new PersonalData(46, Gender.FEMALE));
        var lilly = new Human("Lilly", new PersonalData(25, Gender.other("gender-fluid")));

        this.humans = List.of(peter, karen, lilly);
    }

    public void print() {
        for (Human human : this.humans) {
            print(human);
        }
    }

    private void print(Human human) {

        var pData = human.personalData();

        switch (pData.gender()) {
            case Male male -> System.out.println(STR."Person named \{human.name()} is man");
            case Female female -> System.out.println(STR."Person named \{human.name()} is a woman");
            case Other(var gender) -> System.out.println(STR."Person named \{human.name()} is \{gender}");
        }
    }

}
