plugins {
    `java-library`
    `maven-publish`
    id("velocity-publish")
}

java {
    withSourcesJar()

    sourceSets["main"].java {
        srcDir("src/ap/java")
    }

    sourceSets["main"].resources {
        srcDir("src/ap/resources")
    }
}

dependencies {
    api(libs.gson)
    api(libs.guava)

    // DEPRECATED: Will be removed in Velocity Polymer
    api("com.moandjiezana.toml:toml4j:0.7.2")

    api(platform(libs.adventure.bom))
    api("net.kyori:adventure-api")
    api("net.kyori:adventure-text-serializer-gson")
    api("net.kyori:adventure-text-serializer-legacy")
    api("net.kyori:adventure-text-serializer-plain")
    api("net.kyori:adventure-text-minimessage")
    api("net.kyori:adventure-text-logger-slf4j")
    api("net.kyori:adventure-text-serializer-ansi")

    api(libs.snakeyaml)

    api(libs.slf4j)
    api(libs.guice)
    api(libs.checker.qual)
    api(libs.brigadier)
    api(libs.bundles.configurate)
    api(libs.caffeine)
}

tasks {
    jar {
        manifest {
            attributes["Automatic-Module-Name"] = "com.velocitypowered.api"
        }
    }
}
