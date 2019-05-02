CREATE SEQUENCE location_seq;

CREATE TABLE IF NOT EXISTS  location (
  id int PRIMARY KEY DEFAULT nextval('location_seq'),
  geometry GEOMETRY NOT NULL,
  name     CHARACTER VARYING(255)
 );

CREATE INDEX IF NOT EXISTS idx_location_geometry
  ON location USING GIST
  (geometry)
;

