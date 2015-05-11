package com.github.finatra.swagger

import com.twitter.finatra.http.Controller
import com.twitter.finagle.http.Request

class SwaggerController(docPath: String = "/api-docs") extends Controller {
  get(docPath) { request: Request =>
    val swagger = FinatraSwagger.swagger

    response.ok.json(swagger).toFuture
  }

  get(docPath + "/ui/:*") { request: Request =>
    val res = request.params.get("*")

    response.ok.file("swagger-ui/%s".format(res))
  }
}
