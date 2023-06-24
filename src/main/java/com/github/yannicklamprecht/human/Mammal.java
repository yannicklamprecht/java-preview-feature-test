package com.github.yannicklamprecht.human;

public sealed interface Mammal permits Human, com.github.yannicklamprecht.human.mammal.Dolphin {
}
