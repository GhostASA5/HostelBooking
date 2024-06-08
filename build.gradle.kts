plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

ext {
	mapstructVersion = "1.5.4.Final"
	lombokVersion = "1.18.20"
	lombokMapstructBindingVersion = "0.2.0"
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")
//	compileOnly("org.projectlombok:lombok")
//	annotationProcessor("org.projectlombok:lombok")
//	implementation("org.mapstruct:mapstruct:1.5.3.Final")
//	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.mapstruct:mapstruct:${mapstructVersion}", "org.projectlombok:lombok:${lombokVersion}")
	testImplementation('junit:junit:4.13.1')
	/*
        this example uses lombok directly over the annotationProcessor,
        the io.freefair.lombok plugin works as well.
        The freefair-lombok plugin is used in the example mapstruct-on-gradle-testcp-with-lombok
     */
	annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}", "org.projectlombok:lombok:${lombokVersion}", "org.projectlombok:lombok-mapstruct-binding:${lombokMapstructBindingVersion}")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
