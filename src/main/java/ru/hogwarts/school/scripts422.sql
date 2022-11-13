CREATE TABLE person (
                        id SERIAL PRIMARY KEY,
                        name TEXT,
                        age INTEGER,
                        rights BOOLEAN,
                        car_id BIGINT REFERENCES car (id));

CREATE TABLE car (
                     id SERIAL PRIMARY KEY,
                     make_car TEXT,
                     model_car TEXT,
                     price_car REAL);