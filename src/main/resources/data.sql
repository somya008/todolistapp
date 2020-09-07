





DROP TABLE IF EXISTS TODO_LIST;

CREATE TABLE TODO_LIST(
  item_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  username VARCHAR(255),
  description VARCHAR(255),
  status VARCHAR(255),
  create_dt DATE,
  update_dt DATE
);

INSERT INTO TODO_LIST( user_id ,username, description, status, create_dt, update_dt) values
(1 , 'user1','do homework','progress','2020-09-05','2020-09-05');

INSERT INTO TODO_LIST( user_id ,username, description, status, create_dt, update_dt) values
(1 , 'admin','sleep','progress','2020-09-05','2020-09-05');
 
