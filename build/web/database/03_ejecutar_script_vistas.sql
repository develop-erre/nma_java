CREATE VIEW 
vista_lista_empresas AS 
select empresa.id_empresa id,
empresa.nombre nombre,
empresa.rut rut,
sucursal.nombre nombre_sucursal,
CONCAT(sucursal.direccion, " - ",comuna.nombre_comuna, " - ",region.nombre_region) AS direccion_empresa
from empresa 
JOIN sucursal ON id_empresa_fk = empresa.id_empresa
JOIN comuna ON sucursal.id_comuna_suc_fk = comuna.id_comuna
JOIN region ON comuna.id_region_fk = region.id_region
WHERE sucursal.nombre LIKE 'CASA MATRIZ%' AND empresa.estado = 0;

-----------------------------------------------------------

