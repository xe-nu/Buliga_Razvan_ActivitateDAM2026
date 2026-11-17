pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "S2"
include(":app")
include(":app:seminar02")
include(":app:seminar03")
include(":app:seminar04")
include(":app:grind01")
include(":app:grind01-2")
include(":app:grind02-claude")
include(":app:grind_nebunie_rau_de_tot")
include(":app:grind03")
include(":app:grind04")
include(":app:grind05_claude")
include(":app:grind06_claude")
include(":app:grind06_claude2")
