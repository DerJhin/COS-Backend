CREATE TABLE weapons (
    name VARCHAR(255) PRIMARY KEY
);

-- Create 'skins' table
CREATE TABLE skins (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    weapon_name VARCHAR(255) REFERENCES weapons(name),
    has_pattern NUMBER(1),
    rarity VARCHAR(50)
);

-- Create 'cases' table
CREATE TABLE cases (
    name VARCHAR(255) PRIMARY KEY
);

-- Create 'case_skins' table
CREATE TABLE case_skins (
    id INT PRIMARY KEY,
    case_name VARCHAR(255) REFERENCES cases(name),
    skin_id INT REFERENCES skins(id),
    probability DOUBLE
);


-- Inserting test data into the 'items' table
INSERT INTO weapons (name) VALUES
('M4A4'),
('AK-47'),
('AWP'),
('Karambit');

-- Inserting test data into the 'skins' table
INSERT INTO skins (id, name, weapon_name, has_pattern, rarity) VALUES
(1, 'Temukau', 'M4A4', 0, 'red'),
(2, 'Slate', 'AK-47', 0, 'purple'),
(3, 'Duality', 'AWP', 0, 'pink'),
(4, 'Case Hardened', 'Karambit', 1, 'gold');

-- Insert test data into the 'cases' table
INSERT INTO cases (name) VALUES
('TestCase');

-- Link skins to cases in the 'case_skins' join table
INSERT INTO case_skins (id, case_name, skin_id, probability) VALUES
(1, 'TestCase', 1, 0.25),
(2, 'TestCase', 2, 0.25),
(3, 'TestCase', 3, 0.25),
(4, 'TestCase', 4, 0.25);

