CREATE TABLE restaurant (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  location VARCHAR(255)
);

CREATE TABLE meal (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  date DATE,
  type VARCHAR(20),
  restaurant_id BIGINT,
  description varchar(255),
  CONSTRAINT fk_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
);

CREATE TABLE reservation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    type VARCHAR(255) NOT NULL,
    checked_in BOOLEAN DEFAULT FALSE,
    cancelled BOOLEAN DEFAULT FALSE,
    restaurant_id BIGINT,
    CONSTRAINT fk_reservation_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
);

