# Password Manager App

## Building the Application

### 1. Clone the Repository:
   - Open Android Studio.
   - Select `File > New > Project from Version Control`.
   - Paste the repository URL: `(https://github.com/shubhanshu24510/PasswordManagerApp.git)`.
   - Choose the directory for cloning and click `Clone`.

### 2. Set Up Development Environment:
   - Ensure the following setup:
     - Android Studio (version 4.2+)
     - Android SDK with API level 24+
     - Android Build Tools version 34.0.0+
     - Kotlin plugin updated to the latest version.

### 3. Open Project in Android Studio:
   - If not opened automatically, select `File > Open` and navigate to the cloned project directory.

### 4. Sync Gradle and Build Project:
   - Allow Android Studio to sync with Gradle and complete the build process.

## Running the Application

### 1. Connect Device or Emulator:
   - Connect an Android device via USB or launch an emulator.
   - Ensure the device/emulator runs on API level 34+.

### 2. Build and Run:
   - Click the green play button or select `Run > Run 'app'`.
   - Choose the target device or emulator for deployment.

## Features

- **Add Passwords:**
  - Tap the "+" button.
  - Enter account type, username/email, and password.
  - Tap "Add New Account".

- **View/Edit Passwords:**
  - Select a password from the home screen.
  - Tap "Edit" to modify details and "Confirm" to save changes.

- **Delete Passwords:**
  - Select a password from the home screen.
  - Tap "Delete" to remove it.

- **Password Strength Meter:**
  - Displays password strength when adding/editing passwords.

- **Password Generation:**
  - Tap "Generate Password" for a strong, random password.
  - Customize length and character types.

- **Encryption and Security:**
  - Passwords encrypted with AES.
  - Secure storage using Room database.

## Tech Stack

- **Kotlin:** Main programming language.
- **Jetpack Compose:** UI toolkit.
- **Room Database:** Secure local storage.
- **AES Encryption:** Protects password data.
- **Android Architecture Components:** Enhances maintainability.

## Additional Notes

- **Backup:** Implement backup for encrypted password storage.
- **Security:** Encourage strong, unique master passwords.
- **User Guidance:** Provide in-app instructions for features and security.

---

By following this guide, you'll be able to build, run, and explore the Password Manager app with ease. Happy coding!
