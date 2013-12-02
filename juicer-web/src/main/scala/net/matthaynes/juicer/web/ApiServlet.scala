package net.matthaynes.juicer.web

import net.matthaynes.juicer.service._

class ApiServlet extends JsonServlet {

  val service = new ArticleExtractorService

  get("/ping")        { Map("message"  -> "pong") }

  get("/article")     { Map("article"  -> service.extract(params("url"))) }

  get("/articles")     { 
  	val response = List()
  	params("urls").foreach(
		url => response() = service.extract(url)
	)

  	Map("articles"  -> response) 
  }

  post("/entities")   { Map("entities" -> service.entities.classify(params("text"))) }

}
