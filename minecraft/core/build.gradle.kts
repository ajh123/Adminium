plugins {
    id("java")
}

version = rootProject.findProperty("core_version") as String
group = rootProject.findProperty("maven_group") as String

base {
    archivesName.set(rootProject.findProperty("core_archives_base_name") as String)
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}