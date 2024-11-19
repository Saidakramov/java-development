-- n suppliers 29
SELECT
	COUNT(*) AS n_suppliers
FROM Suppliers;

-- sum salaries
SELECT
	ROUND(SUM(Salary),2) AS sum_salary
FROM Employees;

-- cheapest item
SELECT
	MIN(UnitPrice) AS cheapestItem
FROM Products;

-- avg price
SELECT
	AVG(UnitPrice) AS avg_price
FROM Products;

-- Most expensive item
SELECT
	MAX(UnitPrice) AS cheapestItem
FROM Products;

-- suplier id and number of supplies
SELECT
	SupplierID,
    COUNT(ProductID) AS n_supplies
FROM Products
GROUP BY 1;

-- categoryId and avg_price
SELECT
	CategoryID,
    AVG(UnitPrice) AS avg_category_price
FROM Products
GROUP BY 1;

-- at least 5 items
SELECT
	SupplierID,
    COUNT(*) AS n_supplies
FROM Products
GROUP BY 1
HAVING COUNT(*) >=5;

-- productID, name, inventory_value unitPrice*unitsOnHand
SELECT 
	ProductID,
    ProductName,
    UnitPrice * UnitsInStock AS inventory_value
FROM Products
GROUP BY 1, 2
ORDER BY 3 DESC, 2;