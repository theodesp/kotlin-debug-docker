import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.3.60"
    application
    id("com.google.cloud.tools.jib") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("io.javalin:javalin:3.6.0")
    compile("org.slf4j:slf4j-simple:1.7.28")
    compile("org.slf4j:slf4j-api:1.7.28")
    testCompile("junit:junit:4.12")
}

application {
    mainClassName = "HelloWorldKt"
}

tasks.withType<ShadowJar> {
    manifest.attributes.apply {
        put("Implementation-Title", "Gradle Jar File Example")
        //put("Implementation-Version" version)
        put("Main-Class", "HelloWorldKt")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}