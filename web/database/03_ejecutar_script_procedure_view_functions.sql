/*
VISTA TRAE REGION Y COMUNA CONCATENADA
*/

CREATE VIEW 
vista_region_comuna AS
SELECT 
    comuna.id_comuna
    ,CONCAT(region.nombre_region, " - ",comuna.nombre_comuna) AS nombre_comuna
FROM comuna
    JOIN region ON comuna.id_region_fk = region.id_region
ORDER BY 1 DESC;


/*
CREACION DE VISTA DE EMPRESAS 
DONDE SOLO SE VERA LA CASA MATRIZ COMO LA DIRECCION
*/
CREATE VIEW 
    vista_lista_empresas AS 
SELECT 
    empresa.id_empresa id_empresa,
    empresa.nombre nombre_empresa,
    empresa.rut rut,
    sucursal.nombre nombre_sucursal,
    direccion.nombre_calle,
    direccion.numero,
    comuna.nombre_comuna comuna,
    region.nombre_region region
FROM empresa 
    JOIN sucursal ON sucursal.id_empresa_fk = empresa.id_empresa
    JOIN direccion ON sucursal.id_direccion_suc_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE sucursal.casa_matriz=0 AND empresa.estado = 0
ORDER BY 2 ASC;

/*
CREACION DE VISTA DE EMPRESAS 
DONDE SOLO SE LISTARA LAS EMPRESAS DESHABILITADAS
*/
CREATE VIEW 
    vista_lista_empresas_des AS 
SELECT 
    empresa.id_empresa id_empresa,
    empresa.nombre nombre_empresa,
    empresa.rut rut,
    sucursal.nombre nombre_sucursal,
    direccion.nombre_calle,
    direccion.numero,
    comuna.nombre_comuna comuna,
    region.nombre_region region
FROM empresa 
    JOIN sucursal ON sucursal.id_empresa_fk = empresa.id_empresa
    JOIN direccion ON sucursal.id_direccion_suc_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE sucursal.casa_matriz=0 AND empresa.estado = 1
ORDER BY 2 ASC;

/*
CREACION DE VISTA DE USUARIO 
DONDE SOLO SE LISTARA USUARIOS HABILITADOS
*/
CREATE VIEW 
    vista_lista_usuarios AS 
SELECT 
    usuario.id_usuario,
    usuario.nombre,
    usuario.apellidos,
    usuario.rut,
    usuario.fecha_nacimiento,
    usuario.email,
    usuario.telefono,
    direccion.nombre_calle,
    direccion.numero,
    direccion.depto,
    comuna.nombre_comuna comuna,
    region.nombre_region region,
    usuario.id_rol_fk,
    usuario.id_sucursal_fk,
    usuario.id_direccion_fk
FROM usuario 
    JOIN direccion ON usuario.id_direccion_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE usuario.id_rol_fk=2 AND usuario.estado = 0
ORDER BY 3 ASC;


/*
CREACION DE VISTA DE USUARIO DESHABILITADO
DONDE SOLO SE LISTARA USUARIOS DESHABILITADO
*/
CREATE VIEW 
    vista_lista_usuarios_deshabilitado AS 
SELECT 
    usuario.id_usuario,
    usuario.nombre,
    usuario.apellidos,
    usuario.rut,
    usuario.fecha_nacimiento,
    usuario.email,
    usuario.telefono,
    direccion.nombre_calle,
    direccion.numero,
    direccion.depto,
    comuna.nombre_comuna comuna,
    region.nombre_region region,
    usuario.id_rol_fk,
    usuario.id_sucursal_fk,
    usuario.id_direccion_fk
FROM usuario 
    JOIN direccion ON usuario.id_direccion_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE usuario.id_rol_fk=2 AND usuario.estado = 1
ORDER BY 3 ASC;



 
/*
VIEW QUE SE VERA PARA EL ADMINISTRADOR
DONDE SE VERAN TODAS LAS SOLICITUDES DE ASESORIAS
EN ESTADO 0
*/
CREATE VIEW 
vista_solicitud_asesorias AS
SELECT 
    actividad.id_actividad
    ,asesoria.id_asesoria
    ,sucursal.id_sucursal
    ,sucursal.nombre
    ,tipo_asesoria.descripcion 
FROM ACTIVIDAD
    JOIN sucursal ON sucursal.id_sucursal = actividad.id_sucursal_empresa_fk
    JOIN asesoria ON asesoria.id_actividad_fk_as = actividad.id_actividad
    JOIN tipo_asesoria on asesoria.id_tipo_asesoria_fk = tipo_asesoria.id_tipo_asesoria
    JOIN tipo_estado ON asesoria.id_tipo_estado_fk = tipo_estado.id_tipo_estado
WHERE actividad.id_tipo_actividad_fk = 3 AND actividad.estado_act=0 AND tipo_estado.id_tipo_estado = 1
ORDER BY 1;



/*CREATE PROCEDURE
 OBTENER TODAS LAS ASESORIAS ASIGNADAS DE UN PROFESIONAL
CON EL ESTADO DE LA ACTIVIDAD EN 0 
*/

DELIMITER //

CREATE PROCEDURE GetObtenerSucursalPorId(IN idEmpresa INT)
BEGIN
SELECT 
    sucursal.id_sucursal
    ,sucursal.nombre
    ,CONCAT( direccion.nombre_calle," #",direccion.numero, " - ",comuna.nombre_comuna, " - ",region.nombre_region ) AS direccion
FROM SUCURSAL 
    JOIN direccion ON sucursal.id_direccion_suc_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE ID_EMPRESA_FK = idEmpresa;
END //
 
DELIMITER ;



/*
PROCEDURE TRAE TODOS LOS REPORTES DE ACCIDENTE PARA QUE LOS 
VEA EL ADMINISTRADOR
*/

DELIMITER //

CREATE PROCEDURE GetAllReporteAccidente(IN idEmpresa INT)
BEGIN
SELECT 
    reporte_accidente.id_reporte_accidente
    ,sucursal.id_sucursal
    ,empresa.id_empresa
    ,reporte_accidente.fecha as fecha_accidente
    ,reporte_accidente.hora as hora_accidente
    ,reporte_accidente.comentario
    ,tipo_accidente.descripcion
    ,sucursal.nombre as nombre_sucursal
FROM reporte_accidente
    JOIN tipo_accidente ON reporte_accidente.id_tipo_accidente_fk = tipo_accidente.id_tipo_accidente
    JOIN sucursal ON reporte_accidente.id_sucursal_fk = sucursal.id_sucursal
    JOIN empresa ON empresa.id_empresa = sucursal.id_empresa_fk
WHERE empresa.id_empresa =idEmpresa
ORDER BY 4 DESC;
END //
 
DELIMITER ;




/*CREATE PROCEDURE
 OBTENER TODAS LAS ASESORIAS ASIGNADAS DE UN PROFESIONAL
CON EL ESTADO DE LA ACTIVIDAD EN 0 
*/

DELIMITER //

CREATE PROCEDURE GetAllAsesoriasAsignadas(IN idUsu INT)
BEGIN
SELECT 
    usuario.id_usuario
    ,CONCAT(usuario.nombre, " ", usuario.apellidos) AS nombre_apellido
    ,actividad.id_actividad
    ,actividad.fecha_act
    ,actividad.hora_act
    ,asesoria.id_asesoria
    ,asesoria.comentarios_detectados
    ,asesoria.comentarios_propuesta
    ,tipo_asesoria.descripcion as tipo_asesoria
    ,sucursal.nombre as nombre_sucursal
    ,direccion.nombre_calle
    ,direccion.numero
    ,comuna.nombre_comuna
    ,region.nombre_region
    
FROM USUARIO
    JOIN ACTIVIDAD on actividad.id_usuario_fk = usuario.id_usuario
    JOIN asesoria ON asesoria.id_actividad_fk_as = actividad.id_actividad
    JOIN sucursal ON sucursal.id_sucursal = actividad.id_sucursal_empresa_fk
    JOIN direccion ON sucursal.id_direccion_suc_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
    JOIN tipo_asesoria ON tipo_asesoria.id_tipo_asesoria = asesoria.id_tipo_asesoria_fk
WHERE id_rol_fk = 2 and actividad.estado_act=0 and id_usuario= idUsu 
ORDER BY 4 ASC;
END //
 
DELIMITER ;


/*
PROCEDURE TRAER LISTA DE REPORTE ASESORIA 
DE UNA EMPRESA EN ESPECIFICO

*/

DELIMITER //

CREATE PROCEDURE GetAllAsesoriasFinalizadas(IN idSucursal INT)
BEGIN
SELECT 
     usuario.id_usuario
    ,CONCAT(usuario.nombre, " ", usuario.apellidos) AS nombre_apellido
    ,actividad.id_actividad
    ,actividad.fecha_act
    ,actividad.hora_act
    ,asesoria.id_asesoria
    ,asesoria.comentarios_detectados
    ,asesoria.comentarios_propuesta
    ,tipo_asesoria.descripcion as tipo_asesoria
    ,sucursal.nombre as nombre_sucursal
    ,direccion.nombre_calle
    ,direccion.numero
    ,comuna.nombre_comuna
    ,region.nombre_region
    
FROM USUARIO
    JOIN ACTIVIDAD on actividad.id_usuario_fk = usuario.id_usuario
    JOIN asesoria ON asesoria.id_actividad_fk_as = actividad.id_actividad
    JOIN sucursal ON sucursal.id_sucursal = actividad.id_sucursal_empresa_fk
    JOIN direccion ON sucursal.id_direccion_suc_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
    JOIN tipo_asesoria ON tipo_asesoria.id_tipo_asesoria = asesoria.id_tipo_asesoria_fk
WHERE actividad.id_tipo_actividad_fk = 3 and actividad.estado_act=1 and sucursal.id_sucursal = idSucursal
ORDER BY 4;
END //
 
DELIMITER ;


/*
lista las capacitaciones asignadas a un profesional

*/

DELIMITER //

CREATE PROCEDURE GetAllCapacitacion(IN idUsuario INT)
BEGIN
SELECT
    actividad.id_actividad
    ,capacitacion.id_capacitacion
    ,usuario.id_usuario
    ,CONCAT(usuario.nombre, " ", usuario.apellidos) AS nombre_apellido
    ,actividad.fecha_act 
    ,actividad.hora_act
    ,capacitacion.numero_asistente
    ,sucursal.nombre as nombre_sucursal
    ,tipo_capacitacion.descripcion
FROM USUARIO
    JOIN ACTIVIDAD on actividad.id_usuario_fk = usuario.id_usuario
    JOIN capacitacion ON capacitacion.id_actividad_fk_c = actividad.id_actividad
    JOIN sucursal ON sucursal.id_sucursal = actividad.id_sucursal_empresa_fk
    JOIN tipo_capacitacion ON tipo_capacitacion.id_tipo_capacitacion = capacitacion.id_tipo_capacitacion_fk
WHERE usuario.id_rol_fk = 2 and actividad.estado_act=0 and usuario.id_usuario= idUsuario
ORDER BY 5 ASC;
END //
 
DELIMITER ;





/*
PROCEDIMIENTO TRAE USUARIO CON SUS DATOS PARA LA ACTUALIZACION DE ELLOS.

*/

DELIMITER //

CREATE PROCEDURE GetUsuarioListaActualizar(IN idUsuario INT)
BEGIN
SELECT 
    usuario.id_usuario,
    usuario.nombre,
    usuario.apellidos,
    usuario.rut,
    usuario.fecha_nacimiento,
    usuario.email,
    usuario.telefono,
    direccion.nombre_calle,
    direccion.numero,
    direccion.depto,
    comuna.nombre_comuna comuna,
    region.nombre_region region,
    usuario.id_rol_fk,
    usuario.id_sucursal_fk,
    direccion.id_direccion
FROM usuario 
    JOIN direccion ON usuario.id_direccion_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE usuario.estado = 0 AND usuario.id_usuario=idUsuario;
END //
 
DELIMITER ;

/*
PROCEDIMIENTO PARA LISTAR VISITAS ASIGNADAS
**/

DELIMITER //

CREATE PROCEDURE GetAllVisitasAsignadas(IN idProf INT)
BEGIN
SELECT 
    usuario.id_usuario
    ,CONCAT(usuario.nombre ," ",usuario.apellidos) AS nombre_apellido
    ,actividad.id_actividad
    ,actividad.fecha_act
    ,actividad.hora_act
    ,visita.id_visita
    ,tipo_visita.descripcion tipo_visita
    ,visita.contratos
    ,visita.documentacion
    ,visita.finiquitos
    ,visita.comentario_documentacion
    ,visita.instalacion
    ,visita.banios
    ,visita.comedores
    ,visita.comentarios_faena
    ,visita.seguridad
    ,visita.peligros
    ,visita.comentarios_seguridad
    ,visita.comentarios_propuesta
    ,sucursal.nombre nombre_sucursal
    ,direccion.nombre_calle
    ,direccion.numero
    ,comuna.nombre_comuna
    ,region.nombre_region
FROM usuario 
    JOIN actividad ON usuario.id_usuario = actividad.id_usuario_fk
    JOIN visita ON visita.id_actividad_fk_v = actividad.id_actividad
    JOIN tipo_visita ON visita.id_tipo_visita_fk = tipo_visita.id_tipo_visita
    JOIN sucursal ON actividad.id_sucursal_empresa_fk = sucursal.id_sucursal
    JOIN direccion ON sucursal.id_direccion_suc_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE actividad.estado_act=0 AND usuario.id_usuario=idProf 
ORDER BY 4 ;
END //
 
DELIMITER ;

/*PROCEDIMIENTO PARA LISTAR VISITAS FINALIZADAS POR ID SUCURSAL*/

DELIMITER //

CREATE PROCEDURE GetAllVisitasFinalizadas(IN idSucursal INT)
BEGIN
SELECT 
    usuario.id_usuario
    ,CONCAT(usuario.nombre ," ",usuario.apellidos) AS nombre_apellido
    ,actividad.id_actividad
    ,actividad.fecha_act
    ,actividad.hora_act
    ,visita.id_visita
    ,tipo_visita.descripcion tipo_visita
    ,visita.contratos
    ,visita.documentacion
    ,visita.finiquitos
    ,visita.comentario_documentacion
    ,visita.instalacion
    ,visita.banios
    ,visita.comedores
    ,visita.comentarios_faena
    ,visita.seguridad
    ,visita.peligros
    ,visita.comentarios_seguridad
    ,visita.comentarios_propuesta
    ,sucursal.nombre nombre_sucursal
    ,direccion.nombre_calle
    ,direccion.numero
    ,comuna.nombre_comuna
    ,region.nombre_region
FROM usuario 
    JOIN actividad ON usuario.id_usuario = actividad.id_usuario_fk
    JOIN visita ON visita.id_actividad_fk_v = actividad.id_actividad
    JOIN tipo_visita ON visita.id_tipo_visita_fk = tipo_visita.id_tipo_visita
    JOIN sucursal ON actividad.id_sucursal_empresa_fk = sucursal.id_sucursal
    JOIN direccion ON sucursal.id_direccion_suc_fk = direccion.id_direccion
    JOIN comuna ON comuna.id_comuna = direccion.id_comuna_fk
    JOIN region ON comuna.id_region_fk = region.id_region
WHERE actividad.estado_act=1 AND sucursal.id_sucursal=idSucursal
ORDER BY 4;
END //
 
DELIMITER ;