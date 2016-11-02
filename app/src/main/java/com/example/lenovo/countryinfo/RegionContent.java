package com.example.lenovo.countryinfo;

/**
 * Created by Lenovo on 12-07-2016.
 */
public class RegionContent {
    String region_name ;
    String image_code ;

    public RegionContent(String region_name, String image_code) {
        this.region_name = region_name;
        this.image_code = image_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getImage_code() {
        return image_code;
    }

    public void setImage_code(String image_code) {
        this.image_code = image_code;
    }
}
