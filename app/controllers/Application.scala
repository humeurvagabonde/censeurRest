package controllers

import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import play.api.libs.json.JsObject
import play.api.libs.json.JsArray
import play.api.libs.json.JsString
import play.api.libs.json.JsNumber
import play.api.libs.json.JsNull

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def test = Action {
    Ok(JsArray(
		    JsObject(
		      "name" -> JsString("Bob") ::
		      "age" -> JsNumber(31) ::
		      "email" -> JsString("bob@gmail.com") ::
		      Nil) ::
		    JsObject(
		      "name" -> JsString("Kiki") ::
		      "age" -> JsNumber(25) ::
		      "email" -> JsNull ::
		      Nil
		    ) :: Nil
		))
  }
  
  def fiche = TODO
  def fiches = TODO
  
  //def testAuth = Security.Authenticated(action) 
}