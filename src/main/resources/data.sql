insert into ingredientes (id, dosagem, ingrediente, quantidade) values (1,'ML','Corote','500');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (2,'Unidade','Gelo de coco','1');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (3,'Unidade','Suco ','1');
insert into drink (ID, NOME, MODO_PREPARO) values (1, 'Chevette', 'Mistura Tudo');
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (1,1);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (1,2);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (1,3);

insert into ingredientes (id, dosagem, ingrediente, quantidade) values (4,'ML','Whisky JackDaniels','500');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (5,'Unidade','Gelo de coco','1');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (6,'Unidade','Suco ','1');
insert into drink (ID, NOME, MODO_PREPARO) values (2, 'MaracuWhisky', 'Mistura tudo');
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (2,4);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (2,5);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (2,6);
commit;
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (7,'ML','Vodka Absolute','200');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (8,'Unidade','Morangos','5');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (9,'Colheres de Chá','Suco ','3');
insert into drink (ID, NOME, MODO_PREPARO) values (3, 'Caipirinha de Morango', 'Mistura tudo');
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (3,7);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (3,8);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (3,9);
/*
insert into COMBO_BOX_DOSAGEM (id, tipo) values (null, 'ML');
insert into COMBO_BOX_DOSAGEM (id, tipo) values (null, 'DOSES');
insert into COMBO_BOX_DOSAGEM (id, tipo) values (null, 'LITROS');
insert into COMBO_BOX_DOSAGEM (id, tipo) values (null, 'UNIDADES');
commit;
*/