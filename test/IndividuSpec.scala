import models.current.dao._
import java.sql.Timestamp
import scala.slick.driver.H2Driver.simple._
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import java.util.Date
import java.util.Calendar
import Database.threadLocalSession
import play.api.test._
import play.api.test.Helpers._
import models.Individu

class IndividuSpec extends FlatSpec with ShouldMatchers {

  "Un individu" should "etre persistable" in {
    Database.forURL(url = "jdbc:h2:mem:test", driver = "org.h2.Driver") withSession {

    	Individus.ddl.create
    	val fla = Individu(
    	    cCivilite = "M", 
    	    dNaissance = Some(new Timestamp(dateNaissance(24, 5, 1980).getTime())), 
    	    nomAffichage = "LAGOUEYTE", 
    	    nomPatronymique = "Lagoueyte", 
    	    prenom = "François")
    	Individus.insert(fla)
    	val ind = for(ind <- Individus) yield ind
    	ind.first.id.get     should  equal(1)
    }
  }
  
  def dateNaissance(jour: Int, mois: Int, annee: Int) : Date = {
	  val cal = Calendar.getInstance()
	  cal.set(annee, mois, jour)
	  cal.set(Calendar.HOUR_OF_DAY, 0)
      cal.set(Calendar.MINUTE, 0)
      cal.set(Calendar.SECOND, 0)
      cal.set(Calendar.MILLISECOND, 0)
      
      cal.getTime()
  }
  
}