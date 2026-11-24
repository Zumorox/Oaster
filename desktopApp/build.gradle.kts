import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    jvm("desktop")

    sourceSets {
        val desktopMain by getting {
            dependencies {
                implementation(projects.composeApp)
                implementation(projects.core.designSystem)
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutines.swing)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.cutozmie.oaster.desktop.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Oaster"
            packageVersion = "1.0.0"
            description = "Oaster by Cutozmie"
            vendor = "Cutozmie"
            windows {
                menuGroup = "Cutozmie"
                // iconFile.set(project.file("../brand/logo/oaster.ico")) // add when .ico is generated
            }
        }
    }
}
