
DO $$
DECLARE
   
 v_record record;
 p_userid numeric;
 
p_role_out text;

BEGIN
 p_userid := 3;
 

 select * from api_ge_rol$rolname_byuserid(p_userid) into v_record;
 raise notice '[%]', v_record;
 
 p_role_out := v_record.p_role;
 raise notice '[%]', p_role_out;

EXCEPTION
   WHEN OTHERS THEN
   RAISE NOTICE '[%]', SQLERRM;

END;
$$ 