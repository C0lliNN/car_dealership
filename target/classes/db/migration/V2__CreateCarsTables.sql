CREATE TABLE photos (
    carId VARCHAR(36) NOT NULL,
    description TEXT,
    url TEXT
);

CREATE TABLE acquisitions (
    carId VARCHAR(36) NOT NULL,
    date DATE NOT NULL,
    source VARCHAR(50) NOT NULL
);

CREATE TABLE cars (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    type VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    chassis VARCHAR(100) NOT NULL,
    mileage INTEGER NOT NULL,
    releaseYear INTEGER NOT NULL
);