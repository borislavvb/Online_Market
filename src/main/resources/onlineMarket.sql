-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table online_market.brands
CREATE TABLE IF NOT EXISTS `brands` (
  `BrandID` int(11) NOT NULL,
  `BrandName` varchar(50) NOT NULL,
  PRIMARY KEY (`BrandID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_market.brands: ~0 rows (approximately)
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;

-- Dumping structure for table online_market.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `CustomerID` int(11) NOT NULL,
  `Username` int(11) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_market.customers: ~0 rows (approximately)
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

-- Dumping structure for table online_market.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `OrderID` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `Order_Date` date NOT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `FK_Orders_Customers` (`CustomerId`),
  CONSTRAINT `FK_Orders_Customers` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_market.orders: ~0 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table online_market.order_details
CREATE TABLE IF NOT EXISTS `order_details` (
  `OrderID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  KEY `FK_orderDetails_orders` (`OrderID`),
  KEY `FK_products_orderDetails` (`ProductID`),
  CONSTRAINT `FK_orderDetails_orders` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`OrderID`),
  CONSTRAINT `FK_products_orderDetails` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_market.order_details: ~0 rows (approximately)
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;

-- Dumping structure for table online_market.products
CREATE TABLE IF NOT EXISTS `products` (
  `ProductId` int(11) NOT NULL,
  `BrandID` int(11) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`ProductId`),
  KEY `FK_products_brands` (`BrandID`),
  CONSTRAINT `FK_products_brands` FOREIGN KEY (`BrandID`) REFERENCES `brands` (`BrandID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_market.products: ~0 rows (approximately)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

-- Dumping structure for table online_market.product_details
CREATE TABLE IF NOT EXISTS `product_details` (
  `ProductID` int(11) NOT NULL,
  `ProductDetailsTypeID` int(11) NOT NULL,
  `Value` varchar(50) NOT NULL,
  KEY `FK_Products_productDetails` (`ProductID`),
  KEY `FK_ProductDetails_ProductDetailType` (`ProductDetailsTypeID`),
  CONSTRAINT `FK_ProductDetails_ProductDetailType` FOREIGN KEY (`ProductDetailsTypeID`) REFERENCES `product_detail_types` (`Product_detail_typeID`),
  CONSTRAINT `FK_Products_productDetails` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_market.product_details: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;

-- Dumping structure for table online_market.product_detail_types
CREATE TABLE IF NOT EXISTS `product_detail_types` (
  `Product_detail_typeID` int(11) NOT NULL,
  `Name` int(11) DEFAULT NULL,
  PRIMARY KEY (`Product_detail_typeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_market.product_detail_types: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_detail_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_detail_types` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
