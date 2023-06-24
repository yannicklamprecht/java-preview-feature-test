plugins {
    id("java")
}

group = "com.github.yannicklamprecht"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}


tasks {
    compileJava {
        options.release.set(22)
        options.compilerArgs.add("--enable-preview")
    }

    test {
        useJUnitPlatform()
        jvmArgs("--enable-preview")
    }

    jar {
        manifest {
            attributes(
                Pair("Main-Class", "com.github.yannicklamprecht.Main")
            )
        }
    }
}
