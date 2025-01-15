# PYQ app for Previous Year Papers

This project allows you to download the year-wise papers from various courses. To get started, follow the steps below.

## Prerequisites

Before you start using this app, you need to set up Firebase in your project.

### 1. Configure Firebase

- Create a Firebase project by visiting [Firebase Console](https://console.firebase.google.com/).
- Add an Android app to your Firebase project.
- Download the `google-services.json` file and place it in the `app/` directory of your Android project.

### 2. Add Firebase SDK

- Add the Firebase SDK dependencies to your `build.gradle` files.

### 3. Make a json file in this format:-

```Year wise Papers
├── Sem4
│   ├── Data Science
│   │   └── year: link
│   ├── Digital Marketing
│   │   └── year: link
│   ├── Java
│   │   ├── year: link
│   ├── SE
│   │   ├── year: link
│   └── ........
│       
├── Sem5
│   ├── Cloud Computing
│   │   └── year: link
│   ├── Computer Graphics
│   │   ├── year: link
│   │   ├── ....
├── Sem6
│   ├── Artificial Intelligence
│   │   ├── year: link
│   │   ├── .....
└── Combined Papers
    ├── Sem4
    │   ├── Data Science
    │   │   └── year: link
    │   ├── .......
    ├── Sem5
    │   ├── Cloud Computing
    │   │   └── year: link
    │   ├── ......
    └── Sem6
        ├── Artificial Intelligence
        │   └── year: link
        ├── .......
```

### 4. Upload this file in your firebase realtime database and the app will run.


### 5. Link for the App :-
https://drive.google.com/file/d/1nzn9CaWR3A6H0ug7kWYSCtyVLYO_fxjB/view?usp=drivesdk
