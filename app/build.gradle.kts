import com.android.build.gradle.AppExtension
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

configure<AppExtension> {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.hotsx.cat"
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
    implementation("io.github.microutils:kotlin-logging:1.6.22") //Log
    implementation("org.slf4j", "slf4j-android", "1.7.21")//Log
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0-rc02") // Navigation
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0-rc02")
    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0-alpha02")//ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0")
    implementation("com.squareup.retrofit2:retrofit:2.5.0")//retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")//Gson
    implementation("com.github.bumptech.glide:glide:4.9.0")//Glide
    implementation("androidx.paging:paging-runtime:2.1.0") //Paging 分页组件
    testImplementation("androidx.paging:paging-common:2.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1") //Coroutines
    /*Test dependencies*/
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}

androidExtensions.isExperimental = true
