create table travel
(
    id              bigserial not null
        constraint travel_pkey
            primary key,
    end_date_time   timestamp,
    end_latitude    double precision,
    end_longitude   double precision,
    start_date_time timestamp not null,
    start_latitude  double precision,
    start_longitude double precision,
    driver          bigint    not null
        constraint fkmduw3hni6r73rnd3g1fwrekwj
            references driver,
    passenger       bigint    not null
        constraint fkbegm8dpyjfdofuqsdkod6e318
            references passenger
);

alter table travel
    owner to postgres;

INSERT INTO public.travel (id, end_date_time, end_latitude, end_longitude, start_date_time, start_latitude, start_longitude, driver, passenger) VALUES (1, '2021-06-16 12:13:34.000000', 5.807224416856433, -76.07209854304486, '2021-06-16 11:13:42.000000', 5.457359735792198, -75.96772843111737, 1, 3);
INSERT INTO public.travel (id, end_date_time, end_latitude, end_longitude, start_date_time, start_latitude, start_longitude, driver, passenger) VALUES (2, '2021-06-16 12:13:38.000000', 5.178414478275932, -76.2506263660787, '2021-06-16 11:13:46.000000', 5.156531126254301, -76.01991348708111, 2, 2);
INSERT INTO public.travel (id, end_date_time, end_latitude, end_longitude, start_date_time, start_latitude, start_longitude, driver, passenger) VALUES (3, '2021-06-16 12:13:39.000000', 5.178414478275932, -76.2506263660787, '2021-06-16 12:05:49.000000', 5.457359735792198, -76.01991348708111, 1, 1);
INSERT INTO public.travel (id, end_date_time, end_latitude, end_longitude, start_date_time, start_latitude, start_longitude, driver, passenger) VALUES (4, null, null, null, '2021-06-16 12:06:52.000000', 5.156531126254301, -75.96772843111737, 3, 2);
INSERT INTO public.travel (id, end_date_time, end_latitude, end_longitude, start_date_time, start_latitude, start_longitude, driver, passenger) VALUES (5, null, null, null, '2021-06-16 12:03:56.000000', 5.156531126254301, -76.01991348708111, 4, 4);