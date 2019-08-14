CREATE TABLE url_mapping_tb (
  id MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
  act_url_long  VARCHAR(255),
  map_url_short VARCHAR(20),
  created_dt DATETIME
)