INSERT INTO hechos (id, nombre, valor) VALUES (1, 'preferencia', 'shopping');
INSERT INTO hechos (id, nombre, valor) VALUES (2, 'preferencia', 'travels');
INSERT INTO hechos (id, nombre, valor) VALUES (3, 'preferencia', 'help');
INSERT INTO hechos (id, nombre, valor) VALUES (4, 'preferencia', 'my business');
INSERT INTO hechos (id, nombre, valor) VALUES (5, 'preferencia', 'sports');
INSERT INTO hechos (id, nombre, valor) VALUES (6, 'preferencia', 'my style');

INSERT INTO hechos (id, nombre, valor) VALUES (7, 'salarioMinimo', '7000');
INSERT INTO hechos (id, nombre, valor) VALUES (8, 'salarioMinimo', '15000');
INSERT INTO hechos (id, nombre, valor) VALUES (9, 'salarioMinimo', '30000');
INSERT INTO hechos (id, nombre, valor) VALUES (10, 'salarioMinimo', '35000');
INSERT INTO hechos (id, nombre, valor) VALUES (11, 'salarioMinimo', '50000');
INSERT INTO hechos (id, nombre, valor) VALUES (12, 'salarioMinimo', '12000');

INSERT INTO hechos (id, nombre, valor) VALUES (13, 'salarioMaximo', '15000');
INSERT INTO hechos (id, nombre, valor) VALUES (14, 'salarioMaximo', '30000');
INSERT INTO hechos (id, nombre, valor) VALUES (15, 'salarioMaximo', '35000');
INSERT INTO hechos (id, nombre, valor) VALUES (16, 'salarioMaximo', '50000');
INSERT INTO hechos (id, nombre, valor) VALUES (17, 'salarioMaximo', 'infinito');

INSERT INTO hechos (id, nombre, valor) VALUES (18, 'edadMinima', '18');
INSERT INTO hechos (id, nombre, valor) VALUES (19, 'edadMinima', '24');
INSERT INTO hechos (id, nombre, valor) VALUES (20, 'edadMinima', '33');

INSERT INTO hechos (id, nombre, valor) VALUES (21, 'edadMaxima', '23');
INSERT INTO hechos (id, nombre, valor) VALUES (22, 'edadMaxima', '33');
INSERT INTO hechos (id, nombre, valor) VALUES (23, 'edadMaxima', '76');

INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(1, 'shopping1', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(2, 'shopping2', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(3, 'shopping3', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(4, 'shopping4', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(5, 'shopping5', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(6, 'shopping6', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(7, 'shopping7', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(8, 'shopping8', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(9, 'shopping9', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(10, 'shopping10', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(11, 'travels1', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(12, 'travels2', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(13, 'travels3', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(14, 'travels4', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(15, 'travels5', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(16, 'travels6', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(17, 'travels7', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(18, 'help1', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(19, 'my business1', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(20, 'sports1', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(21, 'sports2', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(22, 'my style1', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(23, 'my style2', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(24, 'my style3', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(25, 'my style4', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(26, 'my style5', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(27, 'my style6', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(28, 'my style7', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(29, 'my style8', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(30, 'my style9', 3);
INSERT INTO reglas (id, nombre, cantidad_hechos) VALUES(31, 'my style10', 3);

INSERT INTO conclusiones (id, valor) VALUES(1,'B+smart, Afinity Card');
INSERT INTO conclusiones (id, valor) VALUES(2,'B+smart, Clasica, Afinity Card, Office Depot, Costco, Beat Buy, Banamex, The Home Depot');
INSERT INTO conclusiones (id, valor) VALUES(3,'Clasica, Office Depot, Costco, Beat Buy, Banamex, The Home Depot');
INSERT INTO conclusiones (id, valor) VALUES(4,'Oro, Afinity Card, Office Depot, Costco, Beat Buy, Banamex, The Home Depot');
INSERT INTO conclusiones (id, valor) VALUES(5,'Oro, Office Depot, Costco, Beat Buy, Banamex, The Home Depot');
INSERT INTO conclusiones (id, valor) VALUES(6,'Platinum, Office Depot, Costco, Beat Buy, Banamex, The Home Depot');
INSERT INTO conclusiones (id, valor) VALUES(7,'Platinum');
INSERT INTO conclusiones (id, valor) VALUES(8,'Citi / Advantage');
INSERT INTO conclusiones (id, valor) VALUES(9,'Citi / Advantage, Platinum');
INSERT INTO conclusiones (id, valor) VALUES(10,'Banamex, Teleton, APAC');
INSERT INTO conclusiones (id, valor) VALUES(11,'Office Depot, Costco, Beat Buy, Banamex, The Home Depot');
INSERT INTO conclusiones (id, valor) VALUES(12,'Martí Clasica, Citibanamex, America Deporteismo, Pumas Deporteismo, Toluca Deporteismo, La verde Deporteismo');
INSERT INTO conclusiones (id, valor) VALUES(13,'Martí Premium, Citibanamex');
INSERT INTO conclusiones (id, valor) VALUES(14,'B+smart, Platinum');
INSERT INTO conclusiones (id, valor) VALUES(15,'B+smart, Afinity Card, Oro');
INSERT INTO conclusiones (id, valor) VALUES(16,'B+smart, Afinity Card, Platinum');
INSERT INTO conclusiones (id, valor) VALUES(17,'Oro');
INSERT INTO conclusiones (id, valor) VALUES(18,'B+smart');

-- #shopping1
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(1, 1);
--7ml - 15mil
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(1, 7);
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(1, 13);
-- #18 - 23
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(1, 18);
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(1, 21);

UPDATE reglas SET conclusion_id = 1 WHERE reglas.id=1;

-- #shopping2
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(2, 1);
-- #7ml - 15mil
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(2, 7);
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(2, 13);
-- #24 - 33
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(2, 19);
INSERT INTO regla_hecho(regla_id, hecho_id) VALUES(2, 22);

UPDATE reglas SET conclusion_id = 2  WHERE reglas.id=2;