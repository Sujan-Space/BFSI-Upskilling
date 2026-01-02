# Project Setup Guide

## Tools Installed
The following tools are required to work with this project:

### 1. **Java Development Kit (JDK 17)**
   - Required for compiling and running Java code.

### 2. **Jenkins**
   - URL: [http://localhost:8080/s](http://localhost:8080/s)
   - **Credentials**:
     - Username: `admin`
     - Password: `Root123$`

### 3. **VSCode**
   - Visual Studio Code for editing code.

### 4. **Eclipse IDE Enterprise**
   - Eclipse IDE for Java development.

### 5. **MySQL with Workbench**
   - **MySQL Credentials**:
     - Username: `root`
     - Password: `Sujan@2003`
     - Command to connect:  
       ```bash
       mysql -u root -pRoot123$
       ```

### 6. **Maven 3.9.8**
   - For project management and build automation.

### 7. **Git**
   - For version control and source code management.

### 8. **Spring Tool Suite 4**
   - For Spring Boot development.

### 9. **Ruby**
   - Ruby programming language for scripting.

### 10. **SoapUI**
   - For testing SOAP and REST APIs.

### 11. **Postman**
   - For testing APIs (RESTful services).

### 12. **Node.js & NPM**
   - Node.js runtime environment.
   - NPM for managing Node.js packages.

### 13. **Angular**
   - For frontend development.

### 14. **DBeaver**
   - Universal database management tool.

### 15. **Heroku CLI**
   - For managing Heroku applications.

### 16. **Jupyter Notebook**
   - For working with Python and data science tools.
   - To start Jupyter Notebook:
     ```bash
     jupyter notebook
     ```

### 17. **Apache Kafka**
   - For event streaming and message brokering.
   - To start Kafka:
     ```bash
     /opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties
     ```

### 18. **MongoDB Community Edition**
   - MongoDB database system.
   - **Service Name**: `mongod`
   - To start MongoDB:
     ```bash
     systemctl start mongod
     ```

### 19. **IntelliJ IDEA Community Edition**
   - For Java development.

### 20. **.NET Runtime 7.0**
   - .NET runtime for running .NET applications.

### 21. **Quarkus**
   - For building Java microservices.

### 22. **MSSQL**
   - Microsoft SQL Server.
   - To connect:
     ```bash
     sqlcmd -S localhost -U sa -P 'Root123$'
     ```

### 23. **TestNG (Eclipse Plugin)**
   - TestNG framework for running tests.

### 24. **JUnit5**
   - JUnit for running unit tests.

### 25. **Selenium WebDriver**
   - For browser automation.
   - **Path**: `/opt/selenium`

### 26. **Playwright**
   - For end-to-end testing of web applications.

### 27. **Splunk Enterprise**
   - For searching, monitoring, and analyzing machine data.
   - To start Splunk (using Docker):
     ```bash
     docker run -d -p 8000:8000 -e "SPLUNK_START_ARGS=--accept-license" -e "SPLUNK_GENERAL_TERMS=--accept-sgt-current-at-splunk-com" -e "SPLUNK_PASSWORD=Root123$" --name splunk splunk/splunk:latest
     ```
   - **URL**: [http://localhost:8000](http://localhost:8000)
   - **Credentials**:
     - Username: `admin`
     - Password: `Root123$`

---

## Project Setup

### 1. **Clone the Repository**
   Clone this repository to your local machine:
   ```bash
   git clone https://github.com/Sujan-Space
   cd Sujan-Space
