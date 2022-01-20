package com.sf.services;

/**
 * Created by jt on 12/28/19.
 */
//@Profile("cat")
//@Service("pet")
public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
