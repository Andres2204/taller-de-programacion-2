INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Fulanito', 'Calle', 'fc@g.com', '2023-12-20');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Pepito', 'Perez', 'pp@g.co', '2023-03-05');

INSERT INTO productos (STOCK, VALOR_UNITARIO, DESCRIPCION, NOMBRE) VALUES (10, 1000, 'Descripcion del Producto A', 'Producto A');

INSERT INTO productos (STOCK, VALOR_UNITARIO, DESCRIPCION, NOMBRE) VALUES (20, 2000, 'Descripcion del Producto B', 'Producto B');

INSERT INTO encabezado (cliente_id, subtotal, fecha, total, descuento_total) VALUES (1, 100.50,'2023-07-10' ,120.60, 20.10);

INSERT INTO detalles (encabezado_id, producto_id, cantidad, valor, descuento) VALUES (1, 1, 10, 1000.00, 50.00);
INSERT INTO detalles (encabezado_id, producto_id, cantidad, valor, descuento) VALUES (1, 2, 10, 1000.00, 50.00);
