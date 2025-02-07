import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "1.6.10" apply false
    id("com.github.gmazzo.buildconfig").version("3.1.0")
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }

    tasks {
        withType<KotlinCompile> {

            kotlinOptions {
                jvmTarget = "11"
                freeCompilerArgs = listOf(
                    "-Xopt-in=kotlin.contracts.ExperimentalContracts",
                    "-Xopt-in=kotlin.RequiresOptIn"
                )
            }
        }

        withType<JavaCompile> {
            sourceCompatibility = "11"
            targetCompatibility = "11"
        }
    }
}
