
Features of this application

- **API Endpoint**: `GET /next-tracking-number`
- **Inquiry Parameters**:
- `origin_country_id`: Root nation code (ISO 3166-1 alpha-2), e.g., `MY`
- `destination_country_id`: Goal nation code (ISO 3166-1 alpha-2), e.g., `ID`
- `weight`: Arrange weight in kilograms, up to three decimal places, e.g., `1.234`
- `created_at`: Arrange creation timestamp in RFC 3339 arrange, e.g., `2018-11-20T19:29:32+08:00`
- `customer_id`: Customer's UUID, e.g., `de619854-b59b-425e-9db4-943979e1bd49`
- `customer_name`: Customer's title, e.g., `RedBox Logistics`
- `customer_slug`: Customer's title in slug-case/kebab-case, e.g., `redbox-logistics`

- **Following Number Constraints**:
- Must coordinate the regex design: `^[A-Z0-9]{1,16}$`
- Must be interesting; no copy following numbers ought to be generated

---

Prerequisites

- **Java**: JDK 17 or latest
- **Maven**: 3.8.6 or higher
- **MySQL**: 8.0 or higher

---
##Code Setup 

Clone the Repository

```bash
git clone https://github.com/praveen-hub-java/tracking-generator.git
cd tracking-generator


##DB Setup
CREATE DATABASE tracking_db;
CREATE USER 'tracking_user'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON tracking_db.* TO 'tracking_user'@'localhost';
FLUSH PRIVILEGES;


src/main/resources/application.yaml

r2dbc:
    url: r2dbc:mysql://DBInstanceIPAddress:3306/Your_DB?useServerPrepStmts=true&zeroDate=use_round&sslMode=DISABLED
    username: your_user_name
    password: your_password
	
	
	
##Build Application

#./mvnw clean install
# or
#mvn clean install

./mvnw clean package -DskipTests
docker build -t tracking-generator:latest .


Run Application
#./mvnw spring-boot:run
# or
#mvn spring-boot:run

docker run -d -p 8080:8080 --name tracking-generator tracking-generator:latest
docker-compose up --build -d

Using JAR

java -jar target/tracking-generator-0.0.1-SNAPSHOT.jar


Test url:
curl -X GET "http://localhost:8080/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2018-11-20T19:29:32%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics"
