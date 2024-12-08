drop database floriano;
create database floriano;
use floriano;




create table rol(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int  ,
    id_usuario_modificacion int  ,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

insert into rol(nombre,id_usuario_creacion,id_usuario_modificacion)
values ('ADMINISTRADOR',1,1);



create table usuario(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    email varchar(255) not null unique,
	password varchar(255) not null,
	id_rol int not null,
    activo TINYINT(1) not null default(1),
    id_usuario_creacion int  ,
    id_usuario_modificacion int  ,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

insert into usuario(nombre, email,id_usuario_creacion,id_usuario_modificacion, password, id_rol)
values ('Admin','admin@jagfloriano.com',1,1,'password', 1);

alter table usuario modify column id_usuario_creacion int not null;
alter table usuario modify column id_usuario_modificacion int not null;
alter table usuario add foreign key fk_usuario_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table usuario add foreign key fk_usuario_usuario_modificacion (id_usuario_modificacion) references usuario(id);
alter table usuario add foreign key fk_usuario_rol (id_rol) references rol(id);

alter table rol add foreign key fk_rol_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table rol add foreign key fk_rol_usuario_modificacion (id_usuario_modificacion) references usuario(id);




create table empresa(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    web varchar(255),
    logo varchar(255),
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table empresa add foreign key fk_empresa_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table empresa add foreign key fk_empresa_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into empresa (nombre,id_usuario_creacion, id_usuario_modificacion) values 
('Tata Consultancy Services',1,1),
('Ibertech IT Services',1,1),
('Orange España',1,1),
('JOIN-MARKETING LTD',1,1),
('The Colonnade Hotel',1,1),
('Capgemini',1,1);

create table institucion_educativa(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    url varchar(255)  null ,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table institucion_educativa add foreign key fk_institucion_educativa_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table institucion_educativa add foreign key fk_institucion_educativa_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into institucion_educativa ( nombre, url,id_usuario_creacion,id_usuario_modificacion) values
('RedHat Acredited Professional','www.redhat.com',1,1),
('INCIBE','www.incibe.es',1,1),
('Universidad Complutense de Madrid','www.ucm.es',1,1),
('Colegio Sagrada Familia El Pilar','safapi.com',1,1);



create table curso(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    id_institucion_educativa int  null ,
    duracion int null ,
    fecha datetime  null,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table curso add foreign key fk_curso_institucion_educativa (id_institucion_educativa) references institucion_educativa(id);
alter table curso add foreign key fk_curso_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table curso add foreign key fk_curso_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into curso ( nombre, id_usuario_creacion, id_usuario_modificacion) values 
('Administración de Aplicaciones JBoss',1,1),
('Entrenamiento para la Certificación de Red Hat RHCSA',1,1),
('Agile for Beginners',1,1),
('Agile E1',1,1),
('Iniciación en programacón Java',1,1);

insert into curso ( nombre,id_institucion_educativa, id_usuario_creacion, id_usuario_modificacion) values 
('Red Hat Ansible Engine Implementation',(select id from institucion_educativa where nombre = 'Red Hat Acredited Professional') ,1,1),
('Red Hat Delivery Specialist - Automation',(select id from institucion_educativa where nombre = 'Red Hat Acredited Professional') ,1,1),
('Red Hat Delivery Specialist - Automation (ISV)',(select id from institucion_educativa where nombre = 'Red Hat Acredited Professional') ,1,1),
('Red Hat Ansible Automation for Microsoft Windows',(select id from institucion_educativa where nombre = 'Red Hat Acredited Professional') ,1,1),
('Automated SAP HANA System Replication with Pacemaker on Red Hat Enterprise Linux',(select id from institucion_educativa where nombre = 'Red Hat Acredited Professional') ,1,1),
('Curso de ciberseguridad',(select id from institucion_educativa where nombre = 'INCIBE') ,1,1);


create table certificacion(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    certificate_number varchar(255) not null unique,
    url varchar(255)  null ,
    imagen varchar(255)  null ,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table certificacion add foreign key fk_certificacion_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table certificacion add foreign key fk_certificacion_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into certificacion(nombre, certificate_number, url, imagen, id_usuario_creacion, id_usuario_modificacion) values
('Red Hat Certified System Administrator (RHCSA RHEL 9)','220-211-338','https://rhtapps.redhat.com/verify?certId=220-211-338','220-211-338.png',1,1),
('Itil V4 - ITIL® Foundation Certificate in IT Service Management ','GR671140039JG','https://candidate.peoplecert.org/CertCheck.aspx','GR671140039JG.png',1,1),
('Microsoft MTA - Networking Fundamentals','98-366. F716-3862',null,'F716-3862.png',1,1);

create table pais(
	id INT  not null auto_increment primary key,
    codigo_ine int not null unique,
    nombre varchar(255) not null unique,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table pais add foreign key fk_pais_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table pais add foreign key fk_pais_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into pais(codigo_ine,nombre,id_usuario_creacion,id_usuario_modificacion)values
(102,'Austria',1,1),
(103,'Bélgica',1,1),
(104,'Bulgaria',1,1),
(106,'Chipre',1,1),
(107,'Dinamarca',1,1),
(108,'España',1,1),
(109,'Finlandia',1,1),
(110,'Francia',1,1),
(111,'Grecia',1,1),
(112,'Hungría',1,1),
(113,'Irlanda',1,1),
(115,'Italia',1,1),
(117,'Luxemburgo',1,1),
(118,'Malta',1,1),
(121,'Países Bajos',1,1),
(122,'Polonia',1,1),
(123,'Portugal',1,1),
(126,'Alemania',1,1),
(128,'Rumanía',1,1),
(131,'Suecia',1,1),
(136,'Letonia',1,1),
(141,'Estonia',1,1),
(142,'Lituania',1,1),
(143,'República Checa',1,1),
(144,'República Eslovaca',1,1),
(146,'Croacia',1,1),
(147,'Eslovenia',1,1),
(101,'Albania',1,1),
(114,'Islandia',1,1),
(116,'Liechtenstein',1,1),
(119,'Mónaco',1,1),
(120,'Noruega',1,1),
(124,'Andorra',1,1),
(125,'Reino Unido',1,1),
(129,'San Marino',1,1),
(130,'Santa Sede',1,1),
(132,'Suiza',1,1),
(135,'Ucrania',1,1),
(137,'Moldavia',1,1),
(138,'Belarús',1,1),
(139,'Georgia',1,1),
(145,'Bosnia y Herzegovina',1,1),
(148,'Armenia',1,1),
(154,'Rusia',1,1),
(156,'Macedonia del Norte',1,1),
(157,'Serbia',1,1),
(158,'Montenegro',1,1),
(436,'Turquía',1,1),
(199,'Otros países de Europa',1,1),
(201,'Burkina Faso',1,1),
(202,'Angola',1,1),
(203,'Argelia',1,1),
(204,'Benin',1,1),
(205,'Botswana',1,1),
(206,'Burundi',1,1),
(207,'Cabo Verde',1,1),
(208,'Camerún',1,1),
(209,'Comores',1,1),
(210,'Congo',1,1),
(211,'Costa de Marfil',1,1),
(212,'Djibouti',1,1),
(213,'Egipto',1,1),
(214,'Etiopía',1,1),
(215,'Gabón',1,1),
(216,'Gambia',1,1),
(217,'Ghana',1,1),
(218,'Guinea',1,1),
(219,'Guinea-Bissau',1,1),
(220,'Guinea Ecuatorial',1,1),
(221,'Kenia',1,1),
(222,'Lesotho',1,1),
(223,'Liberia',1,1),
(224,'Libia',1,1),
(225,'Madagascar',1,1),
(226,'Malawi',1,1),
(227,'Mali',1,1),
(228,'Marruecos',1,1),
(229,'Mauricio',1,1),
(230,'Mauritania',1,1),
(231,'Mozambique',1,1),
(232,'Namibia',1,1),
(233,'Níger',1,1),
(234,'Nigeria',1,1),
(235,'República Centroafricana',1,1),
(236,'Sudáfrica',1,1),
(237,'Ruanda',1,1),
(238,'Santo Tomé y Príncipe',1,1),
(239,'Senegal',1,1),
(240,'Seychelles',1,1),
(241,'Sierra Leona',1,1),
(242,'Somalia',1,1),
(243,'Sudán',1,1),
(244,'Swazilandia',1,1),
(245,'Tanzania',1,1),
(246,'Chad',1,1),
(247,'Togo',1,1),
(248,'Túnez',1,1),
(249,'Uganda',1,1),
(250,'República Democrática del Congo',1,1),
(251,'Zambia',1,1),
(252,'Zimbabwe',1,1),
(253,'Eritrea',1,1),
(254,'Sudán del Sur',1,1),
(299,'Otros países de África',1,1),
(301,'Canadá',1,1),
(302,'Estados Unidos de América',1,1),
(303,'México',1,1),
(310,'Antigua y Barbuda',1,1),
(311,'Bahamas',1,1),
(312,'Barbados',1,1),
(313,'Belice',1,1),
(314,'Costa Rica',1,1),
(315,'Cuba',1,1),
(316,'Dominica',1,1),
(317,'El Salvador',1,1),
(318,'Granada',1,1),
(319,'Guatemala',1,1),
(320,'Haití',1,1),
(321,'Honduras',1,1),
(322,'Jamaica',1,1),
(323,'Nicaragua',1,1),
(324,'Panamá',1,1),
(325,'San Vicente y las Granadinas',1,1),
(326,'República Dominicana',1,1),
(327,'Trinidad y Tobago',1,1),
(328,'Santa Lucía',1,1),
(329,'San Cristóbal y Nieves',1,1),
(340,'Argentina',1,1),
(341,'Bolivia',1,1),
(342,'Brasil',1,1),
(343,'Colombia',1,1),
(344,'Chile',1,1),
(345,'Ecuador',1,1),
(346,'Guyana',1,1),
(347,'Paraguay',1,1),
(348,'Perú',1,1),
(349,'Surinam',1,1),
(350,'Uruguay',1,1),
(351,'Venezuela',1,1),
(399,'Otros países de América',1,1),
(401,'Afganistán',1,1),
(402,'Arabia Saudí',1,1),
(403,'Bahréin',1,1),
(404,'Bangladesh',1,1),
(405,'Myanmar',1,1),
(407,'China',1,1),
(408,'Emiratos Árabes Unidos',1,1),
(409,'Filipinas',1,1),
(410,'India',1,1),
(411,'Indonesia',1,1),
(412,'Iraq',1,1),
(413,'Irán',1,1),
(414,'Israel',1,1),
(415,'Japón',1,1),
(416,'Jordania',1,1),
(417,'Camboya',1,1),
(418,'Kuwait',1,1),
(419,'Laos',1,1),
(420,'Líbano',1,1),
(421,'Malasia',1,1),
(422,'Maldivas',1,1),
(423,'Mongolia',1,1),
(424,'Nepal',1,1),
(425,'Omán',1,1),
(426,'Pakistán',1,1),
(427,'Qatar',1,1),
(430,'Corea',1,1),
(431,'Corea del Norte',1,1),
(432,'Singapur',1,1),
(433,'Siria',1,1),
(434,'Sri Lanka',1,1),
(435,'Tailandia',1,1),
(437,'Vietnam',1,1),
(439,'Brunei',1,1),
(440,'Islas Marshall',1,1),
(441,'Yemen',1,1),
(442,'Azerbaiyán',1,1),
(443,'Kazajstán',1,1),
(444,'Kirguistán',1,1),
(445,'Tayikistán',1,1),
(446,'Turkmenistán',1,1),
(447,'Uzbekistán',1,1),
(448,'Bhután',1,1),
(449,'Palestina. Estado Observador, no miembro de Naciones Unidas',1,1),
(499,'Otros países de Asia',1,1),
(501,'Australia',1,1),
(502,'Fiji',1,1),
(504,'Nueva Zelanda',1,1),
(505,'Papúa Nueva Guinea',1,1),
(506,'Islas Salomón',1,1),
(507,'Samoa',1,1),
(508,'Tonga',1,1),
(509,'Vanuatu',1,1),
(511,'Micronesia',1,1),
(512,'Tuvalu',1,1),
(513,'Islas Cook',1,1),
(514,'Kiribati',1,1),
(515,'Nauru',1,1),
(516,'Palaos',1,1),
(517,'Timor Oriental',1,1),
(599,'Otros países de Oceanía',1,1);

create table comunidad_autonoma(
	id INT  not null auto_increment primary key,
    codigo_ine int not null unique,
    nombre varchar(255) not null unique,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table comunidad_autonoma add foreign key fk_comunidad_autonoma_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table comunidad_autonoma add foreign key fk_comunidad_autonoma_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into comunidad_autonoma(codigo_ine,nombre,id_usuario_creacion,id_usuario_modificacion)values
(1,'Andalucía',1,1),
(2,'Aragón',1,1),
(3,'Asturias, Principado de',1,1),
(4,'Balears, Illes',1,1),
(5,'Canarias',1,1),
(6,'Cantabria',1,1),
(7,'Castilla y León',1,1),
(8,'Castilla - La Mancha',1,1),
(9,'Cataluña',1,1),
(10,'Comunitat Valenciana',1,1),
(11,'Extremadura',1,1),
(12,'Galicia',1,1),
(13,'Madrid, Comunidad de',1,1),
(14,'Murcia, Región de',1,1),
(15,'Navarra, Comunidad Foral de',1,1),
(16,'País Vasco',1,1),
(17,'Rioja, La',1,1),
(18,'Ceuta',1,1),
(19,'Melilla',1,1);


create table provincia(
	id INT  not null auto_increment primary key,
    id_comunidad_autonoma int not null,
    codigo_ine int not null unique,
    nombre varchar(255) not null unique,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table provincia add foreign key fk_provincia_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table provincia add foreign key fk_provincia_usuario_modificacion (id_usuario_modificacion) references usuario(id);
alter table provincia add foreign key fk_provincia_comunidad_autonoma (id_comunidad_autonoma) references comunidad_autonoma(id);

insert into provincia(id_comunidad_autonoma, codigo_ine,nombre,id_usuario_creacion, id_usuario_modificacion) values
((select id from comunidad_autonoma where codigo_ine =1),4,'Almería',1,1),
((select id from comunidad_autonoma where codigo_ine =1),11,'Cádiz',1,1),
((select id from comunidad_autonoma where codigo_ine =1),14,'Córdoba',1,1),
((select id from comunidad_autonoma where codigo_ine =1),18,'Granada',1,1),
((select id from comunidad_autonoma where codigo_ine =1),21,'Huelva',1,1),
((select id from comunidad_autonoma where codigo_ine =1),23,'Jaén',1,1),
((select id from comunidad_autonoma where codigo_ine =1),29,'Málaga',1,1),
((select id from comunidad_autonoma where codigo_ine =1),41,'Sevilla',1,1),
((select id from comunidad_autonoma where codigo_ine =2),22,'Huesca',1,1),
((select id from comunidad_autonoma where codigo_ine =2),44,'Teruel',1,1),
((select id from comunidad_autonoma where codigo_ine =2),50,'Zaragoza',1,1),
((select id from comunidad_autonoma where codigo_ine =3),33,'Asturias',1,1),
((select id from comunidad_autonoma where codigo_ine =4),7,'Balears, Illes',1,1),
((select id from comunidad_autonoma where codigo_ine =5),35,'Palmas, Las',1,1),
((select id from comunidad_autonoma where codigo_ine =5),38,'Santa Cruz de Tenerife',1,1),
((select id from comunidad_autonoma where codigo_ine =6),39,'Cantabria',1,1),
((select id from comunidad_autonoma where codigo_ine =7),5,'Ávila',1,1),
((select id from comunidad_autonoma where codigo_ine =7),9,'Burgos',1,1),
((select id from comunidad_autonoma where codigo_ine =7),24,'León',1,1),
((select id from comunidad_autonoma where codigo_ine =7),34,'Palencia',1,1),
((select id from comunidad_autonoma where codigo_ine =7),37,'Salamanca',1,1),
((select id from comunidad_autonoma where codigo_ine =7),40,'Segovia',1,1),
((select id from comunidad_autonoma where codigo_ine =7),42,'Soria',1,1),
((select id from comunidad_autonoma where codigo_ine =7),47,'Valladolid',1,1),
((select id from comunidad_autonoma where codigo_ine =7),49,'Zamora',1,1),
((select id from comunidad_autonoma where codigo_ine =8),2,'Albacete',1,1),
((select id from comunidad_autonoma where codigo_ine =8),13,'Ciudad Real',1,1),
((select id from comunidad_autonoma where codigo_ine =8),16,'Cuenca',1,1),
((select id from comunidad_autonoma where codigo_ine =8),19,'Guadalajara',1,1),
((select id from comunidad_autonoma where codigo_ine =8),45,'Toledo',1,1),
((select id from comunidad_autonoma where codigo_ine =9),8,'Barcelona',1,1),
((select id from comunidad_autonoma where codigo_ine =9),17,'Girona',1,1),
((select id from comunidad_autonoma where codigo_ine =9),25,'Lleida',1,1),
((select id from comunidad_autonoma where codigo_ine =9),43,'Tarragona',1,1),
((select id from comunidad_autonoma where codigo_ine =10),3,'Alicante/Alacant',1,1),
((select id from comunidad_autonoma where codigo_ine =10),12,'Castellón/Castelló',1,1),
((select id from comunidad_autonoma where codigo_ine =10),46,'Valencia/València',1,1),
((select id from comunidad_autonoma where codigo_ine =11),6,'Badajoz',1,1),
((select id from comunidad_autonoma where codigo_ine =11),10,'Cáceres',1,1),
((select id from comunidad_autonoma where codigo_ine =12),15,'Coruña, A',1,1),
((select id from comunidad_autonoma where codigo_ine =12),27,'Lugo',1,1),
((select id from comunidad_autonoma where codigo_ine =12),32,'Ourense',1,1),
((select id from comunidad_autonoma where codigo_ine =12),36,'Pontevedra',1,1),
((select id from comunidad_autonoma where codigo_ine =13),28,'Madrid',1,1),
((select id from comunidad_autonoma where codigo_ine =14),30,'Murcia',1,1),
((select id from comunidad_autonoma where codigo_ine =15),31,'Navarra',1,1),
((select id from comunidad_autonoma where codigo_ine =16),1,'Araba/Álava',1,1),
((select id from comunidad_autonoma where codigo_ine =16),48,'Bizkaia',1,1),
((select id from comunidad_autonoma where codigo_ine =16),20,'Gipuzkoa',1,1),
((select id from comunidad_autonoma where codigo_ine =17),26,'Rioja, La',1,1);


create table municipio(
	id INT  not null auto_increment primary key,
    id_provincia int not null,
    codigo_ine int not null ,
    dc int not null ,
    nombre varchar(255) not null ,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table municipio add foreign key fk_municipio_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table municipio add foreign key fk_municipio_usuario_modificacion (id_usuario_modificacion) references usuario(id);
alter table municipio add foreign key fk_municipio_provincia (id_provincia) references provincia(id);


create table trabajo(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null ,
    id_empresa int not null,
    fecha_inicio date not null,
    fecha_fin date,
    id_pais int not null,
    id_comunidad_autonoma int,
    id_provincia int,
    id_municipio int,
    otra_ubicacion varchar(255),
    observaciones varchar(2555),
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table trabajo add foreign key fk_trabajo_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table trabajo add foreign key fk_trabajo_usuario_modificacion (id_usuario_modificacion) references usuario(id);
alter table trabajo add foreign key fk_trabajo_empresa (id_empresa) references empresa(id);
alter table trabajo add foreign key fk_trabajo_pais (id_pais) references pais(id);
alter table trabajo add foreign key fk_trabajo_comunidad_autonoma (id_comunidad_autonoma) references comunidad_autonoma(id);
alter table trabajo add foreign key fk_trabajo_provincia (id_provincia) references provincia(id);
alter table trabajo add foreign key fk_trabajo_municipio (id_municipio) references municipio(id);




create table trabajo_tarea(
	id INT  not null auto_increment primary key,
    id_trabajo int not null,
    nombre varchar(1255) not null,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table trabajo_tarea add foreign key fk_trabajo_tarea_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table trabajo_tarea add foreign key fk_trabajo_tarea_usuario_modificacion (id_usuario_modificacion) references usuario(id);
alter table trabajo_tarea add foreign key fk_trabajo_tarea_trabajo (id_trabajo) references trabajo(id);



create table habilidad(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table habilidad add foreign key fk_habilidad_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table habilidad add foreign key fk_habilidad_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into habilidad(nombre,id_usuario_creacion,id_usuario_modificacion)values
('Inglés',1,1),
('Gestión de usuarios',1,1),
('Protocolo seguro de transferenciade archivos',1,1),
('Seguridad',1,1),
('Interacción con el cliente',1,1);

create table trabajo_habilidad(
	id INT  not null auto_increment primary key,
    id_trabajo int not null ,
    id_habilidad int not null ,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table trabajo_habilidad add foreign key fk_trabajo_habilidad_creacion (id_usuario_creacion) references usuario(id);
alter table trabajo_habilidad add foreign key fk_trabajo_habilidad_usuario_modificacion (id_usuario_modificacion) references usuario(id);
alter table trabajo_habilidad add foreign key fk_trabajo_habilidad_trabajo (id_trabajo) references trabajo(id);
alter table trabajo_habilidad add foreign key fk_trabajo_habilidad_habilidad(id_habilidad) references habilidad(id);




insert  into trabajo(nombre , id_empresa, fecha_inicio, fecha_fin,id_pais, id_comunidad_autonoma, id_provincia, id_municipio,otra_ubicacion,
observaciones,id_usuario_creacion,id_usuario_modificacion)
values('Kitchen porter',(select id from empresa where nombre='The Colonnade Hotel'), '2013-09-01','2014-02-01',(select id from pais where 
codigo_ine = 125),null,null,null, 'Londres',
'Kitchen Porter (Ayudante/ Pinche de cocina). Limpieza de las instalaciones y material de cocina. Preparación de comidas y organización del stock. ',
1,1);

insert  into trabajo(nombre , id_empresa, fecha_inicio, fecha_fin,id_pais, id_comunidad_autonoma, id_provincia, id_municipio,otra_ubicacion,
observaciones,id_usuario_creacion,id_usuario_modificacion)
values('Teleoperador Comercial',(select id from empresa where nombre='JOIN-MARKETING LTD'), '2014-04-01','2014-06-01',(select id from pais where 
codigo_ine = 108),(select id from comunidad_autonoma where codigo_ine = 3),(select id from provincia where codigo_ine = 33),
(select id from municipio where nombre = 'Oviedo'), null,
'Teleoperador captador de clientes para campaña de fidelización de Jazztel',
1,1);

insert  into trabajo(nombre , id_empresa, fecha_inicio, fecha_fin,id_pais, id_comunidad_autonoma, id_provincia, id_municipio,otra_ubicacion,
observaciones,id_usuario_creacion,id_usuario_modificacion)
values('Teleoperador Técnico',(select id from empresa where nombre='Orange España'), '2015-02-01','2015-07-01',(select id from pais where 
codigo_ine = 108),(select id from comunidad_autonoma where codigo_ine = 3),(select id from provincia where codigo_ine = 33),
(select id from municipio where nombre = 'Oviedo'), null,
'Teleoperador con perfil técnico y atención al cliente en departamento de atención preferente “Tu Experto Orange”.',
1,1);

insert  into trabajo(nombre , id_empresa, fecha_inicio, fecha_fin,id_pais, id_comunidad_autonoma, id_provincia, id_municipio,otra_ubicacion,
observaciones,id_usuario_creacion,id_usuario_modificacion)
values('Tecnico de explotación de aplicaciones OSS',(select id from empresa where nombre='Capgemini'), '2017-04-01','2019-06-01',(select id from pais where 
codigo_ine = 108),(select id from comunidad_autonoma where codigo_ine = 3),(select id from provincia where codigo_ine = 33),
null, null,
'Servicio N2 (24x7) de Explotación de Aplicaciones OSS (Operations Support Systems) para Telefónica bajo los dominios funcionales correspondientes con los procesos de Negocio: "Mantenimiento de SdR" y "Supervisión y Operación de SdR" (Procesos de Red).',
1,1);

insert  into trabajo(nombre , id_empresa, fecha_inicio, fecha_fin,id_pais, id_comunidad_autonoma, id_provincia, id_municipio,otra_ubicacion,
observaciones,id_usuario_creacion,id_usuario_modificacion)
values('Adminsitrador de sistemas Middleware',(select id from empresa where nombre='Ibertech IT Services'), '2019-06-01','2019-07-01',(select id from pais where 
codigo_ine = 108),(select id from comunidad_autonoma where codigo_ine = 3),(select id from provincia where codigo_ine = 33),
(select id from municipio where nombre = 'Oviedo'), null,
'Técnico Administrador de sistemas de TIC para el CGSI (Centro de Gestión de Servicios Informáticos) del Principado de Asturias, como parte del Lote C, equipo encargado de la ejecución de tareas necesarias para el lanzamiento de aplicaciones y versiones incluyendo las de fase test. Instalación y parametrización de todo el software necesario para el correcto funcionamiento de los Sistemas de Información. Todo ello bajo la participación activa en los procesos ITIL v3.',
1,1);

insert  into trabajo(nombre , id_empresa, fecha_inicio, fecha_fin,id_pais, id_comunidad_autonoma, id_provincia, id_municipio,otra_ubicacion,
observaciones,id_usuario_creacion,id_usuario_modificacion)
values('Senior SYSADMIN',(select id from empresa where nombre='Tata Consultancy Services'), '2019-07-01',null,(select id from pais where 
codigo_ine = 108),(select id from comunidad_autonoma where codigo_ine = 13),(select id from provincia where codigo_ine = 28),
(select id from municipio where nombre = 'Madrid'), null,
'Líder técnico de un equipo de 12 personas, dentro del proyecto: "Linux Manage Service Roche Pharma", encargado de la ejecución de tareas necesarias para el mantenimiento, actualización de sistemas basados en RHEL así como troubleshooting y housekeeping de incidencias de servicio. Todo ello bajo la participación activa en los procesos ITIL v4.',
1,1);


insert into trabajo_habilidad(id_trabajo, id_habilidad, id_usuario_creacion,id_usuario_modificacion)
values ((select id from trabajo where nombre = 'Kitchen porter'), (select id from habilidad where nombre = 'Inglés'),1,1 ),
((select id from trabajo where nombre = 'Teleoperador Comercial'), (select id from habilidad where nombre = 'Gestión de usuarios'),1,1 ),
((select id from trabajo where nombre = 'Teleoperador Comercial'), (select id from habilidad where nombre = 'Interacción con el cliente'),1,1 ),
((select id from trabajo where nombre = 'Teleoperador Técnico'), (select id from habilidad where nombre = 'Gestión de usuarios'),1,1 ),
((select id from trabajo where nombre = 'Teleoperador Técnico'), (select id from habilidad where nombre = 'Seguridad'),1,1 ),
((select id from trabajo where nombre = 'Teleoperador Técnico'), (select id from habilidad where nombre = 'Protocolo seguro de transferenciade archivos'),1,1 ),
((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), (select id from habilidad where nombre = 'Gestión de usuarios'),1,1 ),
((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), (select id from habilidad where nombre = 'Seguridad'),1,1 ),
((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), (select id from habilidad where nombre = 'Protocolo seguro de transferenciade archivos'),1,1 ),
((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), (select id from habilidad where nombre = 'Gestión de usuarios'),1,1 ),
((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), (select id from habilidad where nombre = 'Seguridad'),1,1 ),
((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), (select id from habilidad where nombre = 'Protocolo seguro de transferenciade archivos'),1,1 ),
((select id from trabajo where nombre = 'Senior SYSADMIN'), (select id from habilidad where nombre = 'Gestión de usuarios'),1,1 ),
((select id from trabajo where nombre = 'Senior SYSADMIN'), (select id from habilidad where nombre = 'Seguridad'),1,1 ),
((select id from trabajo where nombre = 'Senior SYSADMIN'), (select id from habilidad where nombre = 'Protocolo seguro de transferenciade archivos'),1,1 ),
((select id from trabajo where nombre = 'Senior SYSADMIN'), (select id from habilidad where nombre = 'Inglés'),1,1 );

insert into trabajo_tarea(id_trabajo, nombre, id_usuario_creacion,id_usuario_modificacion)
values ((select id from trabajo where nombre = 'Teleoperador Técnico'), 'Administración de bases datos, análisis de sistemas, configuración de dispositivos móviles, tablets, y asistencia Helpdesk, con orientación y asesoramiento personalizado',1,1 ),
((select id from trabajo where nombre = 'Teleoperador Técnico'), 'Herramientas utilizadas: SIEBEL 7, BSCS, Altitude, Pandion, CNOR, Avaya, Paquete Office, WINDOWS 7, Android, IOS, Windows Phone, Aspect',1,1 );

insert into trabajo_tarea(id_trabajo, nombre, id_usuario_creacion,id_usuario_modificacion)
values ((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), 'Resolución de incidencias (INCs) y escalado a otros grupos técnicos',1,1 ),
 ((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), 'Ejecución de órdenes de trabajo (WOs) requeridas',1,1 ),
 ((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), 'Realización de tareas (TASs) asignadas para la ejecución de cambios (CRQs) de Infraestructura',1,1 ),
 ((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), 'Desempeño tanto con sistemas operativos "Unix": "AIX"; "HP-UX"; "SunOS" / "Solaris";"GNU/LiNUX" ; así como con herramientas de monitorización ("HP-OM i") y para la gestión de servicios de tecnologías de la información (ITSM) ("Remedy")',1,1 ),
 ((select id from trabajo where nombre = 'Tecnico de explotación de aplicaciones OSS'), 'Tecnologias utilizadas: IBM Netcool Network Management, IBM Netcool/OMNIbus , IBM MQ, HP HPSA, HP IUM, Infovista VistaMart, JBoss, Tomcat, Sun One web server, Weblogic',1,1 );
 
 insert into trabajo_tarea(id_trabajo, nombre, id_usuario_creacion,id_usuario_modificacion)
values ((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), 'Resolución de incidencias, problemas y escalado a otros grupos técnicos',1,1 ),
 ((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), 'Realización de tareas asignadas para la ejecución de cambios e implantaciones de Infraestructura',1,1 ),
  ((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), 'Elaboración de la documentación asociada a los servicios implementados, así como la actualización de los mismos',1,1 ),
   ((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), 'Administración, gestión y operación diaria sobre las Bases de Datos (Oracle, PostgreSQL, MySQL e Informix)',1,1 ),
    ((select id from trabajo where nombre = 'Adminsitrador de sistemas Middleware'), 'Desempeño con sistemas operativos "Unix": "AIX"; "HP-UX"; "SunOS / Solaris"; "GNU/LiNUX"; servidores Apache, Tomcat, Jboss, Weblogic; así como con herramientas de monitorización ("HPOM","Zabbix") y aplicaciones de Ticketing para la gestión de servicios de TIC',1,1 );

 insert into trabajo_tarea(id_trabajo, nombre, id_usuario_creacion,id_usuario_modificacion)
values ((select id from trabajo where nombre = 'Senior SYSADMIN'), 'Resolución de incidencias, ejecución de cambios e implantaciones de infraestructura y escalado a otros grupos técnicos, mediante herramienta ServiceNow',1,1 ),
 ((select id from trabajo where nombre = 'Senior SYSADMIN'), 'Administración de sistemas: “RedHat Enterprise Linux”,”HP-UX”, “Solaris” y "AIX"',1,1 ),
  ((select id from trabajo where nombre = 'Senior SYSADMIN'), 'Gestión de filesystems (NAS, SAN, NFS, CIFS)',1,1 ),
   ((select id from trabajo where nombre = 'Senior SYSADMIN'), 'Administración de Clúster: “Veritas Cluster”, “RedHat Cluster Suite”, “ServiceGuard” y “Pacemaker”',1,1 ),
    ((select id from trabajo where nombre = 'Senior SYSADMIN'), 'Administración Gestores de Volúmenes: “Veritas Volume Manager” “LVM” y” Solaris Volume Manager”',1,1 );


create table estudio(
	id INT  not null auto_increment primary key,
    nombre varchar(255) not null unique,
    id_institucion_educativa int  null ,
    fecha_inicio datetime  null,
    fecha_fin datetime  null,
    nivel_eqf_mec int null,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table estudio add foreign key fk_estudio_institucion_educativa (id_institucion_educativa) references institucion_educativa(id);
alter table estudio add foreign key fk_estudio_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table estudio add foreign key fk_estudio_usuario_modificacion (id_usuario_modificacion) references usuario(id);

insert into estudio (nombre, id_institucion_educativa, fecha_inicio, fecha_fin, nivel_eqf_mec, id_usuario_creacion, id_usuario_modificacion)
values ('Grado de Derecho', (select id from institucion_educativa where nombre = 'Universidad Complutense de Madrid'),'2008-09-09','2013-09-01',6,1,1);

insert into estudio (nombre, id_institucion_educativa, fecha_inicio, fecha_fin, nivel_eqf_mec, id_usuario_creacion, id_usuario_modificacion)
values ('CFGS en Administracion de Sistemas informaticós en Red', (select id from institucion_educativa where nombre = 'Colegio Sagrada Familia El Pilar'),'2015-10-01','2017-03-01',5,1,1);

create table estudio_observacion(
	id INT  not null auto_increment primary key,
    id_estudio int not null ,
    nombre varchar(255) not null ,
    observacion varchar(1255) not null ,
    activo TINYINT(1) not null default(1) ,
    id_usuario_creacion int not null,
    id_usuario_modificacion int not null,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

alter table estudio_observacion add foreign key fk_estudio_observacion_usuario_creacion (id_usuario_creacion) references usuario(id);
alter table estudio_observacion add foreign key fk_estudio_observacion_usuario_modificacion (id_usuario_modificacion) references usuario(id);
alter table estudio_observacion add foreign key fk_estudio_observacion_estudio (id_estudio) references estudio(id);

insert into estudio_observacion(id_estudio,nombre,observacion, id_usuario_creacion, id_usuario_modificacion)
values ((select id from estudio where nombre = 'Grado de Derecho'),'Estudios no finalizados','Completados 120 créditos de 240', 1,1),
((select id from estudio where nombre = 'CFGS en Administracion de Sistemas informaticós en Red'),'Proyecto fin de ciclo','Implementacion de Servidor Proxmox en una red de trabajo. (Calificación 9)', 1,1),
((select id from estudio where nombre = 'CFGS en Administracion de Sistemas informaticós en Red'),'Calificación final','7.5', 1,1);


create table visita(
	id INT  not null auto_increment primary key,
    url varchar(255) not null ,
    ip varchar(255) not null ,
    activo TINYINT(1) not null default(1) ,
    fecha_creacion datetime not null default now(),
    fecha_modificacion datetime not null default now()
);

select * from visita;



