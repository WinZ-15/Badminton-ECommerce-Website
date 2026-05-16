
INSERT INTO users (name, email, password, role, address, phone)
VALUES 
('Admin User', 'admin@gmail.com', 'admin123', 'admin', 'Kathmandu', '9800000000'),
('John Doe', 'john@gmail.com', 'password123', 'buyer', 'Pokhara', '9811111111'),
('Jane Smith', 'jane@gmail.com', 'password123', 'buyer', 'Lalitpur', '9822222222');

INSERT INTO categories (categoryName)
VALUES 
('High End Racket'),
('Mid End Racket'),
('Low End Racket'),
('High End Shuttlecock'),
('Mid End Shuttlecock'),
('Low End Shuttlecock');

INSERT INTO products (name, description, price, brand, image, categoryID)
VALUES 
('Yonex Astrox 100ZZ', 'Professional high-end racket', 250.0, 'Yonex', 'Resources/racket1.jpg', 1),
('Li-Ning Turbo X50', 'Mid range racket', 120.0, 'Li-Ning', 'Resources/racket2.jpg', 2),
('Generic Beginner Racket', 'Affordable starter racket', 40.0, 'Generic', 'Resources/racket3.jpg', 3),
('Yonex Aerosensa 50', 'High quality shuttlecock', 60.0, 'Yonex', 'Resources/shuttle1.jpg', 4),
('Li-Ning A+60', 'Mid range shuttlecock', 30.0, 'Li-Ning', 'Resources/shuttle2.jpg', 5),
('Practice Shuttle', 'Low cost shuttlecock', 10.0, 'Generic', 'Resources/shuttle3.jpg', 6);

INSERT INTO orders (userID, totalAmount, status)
VALUES 
(2, 520.0, 'COMPLETED'),
(3, 150.0, 'PENDING');

INSERT INTO orderItems (orderID, productID, quantity, subtotal)
VALUES 
(1, 1, 1, 500.0),
(1, 3, 1, 20.0),
(2, 5, 1, 150.0);