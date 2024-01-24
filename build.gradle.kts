plugins {
    kotlin("multiplatform") version "1.9.22"
    id("app.cash.sqldelight") version "2.0.1"
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sqldelight {
    linkSqlite.set(true)
    databases {
        create("Database") {
            packageName.set("com.example")
        }
    }
}

kotlin {
    mingwX64("native") {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }

    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation("app.cash.sqldelight:native-driver:2.0.1")
            }
        }
        val nativeTest by getting
    }
}
