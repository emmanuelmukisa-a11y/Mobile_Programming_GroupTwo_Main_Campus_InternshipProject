# \#Intern — Internship Management App for Ndejje University

> \\\*\\\* \\\[WATCH OUR PRESENTATION ON YOUTUBE](https://youtu.be/bVZaUfr2yzo)\\\*\\\*




## \##Project Identity

**\*\*App Name:\*\*** OurInternship
\*\***Course:\*\*** Mobile Programming (BCS 2201 / BIT 2205)  
\*\***Institution:\*\*** Ndejje University Main Campus  
\*\***Faculty:\*\*** Faculty of Science and Computing
\*\***Lecturer:\*\*** Luyima Alex Cedric  
\*\***Group:\*\*** Group Two — Main Campus



## \##Team Roster

|Full Name|Student ID|Role|GitHub Username|
|-|-|-|-|
|Mukisa Emmanuel|24/1/306/D/265|Git Manager and UI/UX Specialist|[@emmanuelmukisa-a11y](https://github.com/emmanuelmukisa-a11y)|
|Apako Dorothy Treasure|24/1/306/D/078|Project Lead|[@apakotreasure-design](https://github.com/apakotreasure-design)|
|Zawedde Susan|24/1/314/D/210|Test and QA Manager|[@zaweddes35](https://github.com/zaweddes35)|
|Nambooze Anna Maria |24/1/314/D/342|Documentation and Research Lead|[@annamarianambooze](https://github.com/annamarianambooze)|
|||||



## \##Feature Set

### \###Student Role

\*Secure login and registration with role-based access control

\*Browse all available internship listings posted by administrators

\*Submit structured weekly internship progress reports

\*View history of all previously submitted reports on the dashboard

### \###Supervisor Role

\*View weekly reports submitted exclusively by assigned students

\*Role-filtered dashboard — no cross-supervisor data exposure

### \###Admin Role

\*Post new internship listings visible to all students

\*Assign supervisors to specific students via an interactive dialog picker

\*Full visibility of all registered users

### \###System-Wide

\*Offline-first architecture — all data stored locally on-device via Room

\*Automatic database seeding with demo accounts on first install

\*Single-activity app entry point with full Compose Navigation



## \##Technical Stack

|Category|Library / Tool|Version|
|-|-|-|
|Language|Kotlin|2.0.0|
|UI Framework|Jetpack Compose|BOM 2024.09.00|
|Design System|Material 3|via Compose BOM|
|Architecture|MVVM (ViewModel + StateFlow)|—|
|Data Persistence|Room Database|2.6.1|
|Navigation|Compose Navigation|2.8.0|
|Async|Kotlin Coroutines + Flow|1.9.0|
|DI / Annotation|KSP (Kotlin Symbol Processing)|2.0.0-1.0.24|
|Build System|Gradle with Version Catalog (libs.versions.toml)|—|
|Min SDK|Android 8.0 (API 24)|—|
|Target SDK|Android 15 (API 35)|—|



## Architecture Overview

Internee follows strict **MVVM (Model-View-ViewModel)** architecture:
app/
└── src/main/java/com/ndejje/internee/
    ├── data/
    │   ├── User.kt              # Room entity — users table
    │   ├── Internship.kt        # Room entity — internships table
    │   ├── Report.kt            # Room entity — reports table
    │   ├── AppDao.kt            # All database queries (Room DAO)
    │   ├── AppDatabase.kt       # Room database
    │   └── AppRepository.kt     # Bridge between DAO and viewmodel
    ├── ui/
    │   ├── viewmodel/
    │   │   ├── AuthViewModel.kt  # Login, register, logout state
    │   │   └── MainViewModel.kt  # Reports, internships, supervisor assignment
    │   ├── navigation/
    │   │   ├── Screen.kt         # Sealed class — 7 named routes
    │   │   └── AppNavigation.kt  # NavHost — wires routes to screens
    │   └── screens/
    │       ├── LoginScreen.kt
    │       ├── RegisterScreen.kt
    │       ├── StudentDashboardScreen.kt
    │       ├── InternshipListingsScreen.kt
    │       ├── ReportSubmissionScreen.kt
    │       ├── SupervisorDashboardScreen.kt
    │       └── AdminPanelScreen.kt
    └── MainActivity.kt           # Entry point only — sets content view


**\*\*Key architectural decisions:\*\***

\*MainActivity.kt contains no business logic — entry point only

\*All state exposed via StateFlow and collected with collectAsState()

\*AppRepository wraps all DAO calls and exposes Kotlin Flow to ViewModels

\*Navigation driven by a sealed Screen class — no hardcoded route strings

## \##Demo Credentials

|Role|Email|Password|
|-|-|-|
|Student|student@example.com|password|
|Admin|admin@example.com|admin123|
|Supervisor|supervisor@example.com|password|

These credentials are seeded automatically on first install. Passwords are stored as plaintext in this version — hashing is documented as a post-MVP enhancement.



## \##QA Summary — Test Cases vs Results

Authored by the Testing and QA Engineer. Tests executed via `./gradlew test`.

|#|Test Class|Test Method|What It Verifies|Result|
|-|-|-|-|-|
|1|AuthViewModelTest|loginWithValidCredentials\\\_returnsSuccess()|Correct email + password returns AuthState.Success| PASS|
|2|AuthViewModelTest|loginWithInvalidPassword\\\_returnsError()|Wrong password returns AuthState.Error| PASS|
|3|AuthViewModelTest|registerWithExistingEmail\\\_returnsError()|Duplicate email registration is blocked| PASS|
|4|MainViewModelTest|submitReport\\\_addsReportToDatabase()|Report submission inserts entity and emits updated list|PASS|
|5|MainViewModelTest|assignSupervisor\\\_updatesSupervisorId()|Supervisor assignment correctly updates student's `supervisorId`| PASS|

&#x20;
\*\***Coverage:\*\*** Authentication state transitions (3 cases) + core data operations (2 cases)  
\*\***All 5 tests: PASSED\*\***

## \##Submission Checklist

\*\\\[x] Final signed APK submitted to Moodle — 1st May 2026

\*\\\[x] Repository link submitted to Moodle — 1st May 2026

\*\\\[x] Individual Affective Domain Reports submitted — 1st May 2026

\*\\\[x] Peer Evaluations completed on Moodle — 1st May 2026

\*\\\[x] YouTube presentation link added to this README — due 6th May 2026



## \##License

This project was developed as a capstone submission for academic purposes at Ndejje University.  


