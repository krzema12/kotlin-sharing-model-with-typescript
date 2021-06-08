import com.moowork.gradle.node.yarn.YarnTask

plugins {
    id("com.github.node-gradle.node") version "2.2.4"
}

node {
    download = true
    version = "12.18.4"
}

val buildTypescript by tasks.creating(YarnTask::class) {
    dependsOn(tasks.getByName("yarn"))
    group = "build"
    inputs.files(fileTree("src"))
    inputs.file("package.json")
    inputs.file("tsconfig.json")
    outputs.files(fileTree("build"))

    args = listOf("build")
}
