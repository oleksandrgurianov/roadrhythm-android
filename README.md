# RoadRhythm – Android App

### Primary front-end features:

- Log In page

  - Background

  - Button

  - Image

  - Text

- Home page

  - Background

  - Dropdown

    - Buttons

    - Icons

### Primary back-end features:

- implementation of an Authentication View Model to enable simple login and logout functionality

- integration of the Spotify API to establish connection with the Spotify application, requiring prior installation and login

- incorporation of gesture detection to facilitate control over Spotify playback, including single tap, double tap, and long press commands

- utilization of gesture detection for controlling system volume, such as swipe up and swipe down motions

- implementation of gesture detection for opening a dropdown menu, such as through long press interactions


### Known bugs:

- when the application is fully closed (e.g., swiped up from Recent Apps) the user is required to log in again, even though the connection with Spotify API is maintained

- when the user switches from the main application to another application and then returns, the playback controls cease to function, necessitating a log out and log in procedure

- in some cases, the long press gesture may be mistaken for a swiping gesture if the user moves their finger excessively while pressing


### Areas of improvement:

- addressing known issues

- implementation of the whole High Fidelity Prototype functionality within the actual application

- incorporation of additional features based on feedback received during the application's presentation
