# Password Manager Application Documentation


## Building the Application:

1. **Clone the Repository:**
   - Open Android Studio.
   - Select `File > New > Project from Version Control`.
   - In the "URL" field, paste the repository URL: `https://github.com/Bhushanp091/passwordManager.git`.
   - Choose the directory where you want to clone the repository.
   - Click on `Clone`.

2. **Set Up Development Environment:**
   - Ensure you have the necessary environment set up for Android development:
     - Android Studio (version 4.2 or higher) with Kotlin support.
     - Android SDK with API level 30 (Android 11) or higher.
     - Android Build Tools version 30.0.3 or higher.
     - Kotlin plugin installed and updated to the latest version..

4. **Open Project in Android Studio:**
   - Once the cloning process is complete, project will open automatically if not then open the project by selecting `File > Open` and navigating to the cloned project directory.
   - Android Studio will load the project and index its contents. This process may take a few minutes depending on your system's performance.

5. **Sync Gradle and Build Project:**
   - Android Studio will automatically sync the project with Gradle. Wait for the sync to complete successfully.
   - This will compile the project and generate the necessary build artifacts.

## Running the Application:

1. **Connect Device or Emulator:**
   - Connect an Android device via USB or launch an emulator from Android Studio.
   - Ensure that the device or emulator is running a compatible version of Android (API level 30 or higher).

2. **Build and Run:**
   - Click on the green play button (Run) in Android Studio toolbar, or select `Run > Run 'app'` from the menu.
   - Select the target device or emulator where you want to deploy the application.
   - Android Studio will install the application on the selected device or emulator and launch it automatically.

3. **Explore the Application:**
   - Once the application is installed and running, explore its features and user interface.

## Using the Application:


## Features:

- **Adding Passwords:**
  - Tap on the "+" floating button.
  - Enter the account type (e.g., Gmail, Facebook), your username/email, and the password.
  - Tap on "Add New Account" to securely store the password.

- **Viewing and Editing Passwords:**
  - View and edit existing passwords by selecting the password which you want to edit from the home screen section.
  - Tap on the "Edit" button to change necessary details.
  - Save your edits by tapping on the "Confirm" button.

- **Deleting Passwords:**
  - View and delete existing passwords by selecting the password which you want to edit from the home screen section.
  - Tap on the "Delete" button to change remove password.

- **Password Strength Meter:**
  - A password strength meter is provided below the password field when adding or editing a password.
  - It helps you gauge the strength of your password based on factors such as length and complexity.

- **Password Generation:**
  - When creating a new password entry, users can tap on the "Generate Password" button to automatically create a strong, random password.
  - The generated password is designed to be complex and secure, reducing the risk of it being easily guessed or cracked.
  - Users can customize the length and character types (e.g., letters, numbers, symbols) of the generated password to meet their specific requirements.

- **Encryption and Security:**
  - Your passwords are encrypted using the Advanced Encryption Standard (AES), a highly secure encryption algorithm widely used for protecting sensitive data.
  - AES encryption ensures that your passwords remain secure even if your device is compromised or accessed by unauthorized users.
  - Additionally, our app utilizes a secure Room database to manage encrypted passwords locally on your device.
  - Room is an Android persistence library that provides an abstraction layer over SQLite, making it easier to manage and access encrypted data.
  - By storing passwords in a secure database locally on your device, we add an extra layer of protection to your sensitive information, minimizing the risk of data breaches or unauthorized access.
 
 - **Room Database:**
    - Our application utilizes a secure Room database to manage encrypted passwords locally on your device.
    - Room is an Android persistence library that provides an abstraction layer over SQLite, making it easier to manage and access encrypted data.
    - The use of Room ensures efficient and reliable storage of passwords, with built-in features such as data validation and query optimization.
    - By storing passwords in a secure database locally on your device, we add an extra layer of protection to your sensitive information, minimizing the risk of data breaches or unauthorized access.
    
- **Intuitive User Interface:**
  - Our app features a clean and intuitive user interface, designed to make password management effortless.
  - The user interface is thoughtfully crafted with a minimalist design, focusing on ease of use and clarity of information.
  - Features such as clear labeling, intuitive icons, and logical layout contribute to the overall usability of the app.
  - Whether you're adding a new password, editing an existing one, or generating a strong password, the user interface guides you through each step with minimal effort.

- **Tech Stack:**
    - Our Password Manager application is built using the following technologies:
    - **Kotlin:** The app is developed primarily using Kotlin, a modern programming language for Android development known for its conciseness and safety features.
    - **Jetpack Compose:** We leverage Jetpack Compose, Google's modern toolkit for building native Android UIs, to create dynamic and responsive user interfaces.
    - **Room Database:** For secure and efficient data storage, we utilize Room, an Android persistence library that provides an abstraction layer over SQLite, ensuring reliable management of encrypted passwords.
    - **AES Encryption:** Passwords are encrypted using the Advanced Encryption Standard (AES), a highly secure encryption algorithm, to protect sensitive data stored locally on the device.
    - **Android Architecture Components:** Our app follows best practices in Android app development by implementing architecture components such as ViewModel, LiveData, and Data Binding, enhancing maintainability and testability.
    - **Material Design:** The app adheres to Google's Material Design guidelines, ensuring a consistent and visually appealing user experience across different Android devices and versions.

## Application Screenshots:
<div style="display: flex;">
    <img src="https://github.com/Bhushanp091/passwordManager/raw/master/Screenshot_20240427_121305.png" alt="Screenshot 1" width="300" />
    <img src="https://github.com/Bhushanp091/passwordManager/raw/master/Screenshot_20240427_121507.png" alt="Screenshot 2" width="300" />
</div>

<div style="display: flex;">
    <img src="https://github.com/Bhushanp091/passwordManager/raw/master/Screenshot_20240427_121557.png" alt="Screenshot 3" width="300" />
    <img src="https://github.com/Bhushanp091/passwordManager/blob/master/Screenshot_20240427_121539.png" alt="Screenshot 3" width="300" />
</div>



## Additional Notes:

- **Backup:** Consider implementing a backup feature to securely store encrypted backups of your passwords.
- **Security Best Practices:** Encourage users to choose strong, unique master passwords and avoid sharing them with anyone.
- **User Guidance:** Provide clear instructions and guidance within the application to help users understand its features and security measures.
