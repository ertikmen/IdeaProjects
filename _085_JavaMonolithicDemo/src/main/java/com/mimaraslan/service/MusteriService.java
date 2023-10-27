package com.mimaraslan.service;

import com.mimaraslan.dto.request.MusteriSaveRequestDto;
import com.mimaraslan.dto.response.MusteriFindAllResponseDto;
import com.mimaraslan.mapper.IMusteriMapper;
import com.mimaraslan.repository.IMusteriRepository;
import com.mimaraslan.repository.entity.Musteri;
import com.mimaraslan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusteriService extends ServiceManager<Musteri,Long> {

    private final IMusteriRepository repository;

    public MusteriService(IMusteriRepository repository) {
        super(repository);
        this.repository=repository;
    }

    public Boolean doLogin(String username,String password){
        Optional<Musteri> musteri= repository.findOptionalByUsernameAndPassword(username, password);
        return musteri.isPresent();
    }

    public Musteri findByAd(String ad) {
        return repository.findByAd(ad);
    }

    public List<Musteri> findAllByIl(String il){
        return repository.findAllByIl(il);
    }

    public void saveDto(MusteriSaveRequestDto dto){
       /* Musteri m1= Musteri.builder()
                .ad(dto.getAd())
                .adres(dto.getAdres())
                .tel(dto.getTelefon())
                .build();
        save(m1);*/
        save(IMusteriMapper.INSTANCE.fromSaveRequestDto(dto));
    }

    public List<MusteriFindAllResponseDto> findAllResponseDto(){
        List<MusteriFindAllResponseDto> liste=new ArrayList<>();
        findAll().forEach(x->{
            liste.add(
                    /*MusteriFindAllResponseDto.builder()
                            .ad(x.getAd())
                            .username(x.getUsername())
                            .img(x.getImg())
                    .build());*/
                    IMusteriMapper.INSTANCE.fromMusteri(x));
        });
        return liste;

    }
}
