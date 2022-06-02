DO $$
DECLARE
   
 v_record record;
 
p_student_out text;

BEGIN

 select * from api_ge_allstudents() into v_record;
 raise notice '[%]', v_record;
 

EXCEPTION
   WHEN OTHERS THEN
   RAISE NOTICE '[%]', SQLERRM;

END;
$$ 