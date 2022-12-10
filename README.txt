NuChange Assignment

This project aims to create a program in Java(urldatabase) that can be run in the command line as per the given requirements below. 

Requirements 
1. To start the program: run java urldatabase. Further, the program will wait for the user to enter the following commands.
2. The command storeurl shall take a URL as a parameter and save that into a table with a unique short key and a count(usage count) initialized to 0.
       a. Use local variables instead of a database to store the data.
       b. Use any appropriate logic to generate the unique short key.
2. The command get shall take a URL as a parameter and return the unique short key after incrementing the usage count.
3. The command count shall take a URL as a parameter and should return the latest usage count.
4. The command list should return all urls and counts. The return value is in JSON.
5. The command exit should terminate the program

Flow of the Program
__________________________________________________________________________________________________________

1. Menu is displayed awaiting input from User as

Welcome to Url counter
 Options
 1. Storeurl
 2. Geturl
 3. Counturl
 4. listUrls
 5. Exit
 Enter your input:

Additional Dependancies 
---------------------------------------------------------------------------
json-simple-1.1.1.jar for import org.json.simple.JSONObject;

pom.xml contents are :
<dependency>  
    <groupId>com.googlecode.json-simple</groupId>  
    <artifactId>json-simple</artifactId>  
    <version>1.1</version>  
  </dependency>  


