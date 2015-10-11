INSERT INTO users (name, surname, birth, email, password) VALUES ('Airouche', 'Meidi', '1988-11-13', 'meidi.airouche@gmail.com', 'vjZn7mxIbux578oxUfoU1A==');
INSERT INTO roles(RUID, name) VALUES('ADM', 'ADMIN');
INSERT INTO applications(AUID, name) VALUES('FRG', 'Forge Argonot');
INSERT INTO authorizations(id_user, AUID, RUID) VALUES(1, 'FRG', 'ADM');