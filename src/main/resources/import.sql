INSERT INTO clientes (nombre, apellido, email, create_at, password) VALUES ('Fulanito', 'Calle', 'a@a.com', '2023-12-20','$2a$12$eaU.tkPnOfAXkLSiprckd.GDjp/oKRSZM5HsPbLWOcM4aOM1Nr6F6');
INSERT INTO clientes (nombre, apellido, email, create_at, password) VALUES ('Pepito', 'Perez', 'pp@g.co', '2023-03-05','12345678');

INSERT INTO productos (STOCK, VALOR_UNITARIO, DESCRIPCION, NOMBRE, DESCUENTO) VALUES (10, 1000, 'Descripcion del Producto A', 'Producto A',0.2);
INSERT INTO productos (STOCK, VALOR_UNITARIO, DESCRIPCION, NOMBRE, DESCUENTO) VALUES (20, 2000, 'Descripcion del Producto B', 'Producto B',0.25);
INSERT INTO productos (STOCK, VALOR_UNITARIO, DESCRIPCION, NOMBRE, DESCUENTO) VALUES (0, 3000, 'Descripcion del Producto C', 'Producto C',0.3);

INSERT INTO encabezado (cliente_id, subtotal, fecha, total, descuento_total) VALUES (1, 100.50,'2023-07-10' ,1550, 0.225);
INSERT INTO encabezado (cliente_id, subtotal, fecha, total, descuento_total) VALUES (2, 0,'2023-07-11' ,0, 0);

INSERT INTO detalles (encabezado_id, producto_id, cantidad, valor) VALUES (1, 1, 1, 1000);
INSERT INTO detalles (encabezado_id, producto_id, cantidad, valor) VALUES (1, 2, 1, 1000);
