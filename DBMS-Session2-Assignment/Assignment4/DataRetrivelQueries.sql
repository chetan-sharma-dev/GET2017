USE city_zip_code;

/* query for retriving zip_code,city_name,state_name*/
SELECT zip_code,city_name,state_name
FROM states AS s,cities AS c
WHERE s.state_id=c.state_id
ORDER BY s.state_name,c.city_name;
