# mobile food project

## How to start in your local machine.
Since this is a very open and simple demo project for presentation, so I just provide you a JAR file.
You can run it in your local machine using the command below, but you need to install JDK 11+ as the pre-condition:
java -jar mobilefood-0.0.1-SNAPSHOT.jar


## Dependencies
- JDK 17
- lombok
- opencsv
- spring-boot 3

- check generated path: `src/generated/main`

- config client address & port at: `src/main/resource/application.yml`

### Application Layer

Defines the jobs the software is supposed to parse CSV file and get some information you want.

I attached 2 APIs for your reference and run them in your local machine.
http://localhost:8080/api/foodfacility/read-csv 
### Retreive all the data from csv file

http://localhost:8080/api/foodfacility/approved-lowest-police-districts-food-facility 
### Filter records to get approved and lowest police districts food facility.

### Domain Layer (or Model Layer)

No database function added, so I didn't mark an notes in domain layer.

### Infrastructure Layer

Provides generic technical capabilities that support to read csv file that already downloaded 
and put into src/main/resources/data/csv
