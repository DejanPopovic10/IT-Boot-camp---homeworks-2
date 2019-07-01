/* --- Zad 1 --- */ 
SELECT Cena FROM Karta 
WHERE Cena > 450 AND Status = 'N' 

/* --- Zad 2 --- */
SELECT  IdLet, MestoOd AS 'Mesto poletanja', MestoDo AS 'Mesto sletanja'
FROM Let  
WHERE Poletanje IS NOT NULL

/* --- Zad 3 --- */
SELECT SUM(PotrGoriva) AS Ukupno, AVG(PotrGoriva) AS Prosek 
FROM Let  
WHERE MestoOd = 'Istanbul' AND Status = 'Z' 
ORDER BY Ukupno DESC, Prosek DESC 

/* --- Zad 4 --- */
SELECT L.IdLet AS IdLet, L.MestoOd AS MestoOd,  
L.MestoDo AS MestoDo, SUM(Cena) AS Zaradjeno 
FROM Let L, Karta K 
WHERE L.IdLet = K.IdLet AND L.Status != 'O' AND K.Status = 'K' 
GROUP BY L.IdLet, L.MestoOd, L.MestoDo 

/* --- Zad 5 --- */
SELECT Let.MestoDo AS MestoDo, MIN(Karta.Cena) AS MinCena, Max(Karta.Cena) AS MaxCena 
FROM Let, Karta
WHERE Let.IdLet = Karta.IdLet AND Let.Status != 'O' AND Let.Poletanje >= 20190101 AND Let.Poletanje < 20190401 AND Karta.Status = 'K' 
GROUP BY Let.MestoDo 
HAVING (SUM(Karta.Cena) >= 300 AND COUNT(*) >= 2); 