INSERT INTO User (Name, Email, Password, Role) VALUES
('Prasun Buddhacharya', 'winz.admin@example.com', 'adminpass', 'Admin'),
('Bob Seller', 'bob.seller@example.com', 'sellerpass', 'Seller'),
('Carol Buyer', 'carol.buyer@example.com', 'buyerpass', 'Buyer'),
('David Buyer', 'david.buyer@example.com', 'buyerpass', 'Buyer');

INSERT INTO Category (CategoryName) VALUES
('Rackets'),
('Shuttlecocks'),
('Shoes');

INSERT INTO Product (SellerID, CategoryID, Name, Description, Price) VALUES
(2, 1, 'Yonex Nanoray 10F', 'Lightweight badminton racket', 120.00),
(2, 2, 'Yonex Mavis 350', 'Durable nylon shuttlecock pack', 15.00),
(2, 3, 'Yonex Power Cushion', 'Badminton shoes with cushioning', 85.00);

INSERT INTO Cart (BuyerID) VALUES
(3),
(4);

INSERT INTO CartItem (CartID, ProductID, Quantity) VALUES
(1, 1, 1),  -- Carol adds 1 racket
(1, 2, 2),  -- Carol adds 2 shuttlecock packs
(2, 3, 1);  -- David adds 1 pair of shoes

INSERT INTO Orderrecord (BuyerID, OrderDate, Status, TotalAmount) VALUES
(3, '2026-04-09 10:30:00', 'Completed', 150.00),
(4, '2026-04-09 11:00:00', 'Pending', 85.00);

INSERT INTO OrderItem (OrderID, ProductID, Quantity, Price) VALUES
(1, 1, 1, 120.00),  -- Carol bought 1 racket
(1, 2, 2, 15.00),   -- Carol bought 2 shuttlecock packs
(2, 3, 1, 85.00);   -- David bought 1 pair of shoes

INSERT INTO Payment (OrderID, Amount, Method, Status, PaymentDate) VALUES
(1, 150.00, 'Credit Card', 'Paid', '2026-04-09 10:35:00'),
(2, 85.00, 'Cash on Delivery', 'Pending', NULL);
