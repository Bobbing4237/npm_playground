plugins {
    kotlin("js")
    id("dev.petuska.npm.publish") version("2.1.2")
}

kotlin {
    js {
        nodejs()
    }
}

npmPublishing {
    publications {
        publication(project.name) {
            main = "index.js"
            readme = file("README.md")
            fileSpecs
            files {
                from(projectDir) {
                    include("index.js")
                }
                from("$projectDir/src/main/resources") {
                    include("kmptor/**")
                }
            }
            packageJson {
                version = "4.7.11-1+1.3.1"
                description = "Assets for npm playground"
                homepage = "https://github.com/Bobbing4237/npm_playground"
                license = "Apache 2.0"
                repository {
                    type = "git"
                    url = "git+https://github.com/Bobbing4237/npm_playground.git"
                }
                author {
                    name = "Bobbing 4237"
                }
                bugs {
                    url = "https://github.com/Bobbing4237/npm_playground/issues"
                }
            }

            repositories {
                repository("npmjs") {
                    registry = uri("https://registry.npmjs.org")
                    authToken = rootProject.findProperty("NPM_AUTH_TOKEN_BOBBING") as? String
                }
            }
        }
    }
}
