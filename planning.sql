-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  sam. 30 mai 2020 à 21:18
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `planning`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `NOM`) VALUES
(1, 'Analyse'),
(2, 'Traitement Du Signal'),
(3, 'English'),
(4, 'Italien'),
(5, 'Thermodynamique'),
(6, 'Robotique'),
(7, 'Anthropologie'),
(8, 'Ethique de l\'ingenieur'),
(9, 'PSTE'),
(10, 'POO Java');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  KEY `ID_COURS` (`ID_COURS`),
  KEY `ID_UTILISATEUR` (`ID_UTILISATEUR`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_UTILISATEUR`, `ID_COURS`) VALUES
(16, 2),
(18, 1),
(19, 3),
(16, 7),
(18, 6),
(17, 8);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_UTILISATEUR`, `NUMERO`, `ID_GROUPE`) VALUES
(4, 0, 1),
(5, 0, 2),
(6, 0, 1),
(7, 0, 3),
(8, 0, 5),
(9, 0, 4),
(10, 0, 3),
(11, 0, 2),
(12, 0, 4),
(13, 0, 6),
(14, 0, 5),
(15, 0, 6);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `ID_PROMOTION` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PROMOTION` (`ID_PROMOTION`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `NOM`, `ID_PROMOTION`) VALUES
(1, 'GR01', 1),
(2, 'GR02', 1),
(3, 'GR03', 2),
(4, 'GR04', 2),
(5, 'GR05', 3),
(6, 'GR06', 3);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` int(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `NOM`) VALUES
(1, 2022),
(2, 2023),
(3, 2024);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(11) NOT NULL,
  `CAPACITE` int(11) NOT NULL,
  `ID_SITE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_SITE` (`ID_SITE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `NOM`, `CAPACITE`, `ID_SITE`) VALUES
(1, 'EM100', 50, 1),
(2, 'EM310', 40, 1),
(3, 'P305', 30, 2),
(4, 'P405', 60, 2),
(5, 'L12', 25, 3),
(6, 'L22', 35, 3),
(7, 'G09', 30, 4),
(8, 'G08', 30, 4),
(9, 'Z112', 80, 5),
(10, 'Z104', 20, 5);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SEMAINE` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `HEURE_DEBUT` time NOT NULL,
  `HEURE_FIN` time NOT NULL,
  `ETAT` tinyint(1) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  `ID_TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_COURS` (`ID_COURS`),
  KEY `ID_TYPE` (`ID_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_ENSEIGNANT` int(11) NOT NULL,
  KEY `ID_SEANCE` (`ID_SEANCE`),
  KEY `ID_ENSEIGNANT` (`ID_ENSEIGNANT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  KEY `ID_GROUPE` (`ID_GROUPE`),
  KEY `ID_SEANCE` (`ID_SEANCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_SALLE` int(11) NOT NULL,
  KEY `ID_SEANCE` (`ID_SEANCE`),
  KEY `ID_SALLE` (`ID_SALLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID`, `NOM`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3'),
(4, 'E4'),
(5, 'E5');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `NOM`) VALUES
(1, 'CI'),
(2, 'TP'),
(3, 'TD'),
(4, 'Demi TD');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `MDP` varchar(255) NOT NULL,
  `NOM` varchar(255) NOT NULL,
  `PRENOM` varchar(255) NOT NULL,
  `DROIT` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `EMAIL`, `MDP`, `NOM`, `PRENOM`, `DROIT`) VALUES
(1, 'user1@edu.ece.fr', 'user1', 'Premier', 'User', 1),
(2, 'user2@edu.ece.fr', 'user2', 'Deuxieme', 'User', 2),
(3, 'user3@edu.ece.fr', 'user3', 'Troisieme', 'User', 3),
(4, 'user4@edu.ece.fr', 'user4', 'Quatrieme', 'User', 4),
(5, 'antoine@ece.fr', 'antoine', 'Conso', 'Antoine', 4),
(6, 'adrien@ece.fr', 'adrien', 'Zychowski', 'Adrien', 4),
(7, 'bautista@ece.fr', 'bautista', 'Piñeiro Aramburu', 'Bautista', 4),
(8, 'quentin@ece.fr', 'quentin', 'Bonnard', 'Quentin', 4),
(9, 'kim@ece.fr', 'kim', 'Zaatar', 'Kim', 4),
(10, 'benoit@ece.fr', 'benoit', 'Clemenceau', 'Benoit', 4),
(11, 'armand@ece.fr', 'armand', 'Du Parc', 'Armand', 4),
(12, 'mathias@ece.fr', 'mathias', 'Prevote', 'Mathias', 4),
(13, 'louis@ece.fr', 'louis', 'Vidil', 'Louis', 4),
(14, 'victor@ece.fr', 'victor', 'Quidet', 'Victor', 4),
(15, 'rasputin@ece.fr', 'rasputin', 'Rasputin', 'Vladimir', 4),
(16, 'chirac@ece.fr', 'chirac', 'Chirac', 'Jack', 3),
(17, 'hurley@ece.fr', 'hurley', 'Hurley', 'Doug', 3),
(18, 'gustav@ece.fr', 'gustav', 'Gustav', 'Claude', 3),
(19, 'reese@ece.fr', 'reese', 'Reese', 'James', 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`),
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`),
  ADD CONSTRAINT `etudiant_ibfk_3` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`ID_PROMOTION`) REFERENCES `promotion` (`ID`);

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`ID_SITE`) REFERENCES `site` (`ID`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`ID_TYPE`) REFERENCES `type_cours` (`ID`);

--
-- Contraintes pour la table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `seance_enseignants_ibfk_1` FOREIGN KEY (`ID_ENSEIGNANT`) REFERENCES `enseignant` (`ID_UTILISATEUR`),
  ADD CONSTRAINT `seance_enseignants_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `seance_groupes_ibfk_1` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `seance_groupes_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`),
  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`ID_SALLE`) REFERENCES `salle` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
