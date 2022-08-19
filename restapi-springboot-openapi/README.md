# restapi-springboot-openapi
in this project you will learn about basic rest-api documentation using spring open api swagger 3

#

#### setup springboot app
- Generate, download, setup your springboot app from website spring.io

#### create your rest api
- controller, service, repo, model, db connection, etc

#### implementation swagger 3 open api
- setup dependency open api on pom
#
	   <dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.10</version>
		</dependency>
#

- open your controller and then add component @Operation for describe the api
- open your controller and then add component @ApiResponses for response format the api
#
    @Operation(summary = "This is for get all data Customer into database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get all data Customer  is success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not available", content = @Content)
    })
#

- run app and test swagger-ui on url
http://localhost:8080/swagger-ui/index.html

#### swagger open api config
- you can configure swagger or open api via file .propertis or .yml



