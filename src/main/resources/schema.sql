CREATE TABLE IF NOT EXISTS `llibres` (
  `id_Llibre` bigint(20) NOT NULL AUTO_INCREMENT,
  `titol` varchar(255) UNIQUE NOT NULL,
  `autor` varchar(255) NOT NULL,
  `editorial` varchar(255) DEFAULT NULL,
  `datapublicacio` DATE NOT NULL,
  `tematica` varchar(255) DEFAULT NULL,
  `ISBN` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id_Llibre`)
);


