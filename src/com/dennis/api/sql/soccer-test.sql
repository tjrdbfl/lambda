# 001. 전체 축구팀 목록을 팀이름 오름 차순으로 출력하시오.
#
# SELECT team_name FROM team ORDER BY team_name;
#
# 002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈 공간으로 두시오
#
# SELECT DISTINCT position FROM player;
#
# 003 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
#
# SELECT DISTINCT case when POSITION='' then '신입' ELSE position end as position FROM player
#
# 004 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
#
# SELECT player_name FROM player WHERE team_id='K02' AND POSITION='GK';
#
# 004-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오.(ID 모를 경우)
#
# SELECT player_name FROM player WHERE POSITION='GK' AND team_id IN (SELECT team_id FROM team WHERE region_name='수원');
#
# 005 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
#
# SELECT player_name FROM player WHERE height>=170 AND team_id='K02';
#
# 005-1. 수원팀에서 성이 고씨이고 키가 170이상인 선수를 출력하싱.(ID를 모를 경우)
#
# SELECT player_name FROM player WHERE height>=170
#                                 and player_name LIKE "고%"
#                                 AND team_id IN
#                                 (SELECT team_id FROM team WHERE region_name='수원');
#
# 006. 다음 조건을 만족하는 선수명단을 출력하시오
#  소속팀이 삼성블루윙즈이거나
#  드래곤즈에 소속된 선수들이어야 하고,
#  포지션이 미드필더(MF:Midfielder)이어야 한다.
#  키는 170 센티미터 이상이고 180 이하여야 한다.
#
# SELECT player_name FROM player WHERE POSITION='MF'
# AND (HEIGHT BETWEEN 170 AND 180)
# AND team_id IN (SELECT team_id FROM team
# WHERE team_name IN ('삼성블루윙즈', '드래곤즈'));
#
# 007. 수원을 연고지로 하는 골키퍼는 누구인가?
#
# SELECT player_name FROM player WHERE POSITION='GK'
# AND team_id IN (SELECT team_id FROM team WHERE region_name='수원');
#
# 008. 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
# - 키와 몸무게가 없으면 "0" 으로 표시하시오
# - 키와 몸무게는 내림차순으로 정렬하시오
#
# SELECT player_name, ifnull(nullif(height,''),0) AS height
# , ifnull(nullif(weight,''),0) AS weight
# FROM player
# ORDER BY height DESC, weight DESC;
#
# 009. 서울팀 선수들 이름과 포지션과
# - 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
# - 단, 키와 몸무게가 없으면 "0" 표시하시오, BMI는 "NONE" 으로 표시하시오(as bmi)
# - 최종 결과는 이름 내림차순으로 정렬하시오
#
# SELECT player_name,
#        CONCAT(IFNULL(NULLIF(height,''),0), 'cm') AS height,
#        CONCAT(IFNULL(NULLIF(weight,''),0), 'kg') AS weight,
#        IFNULL(NULLIF(weight / POWER(NULLIF(height, 0) / 100, 2),''),'NONE') AS bmi
# FROM player
# ORDER BY player_name DESC;
#
# 010. 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK)인 선수를 출력하시오
#  단 , 팀명, 선수명 오름차순 정렬하시오.
# --join x
# select team_name, player_name,region_name from team, player
# where team.team_id=player.team_id
#   and team.region_name in ('수원','대전')
#   and position='GK'
# ORDER BY team_name,player_name;
#
# --join
# SELECT
#     t.team_name as 팀명,
#     p.player_name as 선수명
# FROM
#     team t
# JOIN player p using (team_id)
# WHERE
#     p.position = 'GK'
#     AND t.region_name IN ('울산', '수원')
# order by t.team_name,p.player_name;


# 011. 팀과 연고지를 연결해서 출력하시오
#  [팀 명]             [홈구장]
#  수원 삼성블루윙즈 수원월드컵경기장
# select concat(region_name,' ',team_name) as 팀명, stadium_name as 홈구장
# from team,stadium
# where team.stadium_id=stadium.stadium_id
#   and region_name like '%수원%'
#   and stadium_name like '%수원%';
#
# select
#     concat(t.region_name,' ',t.team_name) as 팀명,s.stadium_name as 홈구장
# from stadium s
#          join team t using (stadium_id)
# where t.region_name like '수원%' and s.stadium_name like '수원%';


# 012.
#  수원팀(K02) 과 대전팀(K10) 선수들 중
#  키가 180 이상 183 이하인 선수들
#  키, 팀명, 사람명 오름차순
#
# select height as 키, team_name as 팀명, player_name as 사람명
# from player, team
# where team.team_id=player.team_id
#   and region_name in ('수원','대전')
#   and height between 180 and 183
# order by height,team_name,player_name;
#
# select p.height as 키,t.team_name as 팀명,p.player_name as 사람명
# from team t
#          join player p on t.team_id=p.team_id
# where (p.height between 180 and 183)
#   and t.region_name in ('수원','대전')
# order by height, team_name,player_name;


# 013.
#  모든 선수들 중 포지션을 배정 받지 못한 선수들의
#  팀명과 선수이름 출력 둘다 오름차순
#
# select team_name as 팀명, player_name as 선수이름
# from team, player
# where team.team_id=player.team_id
#   and position=''
# order by team_name,player_name;
#
# select t.team_name as 팀명,p.player_name as 선수이름
# from team t
#          join player p using (team_id)
# where p.position=''
# order by 1,2;

#
# 014.
#  팀과 스타디움, 스케줄을 조인하여
#  2012년 3월 17일에 열린 각 경기의
#  팀이름, 스타디움, 어웨이팀 이름 출력
#  다중테이블 join 을 찾아서 해결하시오.
# (스칼라와 조인 사용)
#
# select (select team_name from team where stadium_id=sc.stadium_id) as 팀이름,
#        (select stadium_name from stadium where stadium_id=sc.stadium_id) as 스타디움,
#        (select team_name from team where team_id=sc.awayteam_id) as 어웨이팀_이름
# from schedule sc
#          join stadium st using (stadium_id)
#          join team t using (stadium_id)
# where sche_date='20120317';
#
#
# select t.team_name as 팀이름, stadium_name as 스타디움,
#        (select team_name
#         from team
#         where team_id=sc.awayteam_id
#        ) as 어웨이팀_이름
# from stadium s
#          join team t using (stadium_id)
#          join schedule sc using (stadium_id)
# where sc.sche_date='20120317';



015.
 2012년 3월 17일 경기에
 포항 스틸러스 소속 골키퍼(GK)
 선수, 포지션,팀명 (연고지포함),
 스타디움, 경기날짜를 구하시오
 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)

select (select player_name,
       (select position,
       (select concat(team_name,' ',region_name) from team
       where  ) as 팀명,
       (select stadium_name from ) as 스타디음,
       sche_date as 스타디음
from schedule
where sche_date='20120317';


016.
 홈팀이 3점이상 차이로 승리한 경기의
 경기장 이름, 경기 일정
 홈팀 이름과 원정팀 이름을
 구하시오

select (select stadium_name
        from stadium
        where stadium_id=sc.stadium_id) as 경기장_이름,
        sche_date as 경기일정,
        (select team_name
        from team t
        where t.team_id=sc.hometeam_id
        ) as 홈팀_이름,
        (select team_name
        from team t
        where t.team_id=sc.awayteam_id
        )as 원정팀_이름
from schedule sc
where sc.home_score-sc.away_score>=3;

017.
 STADIUM 에 등록된 경기장 중에서
 홈팀이 없는 경기장까지 전부 나오도록
 경기장, 팀이름 출력
 카운트 값은 19
 힌트 : LEFT JOIN 사용해야함
--scalar
select stadium_name,
    (select t.team_name
    from team t
    where t.stadium_id=s.stadium_id
    ) as team_name
from stadium s ;

--left join
select s.stadium_name, t.team_name
from stadium s
    left join team t using(stadium_id);


018. 플레이어 테이블에서 최상단 5개 로우를 출력

select * from player
order by 1 limit 0, 5;


 019. (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
 팀ID, 팀명, 평균키 추출(round 사용)
 인천 유나이티스팀의 평균키 -- 176.59
 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
 포함되지 않도록 하세요.

select * from schedule;
use dennisdb;


 문제 20
 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력

 select (select team_name from team t where t.team_id=p.team_id) as 소속팀명
      , player_name as 선수명, back_no as 백넘버
 from player p
 where p.position='MF';

021.
 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
 단 키  값이 없으면 제외

select (select team_name from team where team_id=p.team_id) as 소속팀명
      , player_name as 선수명, back_no as 백넘버
from player p
order by height desc limit 5;


022.
 선수 자신이 속한 팀의 평균키보다 작은 선수 정보 출력
 (select round(avg(height),2) from player)

SELECT *
FROM player p1
WHERE p1.height < (
    SELECT ROUND(AVG(height), 2)
    FROM player p2
    where p1.team_id=p2.team_id
    group by p2.team_id);


 문제 23
 2012년 5월 한달간 경기가 있는 경기장  조회
select stadium_name
from stadium st
join schedule sc using (stadium_id)
where sc.sche_date like '201205%'
group by stadium_name;
