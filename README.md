# Incident Log API - SPARKLEHOOD Assignment


This project is a RESTful API service built using Java, Spring Boot, and MySQL. It is developed to log and manage AI Safety Incidents with basic CRUD functionality. The API accepts and returns data in JSON format, and is tested using Postman.




## Tech Stack
- **Java** 21  
- **Spring Boot** 3.4.5  
- **MySQL** Database  
- **Maven** for dependency management  
- **Postman** for API testing  
- **VS Code** (Development Environment)  



## Prerequisites
Before setting up the project, ensure the following are installed:
- Java Development Kit (JDK) 21  
- MySQL Server (latest stable version)  
- Visual Studio Code (VS Code)  
- Postman (for API testing)  

**VS Code Extensions Required:**  
- Extension Pack for Java (by Microsoft)  
- Spring Boot Extension Pack (by VMware)  



## Project Setup Instructions

### Step 1: Clone the Project
1. Unzip the provided code folder.  
2. Open VS Code and select **File → Open Folder**.  
3. Choose the extracted project folder.  

### Step 2: Configure MySQL Database
1. Start your MySQL server locally.  
2. Open MySQL Command Line Client or Workbench and create a new database:
   ```sql
   CREATE DATABASE IncidentLogAPI;

### Step 3: Configure `application.properties`

- Navigate to: `src/main/resources/application.properties`
- Ensure the following configuration is updated with your MySQL username and password:
    - spring.datasource.username=your_mysql_username
    - spring.datasource.password=your_mysql_password
    - server.port=8080 # Change if 8080 is busy on local




### Step 4: Build and Run the Project

- Open the VS Code **File Explorer**.
- Go to **JAVA PROJECTS**.
- Right-click on the project root folder and then select **Run**.

You should see logs that confirm the server started at:  
`http://localhost:8080`



### 5. API Endpoints (Using Postman)

| Action                   | Method | URL                                             | Body               |
|--------------------------|--------|--------------------------------------------------|--------------------|
| Create a New Incident    | POST   | `http://localhost:8080/addIncidents`            | JSON body required |
| Get All Incidents        | GET    | `http://localhost:8080/searchAllIncidents`      | -                  |
| Get an Incident by ID    | GET    | `http://localhost:8080/searchByIncidentId/{id}` | -                  |
| Delete an Incident by ID | DELETE | `http://localhost:8080/deleteIncident/{id}`     | -                  |



### Request and Response Examples

**Request Body Example (for `POST /addIncidents`):**

```json
{
"title": "AI Model Misbehaving",
"description": "The AI model started generating offensive content unexpectedly.",
"severity": "High"
}
```
**Response Body Example (for `GET /searchAllIncidents`):**
```json
{
  "incidentId": 1,
  "incidentTitle": "AI Model Misbehaving",
  "incidentDescription": "The AI model started generating offensive content unexpectedly.",
  "incidentSeverity": "High",
  "incidentReportedAt": "2025-04-24T18:30:00"
}
```
### 4. Project’s Hierarchy
```
sparklehood-assignment
└── src
    └── main
        └── java
            └── api.log.incident.com
                ├── controller
                │   ├── AddingIncident
                │   ├── DeleteIncident
                │   ├── HomePage
                │   └── SearchIncident
                ├── entity
                │   ├── Incidents
                │   └── Severity
                ├── exception
                │   └── GlobalExceptionHandler
                ├── repositories
                │   └── IncidentRepo
                ├── services
                │   └── IncidentService
                └── services.impl
                    └── IncidentServiceImpl

```
## 5. Error Handling

The application implements global exception handling using `@ControllerAdvice` and custom exception methods. Any invalid input or incorrect API usage results in meaningful, human-readable JSON error responses.

| Situation                                          | Error Message (JSON)                                                                                 | HTTP Status Code            |
| -------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | --------------------------- |
| Wrong API URL entered                              | `{ "error": "You must enter a valid url." }`                                                          | 404 Not Found               |
| Wrong HTTP method used (e.g., POST instead of GET) | `{ "error": "You must enter a valid HTTP method." }`                                                  | 405 Method Not Allowed      |
| Field validation failed (e.g., missing field)      | `{ "error": "You must enter a valid value for the field: fieldName." }`                               | 400 Bad Request             |
| Severity value not readable/invalid                | `{ "error": "Severity value is not valid. Please use one of the following: LOW, MEDIUM, HIGH." }`     | 400 Bad Request             |
| Incident not found by ID                           | `{ "error": "Incident not found. Please check the ID and try again." }`                               | 400 Bad Request             |

### Example 1: Invalid URL Request

```json
{
  "error": "You must enter a valid url."
}
```
### Example 2: Invalid HTTP Method (e.g., using POST instead of GET)
```json
  {
   "error": "You must enter a valid HTTP method."
  }
```
### Example 3: Missing Required Field
```json
  {
   "error": "You must enter a valid value for the field: title."
  }
```


## 6. Pre-loaded Sample Data

You can optionally preload sample data by using Postman to send a few POST requests, or inserting manually into the MySQL database.

### Option 1: Insert Data Manually into MySQL

```sql
INSERT INTO incidents (IncidentTitle, IncidentDescription, IncidentSeverity, IncidentCreatedAt)
VALUES
  ('Sample Incident 1', 'Description 1', 'Medium', NOW()),
  ('Sample Incident 2', 'Description 2', 'Low', NOW());
```
### Option 2: Pre-load Data Using Postman

Follow these steps to add sample incidents through Postman:

1. Open Postman  
2. Select the **POST** method  
3. Enter the URL: `http://localhost:8080/addIncidents`  
4. Go to the **Body** tab  
5. Select **raw** and choose **JSON** format from the dropdown  
6. Enter data in the following format:
  ```json
   {
     "title": "AI Model Misbehaving",
     "description": "The AI model started generating offensive content unexpectedly.",
     "severity": "High"
   }
```
7. Click Send to submit the request. You will receive a 201 Created response with the created incident's id.
## 7. Notes and Design Choices

- Used **Spring Boot** for rapid API development and cleaner configuration management.  
- Implemented data validation for `severity` field (allowed values: Low, Medium, High).  
- `reportedAt` timestamp is automatically populated at the time of incident creation using Hibernate annotations.  
- Used **Maven** for dependency management to ensure smooth building and running across environments.  
- No frontend is provided as per assignment instructions; all testing is through Postman.  

---

### Thank You

Thank you for reviewing this API documentation.  



