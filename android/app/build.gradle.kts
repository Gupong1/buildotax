plugins {
    id("com.android.application")
    // START: FlutterFire Configuration
    id("com.google.gms.google-services")
    // END: FlutterFire Configuration
    id("kotlin-android") version "1.9.0"
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.otax.ayun"
    compileSdk = 34  // ✅ FIX: Turunkan ke 34 (kompatibel dengan AGP 8.1.0)
    ndkVersion = "28.2.13676358"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    defaultConfig {
        applicationId = "com.otax.ayun"
        minSdk = 24
        targetSdk = 34  // ✅ FIX: Turunkan ke 34
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("debug")
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

flutter {
    source = "../.."
}
