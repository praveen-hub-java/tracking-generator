This Repo contains the code to Generate unique Tracking Number for each request user made


#API Format:
 GET /next-tracking-number
 
	#Query parameters
	
	■ origin_country_id: The order’s origin country code in ISO 3166-1
	alpha-2 format (e.g., "MY").
	■ destination_country_id: The order’s destination country code in
	ISO 3166-1 alpha-2 format (e.g., "ID").
	■ weight: The order’s weight in kilograms, up to three decimal places
	(e.g., "1.234").
	■ created_at: The order’s creation timestamp in RFC 3339 format (e.g.,
	"2018-11-20T19:29:32+08:00").
	■ customer_id: The customer’s UUID (e.g.,
	"de619854-b59b-425e-9db4-943979e1bd49").
	■ customer_name: The customer’s name (e.g., "RedBox Logistics").
	■ customer_slug: The customer’s name in slug-case/kebab-case (e.g.,
		"redbox-logistics").



#Conditions:

The generated tracking number must satisfy the following:
■ It must match the regex pattern: ^[A-Z0-9]{1,16}$.
■ It must be unique; no duplicate tracking numbers should be generated.
■ The generation process should be efficient.
■ The system should be scalable, capable of handling concurrent requests,
and should be able to scale horizontally

In order to build this application in your local you can clone the repo and then run below steps 

mvn clean install -DskipTests

mvn spring-boot:run

#for now there are no test cases added for this. 

And also we have docker compatibiltiy for  this repo, after cloning the code to local you can directly run below docker commands
to load and run the docker container with this service

the service will be up and run on your docker , you can access by docker public ip or localhost 

Eg: 
localhost:8080/next-tracking-number?origin_country_id=IN
&destination_country_id=MY&weight=1.322&customer_id=1001&customer_name=praveen&customer_slug=PraveeN&created_at=2018-11-20T19:29:32+08:00



Sample Response will be  like below.
{
    "trackingnumber": "G0lr53frMPg4rHfs",
    "created_at": "2025-01-04T14:07:55.744+00:00"
}

***** #Improvements: Can be Done *****
For this application below are things that we can add later or provided some time.

1. We can store all these request params to Database, as of now storing only generated numbers with time , but in future we can have user mapping to 
the generated tracking numbers, so that we have a dashboard like how many requests user made, how many shipments are in which stage , that kind of dashboard metrics we can implement.

2. And also we can have MQ mechanism to store these tracking numbers and have another listenr to keep inform user with email or some communication.

3. Authenticaion we can add to this rest api, by having JWT based auth-token mechanism, for now it's not added.(could not find mcuh time, sorry for this).

4. This service is container based one for now, we can have some orchestration tools(like kubectl, openshift, aws ECC) to make it more scalable and optimal.
With some load balancing tools also we can alternative mechanism for this.

5. We can push artifacts to artifact repo (like  nexus, dockerHub ), and thn we can directly download the artifacts in client system so that it will contain everyting needed to acess this service.

6. In similar way we can also have this deployed at some cloud service domain(SAAS based), so that multiple tenants can have thier own dashboard(with some configurations needed for this).
