use assemblylinedb

CREATE TABLE Models(
	id int IDENTITY(1,1) NOT NULL,
	modelName nvarchar(50) NOT NULL,
    modelType nvarchar(50) NULL
 CONSTRAINT PK_models PRIMARY KEY CLUSTERED 
(
	id ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

-------------------------------------------------------------

CREATE TABLE Transmissions(
	id int IDENTITY(1,1) NOT NULL,
	transType nvarchar(50) NOT NULL,
    numOfGears int NULL
 CONSTRAINT PK_transmissions PRIMARY KEY CLUSTERED 
(
	id ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

-------------------------------------------------------------

CREATE TABLE VehicleStates(
	id int IDENTITY(1,1) NOT NULL,
	state INT NOT NULL CHECK (state >= 0 AND state <= 1)
 CONSTRAINT PK_vehiclestates PRIMARY KEY CLUSTERED 
(
	id ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

-------------------------------------------------------------

CREATE TABLE Engines(
	id int IDENTITY(1,1) NOT NULL,
	fuelType nvarchar(50) NULL,
    litres int NULL,
    hp int NULL,
    turbo INT NOT NULL CHECK (turbo >= 0 AND turbo <= 1),
    emissionStandart nvarchar(50) NULL
 CONSTRAINT PK_engines PRIMARY KEY CLUSTERED 
(
	id ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

------------------------------------------------------------------

CREATE TABLE Vehicles(
	vin nvarchar(50) NOT NULL,
    vehicleType NVARCHAR(50) NOT NULL,
    modelId int NOT NULL,
    engineId int NOT NULL,
    transmissionId int NULL,
    vehicleStateId int NOT NULL,
	definedWith NVARCHAR(50) not NULL
)

------------------------------------------------------------------

ALTER TABLE Vehicles  WITH CHECK ADD  CONSTRAINT FK_vehicles_models FOREIGN KEY(modelId)
REFERENCES Models (id)

ALTER TABLE Vehicles CHECK CONSTRAINT FK_vehicles_models


ALTER TABLE Vehicles  WITH CHECK ADD  CONSTRAINT FK_vehicles_engines FOREIGN KEY(engineId)
REFERENCES Engines (id)

ALTER TABLE Vehicles CHECK CONSTRAINT FK_vehicles_engines


ALTER TABLE Vehicles  WITH CHECK ADD  CONSTRAINT FK_vehicles_transmissions FOREIGN KEY(transmissionId)
REFERENCES Transmissions (id)

ALTER TABLE Vehicles CHECK CONSTRAINT FK_vehicles_transmissions


ALTER TABLE Vehicles  WITH CHECK ADD  CONSTRAINT FK_vehicles_vehiclestate FOREIGN KEY(vehicleStateId)
REFERENCES VehicleStates (id)

ALTER TABLE Vehicles CHECK CONSTRAINT FK_vehicles_vehiclestate