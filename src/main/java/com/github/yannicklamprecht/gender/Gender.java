package com.github.yannicklamprecht.gender;

sealed public interface Gender permits Female, Male, Other {
    Gender MALE = new Male();
    Gender FEMALE = new Female();
    static Gender other(String other) {
        return new Other(other);
    }
}
