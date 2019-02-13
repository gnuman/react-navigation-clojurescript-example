# react-navigation-clojurescript-example

Example to show how to use react-navigation3 https://reactnavigation.org/ in ClojureScript.
React Navigation (https://reactnavigation.org/) have few code examples which are written in Java Script.
This Example contains same code examples in ClojureScript that will help you get started with react-navigation.

This example uses re-natal.
## Setup 
Apparently react-navigation3 has few changes than previous version.

Prerequisites:
- yarn
- leiningen
- re-natal & react-native-cli (npm install -g re-natal react-native-cli)

`cd` into the directory

```
  cd react-navigation-clojurescript-example
  re-natal use-component react-native
  re-natal use-component react-navigation 
  re-natal use-component  react-native-gesture-handler
  re-natal use-android-device avd (if you are using android simulator)
  re-natal use-figwheel
  lein figwheel android
  Open another tab
  react-native link react-native-gesture-handler
  react-native run-android
```

## To-Do
Test with IOS
## License

Copyright © 2019 

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
