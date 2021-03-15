insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'ML','Corote','500');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'Unidade','Gelo de coco','1');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'Unidade','Suco ','1');
insert into drink (ID, NOME, MODO_PREPARO) values (null, 'Chevette', 'Mistura Tudo');
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (1,1);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (1,2);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (1,3);

insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'ML','Whisky JackDaniels','500');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'Unidade','Gelo de coco','1');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'Unidade','Suco ','1');
insert into drink (ID, NOME, MODO_PREPARO) values (null, 'MaracuWhisky', 'Mistura tudo');
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (2,4);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (2,5);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (2,6);
commit;
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'ML','Vodka Absolute','200');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'Unidade','Morangos','5');
insert into ingredientes (id, dosagem, ingrediente, quantidade) values (null,'Colheres de Chá','Suco ','3');
insert into drink (ID, NOME, MODO_PREPARO) values (null, 'Caipirinha de Morango', 'Mistura tudo');
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (3,7);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (3,8);
insert into DRINK_INGREDIENTES(DRINK_ENTITY_ID,INGREDIENTES_ID) values (3,9);

commit;