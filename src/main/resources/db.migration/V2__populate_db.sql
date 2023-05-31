INSERT INTO Client (name)
VALUES ('Client 1'), ('Client 2'), ('Client 3'), ('Client 4'), ('Client 5'),
    ('Client 6'), ('Client 7'), ('Client 8'), ('Client 9'), ('Client 10');

INSERT INTO Planet (id, name)
VALUES ('MARS', 'Mars'), ('VEN', 'Venus'), ('EARTH', 'Earth'), ('JUP', 'Jupiter'), ('SAT', 'Saturn'),('URAN', 'Uranus'),
       ('NEP', 'Neptune'), ('PLUTO', 'Pluto'), ('MN', 'Moon');

-- Вибірка даних з таблиці "Client" та "Planet" для використання при створенні квитків
SET @client_count = (SELECT COUNT(*) FROM Client);
SET @planet_count = (SELECT COUNT(*) FROM Planet);

-- Вставка даних для таблиці "Ticket"
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id)
SELECT
    FLOOR(RAND() * @client_count) + 1 AS client_id,
    (SELECT id FROM Planet ORDER BY RAND() LIMIT 1) AS from_planet_id,
    (SELECT id FROM Planet ORDER BY RAND() LIMIT 1) AS to_planet_id
FROM
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5
    UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10) AS numbers;
