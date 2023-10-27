package com.mimaraslan.view;

import lombok.*;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class VwSatis {
    Long satisid;
    Long musteriid;
    String musteriad;
    Long urunid;
    String urunad;
    Integer adet;
    Double birimfiyat;
    Double toplamfiyat;
}
