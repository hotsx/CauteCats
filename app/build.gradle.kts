import com.android.build.gradle.AppExtension
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

configure<AppExtension> {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.hotsx.vocabulary"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dataBinding.isEnabled = true
}

dependencies {
    implementation(fileTree(mapOf("include" to "*.jar", "dir" to "libs")))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.android.material:material:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0-rc02") // Navigation
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0-rc02")
    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0-alpha02")//ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0")

    /*Test dependencies*/

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}

androidExtensions.isExperimental = true
