SELECT * FROM Suppliers;

-- add a new supplier
INSERT INTO Suppliers
VALUES (30, 'BlaBlaCorp', 'Bla Bla', 'Bla Manager', '1 Bla St', 'Bla City', 'BL', '94100', 'Blalaland', '415-111-2233','415-111-22-34', NULL);

-- add a new product by that supplier
SELECT * FROM Products;

INSERT INTO Products 
(`ProductName`, `SupplierID`, `CategoryID`, `QuantityPerUnit`, `UnitPrice`, `UnitsInStock`, `UnitsOnOrder`, `ReorderLevel`, `Discontinued`)
VALUES ('Blablaa Product', 30, NULL,  '1 kg blabla', 15.00, 100, 20, 20, 0);

INSERT INTO `Products` 
(`ProductName`, `SupplierID`, `CategoryID`, `QuantityPerUnit`, `UnitPrice`, `UnitsInStock`, `UnitsOnOrder`, `ReorderLevel`, `Discontinued`)
VALUES
('Apple Juice',30, 1, '500ml', 1.99, 100, 50, 10, 0),
('Orange Juice', 30, 1, '250ml', 2.49, 200, 30, 20, 0),
('Tomato Sauce', 30, 2, '1L', 3.99, 150, 100, 15, 0),
('Pasta', 30, 3, '500g', 1.29, 300, 75, 25, 0),
('Olive Oil', 30, 4, '1L', 8.99, 50, 10, 5, 0),
('Canned Tuna', 30, 2, '150g', 1.69, 400, 200, 30, 1);

SHOW TABLES;

-- delete new product
DELETE FROM Products
WHERE ProductID = 51;

-- delete new supplier
DELETE FROM Suppliers
WHERE SupplierID = 30;