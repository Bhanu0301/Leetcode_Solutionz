# Write your MySQL query statement below

select 
    round((count(distinct player_id)/ (select count(distinct player_id) from activity)),2) as fraction 
from activity
   
    where 

(player_id, date_sub(event_date, INTERVAL 1 day))
in (
    select player_id , MIN(event_date) as event_date
    from activity 
    group by player_id
);
