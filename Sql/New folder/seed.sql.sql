INSERT INTO Customer (name, email, password, address, phone, role)
VALUES 
('Admin User', 'admin@badminton.com', 'admin123', 'Pokhara, Nepal', '9800000000', 'Admin'),
('Seller One', 'seller@badminton.com', 'seller123', 'Kathmandu, Nepal', '9811111111', 'Seller'),
('Buyer One', 'buyer@badminton.com', 'buyer123', 'Pokhara, Nepal', '9822222222', 'Buyer');

INSERT INTO Category (category_name)
VALUES 
('Rackets'),
('Shuttlecocks');

INSERT INTO Product (category_id, brand, stock, image, price, name, description)
VALUES 
(1, 'Yonex', 50, 'yonex_racket.jpg', 120.00, 'Yonex Nanoray 10', 'Lightweight racket for beginners'),
(1, 'Li-Ning', 30, 'lining_racket.jpg', 150.00, 'Li-Ning Turbo X', 'Professional grade racket'),
(2, 'Yonex', 100, 'mavis_shuttle.jpg', 20.00, 'Yonex Mavis 350', 'Durable nylon shuttlecock'),
(2, 'Victor', 80, 'victor_shuttle.jpg', 18.00, 'Victor Champion No.1', 'Feather shuttlecock for tournaments');

INSERT INTO `Order` (customer_id, total_amount, status)
VALUES 
(3, 140.00, 'Confirmed'),
(3, 20.00, 'Pending');

INSERT INTO Order_Item (product_id, order_id, price, quantity)
VALUES 
(1, 1, 120.00, 1),   -- Buyer ordered Yonex racket
(3, 1, 20.00, 1),    -- Buyer ordered Mavis shuttlecock
(4, 2, 18.00, 1);    -- Buyer ordered Victor shuttlecock
