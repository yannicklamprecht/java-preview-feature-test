package com.github.yannicklamprecht.human.mammal;

import com.github.yannicklamprecht.human.Mammal;
import com.github.yannicklamprecht.human.PersonalData;


public record Human(String name, PersonalData personalData) implements Mammal {}
