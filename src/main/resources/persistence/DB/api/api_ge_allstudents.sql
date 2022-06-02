CREATE OR REPLACE FUNCTION "api_ge_allstudents"
(
    OUT p_cod_rpta  TEXT,
    OUT p_student   TEXT --json
)

RETURNS record
LANGUAGE 'plpgsql'
COST 100
VOLATILE 
AS $BODY$

DECLARE

        --SALIDA  parametro --
    c_student CURSOR (pc_variable TEXT) FOR
    SELECT * FROM array_to_json
    (pc_variable::TYPE_TT_STUDENT);
    
    F$RESULT_STUDENT RECORD;
    
BEGIN
    
    SELECT
            *
            FROM ge_allstudents
            INTO F$RESULT_STUDENT;
    
     -- Conversion salida a Json--
     OPEN c_student(F$RESULT_STUDENT.p_student);
     FETCH c_student INTO p_student;
     CLOSE c_student;        
    
    p_cod_rpta := 'OK';

EXCEPTION
    WHEN others THEN

        p_cod_rpta := 'ERROR';
        p_student := NULL;
        
   
    
            
    
    
END
    
$BODY$;