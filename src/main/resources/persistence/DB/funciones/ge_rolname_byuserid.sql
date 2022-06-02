CREATE OR REPLACE FUNCTION "ge_rolname_byuserid"
(
    p_userid        numeric,
    OUT p_cod_rpta  TEXT,
    OUT p_role      TYPE_TT_ROL
)
RETURNS record
LANGUAGE 'plpgsql'
COST 100
VOLATILE
AS $BODY$

DECLARE

c_role CURSOR FOR
    SELECT
    r.*
    FROM user_role ur, rol r
    WHERE ur.userid = p_userid 
    AND ur.roleid = r.rolid;

to_role TYPE_TO_ROL;
tt_role TYPE_TT_ROL;

BEGIN


    FOR i IN c_role
    LOOP
        to_role := ROW (i.rolid,i.rolname)::TYPE_TO_ROL;
        tt_role[COALESCE(array_length(tt_role, 1), 0)] := to_role;
    END LOOP;
    
    p_role := tt_role;
    
    p_cod_rpta := 'OK';

EXCEPTION
    WHEN others THEN

        p_cod_rpta := 'ERROR';
        p_role := NULL;



END;

$BODY$;