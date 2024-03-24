plugins {
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "np.prashant.dev.recipes"
    compileSdk = 34

    defaultConfig {
        applicationId = "np.prashant.dev.recipes"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }


        buildConfigField("String", "API_HOST", "\"api.spoonacular.com\"")
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false

            buildConfigField("String", "API_KEY", "\"${System.getenv("RECIPES_API_KEY_DEBUG")}\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String", "API_KEY", "\"${System.getenv("RECIPES_API_KEY_RELEASE")}\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.lifecycle.process)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.compose.lifecycle.viewmodel)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)

    implementation(libs.javax.inject)
    implementation(libs.dagger.hilt.android)
    implementation(libs.dagger.hilt.compose)
    ksp(libs.dagger.hilt.compiler)

    implementation(libs.coil)
    implementation(libs.bundles.ktor)

    testImplementation(libs.test.junit)
    testImplementation(libs.test.truth)
    testImplementation(libs.coroutines.test)

    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.uiTest)
    androidTestImplementation(libs.dagger.hilt.test)

    kspTest(libs.dagger.hilt.android.compiler)

    debugImplementation(libs.androidx.compose.uiTooling)
    debugImplementation(libs.androidx.compose.uiTestManifest)
}