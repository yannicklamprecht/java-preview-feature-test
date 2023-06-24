package com.github.yannicklamprecht.human.mammal;

import com.github.yannicklamprecht.human.Mammal;
import com.github.yannicklamprecht.human.SoundEmitter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record Dolphin(List<String> sounds) implements Mammal, SoundEmitter {
    public Optional<String> sound() {
        Collections.shuffle(sounds);
        return sounds.stream().findFirst();
    }
}
