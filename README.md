☁️ Cloud Vendor API – Integrated with SailPoint IIQ

A Spring Boot REST API for managing cloud vendors, fully integrated with SailPoint IdentityIQ (IIQ) via its Web Service Connector.
This project exposes REST endpoints to create, retrieve, update, disable, and delete cloud vendor records stored in a MySQL database. These APIs are consumed directly by SailPoint IIQ for provisioning and governance use cases.
________________________________________

📌 Features

  •	CRUD APIs for Cloud Vendor Management

  •	Disable vendor functionality
  
  •	Persistence with Spring Data JPA + MySQL
  
  •	Clean layered architecture (Controller → Service → Repository → Model)
  
  •	Already connected to SailPoint IIQ Web Service Connector for provisioning

________________________________________

🛠️ Tech Stack

•	Java 24

•	Spring Boot 3.5.5

•	Spring Web (REST APIs)

•	Spring Data JPA (persistence)

•	MySQL (database)

•	Maven (build tool)

•	SailPoint IIQ Web Service Connector (configured for CRUD operations)
________________________________________

⚡ Getting Started

   1. Prerequisites
  
   Install Java 24 → java -version
  
   Install Maven → mvn -version
  
   Install MySQL and create a database:
  
    CREATE DATABASE cloud_vendor;

2. Configure Database

Edit src/main/resources/application.yaml:

    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/cloud_vendor?useSSL=false
        username: root
        password: Mysql@123
    
      jpa:
        hibernate:
          ddl-auto: update

3. Run the Application
   
        # Clone the repository
        git clone https://github.com/your-username/rest-demo.git
        cd rest-demo
        
        # Build
        mvn clean install
        
        # Run
        mvn spring-boot:run


Server starts at:

    http://localhost:9090

________________________________________


🔗 API Endpoints

    Base Path
    http://localhost:9090/cloudvendor


| Method | Endpoint                | Description              |
|--------|-------------------------|--------------------------|
| GET    | `/cloudvendor/{id}`     | Get vendor by ID         |
| GET    | `/cloudvendor`          | Get all vendors          |
| POST   | `/cloudvendor`          | Create a new vendor      |
| PUT    | `/cloudvendor`          | Update vendor            |
| PUT    | `/cloudvendor/disable`  | Disable vendor           |
| DELETE | `/cloudvendor/{id}`     | Delete vendor by ID      |


Example Requests

Create Vendor
    
    POST /cloudvendor
    Content-Type: application/json
    
    {
      "vendorId": "101",
      "vendorName": "AWS",
      "vendorAddress": "Seattle, USA",
      "vendorPhoneNumber": "123-456-7890",
      "isDisabled": "false"
    }


Get All Vendors
    
    GET /cloudvendor


Response:

    {
      "users": [
        {
          "vendorId": "101",
          "vendorName": "AWS",
          "vendorAddress": "Seattle, USA",
          "vendorPhoneNumber": "123-456-7890",
          "isDisabled": "false"
        }
      ]
    }


Disable Vendor

    PUT /cloudvendor/disable
    Content-Type: application/json
    
    {
      "vendorId": "101",
      "vendorName": "AWS",
      "vendorAddress": "Seattle, USA",
      "vendorPhoneNumber": "123-456-7890",
      "isDisabled": "true"
    }

________________________________________

📖 Database Schema

Generated automatically by JPA (ddl-auto: update):

    CREATE TABLE cloud_vendor_info (
        vendor_id VARCHAR(255) PRIMARY KEY,
        vendor_name VARCHAR(255),
        vendor_address VARCHAR(255),
        vendor_phone_number VARCHAR(255),
        is_disabled VARCHAR(255)
    );

________________________________________

🔗 SailPoint IIQ Integration

This API is already integrated with SailPoint IdentityIQ using a Web Service Connector.

The connector is configured to:

Provision vendors → Calls the POST /cloudvendor endpoint

Update vendors → Calls the PUT /cloudvendor endpoint

Disable vendors → Calls the PUT /cloudvendor/disable endpoint

Delete vendors → Calls the DELETE /cloudvendor/{id} endpoint

Fetch vendors → Calls the GET /cloudvendor and GET /cloudvendor/{id} endpoints

Below is the sample IIQ application.xml configuration already in place:

    <Application name="CloudVendorAPI" type="Web Services">
        <Attributes>
            <Map>
                <entry key="baseUrl" value="http://localhost:9090/cloudvendor"/>
                <entry key="authType" value="none"/> <!-- Add Basic/Auth if needed -->
                <entry key="responseFormat" value="json"/>
            </Map>
        </Attributes>

    <ObjectType name="cloudVendor" displayName="Cloud Vendor" identityAttribute="vendorId">
        <Attributes>
            <Map>
                <entry key="vendorId" value="$object.vendorId"/>
                <entry key="vendorName" value="$object.vendorName"/>
                <entry key="vendorAddress" value="$object.vendorAddress"/>
                <entry key="vendorPhoneNumber" value="$object.vendorPhoneNumber"/>
                <entry key="isDisabled" value="$object.isDisabled"/>
            </Map>
        </Attributes>

        <Operation name="create" type="POST" url="$(baseUrl)"/>
        <Operation name="update" type="PUT" url="$(baseUrl)"/>
        <Operation name="disable" type="PUT" url="$(baseUrl)/disable"/>
        <Operation name="delete" type="DELETE" url="$(baseUrl)/$(object.vendorId)"/>
        <Operation name="get" type="GET" url="$(baseUrl)/$(object.vendorId)"/>
        <Operation name="list" type="GET" url="$(baseUrl)"/>
    </ObjectType>
    </Application>


With this integration, SailPoint IIQ directly provisions and manages Cloud Vendors through the APIs provided by this project.

________________________________________

🚀 Roadmap

 Add request validation

 Add exception handling + standardized error responses

 Add authentication/authorization (Spring Security + JWT/OAuth2)

 Dockerize the app for deployment

 Extend IIQ connector mappings with entitlements/roles

________________________________________


🤝 Contributing

Fork the repository

Create your feature branch → git checkout -b feature/my-feature

Commit changes → git commit -m 'Add new feature'

Push branch → git push origin feature/my-feature

Open a Pull Request
________________________________________

📜 License

This project is licensed under the MIT License.
