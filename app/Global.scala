import play.api.GlobalSettings
import play.api.Application
import scala.slick.driver.H2Driver.simple._
import Database.threadLocalSession
import play.api.db.DB
import play.api.Play.current
import models.Individus
import play.api.mvc.EssentialAction
import java.sql.Timestamp
import java.util.Calendar


object Global extends GlobalSettings {

  override def onStart(app: Application) {
	  lazy val database = Database.forDataSource(DB.getDataSource("default"))
	  database .withSession {
		  Individus.ddl.create
		  
		  // insert individu
		  val now = new Timestamp(Calendar.getInstance().getTimeInMillis())
		  //Individus.insert(1, "M", "92", "FRANCE", now, None, now, None, 
		  //    , new Timestamp(Calendar.getInstance().getTimeInMillis()))
		      
		  
	  }
  }
  
  override def doFilter(action: EssentialAction) = EssentialAction { request =>
    action.apply(request).map(_.withHeaders(
      "Access-Control-Allow-Origin" -> "http://localhost:9000",
      "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers" -> "Content-Type, X-Requested-With, Accept",
      // cache access control response for one day
      "Access-Control-Max-Age" -> (60 * 60 * 24).toString
    ))
  }
  
}