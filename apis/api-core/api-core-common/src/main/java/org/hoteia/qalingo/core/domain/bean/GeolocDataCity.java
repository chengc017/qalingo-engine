/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.domain.bean;

import java.io.Serializable;

public class GeolocDataCity implements Serializable {

    /**
     * Generated UID
     */
    private static final long serialVersionUID = -4664735647578348774L;
    
    private Integer geoNameId;
    private String name;

    public GeolocDataCity() {
    }

    public Integer getGeoNameId() {
        return geoNameId;
    }
    
    public void setGeoNameId(Integer geoNameId) {
        this.geoNameId = geoNameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}