
DO $$
DECLARE
   
 v_record record;
 p_userid numeric;
 
tt_role_out TYPE_TT_ROL;

BEGIN
 p_userid := 3;
 

 select * from ge_rolname_byuserid(p_userid) into v_record;
 raise notice '[%]', v_record;
 
 tt_role_out := v_record.p_role;
 raise notice '[%]', tt_role_out;

EXCEPTION
   WHEN OTHERS THEN
   RAISE NOTICE '[%]', SQLERRM;

END;
$$ 