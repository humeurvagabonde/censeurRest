package models

import models.current.dao._
import play.api.db.slick.Profile
import java.sql.Timestamp

case class PersonneTelephone(
  persId: Int,
  numero: String,
  typeNumero: String,
  typeTelephone: String,
  dateDebutValidite: Option[Timestamp] = None,
  dateFinValidite: Option[Timestamp] = None,
  dateCreation: Timestamp,
  dateModification: Timestamp,
  indicatif: Option[Int] = None,
  codeStructure: Option[String] = None,
  listeRouge: String,
  telPrincipal: Option[String] = None
)

trait PersonneTelephoneComponent { this: Profile =>
  
  	import profile.simple._
	object PersonneTelephones extends Table[PersonneTelephone]("PERSONNE_TELEPHONE") {
	  
	  def persId = column[Int]("PERS_ID")
	  def numero = column[String]("NO_TELEPHONE")
	  def typeNumero = column[String]("TYPE_NO")
	  def typeTelephone = column[String]("TYPE_TEL")
	  def dateDebutValidite = column[Timestamp]("D_DEB_VAL", O.Nullable)
	  def dateFinValidite = column[Timestamp]("D_FIN_VAL", O.Nullable)
	  def dateCreation = column[Timestamp]("D_CREATION")
	  def dateModification = column[Timestamp]("D_MODIFICATION")
	  def indicatif = column[Int]("INDICATIF", O.Nullable)
	  def codeStructure = column[String]("C_STRUCTURE", O.Nullable)
	  def listeRouge = column[String]("LISTE_ROUGE")
	  def telPrincipal = column[String]("TEL_PRINCIPAL", O.Nullable)
	  
	  def pk = primaryKey("PK_TELEPHONE", (persId, numero, typeNumero, typeTelephone))
	  def personne = foreignKey("PERSONNE_TELEPHONE_REF_PERS", persId, Individus)(_.id)
	  
	  def * = (persId ~ numero ~ typeNumero ~ typeTelephone ~ dateDebutValidite.? ~ dateFinValidite.?
		  ~ dateCreation ~ dateModification ~ indicatif.? ~ codeStructure.? 
		  ~ listeRouge ~ telPrincipal.?) <> (PersonneTelephone, PersonneTelephone.unapply _)
	}
}
