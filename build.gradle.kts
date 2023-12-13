plugins {
    id("java")
}

group = "io.github.xtyuns"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    implementation("org.apache.dubbo:dubbo:3.2.9")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.43")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}