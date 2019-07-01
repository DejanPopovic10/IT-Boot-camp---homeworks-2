SELECT OD as Datum
FROM Termin
GROUP by OD
HAVING count (OD)>=2
