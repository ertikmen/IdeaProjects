package com.mimaraslan.repository;

import com.mimaraslan.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {
    /*
    find: kelimesi ile başlanması gereklidir.
    By: işlem yapılacak bileşen adından önce yazılması gereklidir.
    [değişkenadı] Ad: kullanılan repository içine geçilen entity içindeki
    //arama yapılmak istenen field adı ilk karakteri büyük harfle olacak şekilde yazılır.
    Geri dönüş tipi olmalıdır.

     */
    // select * from tblmusteri where ad=?
    Musteri findByAd(String ad);

    List<Musteri> findAllByIl(String il);

    Optional<Musteri> findOptionalByUsernameAndPassword(String username, String password);
}

