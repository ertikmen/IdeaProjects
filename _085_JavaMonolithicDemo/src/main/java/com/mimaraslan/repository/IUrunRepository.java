package com.mimaraslan.repository;

import com.mimaraslan.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUrunRepository extends JpaRepository<Urun,Long> {
    List<Urun> findAllByAdLike(String ad);
    List<Urun> findAllByMarka(String marka);
}
