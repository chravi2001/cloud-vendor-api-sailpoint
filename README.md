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

       <?xml version='1.0' encoding='UTF-8'?>
    <!DOCTYPE Application PUBLIC "sailpoint.dtd" "sailpoint.dtd">
    <Application connector="sailpoint.connector.webservices.WebServicesConnector" created="1757264122792" featuresString="PROVISIONING, ENABLE, PASSWORD, AUTHENTICATE, UNLOCK" id="c0a8006b99241b2d8199251a93a80046" modified="1757265292393" name="Web application" profileClass="" significantModified="1757265292393" type="Web Services">
      <Attributes>
        <Map>
          <entry key="acctAggregationEnd">
            <value>
              <Date>1757265292372</Date>
            </value>
          </entry>
          <entry key="acctAggregationStart">
            <value>
              <Date>1757265292307</Date>
            </value>
          </entry>
          <entry key="afterProvisioningRule"/>
          <entry key="aggregationPartitioned">
            <value>
              <Boolean></Boolean>
            </value>
          </entry>
          <entry key="aggregationType" value="account"/>
          <entry key="authenticationMethod" value="No Auth"/>
          <entry key="beforeProvisioningRule"/>
          <entry key="clientCertAuthEnabled">
            <value>
              <Boolean></Boolean>
            </value>
          </entry>
          <entry key="compositeDefinition"/>
          <entry key="connectionParameters">
            <value>
              <List>
                <Map>
                  <entry key="afterRule" value="Acc_agg_after_rule"/>
                  <entry key="beforeRule"/>
                  <entry key="body">
                    <value>
                      <Map>
                        <entry key="bodyFormData"/>
                        <entry key="bodyFormat" value="raw"/>
                        <entry key="jsonBody"/>
                      </Map>
                    </value>
                  </entry>
                  <entry key="contextUrl" value="/cloudvendor"/>
                  <entry key="curlCommand"/>
                  <entry key="curlEnabled">
                    <value>
                      <Boolean></Boolean>
                    </value>
                  </entry>
                  <entry key="customAuthUrl"/>
                  <entry key="header"/>
                  <entry key="httpMethodType" value="GET"/>
                  <entry key="operationType" value="Account Aggregation"/>
                  <entry key="paginationSteps"/>
                  <entry key="pagingInitialOffset">
                    <value>
                      <Integer>0</Integer>
                    </value>
                  </entry>
                  <entry key="pagingSize">
                    <value>
                      <Integer>50</Integer>
                    </value>
                  </entry>
                  <entry key="parentEndpointName"/>
                  <entry key="resMappingObj"/>
                  <entry key="rootPath"/>
                  <entry key="sequenceNumberForEndpoint" value="1"/>
                  <entry key="uniqueNameForEndPoint" value="Account aggregation"/>
                  <entry key="xpathNamespaces"/>
                </Map>
                <Map>
                  <entry key="afterRule" value="Acc_agg_after_rule"/>
                  <entry key="beforeRule"/>
                  <entry key="body">
                    <value>
                      <Map>
                        <entry key="bodyFormData"/>
                        <entry key="bodyFormat" value="raw"/>
                        <entry key="jsonBody" value="{&#xD;&#xA;  &quot;vendorId&quot;: &quot;C5&quot;,&#xD;&#xA;  &quot;vendorName&quot;: &quot;Vendor two&quot;,&#xD;&#xA;  &quot;vendorAddress&quot;: &quot;Address two&quot;,&#xD;&#xA;  &quot;vendorPhoneNumber&quot;: &quot;two&quot;,&#xD;&#xA;  &quot;isDisabled&quot;: &quot;false&quot;&#xD;&#xA;}"/>
                      </Map>
                    </value>
                  </entry>
                  <entry key="contextUrl" value="/cloudvendor"/>
                  <entry key="curlCommand"/>
                  <entry key="curlEnabled">
                    <value>
                      <Boolean></Boolean>
                    </value>
                  </entry>
                  <entry key="customAuthUrl"/>
                  <entry key="header"/>
                  <entry key="httpMethodType" value="GET"/>
                  <entry key="operationType" value="Test Connection"/>
                  <entry key="paginationSteps"/>
                  <entry key="pagingInitialOffset">
                    <value>
                      <Integer>0</Integer>
                    </value>
                  </entry>
                  <entry key="pagingSize">
                    <value>
                      <Integer>50</Integer>
                    </value>
                  </entry>
                  <entry key="parentEndpointName"/>
                  <entry key="resMappingObj"/>
                  <entry key="responseCode"/>
                  <entry key="rootPath"/>
                  <entry key="sequenceNumberForEndpoint" value="2"/>
                  <entry key="uniqueNameForEndPoint" value="Update"/>
                  <entry key="xpathNamespaces"/>
                </Map>
              </List>
            </value>
          </entry>
          <entry key="createAccountWithEntReq">
            <value>
              <Boolean></Boolean>
            </value>
          </entry>
          <entry key="enableHasMore" value="true"/>
          <entry key="enableStatus"/>
          <entry key="encrypted" value="accesstoken,refresh_token,oauth_token_info,client_secret,private_key,private_key_password,clientCertificate,clientKeySpec,resourceOwnerPassword,custom_auth_token_info"/>
          <entry key="fixedPlanMultivaluedAttribute" value="true"/>
          <entry key="genericWebServiceBaseUrl" value="http://localhost:9090"/>
          <entry key="httpCookieSpecsStandard" value="true"/>
          <entry key="isGetObjectRequiredForPTA">
            <value>
              <Boolean>true</Boolean>
            </value>
          </entry>
          <entry key="lastAggregationDate_account" value="2025-09-07T17:14:52Z"/>
          <entry key="nativeChangeDetectionAttributeScope" value="entitlements"/>
          <entry key="nativeChangeDetectionAttributes"/>
          <entry key="nativeChangeDetectionEnabled">
            <value>
              <Boolean></Boolean>
            </value>
          </entry>
          <entry key="nativeChangeDetectionOperations"/>
          <entry key="oAuthJwtHeader">
            <value>
              <Map>
                <entry key="alg" value="RS256"/>
              </Map>
            </value>
          </entry>
          <entry key="oAuthJwtPayload">
            <value>
              <Map>
                <entry key="aud"/>
                <entry key="exp" value="15f"/>
                <entry key="iss"/>
                <entry key="sub"/>
              </Map>
            </value>
          </entry>
          <entry key="private_key_to_update"/>
          <entry key="saml_assertion_url"/>
          <entry key="saml_request_body"/>
          <entry key="sysDescriptions">
            <value>
              <Map>
                <entry key="en_US"/>
              </Map>
            </value>
          </entry>
          <entry key="templateApplication" value="Web Services"/>
          <entry key="throwProvAfterRuleException">
            <value>
              <Boolean>true</Boolean>
            </value>
          </entry>
          <entry key="throwProvBeforeRuleException">
            <value>
              <Boolean>true</Boolean>
            </value>
          </entry>
          <entry key="timeoutInSeconds"/>
          <entry key="version" value="v2"/>
        </Map>
      </Attributes>
      <Owner>
        <Reference class="sailpoint.object.Identity" id="c0a8006b9924169881992437938e00ff" name="spadmin"/>
      </Owner>
      <Schemas>
        <Schema created="1757264122795" displayAttribute="vendorName" groupAttribute="" id="c0a8006b99241b2d8199251a93ab0048" identityAttribute="vendorID" instanceAttribute="" modified="1757265271889" nativeObjectType="user" objectType="account" significantModified="1757265271889">
          <AttributeDefinition name="vendorID" type="string">
            <Description></Description>
          </AttributeDefinition>
          <AttributeDefinition name="vendorName" type="string">
            <Description></Description>
          </AttributeDefinition>
          <AttributeDefinition name="vendorAddress" type="string">
            <Description></Description>
          </AttributeDefinition>
          <AttributeDefinition name="vendorPhoneNumber" type="string">
            <Description></Description>
          </AttributeDefinition>
          <AttributeDefinition name="isDisabled" type="string">
            <Description></Description>
          </AttributeDefinition>
        </Schema>
        <Schema created="1757264122795" descriptionAttribute="" displayAttribute="" id="c0a8006b99241b2d8199251a93ab0049" identityAttribute="" instanceAttribute="" modified="1757265271889" nativeObjectType="group" objectType="group" significantModified="1757265271889"/>
      </Schemas>
      <ApplicationScorecard created="1757264122792" id="c0a8006b99241b2d8199251a93a80047" modified="1757265271889" significantModified="1757265271889"/>
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
