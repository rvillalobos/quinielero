SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `empresa` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `empresa` ;

-- -----------------------------------------------------
-- Table `empresa`.`ProfileData`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`ProfileData` (
  `Name` VARCHAR(50) NOT NULL,
  `LastName` VARCHAR(45) NULL,
  `Age` INT NULL,
  `Country` VARCHAR(45) NULL,
  `City` VARCHAR(45) NULL,
  `Favorite Team` VARCHAR(45) NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa`.`Pools`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`Pools` (
  `PoolName` VARCHAR(50) NOT NULL,
  `PoolMinNumberOfParticipants` INT NULL,
  PRIMARY KEY (`PoolName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`Users` (
  `UserName` VARCHAR(50) NOT NULL,
  `UserEmail` VARCHAR(45) NULL,
  `UserPassword` VARCHAR(45) NULL,
  PRIMARY KEY (`UserName`),
  CONSTRAINT `fk_Users_ProfileData1`
    FOREIGN KEY (`UserName`)
    REFERENCES `empresa`.`ProfileData` (`Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa`.`Pool-Participants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`Pool-Participants` (
  `IdParticipants` INT NOT NULL,
  `PoolName` VARCHAR(45) NULL,
  `UserName` VARCHAR(45) NULL,
  `Users_UserName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdParticipants`, `Users_UserName`),
  INDEX `fk_Pool-Participants_Users1_idx` (`Users_UserName` ASC),
  CONSTRAINT `fk_Pool-Participants_Pools1`
    FOREIGN KEY (`IdParticipants`)
    REFERENCES `empresa`.`Pools` (`PoolName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pool-Participants_Users1`
    FOREIGN KEY (`Users_UserName`)
    REFERENCES `empresa`.`Users` (`UserName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa`.`Teams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`Teams` (
  `TeamName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`TeamName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa`.`PoolTeams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`PoolTeams` (
  `Id` INT NOT NULL,
  `PoolName` VARCHAR(45) NULL,
  `TeamName` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `fk_PoolTeams_Pools`
    FOREIGN KEY (`Id`)
    REFERENCES `empresa`.`Pools` (`PoolName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PoolTeams_Teams1`
    FOREIGN KEY (`Id`)
    REFERENCES `empresa`.`Teams` (`TeamName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
