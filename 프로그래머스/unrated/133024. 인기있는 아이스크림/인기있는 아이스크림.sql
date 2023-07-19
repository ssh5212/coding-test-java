# first_half : 상반기 주문 정보 테이블
    # shipment_id : 출하 번호
    # flavor : 맛
    # total_order : 상반기 총 주문량 
# 아이스크림 맛을 총주문량 기준으로 내림차순 정렬, 출하번호 기준으로 오름차순 정렬
select flavor
from first_half
order by total_order desc, shipment_id asc;