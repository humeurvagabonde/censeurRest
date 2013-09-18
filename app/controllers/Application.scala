package controllers

import models.current.dao._
import models.current.dao.profile.simple._
import play.api._
import play.api.Play.current
import play.api.data.Forms._
import play.api.db.slick._
import play.api.mvc._
import models.Individu

object Application extends Controller {
    
  def fiche(name: String) = DBAction { implicit sessionRequest =>
    val individus = Individus.findByName("%" + name + "%")
    Ok
  }
  
  def fiches = DBAction { implicit sessionRequest =>
    //Individus.displayAll
    Ok("fiches")
  }
  

}