insert into VENUE(ID, VENUE_NAME, LINK_MORE_INFO, CITY, KIDS_FRIENDLY, FOOD_AVAILABLE, PARKING, CAPACITY)
values (1, 'BOCADERO', 'https://www.bocadero.be/nl/#', 'ANTWERPEN', false, true, true, 500);

insert into VENUE (ID, VENUE_NAME, LINK_MORE_INFO, CITY, KIDS_FRIENDLY, FOOD_AVAILABLE, PARKING, CAPACITY)
values (2, 'JARDIM', 'https://www.jardim-antwerp.be/', 'ANTWERPEN', false, true, true, 300);

insert into VENUE (ID, VENUE_NAME, LINK_MORE_INFO, CITY, KIDS_FRIENDLY, FOOD_AVAILABLE, PARKING, CAPACITY)
values (3, 'ZOMERFABRIEK', 'https://zomerfabriek.be/', 'ANTWERPEN', true, true, false, 200);

insert into VENUE (ID, VENUE_NAME, LINK_MORE_INFO, CITY, KIDS_FRIENDLY, FOOD_AVAILABLE, PARKING, CAPACITY)
values (4, 'ZOMERBAR', 'https://www.zva.be/zomerbar-circussen', 'ANTWERPEN', true, true, true, 500);

insert into VENUE (ID, VENUE_NAME, LINK_MORE_INFO, CITY, KIDS_FRIENDLY, FOOD_AVAILABLE, PARKING, CAPACITY)
values(5, 'BAR-N', 'http://bar-n.be/index.html', 'ESSEN', true, false, true, 50);

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 1, 'Discobaar a moeder', 'Discobaar A Moeder, een ondertussen legendarisch Antwerps fenomeen, draait al mee van in 2002. Het begon als een cafégrap van twee bevriende vinylfreaks, de grap houden ze er in, van draaien in een café genieten ze nog steeds, maar van een groots festival op z''n tijd zijn ze niet vies.', 'Pop, Soul, Disco', 'http://www.discobaaramoeder.be/', 'Lotto Arena 6/03/2020');

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 2, 'Radio Botanique', 'Radio Botanique: helemaal geen radio. Eigenlijk gewoon een discobaar. Vaste Parkpop (Mechelen) dansers en swingers.', 'voor de lol', 'https://www.facebook.com/radiobotanique/', 'bekend van Parkpop');

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 3, 'DJ Koen', 'Als allround DJ draai ik o.a. genres als de 90s, top 40, feest- en clubmuziek. Wekelijks draai ik op o.a. studentenfeesten, bruiloften, in kroegen, clubs en meer.', '90s, top 40, feest- en clubmuziek', 'https://www.facebook.com/DJKoenMossink/', '');

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 4, 'C-Man', '- 2nd place MNM Start To DJ 2016 - - Versuz - - Carré - - Sunrise Festival - - Ikon (Noxx) - - La Rocca - ... His First single ''Nothing is forever'' came out on 2Dutch (A music label from the Netherlands) in the summer of 2018.', 'deephouse, EDM', 'https://www.facebook.com/cmandj/', 'Q-hotspot 17/07/2020');

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 5, 'Robbe Roels', 'Wie Mechelen zegt zegt Robbe Roels, waar de 20-jarige dj 3 jaar geleden begon op kleine privé feestjes en gelegenheden draait hij nu elk weekend op de grootste fuiven in zijn regio. Al blijft het daar echter niet bij, andere studentensteden zoals o.a. Leuven maar evengoed de Normandische kust zijn al getroffen door zijn prestaties.', 'Allround, Dance, Techno', 'https://vi.be/platform/robberoels', 'Shake That Asspi 2020');

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 6, 'Toloko', 'My name is Stan, also known as Toloko, the DJ who adds the right amount of loco-ness to your party! I am an upcoming DJ talent in the region of Zemst, Belgium. I started my career behind the turntables at the age of 20 at local parties. Entertaining the crowd and making people dance to my music, makes me happy. Every gig, I bring my party people a new and customized set and I introduce them to the latest tracks.', 'house, r&b', 'https://www.toloko.be/', '');

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 7, 'Tough Titty', 'A Belgian Tribute to 80''s Glam and Heavy Metal', '', 'https://www.facebook.com/Tough-Titty-277601302444865', '');

INSERT INTO ARTIST ( ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES ( 8, 'Kryptonight', 'Twee kerels die er al vijf jaar van houden om het publiek uit hun dak te zien gaan! Onze missie: Het leven is een feest en daar moet gedanst worden. Hoe doen we dat? Met onze Latin-, Dancehall- en een vleugje Commercialplaten voor alle leeftijden zorgen we voor ieder wat wils.', 'Moombahton • Dancehall • Commercial', 'https://vi.be/platform/kryptonight', 'SOME GIG''s: Tomorrowland''s Dreamville, MnM Start to Dj Finalist Flowtrack Summer Camp Casa Blanca Festival Sunrise Festival Red ''n Blue Café Local Noxx Publik Vice Festival KdG TD ...');

INSERT INTO PARTY (ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors, venue_Id) VALUES (1, 'Big Spring Party', 6, 10, '1 cocktail included', '2021-03-21', '10:00', 1);
INSERT INTO PARTY (ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors, venue_Id) VALUES (2, 'Liberty 2021', 4, 6, 'free vestiaire, viplounge', '2021-04-3', '22:00', 2);
INSERT INTO PARTY (ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors, venue_Id) VALUES (3, 'Uppercuts', null, null, ' ', '2021-03-14', '21:00', 4);
INSERT INTO PARTY (ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors, venue_Id) VALUES (4, 'Zoetzuur', null, null, 'Zoete house / Zure techno', '2021-03-21', '21:00', 4);
INSERT INTO PARTY (ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors, venue_Id) VALUES (5, 'Oldies but Goldies', null, null, 'afterparty@home van THE BOX!', '2020-03-28', '21:00', 4);