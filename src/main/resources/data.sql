-- Insert test data into the 'cases' table
INSERT INTO cases (case_name, price) VALUES
    ('TestCase', 10);

INSERT INTO weapons (weapon_name) VALUES
    ('AK-47'),
    ('M4A4'),
    ('M4A1-S'),
    ('P2000'),
    ('Glock'),
    ('AWP'),
    ('Flip Knife'),
    ('Bayonet'),
    ('Karambit'),
    ('M9 Bayonet'),
    ('Butterfly Knife'),
    ('Huntsman Knife'),
    ('Falchion Knife'),
    ('Bowie Knife'),
    ('Shadow Daggers'),
    ('Ursus Knife'),
    ('Navaja Knife'),
    ('Stiletto Knife'),
    ('Talon Knife');


INSERT INTO skins (skin_id, has_pattern, name, rarity, weapon_name) VALUES
    (1, true, 'Caseharden', 'PINK', 'AK-47'),
    (2, false, 'Asiimov', 'RED', 'M4A4'),
    (3, false, 'Hyper Beast', 'RED', 'M4A1-S'),
    (4, false, 'Handgun', 'PINK', 'P2000'),
    (5, true, 'Fade', 'PINK', 'Glock'),
    (6, false, 'Dragon Lore', 'RED', 'AWP'),
    (7, false, 'Temukau', 'RED', 'M4A4'),
    (8, false, 'Doppler', 'GOLD', 'Flip Knife'),
    (9, true, 'Caseharden', 'GOLD', 'Karambit');

INSERT INTO case_skins (id, probability, skin_id, case_name) VALUES
    (1, 0.1, 1,'TestCase'),
    (2, 0.15, 2,'TestCase'),
    (3, 0.15, 3,'TestCase'),
    (4, 0.1, 4,'TestCase'),
    (5, 0.1, 5,'TestCase'),
    (6, 0.15, 6,'TestCase'),
    (7, 0.15, 7,'TestCase'),
    (8, 0.05, 8,'TestCase'),
    (9, 0.05, 9,'TestCase');