CREATE TABLE t_orders (
                          id BIGSERIAL NOT NULL,
                          order_number VARCHAR(255) NOT NULL,
                          sku_code VARCHAR(255) DEFAULT NULL,
                          price DECIMAL(19, 2),
                          quantity INT,
                          PRIMARY KEY (id)
);


