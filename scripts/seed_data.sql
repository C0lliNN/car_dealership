INSERT INTO car_dealership.sellers
VALUES
('seller-1', 'Raphael Collin', 'raphael@test.com', 'ACTIVE', '2022-08-04'),
('seller-2', 'Luiz Gustavo', 'luiz@test.com', 'ACTIVE', '2022-08-02');

INSERT INTO car_dealership.cars
VALUES
('car-1', 'HB20', 'Hyundai', 'ACTIVE', 'HATCH', 'WHITE', '234234234', 60000, 2014),
('car-2', 'Onix', 'Chevrolet', 'SOLD', 'SEDAN', 'GRAY', '235252654', 0, 2022);

INSERT INTO car_dealership.photos
VALUES
('car-1', 'Front', 'https://www.netcarshow.com/Hyundai-HB20S-2013-1600-0a.jpg'),
('car-2', 'Front', 'https://1.bp.blogspot.com/-enSdX8lNHdE/XcohpNe7UaI/AAAAAAAAY1k/l-GKvCBTkQ8JmDWmwblRahmfdWYGZSLYQCLcBGAsYHQ/s1600/Novo-Onix-Hatch-2020%2B%25283%2529.jpg');

INSERT INTO car_dealership.acquisitions
VALUES
('car-1', '2022-07-01', 'PRIVATE', 35000),
('car-2', '2022-07-01', 'VENDOR', 80000);

INSERT INTO car_dealership.sales
VALUES
('sale-1', '2022-08-03', 85000, 'seller-1', 'car-2');

INSERT INTO car_dealership.customers
VALUES
('sale-1', 'Hiago', 'hiago@test.com', '22835353535');