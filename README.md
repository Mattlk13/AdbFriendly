ADB Friendly
===

ADB Friendly is a Android Studio plugin to provide some useful functions via ADB.

The plugin can rotate screen on connected devices or emulators only now.
But I will add to some features.
If you have requests feel free to contact me :)

## Functions

### Screen rotation

Refer youtube

[![](http://img.youtube.com/vi/GfFcLmkfbTc/0.jpg)](https://www.youtube.com/watch?v=GfFcLmkfbTc)

## Installation

1. Select Android Studio's menu `Preference > Plugins` then search `ADB Friendly` and install.
1. Clone this repository then build and install from zip file. See develop section.

After installation, plugin added on toolbar at the last section.
If you use Android Studio, the plugin added into Tools > Android too.

If you don't find it, go to View menu on Android Studio and toggle toolbar.

## Usage

Click a ADB Friendly icon (or menu) on your IDE's toolbar then dialog is shown.

Select your device or emulator, and input rotating count in integer, finally click OK button.

Then target device's screen will rotate automatically.

Now the plugin automatically connect to adb.
If the plugin can not connect to adb then input your adb path through the dialog.
Even through do it but devices are not shown on the dialog, try below please on your terminal.

```
adb devices
```

## Development

`git clone https://github.com/gen0083/AdbFriendly.git`

Import the project by gradle project on your IDEA.

### Optional

Modify to plugin project will be useful.

1. Open `.idea/modules/plugin/plugin.iml` and `.idea/modules/plugin/plugin_main.iml`. (If you don't find it then close and reopen project.)
1. Replace 'JAVA_MODULE' to 'PLUGIN_MODULE'. (It is type attribute in module tag.)
1. Close project and reopen project.
1. You can use wizard to add Action etc.

### My developing environment

+ Project SDK: Intellij Platform Plugin SDK with Intellij 14.1.6 (Internal Java Platform 1.6)
+ Develop with IntelliJ 2016.1.1 with JDK 1.8
+ Check with Android Studio 2.0

### Execute

`./gradlew runIdea`

If you set alternativeIdePath (in build.gradle intellij section) then launch it.
Otherwise launch IntelliJ 14.1.6.

### Build zip file

`./gradlew buildPlugin`

Zip file located to `<project_root>/plugin/build/distributions/ADB Friendly.zip`.

## License

```
ADB Friendly
Copyright 2016 gen0083

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```