CREATE TABLE IF NOT EXIST `llibres` (
  `id_Llibre` bigint(20) NOT NULL AUTO_INCREMENT,
  `titol` varchar(255) DEFAULT NULL,
  `autor` datetime(6) DEFAULT NULL,
  `editorial` varchar(255) DEFAULT NULL,
  `datapublicacio` DATE DEFAULT NULL,
  `tematica` varchar(255) DEFAULT NULL,
  `ISBN` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id_Llibre`)
);


