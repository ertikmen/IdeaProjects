# API 
http://localhost:8080/swagger-ui/index.html#/

# KLASÖRLER

## public
* Herkese açık olacak sayfalar burada olacak. Public içindeki hiç bir sayfa için controller yazmaya gerek yok.

## static
* Değişmeyen dosyalar buraya konacak. css, js, img, mp3, pdf..
* Önbelleklemeye yardımcı olur.
* Her session için tekrar yaratılmasına gerek kalmıyor.
* Burada static html sayfaları da tutulabilir.

## templates
* Dinamik sayfalar burada olacak. Veritabanından gelen verilerle doldurulacak şablonlar.
###
* Templates kısmını kullanabilmek için bir template engine gereklidir.
* Bunun için şu an çok sık kullanılan Thymeleaf tercih edeceğiz.

## controller
* Rest projelerinde @RestController kullanarak controller olduğunu belirtiyorduk.
* MVC projelerinde @Controller kullanmamız gerekli.

## modelandview
* Rest projelerinde ResponseEntity ile data dönüyorduk.
* MVC projelerinde modelandview nesnesi geri dönülecek.
* hem web sayfasını hem de görüntülenecek verileri taşımak için kullanılır.

