create table TrackingTable(
  ID int not null AUTO_INCREMENT,
  tracking_number varchar(100) not null,
  created_at TIMESTAMP,
--  TIMESTAMP
--  TIMESTAMP WITH TIME ZONE
  PRIMARY KEY (tracking_number )
);