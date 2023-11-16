CREATE TABLE items (
    name VARCHAR(255) PRIMARY KEY
);

-- Create 'skins' table
CREATE TABLE skins (
    name VARCHAR(255),
    item_name VARCHAR(255) REFERENCES items(name),
    rarity VARCHAR(50),
    PRIMARY KEY (name, item_name)
);

-- Create 'cases' table
CREATE TABLE cases (
    name VARCHAR(255) PRIMARY KEY,
    probability_map_id INT
);

-- Create 'case_skins' join table
CREATE TABLE case_skins (
    case_name VARCHAR(255) REFERENCES cases(name),
    skin_name VARCHAR(255) REFERENCES skins(name),
    skin_itemName VARCHAR(255) REFERENCES items(name),
    PRIMARY KEY (case_name, skin_name)
);

CREATE TABLE case_probability (
    case_name VARCHAR(255),
    rarity VARCHAR(255),
    probability DOUBLE,
    PRIMARY KEY (case_name, rarity),
    FOREIGN KEY (case_name) REFERENCES cases(name)
);

-- Inserting test data into the 'items' table
INSERT INTO items (name) VALUES
('M4A4'),
('AK-47'),
('AWP'),
('Karambit');

-- Inserting test data into the 'skins' table
INSERT INTO skins (name, item_name, rarity) VALUES
('Temukau', 'M4A4', 'red'),
('Slate', 'AK-47', 'purple'),
('Duality', 'AWP', 'pink'),
('Case Hardened', 'Karambit', 'gold');

-- Insert test data into the 'cases' table
INSERT INTO cases (name) VALUES
('TestCase');

-- Link skins to cases in the 'case_skins' join table
INSERT INTO case_skins (case_name, skin_name, skin_itemName) VALUES
('TestCase', 'Temukau', 'M4A4'),
('TestCase', 'Slate', 'AK-47'),
('TestCase', 'Duality', 'AWP'),
('TestCase', 'Case Hardened', 'Karambit');

-- Inserting data into the 'case_probability' table
INSERT INTO case_probability (case_name, rarity, probability) VALUES
('TestCase', 'gold', 0.25),
('TestCase', 'red', 0.25),
('TestCase', 'pink', 0.25),
('TestCase', 'purple', 0.25);
