(ns react-navigation-clojurescript-example.android.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [react-navigation-clojurescript-example.events]
            [react-navigation-clojurescript-example.subs]))

(def ReactNative (js/require "react-native"))
(def ReactNavigation (js/require "react-navigation"))
(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
;; navigation 
(def create-tab-navigator (.-createBottomTabNavigator ReactNavigation))
(def create-app-container (.-createAppContainer ReactNavigation))


(defn home-screen []
  [view {:style {:flex 1 :justify-content "center" :align-tems "center"}}
   [text "Home!"]
   ]
  )

(defn settings-screen []
  [view {:style {:flex 1 :justify-content "center" :align-tems "center"}}
   [text "Settings!"]
   ]
  )

(def tab-navigator 
  (create-tab-navigator
   (clj->js {:Home {:screen (r/reactify-component home-screen)}
             :Settings {:screen (r/reactify-component settings-screen)}
             })
   (clj->js {:tabBarOptions {:style {:backgroundColor "#eee"}}})
   ))

(defn app-root [] [:> (create-app-container tab-navigator ) {}])

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "reactNavigationClojurescriptExample" #(r/reactify-component app-root)))
