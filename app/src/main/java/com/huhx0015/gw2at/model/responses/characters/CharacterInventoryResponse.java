
package com.huhx0015.gw2at.model.responses.characters;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterInventoryResponse {

    @SerializedName("bags")
    @Expose
    private List<Bag> bags = null;

    public List<Bag> getBags() {
        return bags;
    }

    public void setBags(List<Bag> bags) {
        this.bags = bags;
    }

}
