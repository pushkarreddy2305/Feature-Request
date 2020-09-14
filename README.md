# Feature-Request

Tech stack: Angular, SpringBoot, JPA, H2 in memory DB

FRONT END:
Angular
This is a Feature-Request project to demonstrate using Angular and SpringBoot. 

Get started
Clone the repo
git clone https://github.com/pushkarreddy2305/Feature-Request
cd Feature-Request

npm install
npm start/ng serve
The npm start command builds (compiles TypeScript and copies assets) the application into dist/, watches for changes to the source files, and runs lite-server on port 4200.


BACK END: SpringBoot
Import server code into Spring Tool Suite (STS). Set the Java build path and run the application as Spring boot app.
Open H2 DB in a browser by using http://localhost:8086/h2 

Create a table in H2 DB using the following query:
CREATE TABLE FEATURE_REQUEST(
   id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
   title  VARCHAR(55) ,
   description  VARCHAR(55) ,
   client  VARCHAR(55) ,
   client_priority  INT ,
   target_date  VARCHAR(55),
   product_area  VARCHAR(55)
);
