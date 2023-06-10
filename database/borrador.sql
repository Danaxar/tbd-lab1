select * from voluntario;
select * from institucion;
select * from emergencia;
select * from emergencia_habilidad;


insert into institucion(nombre)
values ('Bomberos'), ('Carabineros'), ('Cruz roja');

INSERT INTO habilidad (nombre)
VALUES
    ('Primeros auxilios'),
    ('Rescate y evacuación'),
    ('Extinción de incendios'),
    ('Búsqueda y rescate'),
    ('Manejo de crisis y gestión de incidentes'),
    ('Evaluación de daños y necesidades'),
    ('Comunicación de emergencia'),
    ('Conocimientos de construcción y estructuras'),
    ('Gestión de logística y suministros'),
    ('Habilidades de navegación y orientación');
