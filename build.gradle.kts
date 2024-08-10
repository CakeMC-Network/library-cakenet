import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.nio.charset.StandardCharsets

plugins {
    id("idea")

    id("java")
    id("java-library")

    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "net.cakemc"
version = "0.0.0-develop"

repositories {
    mavenCentral()
}

fun <V> prop(value: String): V {
    return properties.getValue(value) as V
}

dependencies {
    annotationProcessor(
            group = "org.jetbrains",
            name = "annotations",
            version = prop("dep_ann-jbr")
    )
    implementation(
            group = "org.jetbrains",
            name = "annotations",
            version = prop("dep_ann-jbr")
    )

    implementation(
            group = "io.netty",
            name = "netty-common",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-common",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-buffer",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-buffer",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-codec",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-codec",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-resolver",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-resolver",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-codec",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-codec",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-transport",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-transport",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-transport-classes-epoll",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-transport-classes-epoll",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-transport-classes-kqueue",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-transport-classes-kqueue",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-transport-native-epoll",
            version = prop("dep-netty"),
            classifier = "linux-aarch_64"
    )
    shadow(
            group = "io.netty",
            name = "netty-transport-native-epoll",
            version = prop("dep-netty"),
            classifier = "linux-aarch_64"
    )

    implementation(
            group = "io.netty",
            name = "netty-transport-native-epoll",
            version = prop("dep-netty"),
            classifier = "linux-riscv64"
    )
    shadow(
            group = "io.netty",
            name = "netty-transport-native-epoll",
            version = prop("dep-netty"),
            classifier = "linux-riscv64"
    )

    implementation(
            group = "io.netty",
            name = "netty-transport-native-epoll",
            version = prop("dep-netty"),
            classifier = "linux-x86_64"
    )
    shadow(
            group = "io.netty",
            name = "netty-transport-native-epoll",
            version = prop("dep-netty"),
            classifier = "linux-x86_64"
    )

    implementation(
            group = "io.netty",
            name = "netty-transport-native-kqueue",
            version = prop("dep-netty"),
            classifier = "osx-aarch_64"
    )
    shadow(
            group = "io.netty",
            name = "netty-transport-native-kqueue",
            version = prop("dep-netty"),
            classifier = "osx-aarch_64"
    )

    implementation(
            group = "io.netty",
            name = "netty-transport-native-kqueue",
            version = prop("dep-netty"),
            classifier = "osx-x86_64"
    )
    shadow(
            group = "io.netty",
            name = "netty-transport-native-kqueue",
            version = prop("dep-netty"),
            classifier = "osx-x86_64"
    )

    implementation(
            group = "io.netty",
            name = "netty-handler",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-handler",
            version = prop("dep-netty")
    )

    implementation(
            group = "io.netty",
            name = "netty-handler-proxy",
            version = prop("dep-netty")
    )
    shadow(
            group = "io.netty",
            name = "netty-handler-proxy",
            version = prop("dep-netty")
    )
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
    options.encoding = StandardCharsets.UTF_8.toString()
}

tasks.withType<AbstractArchiveTask> {
    isReproducibleFileOrder = true
    isPreserveFileTimestamps = false
}

tasks.withType<ShadowJar> {
    configurations = listOf(project.configurations.shadow.get())
    isZip64 = true
}

configurations.shadow { isTransitive = false }
