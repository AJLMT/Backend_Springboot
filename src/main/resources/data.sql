INSERT INTO category(name) VALUES ('Eurogames');
INSERT INTO category(name) VALUES ('Ameritrash');
INSERT INTO category(name) VALUES ('Familiar');

INSERT INTO author(name, nationality) VALUES ('Alan R. Moon', 'US');
INSERT INTO author(name, nationality) VALUES ('Vital Lacerda', 'PT');
INSERT INTO author(name, nationality) VALUES ('Simone Luciani', 'IT');
INSERT INTO author(name, nationality) VALUES ('Perepau Llistosella', 'ES');
INSERT INTO author(name, nationality) VALUES ('Michael Kiesling', 'DE');
INSERT INTO author(name, nationality) VALUES ('Phil Walker-Harding', 'US');

INSERT INTO game(title, age, category_id, author_id, img) VALUES ('On Mars', '14', 1, 2, 'On_Mars.png');
INSERT INTO game(title, age, category_id, author_id, img) VALUES ('Aventureros al tren', '8', 3, 1, 'Aventureros_al_Tren.png');
INSERT INTO game(title, age, category_id, author_id, img) VALUES ('1920: Wall Street', '12', 1, 4, 'wall_Street.png');
INSERT INTO game(title, age, category_id, author_id, img) VALUES ('Barrage', '14', 1, 3, 'Barrage.png');
INSERT INTO game(title, age, category_id, author_id, img) VALUES ('Los viajes de Marco Polo', '12', 1, 3, 'Marco_Polo.png');
INSERT INTO game(title, age, category_id, author_id, img) VALUES ('Azul', '8', 3, 5, 'Azul.png');

INSERT INTO client(name) VALUES ('Cliente 1');
INSERT INTO client(name) VALUES ('Cliente 2');
INSERT INTO client(name) VALUES ('Cliente 3');
INSERT INTO client(name) VALUES ('Cliente 4');
INSERT INTO client(name) VALUES ('Cliente 5');

INSERT INTO prestamo(game_name, client_name, ini_Date, end_Date) VALUES ('On Mars', 'Cliente 1', '2025-02-1', '2025-02-12');
INSERT INTO prestamo(game_name, client_name, ini_Date, end_Date) VALUES ('Azul', 'Cliente 2', '2025-02-5', '2025-02-12');
INSERT INTO prestamo(game_name, client_name, ini_Date, end_Date) VALUES ('Aventureros al tren', 'Cliente 1', '2025-02-13', '2025-03-12');
INSERT INTO prestamo(game_name, client_name, ini_Date, end_Date) VALUES ('Barrage', 'Cliente 3', '2025-02-11', '2025-02-15');
INSERT INTO prestamo(game_name, client_name, ini_Date, end_Date) VALUES ('On Mars', 'Cliente 2', '2025-03-13', '2025-03-15');
INSERT INTO prestamo(game_name, client_name, ini_Date, end_Date) VALUES ('Azul', 'Cliente 5', '2025-02-13', '2025-02-15');
