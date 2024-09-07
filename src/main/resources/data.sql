
insert into autor values(1,'fulanito juan', 'mamani', 'perez', '1994-12-31', 'Bolivia', 'example@gmail.com');
insert into autor values(2,'cecilia', 'chacra', 'perez', '1990-12-31', 'Bolivia', 'cecilia@gmail.com');
insert into autor values(3,'ricardo', 'flores', 'ticona', '1990-08-01', 'Bolivia', 'ricardo@gmail.com');

insert into BLOG (ID, TITULO, TEMA, CONTENIDO, PERIODICIDAD, PERMITE_COMENTARIOS, AUTOR_ID, FECHA_CREACION)
values (1, 'El pais de las maravillas','Lapaz la ciudad del illimani','La Paz, La Habana, Beirut, Doha, Durban, Kuala Lumpur y Vigan (Filipinas) fueron elegidas como ciudades maravillas del mundo','DIARIA',true,'1',CURRENT_TIMESTAMP());

insert into PUBLIC.COMENTARIO (ID, NOMBRE, CORREO, PAIS_RESIDENCIA, COMENTARIO, PUNTUACION, FECHA_PUBLICACION, BLOG_ID)
values (1, 'pepe aguilar', 'pepe@gmail.com','Brasil','Que buen blog',8, CURRENT_TIMESTAMP(),'1');
commit ;