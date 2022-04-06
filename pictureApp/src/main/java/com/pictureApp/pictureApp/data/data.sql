/* Setting up Picture DB */

use pictureDB;
drop table picture;

CREATE TABLE IF NOT EXISTS picture (
  ID tinyint(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  content BLOB,
  name VARCHAR(125)
)ENGINE=INNODB;

