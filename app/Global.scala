import play.api.GlobalSettings
import play.api.Application
import scala.slick.driver.H2Driver.simple._
//import com.typesafe.slick.driver.oracle.OracleDriver.simple._
//import Database.threadLocalSession
import scala.slick.session.Session
import play.api.db.DB
import play.api.Play.current
import models.Individus
import play.api.mvc.EssentialAction
import java.sql.Timestamp
import java.util.Calendar
import scala.collection.mutable.ArrayBuffer
import models.Individu

object Global extends GlobalSettings {

  override def onStart(app: Application) {
	  lazy val database = Database.forDataSource(DB.getDataSource("default"))
	  database.withSession { implicit session: Session =>
	  		
	      // on ajoute le implicit session: Session => si on utilise import scala.slick.session.Session
	  	  // sinon pas besoin et on importe //import Database.threadLocalSession
	  	  // dans ce dernier cas le h2-browser ne fonctionne p.e pas n'etant pas sur le meme process
	    
		  //Individus.ddl.drop
		  Individus.ddl.create
		  
		  val individus = new ArrayBuffer[Individu]
		  
		  // insert individu
		  val now = new Timestamp(Calendar.getInstance().getTimeInMillis())
		  val naissanceFla = Calendar.getInstance()
		  naissanceFla.set(Calendar.DAY_OF_MONTH, 24)
		  naissanceFla.set(Calendar.MONTH, 4)
		  naissanceFla.set(Calendar.YEAR, 1980)
		  val naissanceFlaStamp = new Timestamp(naissanceFla.getTimeInMillis())
		  
		  val fla = Individu(Some(1), "M", Some("92"), Some("FRANCE"), Some("FRANCE"), now, None, naissanceFlaStamp, 
		      None, None, None, None, None, 
		      "Lagoueyte", "Lagoueyte", "Francois")
		  Individus.insert(fla)
		  Individus.displayAll
		  
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