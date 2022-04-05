/* Setting up Picture DB */

use pictureDB;


CREATE TABLE IF NOT EXISTS picture (
  ID tinyint(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  content BINARY,
  name VARCHAR(125)
)ENGINE=INNODB;

