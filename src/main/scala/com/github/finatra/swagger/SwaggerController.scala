package com.github.finatra.swagger

import com.twitter.finatra.http.Controller
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.request.RequestUtils
import com.twitter.finatra.response.Mustache

@Mustache("index")
case class SwaggerView(baseUrl: String, path: String)

class SwaggerController extends Controller {
  get("%s/swagger.json".format(FinatraSwagger.path)) { request: Request =>
    val swagger = FinatraSwagger.swagger

    response.ok.json(swagger).toFuture
  }

  get("%s".format(FinatraSwagger.path)) { request: Request =>
    val view = SwaggerView(
      RequestUtils.pathUrl(request).replaceAll("%s?(.*)".format(FinatraSwagger.path), ""),
      FinatraSwagger.path
    )

    response.ok.view("swagger/index.mustache", view).toFuture
  }

  get("%s/ui/:*".format(FinatraSwagger.path)) { request: Request =>
    val res = request.getParam("*")

    response.ok.file("public/swagger-ui/%s".format(res))
  }
}
