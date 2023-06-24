package com.github.yannicklamprecht.human;

import java.util.Optional;

public interface SoundEmitter {
    Optional<String> sound();

    default String name(){
        return this.getClass().getSimpleName();
    }

    default void playSound(){
        sound().ifPresent(sound -> {
            System.out.println(name()+ " "+ sound);
        });
    }
}
