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

val ENABLE_PREVIEW = "--enable-preview"

val JAVA_VERSION = JavaVersion.VERSION_23
val RAW_JAVA_VERSION = 23

java {
    sourceCompatibility = JAVA_VERSION
    targetCompatibility = JAVA_VERSION
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(RAW_JAVA_VERSION))
    }
}


tasks {
    compileJava {
        options.release.set(RAW_JAVA_VERSION)
        options.compilerArgs.add(ENABLE_PREVIEW)
        options.compilerArgs.add("-Xlint:preview")
    }

    test {
        useJUnitPlatform()
        jvmArgs(ENABLE_PREVIEW)
    }

    jar {
        manifest {
            attributes(
                Pair("Main-Class", "com.github.yannicklamprecht.Main")
            )
        }
    }
}
