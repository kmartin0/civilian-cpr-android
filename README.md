# Civilian CPR Android

Native Android application for receiving and managing civilian CPR alert messages.

## Features

- Light and dark mode based on the system theme.
- Receive and process incoming SMS messages.
- Persist CPR alert messages received from Hartstichting.
- Display notifications for incoming CPR alerts.
- Open Google Maps from a notification with directions to the CPR location, including possible AED waypoints.
- Display received messages ordered by date.
- Share, copy and delete messages.
- Batch delete multiple messages.
- Open directions for a message in Google Maps.

## Technical Overview

- Kotlin.
- MVVM architecture using Android Architecture Components.
- Single-activity architecture with fragment navigation using Navigation Components.
- Material Design using Material Components.
- Dependency injection using Hilt.
- Local persistence using Room.
- Kotlin Coroutines for background operations.

## Screenshots

<img src="https://github.com/kmartin0/assets/blob/master/civilian-cpr-android/civilian-cpr_empty-state.png?raw=true" alt="Empty state screenshot" width="300" />

<img src="https://github.com/kmartin0/assets/blob/master/civilian-cpr-android/civilian-cpr_messages.png?raw=true" alt="Messages screenshot" width="300" />

<img src="https://github.com/kmartin0/assets/blob/master/civilian-cpr-android/civilian-cpr_home-dark-theme.png?raw=true" alt="Dark theme screenshot" width="300" />

<img src="https://github.com/kmartin0/assets/blob/master/civilian-cpr-android/civilian-cpr_delete-context.png?raw=true" alt="Delete context menu screenshot" width="300" />

<img src="https://github.com/kmartin0/assets/blob/master/civilian-cpr-android/civilian-cpr_notification.png?raw=true" alt="CPR notification screenshot" width="300" />

<img src="https://github.com/kmartin0/assets/blob/master/civilian-cpr-android/civilian-cpr_maps.png?raw=true" alt="Google Maps directions screenshot" width="300" />