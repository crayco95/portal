CREATE OR REPLACE FUNCTION "api_ge_rol$rolname_byuserid"
(
    p_userid        NUMERIC,
    OUT p_cod_rpta  TEXT,
    OUT p_role      TEXT --json
)

RETURNS record
LANGUAGE 'plpgsql'
COST 100
VOLATILE 
AS $BODY$

DECLARE

        --SALIDA  parametro --
    c_role CURSOR (pc_variable TEXT) FOR
    SELECT * FROM array_to_json
    (pc_variable::TYPE_TT_ROL);
    
    F$RESULT_ROLE RECORD;
    
BEGIN
    
    SELECT
            *
            FROM ge_rolname_byuserid(p_userid)
            INTO F$RESULT_ROLE;
    
     -- Conversion salida a Json--
     OPEN c_role(F$RESULT_ROLE.p_role);
     FETCH c_role INTO p_role;
     CLOSE c_role;        
    
    p_cod_rpta := 'OK';

EXCEPTION
    WHEN others THEN

        p_cod_rpta := 'ERROR';
        p_role := NULL;
        
   
    
            
    
    
END
    
$BODY$;