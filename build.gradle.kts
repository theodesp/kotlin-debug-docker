import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.3.60"
    application
    id("com.google.cloud.tools.jib") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("io.ktor:ktor-server-core:1.2.6")
    compile("io.ktor:ktor-server-netty:1.2.6")
    compile("ch.qos.logback:logback-classic:1.2.3")
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