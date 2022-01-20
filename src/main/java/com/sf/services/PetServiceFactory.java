package com.sf.services;

public class PetServiceFactory {

    public PetService getPetService(String petType) {
        if("cat".equalsIgnoreCase(petType)) {
            return new CatPetService();
        } else {
            return new DogPetService();
        }
    }
}
