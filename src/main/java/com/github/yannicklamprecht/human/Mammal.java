package com.github.yannicklamprecht.human;

import com.github.yannicklamprecht.human.mammal.Dolphin;
import com.github.yannicklamprecht.human.mammal.Human;

public sealed interface Mammal permits Human, Dolphin {
}
