CREATE TABLE weapons (
    name VARCHAR(255) PRIMARY KEY
);

-- Create 'skins' table
CREATE TABLE skins (
    name VARCHAR(255),
    weapon_name VARCHAR(255) REFERENCES weapons(name),
    has_pattern NUMBER(1),
    rarity VARCHAR(50),
    PRIMARY KEY (name, weapon_name)
);

-- Create 'cases' table
CREATE TABLE cases (
    name VARCHAR(255) PRIMARY KEY
);

-- Create 'case_skins' table
CREATE TABLE case_skins (
    case_name VARCHAR(255) REFERENCES cases(name),
    skin_name VARCHAR(255) REFERENCES skins(name),
    skin_weapon_name VARCHAR(255) REFERENCES weapons(name),
    probability DOUBLE,
    PRIMARY KEY (case_name, skin_name)
);


-- Inserting test data into the 'items' table
INSERT INTO weapons (name) VALUES
('M4A4'),
('AK-47'),
('AWP'),
('Karambit');

-- Inserting test data into the 'skins' table
INSERT INTO skins (name, weapon_name, has_pattern, rarity) VALUES
('Temukau', 'M4A4', 0, 'red'),
('Slate', 'AK-47', 0, 'purple'),
('Duality', 'AWP', 0, 'pink'),
('Case Hardened', 'Karambit', 1, 'gold');

-- Insert test data into the 'cases' table
INSERT INTO cases (name) VALUES
('TestCase');

-- Link skins to cases in the 'case_skins' join table
INSERT INTO case_skins (case_name, skin_name, skin_weapon_name, probability) VALUES
('TestCase', 'Temukau', 'M4A4', 0.25),
('TestCase', 'Slate', 'AK-47', 0.25),
('TestCase', 'Duality', 'AWP', 0.25),
('TestCase', 'Case Hardened', 'Karambit', 0.25);

