package com.sucho.placepicker

import java.io.Serializable


/*
* Created By mabrouk on 17/06/19
* PlacePicker
*/
/**
 * Normal
*Typical road map. Shows roads, some features built by humans, and important natural features like rivers. Road and feature labels are also visible.
Hybrid
*Satellite photograph data with road maps added. Road and feature labels are also visible.
*Satellite
Satellite photograph data. Road and feature labels are not visible.
Terrain
Topographic data. The map includes colors, contour lines and labels, and perspective shading. Some roads and labels are also visible.
None
No tiles. The map will be rendered as an empty grid with no tiles loaded.
 */
enum class MapType : Serializable{
    Normal,Hybrid,Satellite,Terrain,None
}