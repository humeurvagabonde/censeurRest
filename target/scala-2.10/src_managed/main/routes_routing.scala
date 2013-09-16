// @SOURCE:/home/kahlua/dev/gitPoc/censeurRest/conf/routes
// @HASH:de2fd5a41d9181b2b402b267793b020de8139031
// @DATE:Sat Sep 14 11:47:07 CEST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_fiche0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("fiche"))))
        

// @LINE:7
private[this] lazy val controllers_Application_fiches1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("fiches"))))
        

// @LINE:10
private[this] lazy val controllers_Assets_at2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """fiche""","""controllers.Application.fiche"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """fiches""","""controllers.Application.fiches"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_fiche0(params) => {
   call { 
        invokeHandler(controllers.Application.fiche, HandlerDef(this, "controllers.Application", "fiche", Nil,"GET", """ Home page""", Routes.prefix + """fiche"""))
   }
}
        

// @LINE:7
case controllers_Application_fiches1(params) => {
   call { 
        invokeHandler(controllers.Application.fiches, HandlerDef(this, "controllers.Application", "fiches", Nil,"GET", """""", Routes.prefix + """fiches"""))
   }
}
        

// @LINE:10
case controllers_Assets_at2(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     