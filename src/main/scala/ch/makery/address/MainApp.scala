
////package ch.makery.address
////
////import scalafx.application.JFXApp
////import scalafx.scene.Scene
////import javafx.fxml.FXMLLoader
////import scalafx.scene.layout.VBox
////
////object MainApp extends JFXApp {
////
////  // Load the pet scene from the FXML file
////  val loader = new FXMLLoader()
////  loader.setLocation(getClass.getResource("/ch/makery/address/view/PetScene2.fxml"))
////  val petScene: VBox = loader.load().asInstanceOf[javafx.scene.layout.VBox] // Using JavaFX VBox
////
////  // Show the pet scene in the main stage
////  stage = new JFXApp.PrimaryStage {
////    title = "Pet App"
////    scene = new Scene {
////      root = petScene // Implicit conversion to ScalaFX VBox
////    }
////  }
////}
//package ch.makery.address
//
//import scalafx.application.JFXApp
//import scalafx.scene.Scene
//import javafx.fxml.FXMLLoader
//import javafx.scene.layout.AnchorPane
//import scalafx.Includes._
//
//object MainApp extends JFXApp {
//
//  // Load the pet scene from the FXML file
//  val loader = new FXMLLoader()
//  loader.setLocation(getClass.getResource("/ch/makery/address/view/PetScene2.fxml"))
//  val petScene: AnchorPane = loader.load().asInstanceOf[AnchorPane]
//
//  // Show the pet scene in the main stage
//  stage = new JFXApp.PrimaryStage {
//    title = "Pet App"
//    scene = new Scene(petScene)
//  }
//}

package ch.makery.address

import scalafx.application.JFXApp
import scalafx.scene.Scene
import javafx.fxml.FXMLLoader
import javafx.scene.layout.AnchorPane
import scalafx.Includes._


object MainApp extends JFXApp {


  // Load the start scene from the FXML file
  val loader = new FXMLLoader()
  loader.setLocation(getClass.getResource("/ch/makery/address/view/Start.fxml"))
  val startScene: AnchorPane = loader.load().asInstanceOf[AnchorPane]

  // Show the start scene in the main stage
  stage = new JFXApp.PrimaryStage {
    title = "Mochi-Your Virtual Pet"
    scene = new Scene(startScene)
  }
}


