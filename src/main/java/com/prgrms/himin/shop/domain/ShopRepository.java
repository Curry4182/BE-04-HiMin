package com.prgrms.himin.shop.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long>, ShopRepositoryCustom {

	Shop findFirstByOrderByShopIdDesc();
}
