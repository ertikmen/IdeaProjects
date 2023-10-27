package com.mimaraslan.service;

import com.mimaraslan.repository.ISatisRepository;
import com.mimaraslan.repository.entity.Musteri;
import com.mimaraslan.repository.entity.Satis;
import com.mimaraslan.repository.entity.Urun;
import com.mimaraslan.utility.ServiceManager;
import com.mimaraslan.view.VwSatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SatisService extends ServiceManager<Satis, Long> {
    private final ISatisRepository repository;

    @Autowired
    private MusteriService musteriService;
    @Autowired
    private UrunService urunService;

    public SatisService(ISatisRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * 1. Kime ne satıldı? Liste olarak görelim.
     * findAll bu işi görür.
     */
    public List<Satis> findAll() {
        return repository.findAll();
    }

    /**
     * 2. A kişisine ne satıldı? liste olarak göster.
     */
    public List<Satis> findAllByMusteriid(Long musteriid) {
        return repository.findAllByMusteriid(musteriid);
    }

    /**
     * 3. En çok alışveriş yapan müşteri
     * select musteriid from tblmusteri group by musteriid order by count(musteriid) limit 1
     */
    public String findByMaxSatisMusteriId() {
        return musteriService.findById(repository.findByMaxSatisMusteriId().get(0)).get().getAd() ;
    }

    /**
     * 4. En çok satılan 3 ürünü
     * select s.urunid from Satis s group by s.urunid order by sum(s.adet) desc limit 3
     */

    public List<String> findTop3ProductName() {
        return urunService.findByIdIn(repository.findTop3Product());
    }

    public List<VwSatis> findAllSatisList(){
        List<Urun> urunList=urunService.findAll();
        List<Musteri> musteriList=musteriService.findAll();

        List<VwSatis> vwSatisList=new ArrayList<>();

        findAll().forEach(x->{

            String urunadi=urunList.stream().filter(u->u.getId().equals(x.getUrunid())).findFirst().get().getAd();

            urunadi=urunService.findById(x.getUrunid()).get().getAd();


            String musteriadi=musteriList.stream().filter(m->m.getId().equals(x.getMusteriid())).findFirst().get().getAd();

            musteriadi=musteriService.findById(x.getMusteriid()).get().getAd();

            VwSatis vwSatis= VwSatis.builder()
                    .satisid(x.getId())
                    .musteriid(x.getMusteriid())
                    .urunid(x.getUrunid())
                    .adet(x.getAdet())
                    .birimfiyat(x.getBirimfiyat())
                    .toplamfiyat(x.getToplamfiyat())
                    .urunad(urunadi)
                    .musteriad(musteriadi)
                    .build();
            vwSatisList.add(vwSatis);
        });
        return vwSatisList;
    }
}
