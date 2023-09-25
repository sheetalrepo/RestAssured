Rest Assured framework to test rest web services
Note: RA project is for practice RA with small small modules, used for presentation also in xke or youtube tutorial

#Introduction
https://github.com/rest-assured/rest-assured/wiki/GettingStarted
https://groups.google.com/forum/#!forum/rest-assured



#Demo webservices:
1. http://www.groupkt.com/post/f2129b88/free-restful-web-services-to-consume-and-test.htm  | JSON response
	1.1 http://www.groupkt.com/post/c9b0ccb9/country-and-other-related-rest-webservices.htm
		http://services.groupkt.com/country/get/all
		http://services.groupkt.com/country/get/iso2code/cn
		http://services.groupkt.com/country/get/iso3code/ita
		http://services.groupkt.com/country/search?text=states
		http://geo.groupkt.com/ip/172.217.4.14/json
	
	https://api.apis.guru/v2/list.json
	
2. http://jsonplaceholder.typicode.com/  | JSON response
	http://jsonplaceholder.typicode.com/comments
	http://jsonplaceholder.typicode.com/photos
	http://jsonplaceholder.typicode.com/posts/3
	
	http://restcountries.eu/rest/v1/name/norway
	
	
3. https://www.predic8.com/rest-demo.htm	| XML response
	http://thomas-bayer.com/restgate/index.do?URL=http://www.trynt.com/astrology-horoscope-api/v2/?m=2&d=20&s=Zodiac&l=1&fo=xml&f=0&httpMethod=GET   | For GET,POST,PUT request
	http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/
	http://www.thomas-bayer.com/sqlrest/
	http://www.thomas-bayer.com/sqlrest/INVOICE/
	http://httpbin.org/xml
	

4. http://www.groupkt.com/post/5926d648/free-restful-web-service-to-get-location-by-ip-address.htm  	| HTML response
	http://geo.groupkt.com/ip/172.217.3.14.htm

5. File upload test
	http://ps.uci.edu/~franklin/doc/file_upload.html
	https://encodable.com/uploaddemo/
	http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload

#Rest Assured Supported Functionality(Not implemented in examples)
1. Json schema can be validated using matchesJsonSchemaInClasspath


imp:
https://github.com/toddmotto/public-apis
http://httpbin.org/
http://httpbin.org/forms/post    | Form POST
http://stackoverflow.com/questions/4797534/how-do-i-manually-fire-http-post-requests-with-firefox-or-chrome
http://www.webservicex.com/globalweather.asmx?op=GetWeather
http://www.webservicex.com/globalweather.asmx?op=GetCitiesByCountry
https://www.fonts.com/web-fonts/developers/api/generate-token


todo:
http://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/
https://semaphoreci.com/community/tutorials/how-to-split-junit-tests-in-a-continuous-integration-environment


#Working
https://petstore.swagger.io/v2/pet/findByStatus?status=available

************************************
todo:

1. add : api.txt 633 code snippets
2. Auto generate pojos

steps:
1. place schema in some folders
2. pom.xml entry plugin entry
3. Add generated pojo folder as src folder in mvn 

#To generate pojos
mvn clean install -DskipTests=true -Djib.skip=true

generated folder: com.generated.pojos.request
path: \target\generated-sources\jsonschema2pojo\com\generated\pojos\request

<build>
        <plugins>
            <plugin>
                <groupId>org.jsonschema2pojo</groupId>
                <artifactId>jsonschema2pojo-maven-plugin</artifactId>
                <version>1.0.2</version>

                <executions>
                    <execution>
                        <id>sessionreq</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <sourceDirectory>${basedir}/src/test/resources/schema/request</sourceDirectory>
                            <targetPackage>com.generated.pojos.request</targetPackage>
                            <useCommonsLang3>true</useCommonsLang3>
                        </configuration>
                    </execution>

                    <execution>
                        <id>sessionresp</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <sourceDirectory>${basedir}/src/test/resources/schema/response</sourceDirectory>
                            <targetPackage>com.generated.pojos.response</targetPackage>
                            <useCommonsLang3>true</useCommonsLang3>
                        </configuration>
                    </execution>

                </executions>
            </plugin>
        </plugins>
    </build>









