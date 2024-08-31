val MAIN_CLASS = "haxidenti.furrworld.MainKt"
val PROJECT_NAME = "furworld"
val AUTHOR = "HaxiDenti"
val VERSION = "1.0.0"
val CORO_VER = "1.9.0-RC"

plugins {
    kotlin("jvm") version "2.0.10"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("application")
    `maven-publish`
}

group = AUTHOR
version = VERSION

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$CORO_VER")

    implementation("io.javalin:javalin:6.2.0")
}

application {
    mainClass.set(MAIN_CLASS)
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = AUTHOR
            artifactId = PROJECT_NAME
            version = VERSION
            
            from(components["java"])
        }
    }
}