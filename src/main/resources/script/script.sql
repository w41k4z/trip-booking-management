CREATE DATABASE trip with owner w41k4z;

-- bouquet
CREATE TABLE subscription_tier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE activity (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE tier_activity (
    id SERIAL PRIMARY KEY,
    subscription_tier_id INTEGER REFERENCES subscription_tier(id),
    activity_id INTEGER REFERENCES activity(id)
);