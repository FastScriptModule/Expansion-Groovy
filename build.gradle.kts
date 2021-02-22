plugins {
    kotlin("jvm") version "1.4.30"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.scoretwo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("http://repo.iroselle.com/snapshots/")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.codehaus.groovy:groovy-jsr223:3.0.7")
    compileOnly("me.scoretwo:FastScript-common:1.0.1-SNAPSHOT")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    dependencies {
        exclude(dependency("org.jetbrains.kotlin:kotlin-stdlib"))
        exclude(dependency("org.jetbrains.kotlin:kotlin-stdlib-common"))

        include(dependency("org.codehaus.groovy:groovy-jsr223:3.0.7"))
        include(dependency("org.codehaus.groovy:groovy:3.0.7"))
    }
    relocate("kotlin", "me.scoretwo.utils.shaded.kotlin")
    classifier = null
}
tasks.processResources {
    from("src/main/resources") {
        include("expansion.yml")
        expand(mapOf(
            "name" to rootProject.name,
            "version" to rootProject.version,
            "description" to rootProject.description
        ))
    }
}