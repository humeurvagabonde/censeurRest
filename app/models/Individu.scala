package models

import play.api.db.slick.Profile
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.sql.Timestamp
import java.util.Date
import java.util.Calendar

case class Individu(
    id: Option[Int] = None, 
    cCivilite: String, 
    cDeptNaissance: Option[String] = None, 
    cPaysNaissance: Option[String] = None, 
    cPaysNationalite: Option[String] = None, 
    dCreation: Timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis()), 
    dModification: Option[Timestamp] = None, 
    dNaissance: Option[Timestamp] = None, 
    dDeces: Option[Timestamp] = None, 
    indCSituationFamille: Option[String] = None,  
    indCleInsee: Option[Int] = None, 
    indNoInsee: Option[String] = None, 
    noIndividu: Option[Int] = None, 
    nomAffichage: String, 
    nomPatronymique: String,
    nomUsuel: String, 
    prenom: String
)


trait IndividuComponent { this: Profile with PersonneTelephoneComponent =>
  
  	import profile.simple._
  	
	object Individus extends Table[Individu]("INDIVIDU_ULR") {
	
	  def id = column[Int]("PERS_ID", O.PrimaryKey, O.AutoInc)
	  def cCivilite = column[String]("C_CIVILITE")
	  def cDeptNaissance = column[Option[String]]("C_DEPT_NAISSANCE")
	  def cPaysNaissance = column[Option[String]]("C_PAYS_NAISSANCE")
	  def cPaysNationalite = column[Option[String]]("C_PAYS_NATIONALITE")
	  def dCreation = column[Timestamp]("D_CREATION")
	  def dModification = column[Option[Timestamp]]("D_MODIFICATION")
	  def dNaissance = column[Option[Timestamp]]("D_NAISSANCE")
	  def dDeces = column[Option[Timestamp]]("D_DECES")
	  def indCSituationFamille = column[Option[String]]("IND_C_SITUATION_FAMILLE")
	  def indCleInsee = column[Option[Int]]("IND_CLE_INSEE")
	  def indNoInsee = column[Option[String]]("IND_NO_INSEE")
	  def noIndividu = column[Option[Int]]("NO_INDIVIDU")
	  def nomAffichage = column[String]("NOM_AFFICHAGE")
	  def nomPatronymique = column[String]("NOM_PATRONYMIQUE")
	  def nomUsuel = column[String]("NOM_USUEL")
	  def prenom = column[String]("PRENOM")
	  
	  def * = (id.? ~ cCivilite ~ cDeptNaissance ~ cPaysNaissance ~ cPaysNationalite ~ dCreation
	      ~ dModification ~ dNaissance ~ dDeces ~ indCSituationFamille ~ indCleInsee ~ indNoInsee 
	      ~ noIndividu ~ nomAffichage ~ nomPatronymique ~ nomUsuel ~ prenom) <> (Individu, Individu.unapply _)
	  
      def findByName(name: String)(implicit session: Session) = {
	        val findBy = Query(Individus)
	        val query = findBy.filter(_.nomUsuel like name)
	        query.list
      }
	      
      val byId = createFinderBy(_.id)
	      
	  /** METHODES DE TESTS */
//	  def displayAll(implicit session: Session) = {
//		  Query(Individus) foreach { case (id) =>
//		    println(id)
//		  }
//	  }
//	         
//	  def displayPrs250992(implicit session: Session) = {	
//		val telephones = for {
//			  individu <- Individus if individu.id === 933
//			  tel <- PersonneTelephones if individu.id === tel.persId
//		} yield (individu.nomAffichage, tel.numero)
//		println(telephones.selectStatement)
//		
//		println(telephones.list.mkString(", "))
//	  }
//	  
//	  def getTousLesTelephones(implicit session: Session): List[PersonneTelephone] = (for {
//		  ind <- Individus
//		  tel <- PersonneTelephones if ind.id === tel.persId
//	  } yield ( tel )).list
//	  
//	  def individusByName = for {
//		  name <- Parameters[String]
//		  ind <- Individus if ind.nomPatronymique like name
//	  } yield ind    
  	}
}
