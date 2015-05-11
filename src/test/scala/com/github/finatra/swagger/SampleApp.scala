package com.github.finatra.swagger

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

object SampleAppMain extends SampleApp {
  FinatraSwagger.registerInfo(
    description = "The Student / Course management API, this is a sample for swagger document generation",
    version = "1.0.1",
    title = "Student / Course Management API")
}


class SampleApp extends HttpServer {
  override def configureHttp(router: HttpRouter) {
    router
      .add[SwaggerController]
      .add[SampleController]
  }
}