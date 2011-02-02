/*
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * Author: Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
DROP SCHEMA IF EXISTS `blog_ibatis` ;
CREATE SCHEMA IF NOT EXISTS `blog_ibatis` DEFAULT CHARACTER SET latin1 ;
USE `blog_ibatis` ;

-- -----------------------------------------------------
-- Table `blog_ibatis`.`Employee_Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Employee_Type` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Employee_Type` (
  `idType` INT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idType`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Employee` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Employee` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `employee_type` INT NOT NULL ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Employee_Employee_Type1` (`employee_type` ASC) ,
  CONSTRAINT `fk_Employee_Employee_Type1`
    FOREIGN KEY (`employee_type` )
    REFERENCES `blog_ibatis`.`Employee_Type` (`idType` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Manager` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Manager` (
  `manager_id` INT NOT NULL AUTO_INCREMENT ,
  `info` VARCHAR(45) NOT NULL ,
  `Employee_id` INT NOT NULL ,
  PRIMARY KEY (`manager_id`) ,
  INDEX `fk_Manager_Employee` (`Employee_id` ASC) ,
  CONSTRAINT `fk_Manager_Employee`
    FOREIGN KEY (`Employee_id` )
    REFERENCES `blog_ibatis`.`Employee` (`id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Developer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Developer` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Developer` (
  `developer_id` INT NOT NULL AUTO_INCREMENT ,
  `product` VARCHAR(45) NOT NULL ,
  `Employee_id` INT NOT NULL ,
  PRIMARY KEY (`developer_id`) ,
  INDEX `fk_Developer_Employee1` (`Employee_id` ASC) ,
  CONSTRAINT `fk_Developer_Employee1`
    FOREIGN KEY (`Employee_id` )
    REFERENCES `blog_ibatis`.`Employee` (`id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `blog_ibatis`.`employee_type` (`idType`, `description`) VALUES (1, 'Manager');
INSERT INTO `blog_ibatis`.`employee_type` (`idType`, `description`) VALUES (2, 'Developer');

INSERT INTO `blog_ibatis`.`employee` (`id`, `name`, `employee_type`) VALUES (1, 'Kate', 1);
INSERT INTO `blog_ibatis`.`employee` (`id`, `name`, `employee_type`) VALUES (2, 'Josh', 2);
INSERT INTO `blog_ibatis`.`employee` (`id`, `name`, `employee_type`) VALUES (3, 'Peter', 2);
INSERT INTO `blog_ibatis`.`employee` (`id`, `name`, `employee_type`) VALUES (4, 'James', 1);
INSERT INTO `blog_ibatis`.`employee` (`id`, `name`, `employee_type`) VALUES (5, 'Susan', 2);

INSERT INTO `blog_ibatis`.`manager` (`manager_id`, `info`, `Employee_id`) VALUES (1, 'info Kate', 1);
INSERT INTO `blog_ibatis`.`manager` (`manager_id`, `info`, `Employee_id`) VALUES (2, 'info James', 4);

INSERT INTO `blog_ibatis`.`developer` (`developer_id`, `product`, `Employee_id`) VALUES (1, 'web', 2);
INSERT INTO `blog_ibatis`.`developer` (`developer_id`, `product`, `Employee_id`) VALUES (2, 'desktop', 3);
INSERT INTO `blog_ibatis`.`developer` (`developer_id`, `product`, `Employee_id`) VALUES (3, 'web', 5);