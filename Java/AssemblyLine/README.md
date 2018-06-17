# Henry Ford assembly line
Source code must be submitted in gitlab.talentboost.org server. Your task will be assessed in the following categories: Correctness (validation of input parameters, proper exception handling), Coding Style (java docs, formatting, readability and naming conventions), Design (Interfaces, separations of concerns, proper model and patterns), Algorithms and Unit tests.

A famous Car manufacturer needs a software which should allow them to better manage their facilities in Bulgaria. They offer a variety of models and engines to their customers and they hope to become more efficient by using your software.
Your task is to design and implement a Vehicle Assembly line simulator. The main purpose of the assembly line is to manufacture cars. Your software should keep a record for all cars manufactured by the line. The main functionality that assembly line software should provide is: assemble (create) cars, disassemble (remove) cars and print (display) information about manufactured and disassembled cars. Assembly line can be started in any of the factories owned by the car manufacturer. Factories are located in different countries. 

Each car that is coming out from your assembly line should have  the following properties:
* VIN (Vehicle Identification Number) - see the specification below
* Model  - for example A4-sedan
* Engine 
* Transmission.

VIN is an alphanumeric string of 17 symbols, excluding the letters I, O and Q (to avoid confusion with the numbers 1 and 0). For the purpose of this task consider the first two symbols to be the ISO code for the country where the car is produced (e.g. BG for Bulgaria), the third number to be a unique factory number for the country (one of {0-9}). The other 14 symbols are factory specific unique identifier of each car. 

VIN Example : BG0AZXSW23EDCVFR4

Our car manufacturer offers the following models: A1, A2, A3, A4, A5, A6, A7 and A8. All these can be either sedan, hatchback or kombi.
Each model can be equipped with Petrol or Diesel engine. Each engine has a specific displacement measured in cubic centimeters, which correlates with the engine’s power (measured in kW) as given on the following table of equivalence.

| Engine displacement (cc) | Power in kW |
| ------ | ------ |
| 1000 |  55 |
| 2000 | 147 |
| 3000 | 245 |
| 4000 | 253 |
| 5000 | 331 |
| 6000 | 510 |
| 8000 | 736 |
Note: Diesel engines cc limitation: 2000<=cc<=6000

If a Turbo is mounted to any of the engines above, the power increases with 30%. Engines should comply to one of the following emission standards: euro3, euro4, euro5, euro6.  
Any of the following transmissions can be fitted into a car:

| Automatic | Manual |
| ------ | ------ |
|4 - gears |4 – gears |
|5 - gears |5 – gears |
|6 - gears |6 – gears |
|8 - gears |n/a |

Your assembly line should accept the following commands from keyboard:

create car <specification> - creates a car based on the specification and adds it to persistent storage

Example input and output:

Input: create car model=A5{-hatchback} engine=B|D{-100hp|-6L{T}-euro3} {transmission=Auto{-4}}

Output:

|vin	 |model   |type    |engine |transmission
| ------ | ------ | ------ |------ |------ | 
|BG212345678901234 |A5    |hatchback |D-100hp{T}-euro3     |Auto-4

disassemble <vin> - deletes/removes a vehicle from persistent storage with the provided vin

print {vin|all} – displays information about a specific vehicle for given vin or a list of all manufactured vehicles in the following format:

|vin	 |model   |type    |engine |transmission
| ------ | ------ | ------ |------ |------ | 
BG212345678901234 |A5    |hatchback |D-147hp-euro3        |Auto-4
BG212345678901234 |A4    |sedan     |D-191hpT-euro3        |Auto-4