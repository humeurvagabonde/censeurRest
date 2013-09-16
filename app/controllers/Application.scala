package controllers

import models._
import models.current.dao._
import models.current.dao.profile.simple._
import play.api._
import play.api.Play.current
import play.api.data.Forms._
import play.api.db.slick._
import play.api.mvc._

object Application extends Controller {
    
  def fiche = DBAction { implicit sessionRequest =>
    //Individus.getTousLesTelephones foreach (println _)
    //Individus.displayPrs250992
    println(individusByName("64616").list)
    Ok
  }
  
  def fiches = DBAction { implicit sessionRequest =>
    Individus.displayAll
    Ok("fiches")
  }
}