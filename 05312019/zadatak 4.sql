SELECT round (sum (BrStaza)/count (BrStaza),2) as Prosek
FROM Skijaliste
WHERE BrStaza>10 and Osnezenje = "D"
