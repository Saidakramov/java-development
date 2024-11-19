-- most expensive products with subqueries
WITH cte AS (
	SELECT
		MAX(UnitPrice) AS most_expensive_item
	FROM Products )

SELECT 
	ProductName
FROM Products 
WHERE UnitPrice = (SELECT most_expensive_item
                    FROM cte);
                    
-- orderId, shippingName, shippingAddress via FederalShipping
SELECT
	OrderId,
    ShipName,
    ShipAddress
FROM Orders
WHERE ShipVia = (SELECT
					ShipperId
				FROM Shippers
                WHERE CompanyName LIKE '%Federal%' );

-- find orderIds for SAsquatch Ale orders
SELECT
	OrderID
FROM `Order Details`
WHERE ProductID = (SELECT ProductID
					FROM Products
					WHERE ProductName = 'Sasquatch Ale');
                    
-- name of emp that sold 10266
SELECT 
	CONCAT(FirstName, ' ', LastName) AS FullName
FROM Employees
WHERE EmployeeID IN (SELECT EmployeeID
						FROM Orders
                        WHERE OrderID = 10266);

-- name of a customer who bought 10266	
SELECT ContactName
FROM Customers
WHERE CustomerID IN (SELECT CustomerID
						FROM Orders
                        WHERE OrderID = 10266);