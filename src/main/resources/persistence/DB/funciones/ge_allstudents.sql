CREATE OR REPLACE FUNCTION "ge_allstudents"
(
    OUT p_cod_rpta  TEXT,
    OUT p_student   TYPE_TT_STUDENT
)
RETURNS record
LANGUAGE 'plpgsql'
COST 100
VOLATILE
AS $BODY$

DECLARE

c_student CURSOR FOR
    SELECT
    s.*
    FROM student s;

to_student TYPE_TO_STUDENT;
tt_student TYPE_TT_STUDENT;

BEGIN


    FOR i IN c_student
    LOOP
        to_student := ROW (i.studentid,i.studentname,i.studentgrade,i.studentemail)::TYPE_TO_STUDENT;
        tt_student[COALESCE(array_length(tt_student, 1), 0)] := to_student;
    END LOOP;
    
    p_student := tt_student;
    
    p_cod_rpta := 'OK';

EXCEPTION
    WHEN others THEN

        p_cod_rpta := 'ERROR';
        p_student := NULL;



END;

$BODY$;