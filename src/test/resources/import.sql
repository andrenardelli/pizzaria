insert into SaborPizza values(1,'Alho e Oleo', 35.8);
insert into SaborPizza values(2,'Alicci', 40.2);
insert into SaborPizza values(3,'Americana', 37.2);
insert into SaborPizza values(4,'Baiana', 33);
insert into SaborPizza values(5,'Brasileira', 39.9);
insert into SaborPizza values(6,'Calabresa', 34.6);
insert into SaborPizza values(7,'Catupiry', 32.1);
insert into SaborPizza values(8,'Grega', 39);
insert into SaborPizza values(9,'Lombo com Cheddar', 42.3);
insert into SaborPizza values(10,'Alcachofra', 43.3);

insert into produto values ('S',1, 'Petit Gateau', 12.3);
insert into produto values ('S',2, 'Sorvete (1 bola)', 4.2);
insert into produto values ('S',3, 'Sorvete (2 bolas)', 6.7);
insert into produto values ('S',4, 'Torta Holandesa', 7.2);
insert into produto values ('S',5, 'Mousse de chocolate', 12.3);
insert into produto values ('S',6, 'Torta de Limao', 4.1);
insert into produto values ('S',7, 'Salada de Frutas', 3.6);

insert into produto values ('B',8, 'Guaraná', 5);
insert into produto values ('B',9, 'Coca-cola', 5);
insert into produto values ('B',10, 'Coca-cola Zero', 5);
insert into produto values ('B',11, 'Brahma 600ml', 8.8);
insert into produto values ('B',12, 'Original 600ml', 10.5);
insert into produto values ('B',13, 'Água sem Gás', 4.3);
insert into produto values ('B',14, 'H20', 5.4);

insert into usuario values ('loja','123');
insert into usuario values ('consumidor','123');
insert into consumidor values ('22222222222','Nardelli','consumidor');
insert into loja values ('Av. Paulista, 1','Pizzaria','loja');

insert into pedido values(2,null,'2015-01-01','consumidor');
insert into itempedido values(1,1,1,2);