CREATE TABLE person (
                        Id SERIAL PRIMARY KEY,
                        Name TEXT,
                        Age INTEGER,
                        Rights BOOLEAN,
                        Car_id BIGINT);

CREATE TABLE car (
                     Id SERIAL PRIMARY KEY,
                     Make_car TEXT,
                     Model_car TEXT,
                     Price_car REAL);