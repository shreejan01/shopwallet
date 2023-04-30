package com.shop.wallet.shopwallet.repository;

import com.shop.wallet.shopwallet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
