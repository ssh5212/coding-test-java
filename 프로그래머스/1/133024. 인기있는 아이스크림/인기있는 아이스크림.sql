-- first_half
# shipment_id : 출하 번호
# flavor : 맛
# total_order : 상반기 총 주문량


# 상반기에 판매된 아이스크림 맛

select flavor
from first_half
order by total_order desc, shipment_id asc
# where
# order by
# group by
# having
