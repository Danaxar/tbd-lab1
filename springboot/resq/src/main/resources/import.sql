
INSERT INTO institucion(nombre) VALUES ('Bomberos');
INSERT INTO institucion(nombre) VALUES ('Carabineros');
INSERT INTO institucion(nombre) VALUES ('Cruz roja');

INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Terremoto', 'Alta', '2022-11-01', 'Activa', 'Metropolitana', -70.6483, -33.4567, ST_PointFromText('POINT(' || '-70.6483' || ' ' || '-33.4567' || ')'), 1);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Inundación', 'Media', '2022-12-10', 'Finalizada', 'Valparaíso', -71.6328, -33.0472, ST_PointFromText('POINT(' || '-71.6328' || ' ' || '-33.0472' || ')'), 3);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Incendio forestal', 'Alta', '2023-01-15', 'Activa', 'Araucanía', -72.9352, -38.7414, ST_PointFromText('POINT(' || '-72.9352' || ' ' || '-38.7414' || ')'), 1);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Deslizamiento de tierra', 'Baja', '2023-02-20', 'Finalizada', 'OHiggins', -70.9667, -34.6633, ST_PointFromText('POINT(' || '-70.9667' || ' ' || '-34.6633' || ')'), 2);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Sequía', 'Media', '2023-03-25', 'Activa', 'Maule', -71.5375, -35.675, ST_PointFromText('POINT(' || '-71.5375' || ' ' || '-35.675' || ')'), 3);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Temporal de viento', 'Alta', '2023-04-30', 'Finalizada', 'Biobío', -73.0503, -36.7789, ST_PointFromText('POINT(' || '-73.0503' || ' ' || '-36.7789' || ')'), 1);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Accidente de tránsito', 'Media', '2023-05-05', 'Activa', 'Los Ríos', -72.6361, -39.8383, ST_PointFromText('POINT(' || '-72.636' || ' ' || '-39.8383' || ')'), 2);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Incendio estructural', 'Alta', '2023-01-20', 'Finalizada', 'Aysén', -72.7095, -45.5714, ST_PointFromText('POINT(' || '-72.7095' || ' ' || '-45.5714' || ')'), 3);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Erupción volcánica', 'Alta', '2022-12-26', 'Activa', 'Magallanes', -72.9322, -53.1639, ST_PointFromText('POINT(' ||'-72.9322' || ' ' || '-53.1639' || ')'), 1);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Desbordamiento de río', 'Media', '2023-05-08', 'Finalizada', 'Antofagasta', -70.3133, -23.6519, ST_PointFromText('POINT(' || '-70.3133' || ' ' || '-23.6519' || ')'), 2);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Nevada', 'Baja', '2023-02-13', 'Activa', 'Atacama', -69.6706, -27.3667, ST_PointFromText('POINT(' || '-69.6706' || ' ' || '-27.3667' || ')'), 3);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Incidente químico', 'Media', '2023-02-01', 'Finalizada', 'Coquimbo', -71.3381, -29.9592, ST_PointFromText('POINT(' || '-71.3381' || ' ' || '-29.9592' || ')'), 1);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Tsunami', 'Alta', '2023-01-30', 'Activa', 'Tarapacá', -70.145, -20.2275, ST_PointFromText('POINT(' || '-70.145' || ' ' || '-20.2275' || ')'), 2);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Derrame de petróleo', 'Alta', '2023-02-10', 'Finalizada', 'Los Lagos', -73.045, -41.4719, ST_PointFromText('POINT(' || '-73.045' || ' ' || '-41.4719' || ')'), 3);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Colapso estructural', 'Media', '2023-04-19', 'Activa', 'Valparaíso', -71.6428, -33.0453, ST_PointFromText('POINT(' || '-71.6428' || ' ' || '-33.0453' || ')'), 1);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Ciclón', 'Alta', '2023-04-01', 'Finalizada', 'Maule', -71.5397, -35.6769, ST_PointFromText('POINT(' || '-71.5397' || ' ' || '-35.6769' || ')'), 2);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Fuga de gas', 'Media', '2023-01-05', 'Activa', 'Biobío', -73.0503, -36.7789, ST_PointFromText('POINT(' || '-73.0503' || ' ' || '-36.7789 '|| ')'), 3);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Incidente eléctrico', 'Baja', '2023-01-24', 'Finalizada', 'Los Ríos', -72.6361, -39.8383, ST_PointFromText('POINT(' || '-72.6361' || ' ' || '-39.8383' || ')'), 1);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Deslave', 'Alta', '2023-02-27', 'Activa', 'Aysén', -72.7095, -45.5714, ST_PointFromText('POINT(' || '-72.7095' || ' ' || '-45.5714' || ')'), 2);
INSERT INTO emergencia(nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) VALUES ('Explosión', 'Alta', '2023-04-04', 'Finalizada', 'Magallanes', -72.9322, -53.1639, ST_PointFromText('POINT(' || '-72.9322' || ' ' || '-53.1639' || ')'), 3);

INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('22222222-2', 'Maria', 'Lopez', '1985-09-20', 'Todos los dias', '+56987654321', 'Coordinador', 'password2', 'Valparaiso', -71.5393, -33.0458, ST_PointFromText('POINT(' || '-71.5393' || ' ' || '-33.0458' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('33333333-3', 'Pedro', 'Gonzalez', '1992-02-10', 'Todos los dias', '+56955555555', 'Voluntario', 'password3', 'Biobio', -73.1415, -36.8262, ST_PointFromText('POINT(' || '-73.1415' || ' ' || '-36.8262' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('44444444-4', 'Carolina', 'Rojas', '1988-07-02', 'Todos los dias', '+56977777777', 'Voluntario', 'password4', 'Araucania', -72.9435, -38.7396, ST_PointFromText('POINT(' || '-72.9435' || ' ' || '-38.7396' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('55555555-5', 'Luis', 'Hernandez', '1995-12-28', 'Todos los dias', '+56999999999', 'Administrador', 'password5', 'Antofagasta', -70.4034, -23.6519, ST_PointFromText('POINT(' || '-70.4034' || ' ' || '-23.6519' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('66666666-6', 'Ana', 'Martinez', '1993-03-18', 'Todos los dias', '+56944444444', 'Voluntario', 'password6', 'Magallanes', -70.9519, -53.1625, ST_PointFromText('POINT(' || '-70.9519' || ' ' || '-53.1625' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('77777777-7', 'Jorge', 'Silva', '1991-11-05', 'Todos los dias', '+56933333333', 'Voluntario', 'password7', 'OHiggins', -70.7416, -34.1633, ST_PointFromText('POINT(' || '-70.7416' || ' ' || '-34.1633' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('88888888-8', 'Fernanda', 'Garcia', '1987-04-12', 'Todos los dias', '+56922222222', 'Voluntario', 'password8', 'Los Lagos', -72.9392, -41.4718, ST_PointFromText('POINT(' || '-72.9392' || ' ' || '-41.4718' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('99999999-9', 'Gabriel', 'Torres', '1994-08-22', 'Todos los dias', '+56966666666', 'Voluntario', 'password9', 'Tarapaca', -69.6298, -20.2167, ST_PointFromText('POINT(' || '-69.6298' || ' ' || '-20.2167' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('10101010-0', 'Valentina', 'Fuentes', '1989-01-07', 'Todos los dias', '+56911111111', 'Voluntario', 'password10', 'Atacama', -70.1418, -27.3661, ST_PointFromText('POINT(' || '-70.1418' || ' ' || '-27.3661' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('12121212-1', 'Roberto', 'Gomez', '1990-08-12', 'Todos los dias', '+569555111222', 'Coordinador', 'password11', 'Maule', -71.5377, -35.6747, ST_PointFromText('POINT(' || '-71.5377' || ' ' || '-35.6747' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('13131313-1', 'Andrea', 'Vargas', '1987-03-25', 'Todos los dias', '+569999888777', 'Voluntario', 'password12', 'Coquimbo', -71.3395, -29.9533, ST_PointFromText('POINT(' || '-71.3395' || ' ' || '-29.9533' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('14141414-1', 'Rodrigo', 'Sanchez', '1993-11-08', 'Todos los dias', '+569333777999', 'Voluntario', 'password13', 'Los Rios', -72.6423, -40.5762, ST_PointFromText('POINT(' || '-72.6423' || ' ' || '-40.5762' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('15151515-1', 'Laura', 'Mendoza', '1989-06-19', 'Todos los dias', '+569888777555', 'Voluntario', 'password14', 'Ñuble', -72.3096, -36.7194, ST_PointFromText('POINT(' || '-72.3096' || ' ' || '-36.7194' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('16161616-1', 'Sergio', 'Fernandez', '1996-02-03', 'Todos los dias', '+569444222888', 'Voluntario', 'password15', 'Arica y Parinacota', -70.3333, -18.4783, ST_PointFromText('POINT(' || '-70.3333' || ' ' || '-18.4783' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('17171717-1', 'Camila', 'Vera', '1991-09-14', 'Todos los dias', '+569111999666', 'Voluntario', 'password16', 'Valparaiso', -71.6256, -32.8222, ST_PointFromText('POINT(' || '-71.6256' || ' ' || '-32.8222' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('18181818-1', 'Felipe', 'Navarro', '1988-05-27', 'Todos los dias', '+569222777888', 'Voluntario', 'password17', 'Antofagasta', -69.5296, -24.1616, ST_PointFromText('POINT(' || '-69.5296' || ' ' || '-24.1616' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('19191919-1', 'Natalia', 'Cortes', '1994-12-10', 'Todos los dias', '+569666888999', 'Voluntario', 'password18', 'Magallanes', -70.8972, -53.1631, ST_PointFromText('POINT(' || '-70.8972' || ' ' || '-53.1631' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('20202020-1', 'Diego', 'Cruz', '1992-03-23', 'Todos los dias', '+569444888777', 'Voluntario', 'password19', 'Metropolitana', -70.6413, -33.0476, ST_PointFromText('POINT(' || '-70.6413' || ' ' || '-33.0476' || ')'));
INSERT INTO voluntario(rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) VALUES('21212121-1', 'Carla', 'Gonzalez', '1986-10-06', 'Todos los dias', '+569333888999', 'Voluntario', 'password20', 'Atacama', -70.2490, -26.3663, ST_PointFromText('POINT(' || '-70.2490' || ' ' || '-26.3663' || ')'));

INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (1, 1);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (1, 2);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (3, 3);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (3, 4);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (5, 5);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (5, 6);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (7, 7);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (7, 8);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (9, 9);
INSERT INTO voluntario_emergencia(id_emergencia, id_voluntario) VALUES (9, 12);

INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Remover escombros', 'Se necesita Remover escombros', 'Metropolitana', -70.6480, -33.4550, ST_PointFromText('POINT(' || '-70.2490' || ' ' || '-26.3663' || ')'), 1, 1);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Ayudar heridos', 'Se necesita Ayudar heridos','Metropolitana', -70.6482, -33.4565, ST_PointFromText('POINT(' || '-70.6482' || ' ' || '-33.4565' || ')'), 1, 1);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Entregar suministros', 'Se necesita Entregar suministros', 'Metropolitana', -70.6400, -33.4500, ST_PointFromText('POINT(' || '-70.6400' || ' ' || '-33.4500' || ')'), 2, 1);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Chofer de retroescavadora', 'Se necesita Chofer de retroescavadora', 'Metropolitana', -70.6475, -33.4575, ST_PointFromText('POINT(' || '-70.6475' || ' ' || '-33.4575' || ')'), 2, 1);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Coordinación de voluntarios', 'Se necesita Coordinación de voluntarios', 'Valparaíso', -71.6330, -33.0470, ST_PointFromText('POINT(' || '-71.6330' || ' ' || '-33.0470' || ')'), 1, 2);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Evaluación de daños', 'Se necesita Evaluación de daños', 'Valparaíso', -71.6329, -33.0473, ST_PointFromText('POINT(' || '-71.6329' || ' ' || '-33.0473' || ')'), 1, 2);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Apoyo logístico', 'Se necesita Apoyo logístico', 'Valparaíso', -71.6328, -33.0475, ST_PointFromText('POINT(' || '-71.6328' || ' ' || '-33.0475' || ')'), 2, 2);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Apoyo emocional', 'Se necesita Apoyo emocional', 'Valparaíso', -71.6328, -33.0474, ST_PointFromText('POINT(' || '-71.6328' || ' ' || '-33.0474' || ')'), 2, 2);
INSERT INTO tarea(nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) VALUES ('Busqueda y rescate', 'Se necesita Busqueda y rescate', 'Valparaíso', -71.6327, -33.0471, ST_PointFromText('POINT(' || '-71.6327' || ' ' || '-33.0471' || ')'), 1, 2);

INSERT INTO habilidad(nombre) VALUES ('Primeros auxilios'),('Rescate y evacuación'),('Extinción de incendios'),('Búsqueda y rescate'),('Manejo de crisis y gestión de incidentes'),('Evaluación de daños y necesidades'),('Comunicación de emergencia'),('Conocimientos de construcción y estructuras'),('Gestión de logística y suministros'),('Habilidades de navegación y orientación');

INSERT INTO estado(nombre) VALUES ('Activa'),('Finalizada');