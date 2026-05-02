CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(20),
    role ENUM('Admin','Seller','Buyer') NOT NULL
);
CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);
CREATE TABLE Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT,
    brand VARCHAR(100),
    stock INT DEFAULT 0,
    image VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);
CREATE TABLE `Order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2),
    status ENUM('Pending','Confirmed','Shipped','Delivered','Cancelled') DEFAULT 'Pending',
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);
CREATE TABLE Order_Item (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    order_id INT,
    price DECIMAL(10,2),
    quantity INT,
    FOREIGN KEY (product_id) REFERENCES Product(product_id),
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id)
);
