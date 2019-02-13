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
(def button (r/adapt-react-class (.-Button ReactNative)))
;; navigation 
(def create-stack-navigator (.-createStackNavigator ReactNavigation))
(def create-app-container (.-createAppContainer ReactNavigation))


(defn home-screen [props]
  (fn [props]
    [view {:style {:flex 1 :justify-content "center" :align-tems "center"}}
     [text "Home!"]
     [button {:title "Go to details" 
              :on-press (fn []
                          ;; which is equal to props.navigation.navigate("Details")
                          (.navigate (.-navigation (clj->js props)) "Details") 
                         ) }]
     ])
  )

(defn details-screen []
  [view {:style {:flex 1 :justify-content "center" :align-tems "center"}}
   [text "Details Screen!"]
   ]
  )

(def stack-navigator 
  (create-stack-navigator
   (clj->js {:Home  (r/reactify-component home-screen)
             :Details (r/reactify-component details-screen)
             })
   (clj->js {:initialRouteName "Home"})
   ))

(defn app-root [] [:> (create-app-container stack-navigator ) {}])

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "reactNavigationClojurescriptExample" #(r/reactify-component app-root)))
