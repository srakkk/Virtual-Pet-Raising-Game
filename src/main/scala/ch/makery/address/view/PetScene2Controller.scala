
//package ch.makery.address.view
//
//import javafx.fxml.FXML
//import javafx.scene.control.{Button, Label, ProgressBar}
//import javafx.scene.image.{Image, ImageView}
//import scalafx.animation.{KeyFrame, Timeline}
//import scalafx.util.Duration
//import org.slf4j.LoggerFactory
//
//class PetScene2Controller {
//
//  @FXML
//  var playButton: Button = _
//  @FXML
//  var medicineButton: Button = _
//  @FXML
//  var feedButton: Button = _
//  @FXML
//  var sleepButton: Button = _
//  @FXML
//  var myStatus: Label = _
//  @FXML
//  var myHealth: Label = _
//  @FXML
//  var myFood: Label = _
//  @FXML
//  var myFun: Label = _
//  @FXML
//  var petImage: ImageView = _
//  @FXML
//  var foodBar: ProgressBar = _
//  @FXML
//  var funBar: ProgressBar = _
//  @FXML
//  var healthBar: ProgressBar = _
//  @FXML
//  var energyBar: ProgressBar = _
//  @FXML
//  var petTalk: Label = _
//  @FXML
//  var myBackgroundImage: ImageView = _
//  @FXML
//  var myPoints: Label = _
//
//
//
//
//  private val logger = LoggerFactory.getLogger(getClass)
//
//  // Initial values
//  private var points: Int = 0
//  private var health: Double = 1.0
//  private var food: Double = 1.0
//  private var fun: Double = 1.0
//  private var energy: Double = 1.0
//  private var isAsleep: Boolean = false
//
//  // Create a Timeline that updates every second
//  val gameLoop: Timeline = new Timeline {
//    cycleCount = Timeline.Indefinite
//    keyFrames = Seq(
//      KeyFrame(Duration(1000), onFinished = _ => updateState())
//    )
//  }
//  gameLoop.play()
//
//  def onPlayWithPet(): Unit = {
//    if (isAsleep) return
//    logger.info("Play with Pet button clicked.")
//    fun += 0.1
//    if (fun > 1) fun = 1
//    petTalk.setText("Yay, playing is fun!")
//  }
//
//  def onGiveMedicine(): Unit = {
//    if (isAsleep) return
//    logger.info("Give Medicine button clicked.")
//    health += 0.1
//    if (health > 1) health = 1
//    petTalk.setText("Thank you for the medicine!")
//  }
//
//  def onFeedPet(): Unit = {
//    if (isAsleep) return
//    logger.info("Feed Pet button clicked.")
//    food += 0.1
//    if (food > 1) food = 1
//    petTalk.setText("Yummy, that's delicious!")
//  }
//
//  def onSleep(): Unit = {
//    isAsleep = !isAsleep
//    val imageUrl = getClass.getResource(if (isAsleep) "nightRoom.jpg" else "roomImage.jpg")
//    if (imageUrl != null) {
//      myBackgroundImage.setImage(new Image(imageUrl.toString))
//    } else {
//      logger.error("Image not found")
//    }
//
//    petTalk.setText(if (isAsleep) "Zzz..." else "I'm awake now!")
//    sleepButton.setText(if (isAsleep) "Wake Up" else "Sleep") // Update button text
//  }
//
//
//  private def updateState(): Unit = {
//    // Decrease health, food, fun, and energy over time
//    health -= 0.01
//    food -= 0.02
//    fun -= 0.015
//    if (!isAsleep) energy -= 0.03 else energy += 0.045
//
//    // Cap the values between 0 and 1
//    if (health < 0) health = 0
//    if (food < 0) food = 0
//    if (fun < 0) fun = 0
//    if (energy < 0) energy = 0
//    if (energy > 1) energy = 1
//
//    // Update the UI elements
//    foodBar.setProgress(food)
//    funBar.setProgress(fun)
//    healthBar.setProgress(health)
//    energyBar.setProgress(energy)
//
//    // Automatic sleep mode when energy reaches 0
//    if (energy <= 0 && !isAsleep) onSleep()
//
//    // Update pet talk based on the current status
//    if (food < 0.3) petTalk.setText("I'm hungry!")
//    if (fun < 0.3) petTalk.setText("I'm bored!")
//    if (health < 0.3) petTalk.setText("I'm feeling sick!")
//    if (energy < 0.3 && !isAsleep) petTalk.setText("I'm sleepy!")
//
//    // Calculate average of all stats
//    val average = (health + food + fun + energy) / 4
//
//    // Update points based on the average
//    if (average > 0.63) {
//      points += 10
//    } else {
//      points -= 8
//    }
//
//    // Ensure points do not go negative
//    if (points < 0) points = 0
//
//    // Update the points label
//    myPoints.setText(s"Points: $points")
//
//  }
//}

//Final working code without home button
//package ch.makery.address.view
//
//import javafx.fxml.FXML
//import javafx.scene.control.{Button, Label, ProgressBar}
//import javafx.scene.image.{Image, ImageView}
//import scalafx.animation.{KeyFrame, Timeline}
//import scalafx.util.Duration
//import org.slf4j.LoggerFactory
//import javafx.scene.media.{MediaPlayer, Media}
//
//import java.nio.file.Paths
//
//class PetScene2Controller {
//
//  @FXML
//  var playButton: Button = _
//  @FXML
//  var medicineButton: Button = _
//  @FXML
//  var feedButton: Button = _
//  @FXML
//  var sleepButton: Button = _
//  @FXML
//  var myStatus: Label = _
//  @FXML
//  var myHealth: Label = _
//  @FXML
//  var myFood: Label = _
//  @FXML
//  var myFun: Label = _
//  @FXML
//  var petImage: ImageView = _
//  @FXML
//  var foodBar: ProgressBar = _
//  @FXML
//  var funBar: ProgressBar = _
//  @FXML
//  var healthBar: ProgressBar = _
//  @FXML
//  var energyBar: ProgressBar = _
//  @FXML
//  var petTalk: Label = _
//  @FXML
//  var myBackgroundImage: ImageView = _
//  @FXML
//  var myPoints: Label = _
//  @FXML
//  var petNameLabel: Label = _
//
//  private val logger = LoggerFactory.getLogger(getClass)
//
//  // Initial values
//  private var points: Int = 0
//  private var health: Double = 1.0
//  private var food: Double = 1.0
//  private var fun: Double = 1.0
//  private var energy: Double = 1.0
//  private var isAsleep: Boolean = false
//
//  // Define paths to the images
//  private val basicImage = "pet1.png"
//  private val sickImage = "sickImg.png"
//  private val hungryImage = "hungryImg.png"
//  private val boredImage = "boredImg.png"
//  private val eatImage = "eatImg.png"
//  private val playImage = "playImg.png"
//  private val healthyImage = "healthyImg.png"
//  private val sleepImage = "sleepImg.png"
//
//
//  val gameLoop: Timeline = new Timeline {
//    cycleCount = Timeline.Indefinite
//    keyFrames = Seq(
//      KeyFrame(Duration(1000), onFinished = _ => updateState())
//    )
//  }
//  gameLoop.play()
//
//  def onPlayWithPet(): Unit = {
//    if (isAsleep) return
//    logger.info("Play with Pet button clicked.")
//    fun += 0.1
//    if (fun > 1) fun = 1
//    petTalk.setText("Yay, playing is fun!")
//    updatePetImage(playImage)
//  }
//
//def setPetName(name: String): Unit = {
//
//  petTalk.setText(s"Hi there, I'm $name!")
//  petNameLabel.setText(name + "'s")
//}
//
//  def onGiveMedicine(): Unit = {
//    if (isAsleep) return
//    logger.info("Give Medicine button clicked.")
//    health += 0.1
//    if (health > 1) health = 1
//    petTalk.setText("Thank you for the medicine!")
//    updatePetImage(healthyImage)
//  }
//
//  def onFeedPet(): Unit = {
//    if (isAsleep) return
//    logger.info("Feed Pet button clicked.")
//    food += 0.1
//    if (food > 1) food = 1
//    petTalk.setText("Yummy, that's delicious!")
//    updatePetImage(eatImage)
//  }
//
//  def onSleep(): Unit = {
//    isAsleep = !isAsleep
//    val imageUrl = getClass.getResource(if (isAsleep) "nightRoom.jpg" else "roomImage.jpg")
//    if (imageUrl != null) {
//      myBackgroundImage.setImage(new Image(imageUrl.toString))
//    } else {
//      logger.error("Image not found")
//    }
//
//    petTalk.setText(if (isAsleep) "Zzz..." else "I'm awake now!")
//    sleepButton.setText(if (isAsleep) "Wake Up" else "Sleep") // Update button text
//    updatePetImage(if (isAsleep) sleepImage else getLowestStatImage())
//  }
//3
//  private def updateState(): Unit = {
//    // Decrease the health, food, fun, and energy over time
//    health -= 0.01
//    food -= 0.02
//    fun -= 0.015
//    if (!isAsleep) energy -= 0.015 else energy += 0.06
//
//    // Cap the values between 0 and 1
//    if (health < 0) health = 0
//    if (food < 0) food = 0
//    if (fun < 0) fun = 0
//    if (energy < 0) energy = 0
//    if (energy > 1) energy = 1
//
//    // Update the UI elements
//    foodBar.setProgress(food)
//    funBar.setProgress(fun)
//    healthBar.setProgress(health)
//    energyBar.setProgress(energy)
//
//    // Automatic sleep mode when energy reaches 0
//    if (energy <= 0 && !isAsleep) onSleep()
//
//    // Update pet talk based on the current status
//    if (!isAsleep) {
//      if (health < 0.3) updatePetImage(sickImage)
//      if (food < 0.3) updatePetImage(hungryImage)
//      if (fun < 0.3) updatePetImage(boredImage)
//      if ((health + food + fun + energy) / 4 > 0.63) updatePetImage(basicImage)
//    }
//
//    // Calculate average of all stats
//    val average = (health + food + fun + energy) / 4
//
//    // Update points based on the average
//    if (average > 0.63) {
//      points += 10
//    } else {
//      points -= 8
//    }
//
//    // Ensure points do not go negative
//    if (points < 0) points = 0
//
//    // Update the points label
//    myPoints.setText(s"Points: $points")
//  }
//
//  private def updatePetImage(imageName: String): Unit = {
//    val imageUrl = getClass.getResource(imageName)
//    if (imageUrl != null) {
//      petImage.setImage(new Image(imageUrl.toString))
//    } else {
//      logger.error(s"Image not found: $imageName")
//    }
//  }
//
//  private def getLowestStatImage(): String = {
//    if (health <= food && health <= fun) sickImage
//    else if (food <= health && food <= fun) hungryImage
//    else boredImage
//  }
//
//  val musicFile = "src/main/resources/ch/makery/address/view/myMusic.mp3"
//  val mediaPath = Paths.get(musicFile).toUri.toString
//  val mediaObj = new Media(mediaPath)
//  val mediaPlayer = new MediaPlayer(mediaObj)
//  mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) // Loop the music
//  mediaPlayer.play()
//}
//


//adding home button
package ch.makery.address.view
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage
import javafx.event.ActionEvent

import javafx.fxml.FXML
import javafx.scene.control.{Button, Label, ProgressBar}
import javafx.scene.image.{Image, ImageView}
import scalafx.animation.{KeyFrame, Timeline}
import scalafx.util.Duration
import org.slf4j.LoggerFactory
import javafx.scene.media.{MediaPlayer, Media}

import java.nio.file.Paths

class PetScene2Controller {

  @FXML
  var playButton: Button = _
  @FXML
  var medicineButton: Button = _
  @FXML
  var feedButton: Button = _
  @FXML
  var sleepButton: Button = _
  @FXML
  var myStatus: Label = _
  @FXML
  var myHealth: Label = _
  @FXML
  var myFood: Label = _
  @FXML
  var myFun: Label = _
  @FXML
  var petImage: ImageView = _
  @FXML
  var foodBar: ProgressBar = _
  @FXML
  var funBar: ProgressBar = _
  @FXML
  var healthBar: ProgressBar = _
  @FXML
  var energyBar: ProgressBar = _
  @FXML
  var petTalk: Label = _
  @FXML
  var myBackgroundImage: ImageView = _
  @FXML
  var myPoints: Label = _
  @FXML
  var petNameLabel: Label = _
  @FXML
  var homeButton: Button = _

  private val logger = LoggerFactory.getLogger(getClass)

  // Initial values
  private var points: Int = 0
  private var health: Double = 1.0
  private var food: Double = 1.0
  private var fun: Double = 1.0
  private var energy: Double = 1.0
  private var isAsleep: Boolean = false

  // Define paths to the images
  private val basicImage = "pet1.png"
  private val sickImage = "sickImg.png"
  private val hungryImage = "hungryImg.png"
  private val boredImage = "boredImg.png"
  private val eatImage = "eatImg.png"
  private val playImage = "playImg.png"
  private val healthyImage = "healthyImg.png"
  private val sleepImage = "sleepImg.png"


  val gameLoop: Timeline = new Timeline {
    cycleCount = Timeline.Indefinite
    keyFrames = Seq(
      KeyFrame(Duration(1000), onFinished = _ => updateState())
    )
  }
  gameLoop.play()

//  def onHome(event: ActionEvent): Unit = {
//    val node = event.getSource.asInstanceOf[javafx.scene.Node]
//    val stage = node.getScene.getWindow.asInstanceOf[Stage]
//    val parent: Parent = FXMLLoader.load(getClass.getResource("/ch/makery/address/view/Start.fxml"))
//    val scene = new Scene(parent)
//    stage.setScene(scene)
//    stage.show()
//  }

  // This method will be called when PetScene2.fxml is loaded
  def initialize(): Unit = {
    mediaPlayer.play() // Start the music
  }
  def onHome(event: ActionEvent): Unit = {
    mediaPlayer.stop() // Stop the music
    val node = event.getSource.asInstanceOf[javafx.scene.Node]
    val stage = node.getScene.getWindow.asInstanceOf[Stage]
    val parent: Parent = FXMLLoader.load(getClass.getResource("/ch/makery/address/view/Start.fxml"))
    val scene = new Scene(parent)
    stage.setScene(scene)
    stage.show()
  }


  def onPlayWithPet(): Unit = {
    if (isAsleep) return
    logger.info("Play with Pet button clicked.")
    fun += 0.1
    if (fun > 1) fun = 1
    petTalk.setText("Yay, playing is fun!")
    updatePetImage(playImage)
  }

  def setPetName(name: String): Unit = {

    petTalk.setText(s"Hi there, I'm $name!")
    petNameLabel.setText(name + "'s")
  }

  def onGiveMedicine(): Unit = {
    if (isAsleep) return
    logger.info("Give Medicine button clicked.")
    health += 0.1
    if (health > 1) health = 1
    petTalk.setText("Thank you for the medicine!")
    updatePetImage(healthyImage)
  }

  def onFeedPet(): Unit = {
    if (isAsleep) return
    logger.info("Feed Pet button clicked.")
    food += 0.1
    if (food > 1) food = 1
    petTalk.setText("Yummy, that's delicious!")
    updatePetImage(eatImage)
  }

  def onSleep(): Unit = {
    isAsleep = !isAsleep
    val imageUrl = getClass.getResource(if (isAsleep) "nightRoom.jpg" else "roomImage.jpg")
    if (imageUrl != null) {
      myBackgroundImage.setImage(new Image(imageUrl.toString))
    } else {
      logger.error("Image not found")
    }

    petTalk.setText(if (isAsleep) "Zzz..." else "I'm awake now!")
    sleepButton.setText(if (isAsleep) "Wake Up" else "Sleep") // Update button text
    updatePetImage(if (isAsleep) sleepImage else getLowestStatImage())
  }
  3
  private def updateState(): Unit = {
    // Decrease the health, food, fun, and energy over time
    health -= 0.01
    food -= 0.02
    fun -= 0.015
    if (!isAsleep) energy -= 0.015 else energy += 0.06

    // Cap the values between 0 and 1
    if (health < 0) health = 0
    if (food < 0) food = 0
    if (fun < 0) fun = 0
    if (energy < 0) energy = 0
    if (energy > 1) energy = 1

    // Update the UI elements
    foodBar.setProgress(food)
    funBar.setProgress(fun)
    healthBar.setProgress(health)
    energyBar.setProgress(energy)

    // Automatic sleep mode when energy reaches 0
    if (energy <= 0 && !isAsleep) onSleep()

    // Update pet talk based on the current status
    if (!isAsleep) {
      if (health < 0.3) updatePetImage(sickImage)
      if (food < 0.3) updatePetImage(hungryImage)
      if (fun < 0.3) updatePetImage(boredImage)
      if ((health + food + fun + energy) / 4 > 0.63) updatePetImage(basicImage)
    }

    // Calculate average of all stats
    val average = (health + food + fun + energy) / 4

    // Update points based on the average
    if (average > 0.63) {
      points += 10
    } else {
      points -= 8
    }

    // Ensure points do not go negative
    if (points < 0) points = 0

    // Update the points label
    myPoints.setText(s"Points: $points")
  }

  private def updatePetImage(imageName: String): Unit = {
    val imageUrl = getClass.getResource(imageName)
    if (imageUrl != null) {
      petImage.setImage(new Image(imageUrl.toString))
    } else {
      logger.error(s"Image not found: $imageName")
    }
  }

  private def getLowestStatImage(): String = {
    if (health <= food && health <= fun) sickImage
    else if (food <= health && food <= fun) hungryImage
    else boredImage
  }

  val musicFile = "src/main/resources/ch/makery/address/view/myMusic.mp3"
  val mediaPath = Paths.get(musicFile).toUri.toString
  val mediaObj = new Media(mediaPath)
  val mediaPlayer = new MediaPlayer(mediaObj)
  mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE) // Loop the music
  mediaPlayer.play()
}
