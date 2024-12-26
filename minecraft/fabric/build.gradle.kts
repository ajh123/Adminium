plugins {
    id("fabric-loom") version "1.9-SNAPSHOT"
    id("maven-publish")
}

version = rootProject.findProperty("mod_version") as String
group = rootProject.findProperty("maven_group") as String

base {
    archivesName.set(rootProject.findProperty("fabric_archives_base_name") as String)
}

dependencies {
    "minecraft"("com.mojang:minecraft:${rootProject.findProperty("minecraft_version") as String}")
    "mappings"("net.fabricmc:yarn:${rootProject.findProperty("yarn_mappings") as String}:v2")
    
    "modImplementation"("net.fabricmc:fabric-loader:${rootProject.findProperty("loader_version") as String}")
    "modImplementation"("net.fabricmc.fabric-api:fabric-api:${rootProject.findProperty("fabric_version") as String}")
}

tasks.named<ProcessResources>("processResources") {
    inputs.property("version", rootProject.findProperty("mod_version") as String)
    inputs.property("mc_version", rootProject.findProperty("minecraft_version") as String)
    inputs.property("yarn_mappings", rootProject.findProperty("yarn_mappings") as String)
    inputs.property("loader_version", rootProject.findProperty("loader_version") as String)
    inputs.property("fabric_version", rootProject.findProperty("fabric_version") as String)
    inputs.property("maven_group", rootProject.findProperty("maven_group") as String)
    inputs.property("archives_base_name", rootProject.findProperty("fabric_archives_base_name") as String)

    filesMatching("**/fabric.mod.json") {
        expand(rootProject.properties)
    }
}

tasks.withType<JavaCompile> {
    options.release.set(21)
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.named<Jar>("jar") {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}" }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = project.base.archivesName.get()
        }
    }
}