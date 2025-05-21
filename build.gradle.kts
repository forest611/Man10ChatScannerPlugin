plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.psysoftware"
version = "1.0"

repositories {
    mavenCentral()
    // Waterfall API
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc"
    }
}

dependencies {
    compileOnly("io.github.waterfallmc:waterfall-api:1.21-R0.1-SNAPSHOT")
}

val targetJavaVersion = 17
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("bungee.yml") {
        expand(props)
    }
}
