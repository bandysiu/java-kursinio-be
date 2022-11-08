CREATE TABLE IF NOT EXISTS Users (
    user_id SERIAL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    login TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    position TEXT NOT NULL,
    salary TEXT NOT NULL,
    status TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Vehicles (
    vehicle_id SERIAL,
    vehicle_brand TEXT NOT NULL,
    vehicle_year TEXT NOT NULL,
    vehicle_price TEXT NOT NULL,
    status TEXT NOT NULL
)

CREATE TABLE IF NOT EXISTS Commissions (
    commission_id SERIAL,
    destination TEXT NOT NULL,
    delivery_date TIMESTAMP NOT NULL,
    shipment INT NOT NULL,
    user INT NOT NULL,
    vehicle INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Shipments (
    shipment_id SERIAL,
    description TEXT NOT NULL,
    weight TEXT NOT NULL
)