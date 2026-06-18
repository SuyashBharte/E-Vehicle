# ⚡ E-Vehicle Information App

An Android application developed as a **Diploma Final Year Project** that provides comprehensive information about Electric Vehicles (EVs), nearby charging stations, showrooms, and allows users to compare EV models.

---

## 📱 Features

- **Splash Screen** — Animated launch screen with app branding
- **User Authentication** — Register and Login with backend API
- **Dashboard** — Central navigation hub
- **EV Information** — Browse and explore electric vehicle models
- **Car Details** — View detailed specifications, features, and photo gallery for each EV
- **Compare Cars** — Side-by-side comparison of two EV models
- **Charging Stations** — Discover nearby EV charging stations
- **Showrooms** — Find EV showroom locations and details
- **Reviews** — Users can submit and view car reviews
- **Feedback** — General feedback submission form
- **Contact / Query Form** — Send queries directly to the team

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Platform | Android (minSdk 24, targetSdk 33) |
| Build System | Gradle 7.3.1 |
| Networking | Retrofit 2.9.0 + Gson |
| Image Loading | Glide 4.15.0 |
| UI Components | Material Design, RecyclerView, CardView, SwipeRefreshLayout |
| Ads | Google AdMob |
| Progress HUD | KProgressHUD |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Electric Eel or newer)
- Android SDK (API 33 / Android 13)
- Java 8+

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/SuyashBharte/E-Vehicle.git
   cd E-Vehicle
   ```

2. **Open in Android Studio:**
   - Launch Android Studio
   - Select **File → Open** and navigate to the cloned folder

3. **Sync Gradle:**
   - Android Studio will automatically prompt you to sync Gradle
   - Click **Sync Now**

4. **Run the app:**
   - Connect an Android device or start an emulator
   - Click the ▶ **Run** button

---

## 🌐 Backend API

The app connects to a hosted backend API:

```
Base URL: https://demo.ayaminteractive.com/Electric%20Vehicles/Android/
```

Key endpoints:
- `signup.php` — User registration
- `login.php` — User authentication
- `view_car.php` — Fetch all car listings
- `car_details.php` — Fetch car details by ID
- `customer_review.php` — Submit a review
- `feedback.php` — Submit feedback
- `query.php` — Submit a contact query
- `station_list.php` — Fetch charging stations
- `showroom_list.php` — Fetch showrooms

---

## 📁 Project Structure

```
app/src/main/
├── java/
│   ├── com/example/electricalvehicalinformation/
│   │   ├── Adapter/        ← RecyclerView Adapters
│   │   ├── Api/            ← Retrofit client & API interface
│   │   ├── Fragment/       ← Fragments & session manager
│   │   ├── Models/         ← Data model classes (POJOs)
│   │   └── *.java          ← Activity classes
│   └── InternetConnection/ ← Network connectivity utility
├── res/
│   ├── layout/             ← XML UI layouts
│   ├── drawable/           ← Images and shape drawables
│   ├── values/             ← Strings, colors, themes
│   └── ...
└── AndroidManifest.xml
```

---

## 📸 Permissions Required

| Permission | Purpose |
|---|---|
| `INTERNET` | API and ad network communication |
| `ACCESS_NETWORK_STATE` | Check connectivity before API calls |
| `CALL_PHONE` | Allow direct calling from showroom/station screens |

---

## 👨‍💻 Author

**Suyash Bharte**
Diploma Final Year Project — Computer Engineering

---

## 📄 License

This project is developed for educational purposes.
