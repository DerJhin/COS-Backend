-- Insert test data into the 'cases' table
INSERT INTO weapons (weapon_name) VALUES
    ('AK-47'),
    ('M4A4'),
    ('M4A1-S'),
    ('P2000'),
    ('Glock'),
    ('UMP-45'),
    ('AWP'),
    ('P90'),
    ('Desert Eagle'),
    ('Five-Seven'),
    ('Tec-9'),
    ('MP9'),
    ('MP7'),
    ('MAC-10'),
    ('P250'),
    ('CZ75-Auto'),
    ('Dual Berettas'),
    ('Nova'),
    ('XM1014'),
    ('Sawed-Off'),
    ('MAG-7'),
    ('Negev'),
    ('M249'),
    ('FAMAS'),
    ('AUG'),
    ('MP5-SD'),
    ('SG 553'),
    ('SSG 08'),
    ('SCAR-20'),
    ('G3SG1'),
    ('Galil AR'),
    ('Revolver'),
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
    ('Talon Knife'),
    ('Driver Gloves'),
    ('Hand Wraps'),
    ('Moto Gloves'),
    ('Specialist Gloves'),
    ('Sport Gloves'),
    ('Bloodhound Gloves'),
    ('Hydra Gloves'),
    ('USP-S'),
    ('Spitting Lama');

INSERT INTO skins (skin_id, has_pattern, name, rarity, weapon_name, image) VALUES
    (1, false, 'Temukau', 5, 'M4A4', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_m4a1_cu_m4a4_temukau_light_large.a41eb80c70cbbee5d84e53b5cd1eaa10954c938d.png'),
    (2, false, 'Head Shot', 5, 'AK-47', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_ak47_cu_ak_head_shot_holo_light_large.85be84ba7c07917493b8e8a66c9d95c928ebe8b6.png'),
    (3, false, 'Duality', 4, 'AWP', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_awp_gs_awp_limbo_snake_light_large.60984ce1e5c1a4ac10e83444a9b7e7f78dd98b1e.png'),
    (4, false, 'Wicked Sick', 4, 'P2000', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_hkp2000_cu_p2000_decline_light_large.7f57145674a5e41b3b8e7fe70be4ffbb57ec6f84.png'),
    (5, false, 'Wild Child', 4, 'UMP-45', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_ump45_cu_ump_clutch_kick_light_large.b57e43c07b433517b1c3bdaa1e52ce44878af481.png'),
    (6, false, 'Emphorosaur-S', 3, 'M4A1-S', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_m4a1_silencer_cu_m4a1s_feeding_frenzy_light_large.e1cb803e0e10ae4457e42d34ec8515b1500f4762.png'),
    (7, false, 'Neoqueen', 3, 'P90', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_p90_gs_p90_neoqueen_light_large.fa2a81f8c7906b2683b5eb4b562edd2529ad2cf0.png'),
    (8, false, 'Umbral Rabbit', 3, 'Glock', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_glock_cu_glock_moon_rabbit_light_large.9063b9745250446c657632eb13a6325f51d101f2.png'),
    (9, false, 'Sakkaku', 3, 'MAC-10' , 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_mac10_cu_mac10_sakkaku_light_large.b590689d0ca099e8a759dd0a86da0710a58bca42.png'),
    (10, false, 'Banana Cannon', 3, 'Revolver', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_revolver_gs_r8_banana_light_large.50f0b729a36a405d48b41d58463234dbbd15b9cf.png'),
    (11, false, 'Liquidation', 2, 'MP5-SD', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_mp5sd_cu_mp5sd_quick_liquidation_light_large.2b446c710928debe38469e33b3b9030bd218c0e3.png'),
    (12, false, 'Featherweight', 2, 'MP9', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_mp9_cu_mp9_superlight_light_large.81ad837f4c889f250fa03b227ef74555614de55d.png'),
    (13, false, 'Cyberforce', 2, 'SG 553', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_sg556_cu_sg553_cyberforce_light_large.63aa4e611195d801eb706ac65d38df68f98e2b76.png'),
    (14, false, 'Rebel', 2, 'Tec-9', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_tec9_cu_tec9_freedom_light_large.bb79585222a88d4dd3b154915c5527cac7e507d1.png'),
    (15, false, 'Insomnia', 2, 'MAG-7', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_mag7_cu_mag7_insomnia_light_large.0d971fb17ca0bb1df7baed6a1caa902c56c1ea5b.png'),
    (16, false, 'Re.built', 2, 'P250', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_p250_cu_p250_rebuilt_light_large.69d4fcb9a8151d09818d1c26cf4c7b03d046b5a1.png'),
    (17, false, 'Fragments', 2, 'SCAR-20', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_scar20_gs_scar_fragments_black_light_large.d6bde287b06ba2380ba07621a0b06c36b13c4025.png'),
    (18, false, 'The Traitor', 5, 'USP-S','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_usp_silencer_gs_usps_hangedman_light_large.a01890fdeb8335437df7af6641a7b4f6e2fcca34.png'),
    (19, false, 'In Living Color', 5, 'M4A4','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_m4a1_cu_m4a4_love_light_large.5f7f6a3085aedc1a878dd10881144e7898a2db3d.png'),
    (20, false, 'Chromatic Aberration', 4, 'Galil AR','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_galilar_cu_galil_chroma_pink_light_large.e29cb838de1fc6318d36ed2d7263b7fcef10a4d8.png'),
    (21, false, 'Food Chain', 4, 'MP9','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_mp9_cu_mp9_food_chain_light_large.5895f4cc864387a61a3783470037e6ed1953f7df.png'),
    (22, false, 'XOXO', 4, 'XM1014','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_xm1014_aq_xm1014_punk_light_large.8c6eb5bcf234179713a52b1a5e22c64c21c52007.png'),
    (23, false, 'Slate', 3, 'AK-47','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_ak47_gs_ak47_professional_light_large.d09d623d0a725c63e8a3905f66bba41ba2ed59e8.png'),
    (24, false, 'Trigger Discipline', 3, 'Desert Eagle','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_deagle_cu_deag_trigger_discipline_light_large.9d8615945f079e3f7ea84c572fd34408fee6341c.png'),
    (25, false, 'Cyber Shell', 3, 'P250','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_p250_gs_p250_cybershell_light_large.9f0408cde898dd81609541a8e68ff1ffe81320fd.png'),
    (26, false, 'Button Masher', 3, 'MAC-10','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_mac10_cu_mac10_portable_light_large.d4e97127a92ecba12884e5af083aa84685486b39.png'),
    (27, false, 'dev_texture', 3, 'Negev','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_negev_cu_negev_devtexture_light_large.a0c6f2fcbac9d473d7b9d0452773843c284683e3.png'),
    (28, false, 'Clear Polymer', 2, 'Glock','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_glock_gs_glock_polymer_light_large.9a56b15b2deea5847b0820c5ad982c1796cc8e0c.png'),
    (29, false, 'Circaetus', 2, 'CZ75-Auto','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_cz75a_cu_cz75_whirlwind_light_large.86609770746655c350bb7b087a8c0f1f1b55d01f.png'),
    (30, false, 'Heavy Metal', 2, 'SG 553','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_sg556_gs_sg553_deathmetal_light_large.c41041d1a69838d3b66f21032254066eaea8fe41.png'),
    (31, false, 'Junk Yard', 2, 'Revolver','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_revolver_gs_r8_rustking_light_large.5245178cf84e1bf8d77eb7a3ec19d108a70131d3.png'),
    (32, false, 'Windblown', 2, 'Nova','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_nova_sp_nova_wind_dispersal_light_large.9156d5a206e0e4b47f814bee9b6b54ac0a16b159.png'),
    (33, false, 'O.S.I.P.R.', 2, 'M249','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_m249_gs_m249_combine_light_large.6f8724ef896506ede0925a425da05969f19aafdc.png'),
    (34, false, 'Oscillator', 2, 'UMP-45','https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/weapon_ump45_am_ump45_electrowave_light_large.98b6a5211b19bfeecb69d08cc7ebe6584cff353f.png'),
    (35, false, 'Undercover Version', 6, 'Spitting Lama', 'https://steamcdn-a.akamaihd.net/apps/730/icons/econ/default_generated/slick_gloves_slick_snakeskin_white_light_large.f6a54c7a3cf91ecbe0a712bb2126bfe77f86825e.png');

INSERT INTO inventory (inventory_id) VALUES
    (1),
    (2),
    (3);

INSERT INTO benutzer (username, email, balance, inventory_id, password, last_login) VALUES
('Joris', 'user1@example.com', 100, 1, 12345678, '2024-01-07'),
('Lucas', 'user2@example.com', 150, 2, 12345678, '2024-01-07'),
('Tim', 'user3@example.com', 200, 3, 12345678, '2024-01-07');


INSERT INTO cases (case_name, image) VALUES
('Revolution', 'https://steamcommunity-a.akamaihd.net/economy/image/-9a81dlWLwJ2UUGcVs_nsVtzdOEdtWwKGZZLQHTxDZ7I56KU0Zwwo4NUX4oFJZEHLbXU5A1PIYQNqhpOSV-fRPasw8rsUFJ5KBFZv668FFQynaHMJT9B74-ywtjYxfOmMe_Vx28AucQj3brAoYrz3Fay_kY4MG_wdYeLMlhpLMaM-1U/256fx256f'),
('Snakebite', 'https://steamcommunity-a.akamaihd.net/economy/image/-9a81dlWLwJ2UUGcVs_nsVtzdOEdtWwKGZZLQHTxDZ7I56KU0Zwwo4NUX4oFJZEHLbXU5A1PIYQNqhpOSV-fRPasw8rsUFJ5KBFZv668FFU4naLOJzgUuYqyzIaIxa6jMOLXxGkHvcMjibmU99Sg3Qaw-hA_ZWrzLISLMlhpgJJUhGE/256fx256f');

-- Füge "Revolution" case in die Tabelle "cases" ein
INSERT INTO case_skins (probability, skin_id, case_name) VALUES
(0.0032, 1, 'Revolution'),
(0.0032, 2, 'Revolution'),
(0.010666666666666666, 3, 'Revolution'),
(0.010666666666666666, 4, 'Revolution'),
(0.010666666666666666, 5, 'Revolution'),
(0.03196, 6, 'Revolution'),
(0.03196, 7, 'Revolution'),
(0.03196, 8, 'Revolution'),
(0.03196, 9, 'Revolution'),
(0.03196, 10, 'Revolution'),
(0.11417142857142858, 11, 'Revolution'),
(0.11417142857142858, 12, 'Revolution'),
(0.11417142857142858, 13, 'Revolution'),
(0.11417142857142858, 14, 'Revolution'),
(0.11417142857142858, 15, 'Revolution'),
(0.11417142857142858, 16, 'Revolution'),
(0.11417142857142858, 17, 'Revolution'),
(0.0025, 35, 'Revolution');

-- Füge "Snakebite" case in die Tabelle "cases" ein
INSERT INTO case_skins (probability, skin_id, case_name) VALUES
(0.0032, 18, 'Snakebite'),
(0.0032, 19, 'Snakebite'),
(0.010666666666666666, 20, 'Snakebite'),
(0.010666666666666666, 21, 'Snakebite'),
(0.010666666666666666,22, 'Snakebite'),
(0.03196, 23, 'Snakebite'),
(0.03196, 24, 'Snakebite'),
(0.03196, 25, 'Snakebite'),
(0.03196, 26, 'Snakebite'),
(0.03196, 27, 'Snakebite'),
(0.11417142857142858, 28, 'Snakebite'),
(0.11417142857142858, 29, 'Snakebite'),
(0.11417142857142858, 30, 'Snakebite'),
(0.11417142857142858, 31, 'Snakebite'),
(0.11417142857142858, 32, 'Snakebite'),
(0.11417142857142858, 33, 'Snakebite'),
(0.11417142857142858, 34, 'Snakebite'),
(0.0025, 35, 'Snakebite');
