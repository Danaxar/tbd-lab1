select
    *
from
    voluntario;

select
    *
from
    institucion;

select
    *
from
    emergencia;

select
    *
from
    emergencia_habilidad;

insert into
    institucion(nombre)
values
    ('Bomberos'),
    ('Carabineros'),
    ('Cruz roja');

INSERT INTO
    habilidad (nombre)
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

INSERT INTO
    emergencia (
        nombre,
        gravedad,
        fecha,
        Region,
        longitud,
        latitud,
        geom,
        estado
    )
VALUES
    (
        'Terremoto',
        'Alta',
        '2022-11-01',
        'Metropolitana',
        -70.6483,
        -33.4567,
        ST_MakePoint(-70.6483, -33.4567),
        'Activa'
    ),
    (
        'Inundación',
        'Media',
        '2022-12-10',
        'Valparaíso',
        -71.6328,
        -33.0472,
        ST_MakePoint(-71.6328, -33.0472),
        'Activa'
    ),
    (
        'Incendio forestal',
        'Alta',
        '2023-01-15',
        'Araucanía',
        -72.9352,
        -38.7414,
        ST_MakePoint(-72.9352, -38.7414),
        'Activa'
    ),
    (
        'Deslizamiento de tierra',
        'Baja',
        '2023-02-20',
        'OHiggins',
        -70.9667,
        -34.6633,
        ST_MakePoint(-70.9667, -34.6633),
        'Activa'
    ),
    (
        'Sequía',
        'Media',
        '2023-03-25',
        'Maule',
        -71.5375,
        -35.675,
        ST_MakePoint(-71.5375, -35.675),
        'Activa'
    ),
    (
        'Temporal de viento',
        'Alta',
        '2023-04-30',
        'Biobío',
        -73.0503,
        -36.7789,
        ST_MakePoint(-73.0503, -36.7789),
        'Activa'
    ),
    (
        'Accidente de tránsito',
        'Media',
        '2023-05-05',
        'Los Ríos',
        -72.6361,
        -39.8383,
        ST_MakePoint(-72.636, -39.8383),
        'Activa'
    ),
    (
        'Incendio estructural',
        'Alta',
        '2023-06-01',
        'Aysén',
        -72.7095,
        -45.5714,
        ST_MakePoint(-72.7095, -45.5714),
        'Activa'
    ),
    (
        'Erupción volcánica',
        'Alta',
        '2023-07-10',
        'Magallanes',
        -72.9322,
        -53.1639,
        ST_MakePoint(-72.9322, -53.1639),
        'Activa'
    ),
    (
        'Desbordamiento de río',
        'Media',
        '2023-08-15',
        'Antofagasta',
        -70.3133,
        -23.6519,
        ST_MakePoint(-70.3133, -23.6519),
        'Activa'
    ),
    (
        'Nevada',
        'Baja',
        '2023-09-20',
        'Atacama',
        -69.6706,
        -27.3667,
        ST_MakePoint(-69.6706, -27.3667),
        'Activa'
    ),
    (
        'Incidente químico',
        'Media',
        '2023-10-25',
        'Coquimbo',
        -71.3381,
        -29.9592,
        ST_MakePoint(-71.3381, -29.9592),
        'Activa'
    ),
    (
        'Tsunami',
        'Alta',
        '2023-11-01',
        'Tarapacá',
        -70.145,
        -20.2275,
        ST_MakePoint(-70.145, -20.2275),
        'Activa'
    ),
    (
        'Derrame de petróleo',
        'Alta',
        '2023-12-10',
        'Los Lagos',
        -73.045,
        -41.4719,
        ST_MakePoint(-73.045, -41.4719),
        'Activa'
    ),
    (
        'Colapso estructural',
        'Media',
        '2024-01-15',
        'Valparaíso',
        -71.6428,
        -33.0453,
        ST_MakePoint(-71.6428, -33.0453),
        'Activa'
    ),
    (
        'Ciclón',
        'Alta',
        '2024-02-20',
        'Maule',
        -71.5397,
        -35.6769,
        ST_MakePoint(-71.5397, -35.6769),
        'Activa'
    );