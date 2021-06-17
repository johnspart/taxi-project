create table driver
(
    id            bigserial    not null
        constraint driver_pkey
            primary key,
    date_of_birth date         not null,
    latitude      double precision,
    longitude     double precision,
    last_name     varchar(255) not null,
    name          varchar(255) not null
);

alter table driver
    owner to postgres;

INSERT INTO public.driver (id, date_of_birth, latitude, longitude, last_name, name) VALUES (1, '2021-06-18', 5.4979178000818845, -76.62304302923185, 'Prueba 1', 'Apellido 1');
INSERT INTO public.driver (id, date_of_birth, latitude, longitude, last_name, name) VALUES (2, '2021-06-18', 5.49791780008189, -76.62304302923185, 'Prueba 2', 'Apellido 2');
INSERT INTO public.driver (id, date_of_birth, latitude, longitude, last_name, name) VALUES (3, '2021-06-18', 5.4979178000818845, -76.62304302923985, 'Prueba 3', 'Apellido 3');
INSERT INTO public.driver (id, date_of_birth, latitude, longitude, last_name, name) VALUES (4, '2021-06-18', 5.4979178000818845, -76.62304702923885, 'Prueba 4', 'Apellido 4');
INSERT INTO public.driver (id, date_of_birth, latitude, longitude, last_name, name) VALUES (5, '2021-06-18', 5.497917889081885, -76.62308702923185, 'Prueba 5', 'Apellido 5');