CREATE DATABASE `londres` /*!40100 DEFAULT CHARACTER SET latin1 */;


CREATE TABLE `estacoes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` decimal(7,4) DEFAULT NULL,
  `longitude` decimal(5,4) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `zona` decimal(3,1) DEFAULT NULL,
  `total_linhas` int(11) DEFAULT NULL,
  `trilhos` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=latin1;
SELECT * FROM londres.estacoes;

CREATE TABLE `linhas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `estacao1` int(11) DEFAULT NULL,
  `estacao2` int(11) DEFAULT NULL,
  `linha` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=411 DEFAULT CHARSET=latin1;


CREATE TABLE `rotas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `linha` int(11) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cor` varchar(45) DEFAULT NULL,
  `fachada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

