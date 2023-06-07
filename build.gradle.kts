plugins {
    kotlin("jvm") version "1.8.21"
}

group = "nuua.aggregator.flights.converter.yyy.xx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}