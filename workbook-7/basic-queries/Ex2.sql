-- 
SELECT * FROM northwind.`Order Details`;

-- Table that holds items
SELECT * FROM Products;

-- list productID, productName, unitPrice
SELECT ProductId, ProductName, UnitPrice
FROM Products;

--  list products with unit price <7.50
SELECT ProductId, ProductName, UnitPrice
FROM Products
WHERE UnitPrice <= 7.50;

-- at least 100 units
SELECT * FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitsInStock DESC;

-- at least 100 units, order by price desc, product name asc
SELECT * FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC, ProductName;

-- 0 units on hand, but 1 or more on backorder
SELECT * FROM Products
WHERE UnitsInStock = 0 AND UnitsOnOrder >= 1
ORDER BY ProductName;

-- table that holds categories
SELECT * FROM Categories;

-- category id of seafood = 8
SELECT * FROM Categories
WHERE CategoryName = "Seafood";

-- seafood items in Producst table
SELECT * FROM Products
WHERE CategoryID = 8;

-- first and last name of emps
SELECT FirstName, LastName
FROM Employees;

-- managers
SELECT * FROM Employees
WHERE Title LIKE '%manager%';

-- distinct job titles
SELECT DISTINCT Title
FROM Employees;

-- slary between 2000 and 2500
SELECT * FROM Employees
WHERE Salary BETWEEN 2000 AND 2500;

-- list all the info of suppliers tokyo = 4
SELECT * FROM Suppliers;

-- products that are suplied by tokyo tradfers
SELECT * FROM Products
WHERE SupplierID = 4;