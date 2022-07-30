CREATE TABLE customers (
    saleId VARCHAR(36) NOT NULL,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE sales (
    id VARCHAR(36) NOT NULL,
    date DATE NOT NULL,
    price INTEGER NOT NULL,
    sellerId VARCHAR(36) NOT NULL,
    carId varchar(36) NOT NULL
);