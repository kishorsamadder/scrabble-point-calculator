# Scrabble points Calculator
 Scrabble points Calculator application
 
# Application Project
  This application allows users typing in the letter in the Tiles and it will calculate the score real-time based on Appendix.
  It has been built using the Spring Boot framework for the backend, Junit 5 for test cases, h2 database for data storage and React for the frontend. The project utilizes Maven as the build tool for the backend.

## Features
- __Enter__Letters__: User can enter letters in the given tiles and automatically convert into capital letters.
- __Real-time Calculation__: Score will calculate real-time based on the input.
- __Reset Tiles__: Clear all values from tiles after clicking on Reset Tiles button.
- __Save Score__: Store calculated score in database.
- __View Top 10 scores__: Fetch top 10 scores from database via api.

## Tech Stack
The application incorporates the following technologies:

- __Spring Boot__: A Java-based framework used for building the backend server and handling business logic.
- __H2 database__: Save score in database
- __React__: A framework for building frontend.
  
## Setup Instructions
To run the application locally, follow these steps:

1. __Clone the repository__: ``` https://github.com/kishorsamadder/scrabble-point-calculator.git```
2. __Navigate to the project directory__: ```cd scrabble-service```
3. __Set up the backend server__:
   - Install the dependencies: ```mvn clean install```
   - Start the Spring Boot server: ```mvn spring-boot:run```
4. __Set up the frontend__:
   - Install the dependencies: ```cd scrabble-point-calculator``` && ```npm install```
   - Start the React server: ```npm start```
5. __Open your application__ ```http://localhost:3000```

## Application flow

Detailed application flow can be found here in wiki page : 

[https://drive.google.com](https://github.com/kishorsamadder/scrabble-point-calculator/wiki/Scrabble-Points-Calculator-document)https://github.com/kishorsamadder/scrabble-point-calculator/wiki/Scrabble-Points-Calculator-document

Feel free to enhance the application as per your requirement.

