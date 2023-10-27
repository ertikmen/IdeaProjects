package com.mimaraslan.repository;

import com.mimaraslan.repository.entity.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ISatisRepository extends JpaRepository<Satis,Long> {
    /**
     * 1. Kime ne satıldı? Liste olarak görelim.
     *  findAll bu işi görür.
     */

    /**
     *  2. A kişisine ne satıldı? liste olarak göster.
     */
    List<Satis> findAllByMusteriid(Long musteriid);
    /**
     * 3. En çok alışveriş yapan müşteri
     * select musteriid from tblsatis group by musteriid order by count(musteriid) limit 1
     */
//jpql
    @Query(value = "select s.musteriid from tblsatis s group by s.musteriid order by  count(s.musteriid) desc limit 1",nativeQuery = true)
    List<Long> findByMaxSatisMusteriId();

    /**
     * 4. En çok satılan 3 ürünü
     * select s.urunid from Satis s group by s.urunid order by sum(s.adet) desc limit 3
     */
    @Query(value="select s.urunid from tblsatis s group by s.urunid order by sum(s.adet) desc limit 3",nativeQuery = true)
    List<Long> findTop3Product();
}
