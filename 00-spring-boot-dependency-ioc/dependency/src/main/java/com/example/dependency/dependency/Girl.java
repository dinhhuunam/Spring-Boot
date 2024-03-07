package com.example.dependency.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl {
    @Autowired
    private Outfit outfit;
    public Girl(){
    }
    public Girl(@Qualifier("naked") Outfit outfit){
        this.outfit=outfit;
    }
//    public Girl(Outfit anything){
//        this.outfit = anything;
//    }
//    public void getOutfit(){
//        outfit.wear();
//    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
