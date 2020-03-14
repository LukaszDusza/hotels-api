
INSERT INTO pre_hotels.hotel (id, country, rate, title) VALUES (1, 'Poland', '5', 'Sobieski');
INSERT INTO pre_hotels.hotel (id, country, rate, title) VALUES (2, 'Germany', '4', 'Hitler Resort & SPA');
INSERT INTO pre_hotels.hotel (id, country, rate, title) VALUES (3, 'Poland', '3', 'Aparthotel Stare Miasto');
INSERT INTO pre_hotels.hotel (id, country, rate, title) VALUES (4, 'Hungary', '4', 'VIP Residence Budapest');
INSERT INTO pre_hotels.hotel (id, country, rate, title) VALUES (5, 'Italy', '3', 'Mecenate Charme - My Extra Home');
INSERT INTO pre_hotels.hotel (id, country, rate, title) VALUES (6, 'Italy', '4', 'Mecenate Charme - My Extra Home 2');

INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (1, 1);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (1, 2);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (1, 2);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (1, 1);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (1, 1);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (2, 1);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (2, 2);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (3, 1);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (3, 1);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (4, 2);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (5, 1);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (5, 2);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (5, 2);
INSERT INTO pre_hotels.hotel_room (hotel_id, room_id) VALUES (6, 2);

INSERT INTO pre_hotels.address (id, city, email, phone, street, street_no, url, hotel_id) VALUES (1, 'Warszawa', 'kontakt@sobieski-hotel.pl', '+48221254588', 'al. jerozolimskie', '190/2', 'https://www.sobieski.pl', 1);
INSERT INTO pre_hotels.address (id, city, email, phone, street, street_no, url, hotel_id) VALUES (2, 'Berlin', 'hitla-hotel@germany.de', '+40555232356', 'Lennin strasse', '45A', 'http://www/hitler-hotel.de', 2);
INSERT INTO pre_hotels.address (id, city, email, phone, street, street_no, url, hotel_id) VALUES (3, 'Kraków', 'hotel@hotel-krakow.pl', '+48402323235', 'ul. warszawska', '150', 'http://apart-hotel.pl', 3);
INSERT INTO pre_hotels.address (id, city, email, phone, street, street_no, url, hotel_id) VALUES (4, 'Budapeszt', 'hungary-hotel@budapest.hu', '+33458721245', 'ul. hungary', '45B/120', 'https://hungary-hotel.pl', 4);
INSERT INTO pre_hotels.address (id, city, email, phone, street, street_no, url, hotel_id) VALUES (5, 'Rzym', 'rzym@rzym-hotel.pl', '+78456321465', 'ul. rzymska', '100/100', 'https://italia-hotles.it', 5);
INSERT INTO pre_hotels.address (id, city, email, phone, street, street_no, url, hotel_id) VALUES (6, 'Rzym', 'rzym@rzym-hotel.pl', '+78456321465', 'ul. rzymska', '100/200', 'https://italia-hotles.it', 6);
