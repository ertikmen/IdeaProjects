package com.ertikmen.utility;

import java.util.UUID;

public class CodeGenerator {

    public static String generateCode(){


        String uuid= UUID.randomUUID().toString();

        String[] data=uuid.split("-");

        String newCode="";
        int i=0;

        while ( i<data.length){

            newCode+=data[i].charAt(0);
            i++;

        }
        return newCode;
    }



}
