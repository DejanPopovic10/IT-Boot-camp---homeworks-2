/* --- Generisanje --- */ 
DROP TABLE IF EXISTS Skijaliste;
CREATE TABLE Skijaliste (IdSki INTEGER PRIMARY KEY, 
 Naziv VARCHAR(45) NOT NULL, 
 BrStaza INTEGER, 
 Osnezenje CHAR(1)) ;
 
INSERT INTO Skijaliste(IdSki,Naziv,BrStaza,Osnezenje)
VALUES (1, 'Kopaonik', 25, 'D'),
 (2, 'Zlatibor', 4, 'N'),
 (3, 'Les 2 Alpes', 96, 'D'),
 (4, 'Paradiski', 253, 'D'),
 (5, 'Chatel', 49, NULL),
 (6,'Bansko', 18, 'D');
 
DROP TABLE IF EXISTS Termin;
CREATE TABLE Termin (IdTer INTEGER PRIMARY KEY, 
 Od INTEGER NOT NULL, 
 Do INTEGER NOT NULL, 
 IdSki INTEGER,
 Cena INTEGER) ;
 
INSERT INTO Termin(IdTer,Od,Do,IdSki,Cena)
VALUES (1, 20181229, 20190105, 1, 350), 
 (2, 20190105, 20190112, 1, 230),
 (3, 20190126, 20190202, 6, 165),
 (4, 20190125, 20190203, 3, 396),
 (5, 20190201, 20190210, 3, 410),
 (6, 20190308, 20190317, 3, 379);

/* --- Zad 1 --- */ 
DELETE FROM Termin 
WHERE Cena  >400 

/* --- Zad 2 --- */
UPDATE Skijaliste 
SET Osnezenje = 'D' 
WHERE IdSki = 2

/* --- Zad 3 --- */
INSERT INTO Termin(IdTer, Od, Do, IdSki, Cena) VALUES ( 7, 20190213, 20190217, 1, 170)

/* --- Zad 4 --- */
SELECT AVG(BrStaza) AS Prosek FROM Skijaliste
WHERE Osnezenje = 'D' AND BrStaza > 10

/* --- Zad 5 --- */
SELECT Naziv, BrStaza, Od, Do, Cena 
FROM Termin T, Skijaliste S 
WHERE T.IdSki = S.IdSki AND BrStaza > 15 
ORDER BY Od, BrStaza DESC 

/* --- Zad 6 --- */
SELECT Od AS Datum
FROM Termin
GROUP BY Od 
HAVING COUNT(*) >= 2