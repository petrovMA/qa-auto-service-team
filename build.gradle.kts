group = "ru.action_tech"
version = "1.0-SNAPSHOT"

apply {
    plugin("org.jetbrains.kotlin.jvm")
    plugin("ru.action_tech.ghelper")

    from(rootProject.file("build.gradle.dependencies.kts"))
}

buildscript {
    val betaProp = "GHELPER_FORCE_VERSION"
    val ghelperForceVersion = providers.gradleProperty(betaProp).orNull ?: System.getenv(betaProp) ?: null

    configurations.all {
        resolutionStrategy {
            cacheDynamicVersionsFor(0, "seconds")
            cacheChangingModulesFor(0, "seconds")

            componentSelection {
                withModule("ru.action_tech:ghelper") {
                    if (ghelperForceVersion.isNullOrBlank() && candidate.version.contains("beta")) {
                        reject("version $version is beta for 'ru.action_tech:ghelper'")
                    }
                }
                withModule("ru.action_tech:qa-auto-core") {
                    if (ghelperForceVersion.isNullOrBlank() && candidate.version.contains("beta")) {
                        reject("version $version is beta for 'ru.action_tech:qa-auto-core'")
                    }
                }
            }
        }
    }

    repositories {
        val nexusRepositoryHost = "http://nexus.action-media.ru"
        val nexusRepositoryUrl = "$nexusRepositoryHost/repository"
        val nexusRepositoryQaAutoGroupUrl = "$nexusRepositoryUrl/qa-auto"

        mavenLocal {
            content {
                excludeGroup("org.jetbrains.kotlin")
                excludeGroup("ru.action_tech")
            }
        }

        maven {
            isAllowInsecureProtocol = true
            url = uri(nexusRepositoryQaAutoGroupUrl)
        }
    }

    dependencies {
        classpath(ghelperForceVersion ?: "ru.action_tech:ghelper:9.+") { isChanging = true }
    }
}