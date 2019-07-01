SELECT Skijaliste.Naziv,Skijaliste.BrStaza, Termin.Od, Termin.Do, Termin.Cena
FROM Skijaliste JOIN Termin USING (IdSki)
WHERE Skijaliste.BrStaza>15
ORDER BY OD ASC, BrStaza DESC

