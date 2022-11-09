package com.parcel.repository;

import com.parcel.model.domain.order.DtoCommission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommissionRepository extends JpaRepository<DtoCommission, Long> {
    List<DtoCommission> findAllById(Long id);
    DtoCommission findDtoCommissionById(Long id);
}
