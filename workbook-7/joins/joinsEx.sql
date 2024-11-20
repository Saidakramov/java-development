-- list product_id, productName, unitPrice, categoryName, order by categoryName, productNBame
SELECT
	p.ProductID,
    p.ProductName,
    p.UnitPrice,
    c.CategoryName
FROM Products p
JOIN Categories c ON p.CategoryID = c.CategoryID
ORDER BY 4,2;

-- list product_id, productName, unitPrice, categoryName, supplierName that are >75, order by productName
SELECT
	p.ProductID,
    p.ProductName,
    p.UnitPrice,
    s.CompanyName
FROM Products p
JOIN Suppliers s ON p.SupplierID = s.SupplierID
WHERE p.UnitPrice > 75
ORDER BY 2;

-- list product_id, productName, unitPrice, categoryName, supplierName
SELECT
	p.ProductID,
    p.ProductName,
    p.UnitPrice,
    c.CategoryName,
    s.CompanyName
FROM Products p
JOIN Categories c ON p.CategoryID = c.CategoryID
JOIN Suppliers s ON p.SupplierID = s.SupplierID
ORDER BY 2;

-- find productName, categories of the most expensive products
SELECT
	ProductName,
    CategoryName
FROM Products p
JOIN Categories c ON p.CategoryID = c.CategoryID
WHERE p.UnitPrice = (SELECT MAX(UnitPrice) 
						FROM Products);
                        
-- list orderID, shipName, shipAddress, shippingCompanyName that shipped to Germany
SELECT
	OrderID,
    ShipName,
    ShipAddress,
    CompanyName
FROM Orders o
JOIN Shippers sh ON o.ShipVia = sh.ShipperID
WHERE ShipCountry = 'Germany';

-- list orderID, orderDate, shipName, shipAddress who ordered SasquatchAle
SELECT
	o.OrderID,
    OrderDate,
    ShipName,
    ShipAddress
FROM Orders o
JOIN `Order Details` od ON o.OrderID = od.OrderID
JOIN Products p ON od.ProductID = p.ProductID
WHERE ProductName = 'Sasquatch Ale';