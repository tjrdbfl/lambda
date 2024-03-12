001. 전체 축구팀 목록을 팀이름 오름 차순으로 출력하시오.

SELECT team_name FROM team ORDER BY team_name;

002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈 공간으로 두시오

SELECT DISTINCT position FROM player;

003 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오

SELECT DISTINCT case when POSITION='' then '신입' ELSE position end as position FROM player

004 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.

SELECT player_name FROM player WHERE team_id='K02' AND POSITION='GK';

004-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오.(ID 모를 경우)

SELECT player_name FROM player WHERE POSITION='GK' AND team_id IN (SELECT team_id FROM team WHERE region_name='수원');

005 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.

SELECT player_name FROM player WHERE height>=170 AND team_id='K02';

005-1. 수원팀에서 성이 고씨이고 키가 170이상인 선수를 출력하싱.(ID를 모를 경우)

SELECT player_name FROM player WHERE height>=170
                                and player_name LIKE "고%"
                                AND team_id IN
                                (SELECT team_id FROM team WHERE region_name='수원');

006. 다음 조건을 만족하는 선수명단을 출력하시오
 소속팀이 삼성블루윙즈이거나
 드래곤즈에 소속된 선수들이어야 하고,
 포지션이 미드필더(MF:Midfielder)이어야 한다.
 키는 170 센티미터 이상이고 180 이하여야 한다.

SELECT player_name FROM player WHERE POSITION='MF'
AND (HEIGHT BETWEEN 170 AND 180)
AND team_id IN (SELECT team_id FROM team
WHERE team_name IN ('삼성블루윙즈', '드래곤즈'));

007. 수원을 연고지로 하는 골키퍼는 누구인가?

SELECT player_name FROM player WHERE POSITION='GK'
AND team_id IN (SELECT team_id FROM team WHERE region_name='수원');

008. 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
- 키와 몸무게가 없으면 "0" 으로 표시하시오
- 키와 몸무게는 내림차순으로 정렬하시오

SELECT player_name, ifnull(nullif(height,''),0) AS height, ifnull(nullif(weight,''),0) AS weight
FROM player
ORDER BY height DESC, weight DESC;

009 서울팀 선수들 이름과 포지션과
- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
- 단, 키와 몸무게가 없으면 "0" 표시하시오, BMI는 "NONE" 으로 표시하시오(as bmi)
- 최종 결과는 이름 내림차순으로 정렬하시오

SELECT player_name, ifnull(nullif(height,''),0) AS height, ifnull(nullif(weight,''),0) AS weight,
case when height=0 then "NONE" ELSE weight/((height/100)*(height/100)) END AS bmi
FROM player
ORDER BY player_name DESC;