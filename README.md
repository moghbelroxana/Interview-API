
# PNC Interview Exercise

This exercise simulates user registration. The user must enter a username, password, and IP address, none of which are null. The password must be greater than 8 chars,containing at least 1 number, 1 
Capitalized letter, 1 special character in this set “_ # $ % .” It uses the geolocation API to check if the user's IP address is in Canada - if not, they are not able to register.

If the user meets all requirements, they are greeted with a random uuid and a welcome message with their
username and their city name (using ip-geolocation api).

Enter in username and password via JSON object with the format:


        {
            "userName": "exampleUserName",
            "password": "examplePassword",
            "ipAddress": "100.42.255.255"
        }

Other User properties are not necessary to register.       


The Open API Specification can be found under openapi.json

The JUnit tests are located in src/test/java/com/exercise/app/RegistrationApplicationTests.java

