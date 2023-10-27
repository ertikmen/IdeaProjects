package com.mimaraslan.controller;

import com.mimaraslan.dto.request.MusteriSaveRequestDto;
import com.mimaraslan.dto.response.MusteriFindAllResponseDto;
import com.mimaraslan.exception.ErrorType;
import com.mimaraslan.exception.SatisException;
import com.mimaraslan.repository.entity.Musteri;
import com.mimaraslan.service.MusteriService;
import com.mimaraslan.constant.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @RestController: Rest apilerde kullanılır. Json data veri alışverişi olur.
 * @Controller: MVClerde kullanılır.
 * @RequestMapping: 9090 nolu porta gelen istekleri dinlemeye başlar.
 * Eğer /musteri isteği gelirse onu mapler ve bu sınıfa çeker.
 * @GetMapping: @RequestMapping ile /musteri yakalandıktan sonraki kısımdaki eşleşmelere bakar. Eğer isteğin tipi ile de
 * eşleşme sağlanırsa altındaki metodu çalıştırır.
 * @PostMapping, DeleteMapping, PutMapping İstekleri için de yazılabilir.
 * ResponseEntity: Requestle maplenen metodun geri dönüş tipidir.
 * Entity mantığına benzer bir response oluşturur. Ayrıca buradan json tipine dönüştürerek datayı gönderir.
 * Önemli!!! Response api data iletme ve alma işlemlerini json ile yapar.
 * Yalnız veri alma ve gönderme işlemlerinde gereksiz bilgiler kullnıcıyla paylaşılmaz.
 * Gereksiz yere paylaşılan bilgiler
 *  Güvenlik açığı oluştur...
 *  Daha faza data işlendiği için performans düşer.
 *  Gereksiz trafik yoğunluğu yaratır.
 */
@RestController  //   /api        /v1                /musteri
@RequestMapping(EndPoints.API+ EndPoints.VERSION+ EndPoints.MUSTERI)
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService service;

    @GetMapping(EndPoints.SAVE)
    public ResponseEntity<String> save(MusteriSaveRequestDto dto){
        service.saveDto(dto);
        return ResponseEntity.ok("Kayıt Başarılı");
    }


    @GetMapping(EndPoints.GETALL)
    public ResponseEntity<List<MusteriFindAllResponseDto>> findAll(){
        return ResponseEntity.ok(service.findAllResponseDto());
    }




   @GetMapping(EndPoints.GETBYAD)
   public ResponseEntity<String> findByAd(String ad) throws Exception {
        if(ad==null){
            throw new SatisException(ErrorType.INVALID_PARAMETER,"Musteri ad bilgisi vermediniz.");
        }
       return ResponseEntity.ok("Herşey doğru çalıştı");
   }


    @GetMapping(EndPoints.GETALLBYIL)
    public ResponseEntity<List<Musteri>> findAllByIl(String il){
        return ResponseEntity.ok(service.findAllByIl(il));
    }


    //  http://localhost:8080/api/v1/musteri/selam
    @GetMapping("/selam")
    public String selam(){
        return "<h1 style=\"color:red\">SELAM</h1>";
    }

}