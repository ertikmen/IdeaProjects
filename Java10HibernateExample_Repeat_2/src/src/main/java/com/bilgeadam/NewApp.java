package com.bilgeadam;

import com.bilgeadam.controller.PostController;
import com.bilgeadam.controller.UserController;
import com.bilgeadam.repository.entity.*;
import com.bilgeadam.repository.enums.EGender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewApp {

    public static void main(String[] args) {

          UserController userController=new UserController();
          PostController postController=new PostController();
//          createUsers(userController);
//          createPost(postController);
        System.out.println("user===>"+userController.findByUsername("musty111"));  ;

    }

    public static  void createUsers(UserController userController){
        List<String> list1=List.of("Astroloji","Sinema");
        List<String> list2=List.of("Dans","Müzik");
        List<String> list3=List.of("Seyahat","Tiyatro");
        List<String> list4=List.of("Kitap","Konsal oyunları");

        Map<EAddressType, Address> map1=new HashMap<>();
        map1.put(EAddressType.HOME, Address.builder().city("Ankara").country("Türkiye").build());
        map1.put(EAddressType.WORK, Address.builder().city("İstanbul").country("Türkiye").build());
        //2.map
        Map<EAddressType, Address> map2=new HashMap<>();
        map2.put(EAddressType.HOME, Address.builder().city("İzmir").country("Türkiye").build());
        map2.put(EAddressType.WORK, new Address("Antalya","Türkiye"));
        Map<EAddressType, Address> map3=new HashMap<>();
        map3.put(EAddressType.HOME, Address.builder().city("İstanbul").country("Türkiye").build());
        map3.put(EAddressType.WORK, new Address("İstanbul","Türkiye"));

        User user1=User.builder()
                .name(Name.builder().firstName("Zeliha").lastName("Ünlü").build())
                .username("zlh")
                .gender(EGender.WOMAN)
                .interests(list1)
                .addresses(map2)
                .postCount(20)
                .password("1234")
                .build();

        User user2=User.builder()
                .name(Name.builder().firstName("Mustafa").lastName("Öztürk").build())
                .username("musty")
                .gender(EGender.MAN)
                .interests(list2)
                .addresses(map1)
                .postCount(5)
                .password("123")
                .build();
        User user3=User.builder()
                .name(Name.builder().firstName("Merve").lastName("Keskin").build())
                .username("merve")
                .gender(EGender.WOMAN)
                .interests(list2)
                .addresses(map3)
                .postCount(9)
                .password("12345")
                .build();

        User user4=User.builder()
                .name(Name.builder().firstName("Mert").lastName("Gürel").build())
                .username("mert")
                .gender(EGender.MAN)
                .interests(list4)
                .addresses(map3)
                .postCount(12)
                .password("123456")
                .build();
        User user5=User.builder()
                .name(Name.builder().firstName("Gokhan").lastName("Kaya").build())
                .username("gokhan")
                .gender(EGender.MAN)
                .interests(list3)
                .addresses(map1)
                .postCount(4)
                .password("123456")
                .build();
        userController.save(user1);
        userController.save(user2);
        userController.save(user3);
        userController.save(user4);
        userController.save(user5);

    }
    public static void createPost(PostController postController){
        Post post1=Post.builder().content("içerik1").userId(1L).build();
        Post post2=Post.builder().content("içerik2").userId(1L).build();
        Post post3=Post.builder().content("içerik3").userId(2L).build();
        Post post4=Post.builder().content("içerik4").userId(3L).build();
        Post post5=Post.builder().content("içerik5").userId(2L).build();
        Post post6=Post.builder().content("içerik6").userId(5L).build();
        Post post7=Post.builder().content("içerik7").userId(4L).build();
        Post post8=Post.builder().content("içerik8").userId(4L).build();
        Post post9=Post.builder().content("içerik9").userId(1L).build();
        Post post10=Post.builder().content("içerik10").userId(2L).build();
        Post post11=Post.builder().content("içerik11").userId(3L).build();
        Post post12=Post.builder().content("içerik12").userId(5L).build();
        Post post13=Post.builder().content("içerik13").userId(1L).build();
        Post post14=Post.builder().content("içerik14").userId(2L).build();
        Post post15=Post.builder().content("içerik15").userId(3L).build();
        Post post16=Post.builder().content("içerik16").userId(4L).build();
        postController.save(post1);
        postController.save(post2);
        postController.save(post3);
        postController.save(post4);
        postController.save(post5);
        postController.save(post6);
        postController.save(post7);
        postController.save(post8);
        postController.save(post9);
        postController.save(post10);
        postController.save(post11);
        postController.save(post12);
        postController.save(post13);
        postController.save(post14);
        postController.save(post15);
        postController.save(post16);

    }

}
