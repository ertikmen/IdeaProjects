package com.ertikmen.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Kaydederken kullanıcıdan alınacak bilgileri içeren DTO
@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class DoLoginRequestDto {


  @NotBlank(message = "Kullanıcı adı boş geçilemez.")
  @Size(min = 2,max = 50)
  private   String username;
  private   String password;

}
