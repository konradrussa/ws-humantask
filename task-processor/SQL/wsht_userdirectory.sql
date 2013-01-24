    --groups
    INSERT INTO groupentityinfo(
            id, groupcode, groupname, regionname)
    VALUES (nextval('hibernate_sequence'), 'ceo', 'CEO	Global', 'Global');
    INSERT INTO groupentityinfo(
            id, groupcode, groupname, regionname)
    VALUES (nextval('hibernate_sequence'), 'salesrep_west', 'SalesRep (West)', 'West');
    INSERT INTO groupentityinfo(
            id, groupcode, groupname, regionname)
    VALUES (nextval('hibernate_sequence'), 'manager_west', 'Manager (West)', 'West');
    INSERT INTO groupentityinfo(
            id, groupcode, groupname, regionname)
    VALUES (nextval('hibernate_sequence'), 'salesrep_east', 'SalesRep (East)', 'East');
    INSERT INTO groupentityinfo(
            id, groupcode, groupname, regionname)
    VALUES (nextval('hibernate_sequence'), 'manager_east', 'Manager (East)', 'East');

    --users
    INSERT INTO userentityinfo(
            id, active, "name",  "password", username, email)
    VALUES (nextval('hibernate_sequence'), true, 'John Abrams', 'pass123', 'jabrams', 'konrad.russa@gmail.com');
    INSERT INTO userentityinfo(
            id, active, "name", "password", username, email)
    VALUES (nextval('hibernate_sequence'), true, 'Kate Batty', 'pass123', 'kbatty', 'konrad.russa@gmail.com');
    INSERT INTO userentityinfo(
            id, active, "name", "password", username, email)
    VALUES (nextval('hibernate_sequence'), true, 'Jan Kowalski', 'pass123', 'jkowalski', 'konrad.russa@gmail.com');
    INSERT INTO userentityinfo(
            id, active, "name", "password", username, email)
    VALUES (nextval('hibernate_sequence'), true, 'Anna Pogodna', 'pass123', 'apogodna', 'konrad.russa@gmail.com');
    INSERT INTO userentityinfo(
            id, active, "name", "password", username, email)
    VALUES (nextval('hibernate_sequence'), true, 'Jacek CEO Olszewski', 'pass123', 'jceo', 'konrad.russa@gmail.com');
