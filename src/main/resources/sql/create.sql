CREATE TABLE tracking_number (
  id SERIAL PRIMARY KEY,
  tracking_number VARCHAR(16) UNIQUE NOT NULL,
  created_at TIMESTAMPTZ NOT NULL
);