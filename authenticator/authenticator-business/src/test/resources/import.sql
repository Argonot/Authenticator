INSERT INTO users (name, surname, birth, email, password, locked, tries) VALUES ('Airouche', 'Meidi', '1988-11-13', 'meidi.airouche@gmail.com', 'vjZn7mxIbux578oxUfoU1A==', false, 0);
INSERT INTO users (name, surname, birth, email, password, locked, tries) VALUES ('User', 'Test', '1989-11-10', 'test@gmail.com', 'vjZn7mxIbux578oxUfoU1A==', true, 3);
INSERT INTO applications(AUID, name) VALUES('TKP', 'Trello KPI');
INSERT INTO applications(AUID, name) VALUES('FRG', 'Forge Argonot');
INSERT INTO authorizations(id_user, AUID) VALUES(1, 'FRG');
INSERT INTO authorizations(id_user, AUID) VALUES(2, 'TKP');