CREATE VIEW v_bouquet_activite AS
SELECT 
    bouquet.idBouquet,
    activite.idActivite, 
    activite.nom AS nom_activite 
FROM bouquet
JOIN bouquet_activite ON bouquet.idBouquet = bouquet_activite.idBouquet
JOIN activite ON activite.idActivite = bouquet_activite.idActivite;