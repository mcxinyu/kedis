plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.6.10"
    `maven-publish`
}

kotlin {
    explicitApi()
}

group = "com.github.mcxinyu"
version = "1.0.0"
publishing {
    repositories {
        maven {
            name = "repo"
            url = uri("${project.buildDir}/repo")
        }
    }
    publications {
        create<MavenPublication>("maven"){
            from(components.getByName("kotlin"))
        }
    }
}

dependencies {
    implementation(project(":kedis-core"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
}
