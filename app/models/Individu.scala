package models

import play.api.db.slick.Profile
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
    prenom: String
)

trait IndividuComponent { this: Profile with PersonneTelephoneComponent =>
  
  	import profile.simple._
	object Individus extends Table[Individu]("INDIVIDU_ULR") {
	
	  def id = column[Int]("PERS_ID", O.PrimaryKey, O.AutoInc)
	  def cCivilite = column[String]("C_CIVILITE")
	  def cDeptNaissance = column[String]("C_DEPT_NAISSANCE", O.Nullable)
	  def cPaysNaissance = column[String]("C_PAYS_NAISSANCE", O.Nullable)
	  def cPaysNationalite = column[String]("C_PAYS_NATIONALITE", O.Nullable)
	  def dCreation = column[Timestamp]("D_CREATION")
	  def dModification = column[Timestamp]("D_MODIFICATION", O.Nullable)
	  def dNaissance = column[Timestamp]("D_NAISSANCE", O.Nullable)
	  def dDeces = column[Timestamp]("D_DECES", O.Nullable)
	  def indCSituationFamille = column[String]("IND_C_SITUATION_FAMILLE", O.Nullable)
	  def indCleInsee = column[Int]("IND_CLE_INSEE", O.Nullable)
	  def indNoInsee = column[String]("IND_NO_INSEE", O.Nullable)
	  def noIndividu = column[Int]("NO_INDIVIDU", O.Nullable)
	  def nomAffichage = column[String]("NOM_AFFICHAGE")
	  def nomPatronymique = column[String]("NOM_PATRONYMIQUE")
	  def prenom = column[String]("PRENOM")
	  
	  def * = (id.? ~ cCivilite ~ cDeptNaissance.? ~ cPaysNaissance.? ~ cPaysNationalite.? ~ dCreation
	      ~ dModification.? ~ dNaissance.? ~ dDeces.? ~ indCSituationFamille.? ~ indCleInsee.? ~ indNoInsee.? 
	      ~ noIndividu.? ~ nomAffichage ~ nomPatronymique ~ prenom) <> (Individu, Individu.unapply _)
	  	      
	  def displayAll(implicit session: Session) = {
		  Query(Individus) foreach { case (id) =>
		    println(id)
		  }
	  }
	         
	  def displayPrs250992(implicit session: Session) = {	
		val telephones = for {
			  individu <- Individus if individu.id === 933
			  tel <- PersonneTelephones if individu.id === tel.persId
		} yield (individu.nomAffichage, tel.numero)
		println(telephones.selectStatement)
		
		println(telephones.list.mkString(", "))
	  }
	  
	  def getTousLesTelephones(implicit session: Session): List[PersonneTelephone] = (for {
		  ind <- Individus
		  tel <- PersonneTelephones if ind.id === tel.persId
	  } yield ( tel )).list //or list ... 
  	}
}
