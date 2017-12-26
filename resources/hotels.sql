CREATE DATABASE `hotel_locations` /*!40100 DEFAULT CHARACTER SET utf8 */;

use hotel_locations;

CREATE TABLE `markers` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `name` VARCHAR( 60 ) NOT NULL ,
  `address` VARCHAR( 80 ) NOT NULL ,
  `lat` FLOAT( 10, 6 ) NOT NULL ,
  `lng` FLOAT( 10, 6 ) NOT NULL
) ENGINE = MYISAM ;

INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('1','Hotel Ellora park','Dhankawadi','18.465853','73.858193');
INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('2','Hotel Krushna','Dhankawadi','18.4681503','73.8538022');
INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('3','Vivanta by Taj','Koregaon Park','18.540112','73.8882739');
INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('4','The Westin','Koregaon Park','18.540112','73.8882739');
INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('5','Hotel ABC Inn',' Nigdi','18.657125','73.7716086');
INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('6','Hotel Krishna Regency','Nigdi','18.657125','73.7716086');
INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('7','Hotel Basera','Bajirao Road','18.5193718','73.8519211');
INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES ('8','Hotel Sapna','Shivajinagar','18.5193718','73.8519211');




