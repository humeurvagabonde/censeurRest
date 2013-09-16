package models

import play.api.Application
import slick.driver.ExtendedProfile
import play.api.db.slick.Profile
import play.api.db.slick.DB
import scala.slick.driver._
import com.typesafe.slick.driver.oracle._
import scala.slick.driver.ExtendedDriver

class DAO(override val profile: ExtendedProfile) extends IndividuComponent with PersonneTelephoneComponent with Profile

object DAO {
  private def driverByName: String => Option[ExtendedDriver] = Map(
    "oracle.jdbc.driver.OracleDriver" -> OracleDriver,
    "org.apache.derby.jdbc.EmbeddedDriver" -> DerbyDriver, "org.h2.Driver" -> H2Driver, "org.hsqldb.jdbcDriver" -> HsqldbDriver, "com.mysql.jdbc.Driver" -> MySQLDriver, "org.postgresql.Driver" -> PostgresDriver, "org.sqlite.JDBC" -> SQLiteDriver, "com.microsoft.sqlserver.jdbc.SQLServerDriver" -> SQLServerDriver, "net.sourceforge.jtds.jdbc.Driver" -> SQLServerDriver).get(_)
    
  def driver(name: String = "default")(implicit app: Application) = {
	    val key = s"db.$name.driver"
	    val conf = app.configuration
	    import conf._
	    getString(key).map { driverName =>
	      driverByName(driverName).getOrElse {
	        throw reportError(
	          key, s"Slick error : Unknown jdbc driver found in application.conf: [$driverName]")
	      }
	    }.getOrElse {
	      throw reportError(
	        key, s"Slick error : jdbc driver not defined in application.conf for db.$name.driver key")
	    }
    }
}

object current {
  //val db = DB("censOracle")(play.api.Play.current)
  //val dao = new DAO(db.driver)
  val dao = new DAO(DAO.driver("default")(play.api.Play.current))
}