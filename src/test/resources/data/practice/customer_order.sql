INSERT INTO customer (id, age, joined, name, email)
VALUES
    (1, 30, '2021-05-21', 'John Doe', 'john@example.com'),
    (2, 35, '2021-11-15', 'Jane Doe', 'jane@example.com'),
    (3, 25, '2021-02-03', 'Bob Smith', 'bob@example.com'),
    (4, 40, '2021-09-10', 'Alice Johnson', 'alice@example.com');

INSERT INTO orders (id, customer_id, product, amount, sales_date)
VALUES
    (1, 1, 'Laptop', 1000, '2023-10-05'),
    (2, 2, 'Smartphone', 800, '2023-10-08'),
    (3, 3, 'Headphones', 120, '2023-10-10'),
    (4, 4, 'Tablet', 500, '2023-10-12'),
    (5, 1, 'Digital Camera', 700, '2023-10-15'),
    (6, 2, 'Gaming Console', 1200, '2023-10-18'),
    (7, 3, 'Fitness Tracker', 80, '2023-10-20'),
    (8, 4, 'Bluetooth Speaker', 150, '2023-10-22'),
    (9, 1, 'E-book Reader', 90, '2023-10-25'),
    (10, 2, 'Wireless Earbuds', 100, '2023-10-28'),
    (11, 3, 'External Hard Drive', 200, '2023-11-02'),
    (12, 4, '4K Monitor', 800, '2023-11-05'),
    (13, 1, 'Smart Watch', 250, '2023-11-08'),
    (14, 2, 'Tablet Stand', 30, '2023-11-11'),
    (15, 3, 'Wireless Mouse', 50, '2023-11-14'),
    (16, 4, 'Home Printer', 300, '2023-11-18'),
    (17, 1, 'Mini Projector', 200, '2023-11-22'),
    (18, 2, 'External SSD', 150, '2023-11-26'),
    (19, 3, 'Gaming Mousepad', 20, '2023-11-30'),
    (20, 4, 'Smart Thermostat', 120, '2023-12-04');