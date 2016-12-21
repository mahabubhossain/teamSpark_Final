Presentation layer of Lesson 11 MemberSpringMVC
Rest services are remotely accessed for Service & Persistence Layer  

ProductServiceImpl now has 2 different options for accessing  Product through REST services...

@Qualifier("MVC")
@Qualifier("Jersey")
	private ProductRestService productRestService;

They correspond to the relevant REST service server [ see edu.mum.rest.service.impl]

Jersey == starting MongoJerry as Spring Boot App
MVC == starting MemberRest

