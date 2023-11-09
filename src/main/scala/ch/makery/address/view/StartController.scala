////package ch.makery.address.view
////
////import scalafx.scene.control.{Button, TextField}
////import scalafx.scene.Scene
////import javafx.fxml.FXML
////import javafx.scene.layout.AnchorPane
////import scalafx.Includes._
////import javafx.fxml.FXMLLoader
////import ch.makery.address.MainApp
//
////class StartController {
////
////  @FXML
////  var continueBtn: Button = _
////
////  @FXML
////  var petName: TextField = _
////
////  // Handle continue button click
////  def onContinue(): Unit = {
////    // Get pet name or default to "Mochi" if not provided
////    val name = Option(petName.getText).filter(_.nonEmpty).getOrElse("Mochi")
////
////    // Load the pet scene from the FXML file
////    val loader = new FXMLLoader()
////    loader.setLocation(getClass.getResource("/ch/makery/address/view/PetScene2.fxml"))
////    val petScene: AnchorPane = loader.load().asInstanceOf[AnchorPane]
////
////    // Get the controller and set the pet name
////    val controller = loader.getController[PetScene2Controller]
////    controller.setPetName(name)
////
////    // Show the pet scene in the main stage
////    MainApp.stage.scene = new Scene(petScene)
////  }
////}
//
//
//package ch.makery.address.view
//import javafx.scene.Scene
//import javafx.scene.control.{Button, TextField}
//import javafx.fxml.FXML
//import javafx.scene.layout.AnchorPane
//import javafx.fxml.FXMLLoader
//import ch.makery.address.MainApp
//
//class StartController {
//
//  @FXML
//  var continueBtn: Button = _
//
//  @FXML
//  var petName: TextField = _
//
//  // Handle continue button click
//  @FXML
//  def onContinue(): Unit = {
//    // Get pet name or default to "Mochi" if not provided
//    val name = Option(petName.getText).filter(_.nonEmpty).getOrElse("Mochi")
//
//    // Load the pet scene from the FXML file
//    val loader = new FXMLLoader()
//    loader.setLocation(getClass.getResource("/ch/makery/address/view/PetScene2.fxml"))
//    val petScene: AnchorPane = loader.load().asInstanceOf[AnchorPane]
//
//    // Get the controller and set the pet name
//    val controller = loader.getController.asInstanceOf[PetScene2Controller]
//    controller.setPetName(name)
//
//
//
//    // Show the pet scene in the main stage
//    MainApp.stage.setScene(new Scene(petScene))
//  }
//}

package ch.makery.address.view

import javafx.scene.Scene
import javafx.scene.control.{Button, TextField}
import javafx.fxml.FXML
import javafx.scene.layout.AnchorPane
import javafx.fxml.FXMLLoader
import ch.makery.address.MainApp


class StartController {

  @FXML
  var continueBtn: Button = _

  @FXML
  var petName: TextField = _



  // Handle continue button click
  @FXML
  def onContinue(): Unit = {
    // Play the background music

    // Get pet name or default to "Mochi" if not provided
    val name = Option(petName.getText).filter(_.nonEmpty).getOrElse("Mochi")

    // Load the pet scene from the FXML file
    val loader = new FXMLLoader()
    loader.setLocation(getClass.getResource("/ch/makery/address/view/PetScene2.fxml"))
    val petScene: AnchorPane = loader.load().asInstanceOf[AnchorPane]

    // Get the controller and set the pet name
    val controller = loader.getController.asInstanceOf[PetScene2Controller]
    controller.setPetName(name)

    // Show the pet scene in the main stage
    MainApp.stage.setScene(new Scene(petScene))
  }
}
