// @SOURCE:/home/kahlua/dev/gitPoc/censeurRest/conf/routes
// @HASH:de2fd5a41d9181b2b402b267793b020de8139031
// @DATE:Sat Sep 14 11:47:07 CEST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:10
// @LINE:7
// @LINE:6
package controllers {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def fiche(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "fiche")
}
                                                

// @LINE:7
def fiches(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "fiches")
}
                                                
    
}
                          
}
                  


// @LINE:10
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def fiche : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.fiche",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "fiche"})
      }
   """
)
                        

// @LINE:7
def fiches : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.fiches",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "fiches"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:10
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def fiche(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.fiche(), HandlerDef(this, "controllers.Application", "fiche", Seq(), "GET", """ Home page""", _prefix + """fiche""")
)
                      

// @LINE:7
def fiches(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.fiches(), HandlerDef(this, "controllers.Application", "fiches", Seq(), "GET", """""", _prefix + """fiches""")
)
                      
    
}
                          
}
        
    